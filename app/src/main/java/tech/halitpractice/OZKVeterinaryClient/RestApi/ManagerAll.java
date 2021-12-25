package tech.halitpractice.OZKVeterinaryClient.RestApi;

import java.util.List;

import retrofit2.Call;
import tech.halitpractice.OZKVeterinaryClient.Models.AnswerModel;
import tech.halitpractice.OZKVeterinaryClient.Models.AskQuestionModel;
import tech.halitpractice.OZKVeterinaryClient.Models.DeleteAnswerModel;
import tech.halitpractice.OZKVeterinaryClient.Models.KampanyaModel;
import tech.halitpractice.OZKVeterinaryClient.Models.LoginModel;
import tech.halitpractice.OZKVeterinaryClient.Models.PetModel;
import tech.halitpractice.OZKVeterinaryClient.Models.RegisterPojo;

public class ManagerAll extends BaseManager{

    private  static ManagerAll ourInstance = new ManagerAll();

    public  static synchronized ManagerAll getInstance()
    {
        return  ourInstance;
    }

    public Call<RegisterPojo> kayitOl(String mail , String kadi, String parola)
    {
        Call<RegisterPojo> x = getRestApi().registerUser(mail,kadi,parola);
        return  x ;
    }

    public Call<LoginModel> girisYap(String mail , String parola)
    {
        Call<LoginModel> x = getRestApi().loginUser(mail,parola);
        return  x ;
    }

    public Call<List<PetModel>> getPets(String id)
    {
        Call<List<PetModel>> x = getRestApi().getPets(id);
        return  x ;
    }

    public Call<AskQuestionModel> soruSor(String id , String soru)
    {
        Call<AskQuestionModel> x = getRestApi().soruSor(id,soru);
        return  x ;
    }

    public Call<List<AnswerModel>> getAnswer(String id) {
        Call<List<AnswerModel>> x = getRestApi().getAnswer(id);
        return  x ;
    }

    public Call<DeleteAnswerModel> deleteAnswer(String cevap , String soru)
    {
        Call<DeleteAnswerModel> x = getRestApi().deleteAnswer(cevap,soru);
        return  x ;
    }

    public Call<List<KampanyaModel>> getKampanya()
    {
        Call<List<KampanyaModel>> x = getRestApi().getKampanya();
        return  x ;
    }

}
