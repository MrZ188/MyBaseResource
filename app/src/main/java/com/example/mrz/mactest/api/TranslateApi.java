package com.example.mrz.mactest.api;

import com.example.mrz.mactest.entity.Translation;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by mrz on 2018/3/22.
 */

public interface TranslateApi {
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello%20")
    Observable<Translation> translate();
}
