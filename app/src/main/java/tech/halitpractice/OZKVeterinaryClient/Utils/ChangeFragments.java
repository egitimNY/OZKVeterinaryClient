package tech.halitpractice.OZKVeterinaryClient.Utils;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import tech.halitpractice.OZKVeterinaryClient.R;

public class ChangeFragments {

    private Context context;

    public ChangeFragments(Context context){
        this.context = context;
    }

    public void change(Fragment fragment){
        ((FragmentActivity)context).getSupportFragmentManager().beginTransaction()
                .replace(R.id.mainFrameLayout,fragment,"fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
//                .addToBackStack(null).commit();
    }

}
