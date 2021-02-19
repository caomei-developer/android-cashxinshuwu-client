package com.xinshuwu.net;

import com.xinshuwu.banner.bean.BannerInfos;
import com.xinshuwu.hot.bean.Hot;
import com.xinshuwu.recomend.bean.Recommends;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    String BASE_QUBU_URL = "http://s.mujiang88.cn/";

    String BASE_FUZHU_URL = "http://a.lc1001.com/";

    String BASE_AIQU_URL = "http://statics.yingxinpeixun.com/";


    @GET("book/hot/1/hot.json")
    Observable<Response<List<Hot>>> hotList();

    @GET("banner/1/all.json")
    Observable<Response<List<BannerInfos>>> banners();

    @GET("app/home/elitebook")
    Observable<Response<Recommends>> recommends(@Query("consumerKey") String paramString1, @Query("timestamp") long paramLong, @Query("sign") String paramString2, @Query("page") String paramString3, @Query("uID") String paramString4, @Query("token") String paramString5, @Query("country") String paramString6, @Query("province") String paramString7, @Query("city") String paramString8, @Query("isWifi") String paramString9, @Query("mType") String paramString10, @Query("PACKINGCHANNEL") String paramString11, @Query("imei") String paramString12, @Query("androidID") String paramString13);


}
