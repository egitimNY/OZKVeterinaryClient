package tech.halitpractice.OZKVeterinaryClient.RestApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import tech.halitpractice.OZKVeterinaryClient.Models.AnswerModel;
import tech.halitpractice.OZKVeterinaryClient.Models.AsiModel;
import tech.halitpractice.OZKVeterinaryClient.Models.AskQuestionModel;
import tech.halitpractice.OZKVeterinaryClient.Models.DeleteAnswerModel;
import tech.halitpractice.OZKVeterinaryClient.Models.KampanyaModel;
import tech.halitpractice.OZKVeterinaryClient.Models.LoginModel;
import tech.halitpractice.OZKVeterinaryClient.Models.PetModel;
import tech.halitpractice.OZKVeterinaryClient.Models.RegisterPojo;

public interface RestApi {

    @FormUrlEncoded
    @POST("/veteriner/kayitol.php")
    Call<RegisterPojo> registerUser(@Field("mailAdres") String kayitol, @Field("kadi") String kadi, @Field("pass") String pass);

    @FormUrlEncoded
    @POST("/veteriner/girisyap.php")
    Call<LoginModel> loginUser(@Field("mailadres") String mailAdres, @Field("sifre") String pass);

    @FormUrlEncoded
    @POST("/veteriner/petlerim.php")
    Call<List<PetModel>> getPets(@Field("musid") String mus_id);

    @FormUrlEncoded
    @POST("/veteriner/sorusor.php")
    Call<AskQuestionModel> soruSor(@Field("id") String id, @Field("soru") String soru);

    @FormUrlEncoded
    @POST("/veteriner/cevaplar.php")
    Call<List<AnswerModel>> getAnswer(@Field("mus_id") String mus_id);

    @FormUrlEncoded
    @POST("/veteriner/cevapSil.php")
    Call<DeleteAnswerModel> deleteAnswer(@Field("cevap") String cevapid, @Field("soru") String soruid);

    @GET("/veteriner/kampanya.php")
    Call<List<KampanyaModel>> getKampanya();

    @FormUrlEncoded
    @POST("/veteriner/asitakip.php")
    Call<List<AsiModel>> getAsi(@Field("id") String id);

    @FormUrlEncoded
    @POST("/veteriner/gecmisasi.php")
    Call<List<AsiModel>> getGecmisAsi(@Field("id") String id, @Field("petid") String pet_id );


}
