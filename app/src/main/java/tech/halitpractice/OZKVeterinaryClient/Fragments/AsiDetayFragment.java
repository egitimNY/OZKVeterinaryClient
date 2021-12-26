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
import tech.halitpractice.OZKVeterinaryClient.Models.AsiModel;
import tech.halitpractice.OZKVeterinaryClient.R;
import tech.halitpractice.OZKVeterinaryClient.RestApi.ManagerAll;
import tech.halitpractice.OZKVeterinaryClient.Utils.ChangeFragments;
import tech.halitpractice.OZKVeterinaryClient.Utils.GetSharedPreferences;
import tech.halitpractice.OZKVeterinaryClient.adapters.SanalKarneGecmisAsiAdapter;

public class AsiDetayFragment extends Fragment {

    private View view;
    private String musid;
    private String petId;
    private GetSharedPreferences getSharedPreferences;
    private RecyclerView asiDetayRecyclerView;
    private SanalKarneGecmisAsiAdapter adapter;
    private List<AsiModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_asi_detay, container, false);
        tanimla();
        getGecmisAsi();
        return view;
    }

    public void tanimla(){
        petId = getArguments().getString("petid").toString();
        getSharedPreferences = new GetSharedPreferences(getActivity());
        musid = getSharedPreferences.getSession().getString("id",null);
        asiDetayRecyclerView = view.findViewById(R.id.asiDetayRecyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),1);
        asiDetayRecyclerView.setLayoutManager(layoutManager);
        list = new ArrayList<>();
    }

    public void getGecmisAsi(){
//        Call<List<AsiModel>> req = ManagerAll.getInstance().getGecmisAsi("30","1");
        Call<List<AsiModel>> req = ManagerAll.getInstance().getGecmisAsi(musid,petId);
        req.enqueue(new Callback<List<AsiModel>>() {
            @Override
            public void onResponse(Call<List<AsiModel>> call, Response<List<AsiModel>> response) {
//                Log.i( "gecmisasilar: ",response.body().toString());
                if (response.body().get(0).isTf()){
                    list = response.body();
                    adapter = new SanalKarneGecmisAsiAdapter(list,getContext());
                    asiDetayRecyclerView.setAdapter(adapter);
//                    Toast.makeText(getContext(), " Petinize ait "+ list.size()+" adet gecmiste yapilan asi bulunmustur. ", Toast.LENGTH_LONG).show();
                    Toast.makeText(getContext(), " belonging to your pet "+ list.size()+" Vaccination was found in the past. ", Toast.LENGTH_LONG).show();

                }else {
                    ChangeFragments changeFragments = new ChangeFragments(getContext());
                    changeFragments.change(new SanalKarnePetlerFragment());
//                    Toast.makeText(getContext(), " Petinize ait gecmiste yapilan herhangi bir asi bulunamamistir. ", Toast.LENGTH_LONG).show();
                    Toast.makeText(getContext(), " No vaccinations of your pet have been found in the past.. ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<AsiModel>> call, Throwable t) {

            }
        });
    }

}
