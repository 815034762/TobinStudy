package com.tobin.top.net;

import com.tobin.top.bean.RecipesBean;
import com.tobin.top.bean.RecipesClassBean;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface ApiStore {

    String BASE_URL_DEVELOP = "https://way.jd.com";  // 开发环境
    String BASE_URL_TEST = "";       // 测试环境
    String BASE_URL_RELEASE = "";       // 商用环境

    String appKey = "2a5f3669118e8a082a1697c6b6f73f9a";

    @GET("/jisuapi/search") // 菜谱查询
    Flowable<BaseResult<RecipesBean>> recipesSearch(@QueryMap Map<String, Object> body);

    @GET("/jisuapi/recipe_class") // 菜谱分类
    Flowable<BaseResult<RecipesClassBean>> recipesClass(@QueryMap Map<String, Object> body);

    @GET("/jisuapi/byclass") // 按分类检索
    Flowable<BaseResult<RecipesClassBean>> byRecipesClass(@QueryMap Map<String, Object> body);

    @GET("/jisuapi/detail") // 根据ID查询详情
    Flowable<BaseResult<RecipesClassBean>> recipesDetail(@QueryMap Map<String, Object> body);


    @Streaming
    @GET
    Observable<ResponseBody> startDownLoad(@Url String fileUrl);


    @POST("/api/app")
    Flowable<BaseResult<String>> carInputData(@HeaderMap Map<String, Object> headers,
                                              @Body Map<String, Object> body);

    @POST
    Flowable<String> mPostRequestString(@Url String url, @HeaderMap Map<String, Object> headers,
                                        @Body Map<String, Object> body);

    @GET
    Flowable<String> mGetRequestString(@Url String url, @HeaderMap Map<String, Object> headers,
                                       @Body Map<String, Object> body);

    @POST
    Flowable<BaseResult<Object>> mPostRequest(@Url String url, @HeaderMap Map<String, Object> headers,
                                              @Body Map<String, Object> body);

    @GET
    Flowable<BaseResult<Object>> mGetRequest(@Url String url, @HeaderMap Map<String, Object> headers,
                                             @Body Map<String, Object> body);

}
