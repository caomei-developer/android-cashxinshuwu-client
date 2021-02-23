package com.xinshuwu.net;

import com.xinshuwu.banner.bean.BannerA;
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

    String BASR_NEW_AIQU_URL = "http://statics.ywpxg.com/static/";

    @GET("book/hot/1/hot.json")
    Observable<Response<List<Hot>>> hotList();

    @GET("banner/1/all.json")
    Observable<Response<List<BannerInfos>>> banners();

    @GET("banner/16/1/all.json")
    Observable<Response<List<BannerA>>> bannerA();

    @GET("app/home/elitebook")
    Observable<Response<Recommends>> recommends(@Query("consumerKey") String paramString1, @Query("timestamp") long paramLong, @Query("sign") String paramString2, @Query("page") String paramString3, @Query("uID") String paramString4, @Query("token") String paramString5, @Query("country") String paramString6, @Query("province") String paramString7, @Query("city") String paramString8, @Query("isWifi") String paramString9, @Query("mType") String paramString10, @Query("PACKINGCHANNEL") String paramString11, @Query("imei") String paramString12, @Query("androidID") String paramString13);

//    @GET("/app/info/bookindex")
//    Observable<BookIndexBean> bookindex(@Query("consumerKey") String paramString1, @Query("timestamp") long paramLong, @Query("sign") String paramString2, @Query("bID") String paramString3, @Query("lmID") String paramString4, @Query("uID") String paramString5, @Query("token") String paramString6, @Query("imei") String paramString7, @Query("androidID") String paramString8);


//    @GET("book/reco/{gender}/page/{page}.json")
//
//    @GET("ranking/{gender}/{order}.json")
//
//    @GET("book/relationread/{categoryId}.json")
//
//
//    @GET("category/{gender}/all.json")
//
//
//    @GET("book/new/{gender}/page/{page}.json")
//
//    @GET("book/finish/{gender}/page/{page}.json")
//
//    @GET("book/hot/{gender}/page/{page}.json")

//    @GET("ranking/{gender}/finish.json")
//
//    @GET("book/category/{cid}/{order}/{page}.json")
//
//    @GET("book/category/{category}/finish/1.json")


//    @GET("book/finish/{gender}/finish.json")
//
//    @GET("book/hot/{gender}/hot.json")
//
//    @GET("banner/{gender}/all.json")
//
//    @GET("book/reco/{gender}/reco.json")
//
//    @POST("index")
//
//    @GET("book/new/{gender}/new.json")


}
