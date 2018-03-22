package com.example.mrz.mactest.ui.activity;

import android.os.Bundle;
import android.util.Log;

import com.example.mrz.mactest.R;
import com.example.mrz.mactest.api.TranslateApi;
import com.example.mrz.mactest.common.BaseActivity;
import com.example.mrz.mactest.entity.Translation;
import com.example.mrz.mactest.utils.RetrofitTest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        request();

    }

    public void request() {
        //创建retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        //创建网络请求接口实例
         TranslateApi translateApi = retrofit.create(TranslateApi.class);
        translateApi.translate().    //获取Observer对象
                subscribeOn(Schedulers.newThread())   //请求在新线程中执行
                .observeOn(Schedulers.io())           //请求完成之后，执行io线程
                .doOnNext(new Action1<Translation>() {
                    @Override
                    public void call(Translation translation) {
                        translation.show();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程执行
                .subscribe(new Subscriber<Translation>() {
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(Translation translation) {
                        Log.i(TAG, "onNext: ");
                    }
                });
    }
}

