package us.bmark.bookieParserClient.BookeParserService;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

public interface BookieParserService {

    @FormUrlEncoded
    @POST("/api/v1/parse")
    public ParseResponse parse(
            @Field("url") String url
    );

    @FormUrlEncoded
    @POST("/api/v1/parse")
    public void parse(
            @Field("url") String url,
            Callback<ParseResponse> callback
    );

}