package tech.halitpractice.OZKVeterinaryClient.RestApi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import tech.halitpractice.OZKVeterinaryClient.Models.RegisterPojo;

public interface RestApi {

    @FormUrlEncoded
    @POST("/veteriner/kayitol.php")
    Call<RegisterPojo> registerUser(@Field("mailAdres") String kayitol, @Field("kadi") String kadi, @Field("pass") String pass);

}
