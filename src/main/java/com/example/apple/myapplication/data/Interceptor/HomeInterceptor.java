package com.example.apple.myapplication.data.Interceptor;

import com.example.apple.myapplication.data.constant.Constant;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HomeInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request build = request.newBuilder()
                .url(Constant.SHOOP_HOME)
                .build();
        Response proceed = chain.proceed(build);
        return proceed;
    }
}
