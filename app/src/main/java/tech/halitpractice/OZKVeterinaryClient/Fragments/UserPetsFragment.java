package tech.halitpractice.OZKVeterinaryClient.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tech.halitpractice.OZKVeterinaryClient.Models.PetModel;
import tech.halitpractice.OZKVeterinaryClient.R;
import tech.halitpractice.OZKVeterinaryClient.RestApi.ManagerAll;
import tech.halitpractice.OZKVeterinaryClient.Utils.ChangeFragments;
import tech.halitpractice.OZKVeterinaryClient.Utils.GetSharedPreferences;
import tech.halitpractice.OZKVeterinaryClient.Utils.Warnings;
import tech.halitpractice.OZKVeterinaryClient.adapters.PetsAdapter;

public class UserPetsFragment extends Fragment {

    View view;
    private RecyclerView petListRecyclerView;
    private PetsAdapter petsAdapter;
    private List<PetModel> petList;
    private ChangeFragments changeFragments;
    private String mus_id;
    private GetSharedPreferences getSharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_user_pets, container, false);

        tanimla();
//      getPets("4");
        getPets(mus_id);
        return view;
    }

    public void tanimla(){
        petList = new ArrayList<>();
        petListRecyclerView = view.findViewById(R.id.petListRecyclerView);
        RecyclerView.LayoutManager mng = new GridLayoutManager(getContext(),2);
        petListRecyclerView.setLayoutManager(mng);
        changeFragments =new ChangeFragments(getContext());
        getSharedPreferences =new GetSharedPreferences(getActivity());
        mus_id = getSharedPreferences.getSession().getString("id",null);
    }

    public void getPets(String mus_id){
        Call<List<PetModel>> req = ManagerAll.getInstance().getPets(mus_id);
        req.enqueue(new Callback<List<PetModel>>() {
            @Override
            public void onResponse(Call<List<PetModel>> call, Response<List<PetModel>> response) {
//                Log.i( "listem: ",response.body().toString());
                if (response.body().get(0).isTf()){
                    petList = response.body();
                    petsAdapter = new PetsAdapter(petList,getContext());
                    petListRecyclerView.setAdapter(petsAdapter);
                    Toast.makeText(getContext(), " Registered in the system " +petList.size() + " pet was found ", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getContext(), " You don't have a registered pet in the system ", Toast.LENGTH_LONG).show();
                    changeFragments.change(new HomeFragment());
                }
            }

            @Override
            public void onFailure(Call<List<PetModel>> call, Throwable t) {
                Toast.makeText(getContext(), Warnings.internetProblemText, Toast.LENGTH_LONG).show();
            }
        });
    }


}
