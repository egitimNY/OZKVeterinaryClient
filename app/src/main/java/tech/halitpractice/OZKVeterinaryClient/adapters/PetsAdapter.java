package tech.halitpractice.OZKVeterinaryClient.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import tech.halitpractice.OZKVeterinaryClient.Models.PetModel;
import tech.halitpractice.OZKVeterinaryClient.R;

public class PetsAdapter extends RecyclerView.Adapter<PetsAdapter.ViewHolder>{

    List<PetModel> list;
    Context context;

    public PetsAdapter(List<PetModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pet_list_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.petLayoutCinsName.setText("Pet Breed: " +list.get(position).getPetcins().toString());
        holder.petLayoutPetName.setText("Pet Name: " +list.get(position).getPetisim().toString());
        holder.petLayoutTurName.setText("Pet Type: " +list.get(position).getPettur().toString());

//        Picasso.get().load(list.get(position).getPetresim()).into(holder.petLayoutPetImage);
        Picasso.get().load(list.get(position).getPetresim()).into(holder.petLayoutPetImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView petLayoutPetName,petLayoutCinsName,petLayoutTurName;
        CircleImageView petLayoutPetImage;

        // itemView ile LisView'un he elemani icin Layout ile olusturdugumuz View tanimlamasi islemi gerceklesiyor
        public ViewHolder(View itemView) {
            super(itemView);
            petLayoutPetName = itemView.findViewById(R.id.petLayoutPetName);
            petLayoutCinsName = itemView.findViewById(R.id.petLayoutCinsName);
            petLayoutTurName = itemView.findViewById(R.id.petLayoutTurName);
            petLayoutPetImage = itemView.findViewById(R.id.petLayoutPetImage);
        }
    }
}
