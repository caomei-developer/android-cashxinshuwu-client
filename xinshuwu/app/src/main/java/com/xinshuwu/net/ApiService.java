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
    Observable<Response<Recommends>> recommends(@Query("timestamp") String timestamp,@Query("sign") String sign,@Query("page") String page,
                                                @Query("uID")String uID,@Query("token")String token,@Query("country")String country,
                                                @Query("province")String province,@Query("city") String city,@Query("isWifi") String isWifi,
                                                @Query("mType") String paramString10, @Query("PACKINGCHANNEL") String paramString11, @Query("imei") String paramString12, @Query("androidID") String paramString13);

}
