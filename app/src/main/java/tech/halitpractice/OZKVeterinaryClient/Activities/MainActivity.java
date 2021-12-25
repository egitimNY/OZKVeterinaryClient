package tech.halitpractice.OZKVeterinaryClient.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import tech.halitpractice.OZKVeterinaryClient.Fragments.HomeFragment;
import tech.halitpractice.OZKVeterinaryClient.R;
import tech.halitpractice.OZKVeterinaryClient.Utils.ChangeFragments;
import tech.halitpractice.OZKVeterinaryClient.Utils.GetSharedPreferences;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences getSharedPreferences;
    private GetSharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragment();
        tanimla();
        kontrol();

    }

    private void getFragment() {
        ChangeFragments changeFragments = new ChangeFragments(MainActivity.this);
        changeFragments.change(new HomeFragment());
    }

    private void tanimla() {
        preferences = new GetSharedPreferences(MainActivity.this);
        getSharedPreferences = preferences.getSession();

    }

    public void kontrol(){

        if (getSharedPreferences.getString("id", null)==null && getSharedPreferences.getString("mailadress",null)==null
                && getSharedPreferences.getString("username",null)==null){
            Log.i( "sharedSonuc","girdi");
            Intent intent = new Intent(MainActivity.this,GirisYapActivity.class);
            startActivity(intent);
            finish();
        }
    }

}
