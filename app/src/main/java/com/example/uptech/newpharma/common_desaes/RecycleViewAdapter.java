package com.example.uptech.newpharma.common_desaes;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.uptech.newpharma.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by uptech on 11/08/2018.
 */

    public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    private Context mcontext;
    private ArrayList<diseases> mDiseases;

    public RecycleViewAdapter(Context mcontext, ArrayList<diseases> mDiseases) {
        this.mcontext = mcontext;
        this.mDiseases = mDiseases;
    }



    @NonNull
    @Override
    public RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mcontext);
            view = mInflater.inflate(R.layout.cardview_items_common_diseases,parent,false);

        return new MyViewHolder(view,mcontext,mDiseases);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        diseases product=mDiseases.get(position);
        holder.Texttitle.setText(product.getName());
        holder.Textdes.setText(product.getDesciption());

        // clicklistner

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext,Inside_card_common_diseases.class);
                intent.putExtra("name",mDiseases.get(position).getName());
                intent.putExtra("desicription",mDiseases.get(position).getDesciption());

//                Log.d("TAG", "Card Clicked");

                mcontext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDiseases.size();
    }

    public   class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Texttitle,Textdes;
        CardView cardView;
        Context context;
        ArrayList<diseases> contacts = new ArrayList<diseases>();

        public MyViewHolder(View itemView, Context context, ArrayList<diseases> contacts) {
            super(itemView);
            Texttitle = (TextView) itemView.findViewById(R.id.cardtextviewid);
            Textdes = (TextView) itemView.findViewById(R.id.description_id);
            cardView = (CardView)  itemView.findViewById(R.id.fullcardid);
            this.context = context;
            this.contacts = contacts;

        }
    }


}
