package tech.halitpractice.OZKVeterinaryClient.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tech.halitpractice.OZKVeterinaryClient.Models.SifremiUnuttumModel;
import tech.halitpractice.OZKVeterinaryClient.R;
import tech.halitpractice.OZKVeterinaryClient.RestApi.ManagerAll;
import tech.halitpractice.OZKVeterinaryClient.Utils.Warnings;

public class SifremiUnuttumActivity extends AppCompatActivity {

    private EditText forgetMailAddress;
    private Button forgetButton;
    private LinearLayout loginRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sifremi_unuttum);

        tanimla();
    }

    public void tanimla(){

        forgetMailAddress = findViewById(R.id.forgetMailAddress);
//        forgetUserName = findViewById(R.id.forgetUserName);
//        forgetPassword = findViewById(R.id.forgetPassword);
        forgetButton = findViewById(R.id.forgetButton);
        loginRemember = findViewById(R.id.loginRemember);

        loginRemember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SifremiUnuttumActivity.this, GirisYapActivity.class);
                startActivity(intent);
            }
        });



        forgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail="";

                mail = forgetMailAddress.getText().toString();
//                kadi = forgetUserName.getText().toString();
//                pass = forgetPassword.getText().toString();

                if (!mail.equals("")){

                    forgetMailAddress.setText("");
//                    forgetUserName.setText("");
//                    forgetPassword.setText("");

                    forgetPassword(mail);

                }else {
                    Toast.makeText(getApplicationContext(), "Tüm alanların doldurulması zorunludur.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void forgetPassword(String mail){
        Call<SifremiUnuttumModel> req = ManagerAll.getInstance().sifremiUnuttum(mail);
        req.enqueue(new Callback<SifremiUnuttumModel>() {
            @Override
            public void onResponse(Call<SifremiUnuttumModel> call, Response<SifremiUnuttumModel> response) {
                if (response.body().isTf()){
                    Toast.makeText(getApplicationContext(), response.body().getText().toString(), Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(), response.body().getText().toString(), Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<SifremiUnuttumModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), Warnings.internetProblemText, Toast.LENGTH_LONG).show();

            }
        });

    }


}
