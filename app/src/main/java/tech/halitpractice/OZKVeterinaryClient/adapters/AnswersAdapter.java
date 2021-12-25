package tech.halitpractice.OZKVeterinaryClient.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tech.halitpractice.OZKVeterinaryClient.Models.AnswerModel;
import tech.halitpractice.OZKVeterinaryClient.R;

public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.ViewHolder>{

    List<AnswerModel> list;
    Context context;

    public AnswersAdapter(List<AnswerModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cevap_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.cevapSoruText.setText("Question : " +list.get(position).getSoru().toString());
        holder.cevapText.setText("\r\nAnswer : " +list.get(position).getCevap().toString());

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView cevapSoruText,cevapText;

        // itemView ile LisView'un he elemani icin Layout ile olusturdugumuz View tanimlamasi islemi gerceklesiyor
        public ViewHolder(View itemView) {
            super(itemView);
            cevapSoruText = itemView.findViewById(R.id.cevapSoruText);
            cevapText = itemView.findViewById(R.id.cevapText);

        }
    }
}
