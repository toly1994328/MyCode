package com.toly1994.mycode.app;

import com.toly1994.mycode.bean.ResultBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/13 0013:19:48<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：API接口
 */
public interface NoteApi {


    /**
     * 查询所有操作
     *
     * @param offset 偏移
     * @param page   一页数目
     * @return ResultBean包装
     */
    @GET("api/android/note/{offset}/{page}")
    Observable<ResultBean> findAll(@Path("offset") int offset, @Path("page") int page);


    @GET("api/android/note/area/{op}/{offset}/{page}")
    Observable<ResultBean> findByArea(@Path("op") String op, @Path("offset") int offset, @Path("page") int page);

    @GET("api/android/note/type/{type}/{offset}/{page}")
    Observable<ResultBean> findByType(@Path("type") String op, @Path("offset") int offset, @Path("page") int page);


    @GET("api/android/note/name/{type}/{offset}/{page}")
    Observable<ResultBean> findByName(@Path("type") String type, @Path("offset") int offset, @Path("page") int page);


    @FormUrlEncoded
    @POST("api/android/note")
    Observable<ResultBean> insert(@FieldMap Map<String, String> params);
}
