package com.example.mrz.mactest.utils;

import com.example.mrz.mactest.entity.Translation;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mrz on 2018/3/22.
 */

public class RetrofitTest {
    public interface GetRequest_Interface{
        @GET("ajax.php?a=fy&f=auto&t=auto&w=hello%20")
        Call<Translation> getCall();
    }
}
