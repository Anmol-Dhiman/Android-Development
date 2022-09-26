package com.example.retrofit;


import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface RetrofitSample {

    //    for using the retrofit we have to make the interface where we define the method and it's return type
// the the annotation includes the extra url data
    @GET("posts")
    Call<List<DataModel>> getData();


//    to take the input from the activity and on the basis of that we have to make the http request
//    so for that we use the @Path annotation

    //    eg: -
//    for the url : - https://jsonplaceholder.typicode.com/posts/1/comments
    @GET("posts/{id}/comments")
    Call<List<DataModel>> getComments(@Path("id") int postId);

    //    for adding the query: -
//    eg for the url: - https://jsonplaceholder.typicode.com/posts?userId=2
//    @Query() annotation automatically add the ? sign and the = sign

//    for giving the multiple query we can use the @Query() annotation multiple times

    @GET("posts")
    Call<List<DataModel>> getDataWithQuery(@Query("userId") int userId);

    @GET("posts")
    Call<List<DataModel>> getDataWithQueryMap(@QueryMap Map<String, String> param);


    //    from this annotation we have to pass the post url i.e. other than the base url
//    which means we can make changes in the activity java file
    @GET
    Call<List<DataModel>> getUrl(@Url String url);


//    to give input in the data base we use the @POST annotation

//    here we have defined the different variables we want to post in the database
//    other than that we can use it like: -

    //    @Body DataModel dataModel;
    @FormUrlEncoded
    @POST("posts")
    Call<List<DataModel>> createPost(
            @Field("userId") int userID,
            @Field("title") String title,
            @Field("body") String body
    );

    //we have @PUT for updating the input in the Json by using the id the Json object

    @PUT("posts/{id}")
//we have to pass the complete object in @Body annotation
    Call<List<DataModel>> putPost(@Path("id") int userId, @Body DataModel dataModel);
//both @PUT and @PATCH are used to update the existing object but in put it creates the whole new object
//    while @PATCH override the updated vales only

    @PATCH("posts/{id}")
    Call<List<DataModel>> patchPost(@Path("id") int userId, @Body DataModel dataModel);


//    as the name suggests it is used to     delete the
    @DELETE("posts/{id}")
    Call<Void> deletePosts(@Path("id") int userId);
}
