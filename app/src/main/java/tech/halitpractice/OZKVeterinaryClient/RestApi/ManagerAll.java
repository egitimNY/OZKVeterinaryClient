package tech.halitpractice.OZKVeterinaryClient.RestApi;

import retrofit2.Call;
import tech.halitpractice.OZKVeterinaryClient.Models.LoginModel;
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

}
