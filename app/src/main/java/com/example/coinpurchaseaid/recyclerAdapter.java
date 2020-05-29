package com.example.coinpurchaseaid;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Map;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.optionsViewHolder> {


    private ArrayList<Map<String,Double>> data;

    public recyclerAdapter(ArrayList<Map<String,Double>> dataReceived){

        data=dataReceived;

        System.out.println(dataReceived);

        System.out.println("recyclerAdapter : data=dataReceived ");

        System.out.println(data);
    }

    //views
    @Override
    public recyclerAdapter.optionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        System.out.println("recyclerAdapter : onCreate View Holder ");

        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem,parent,false);

        optionsViewHolder vh = new optionsViewHolder(v);
        return vh;


    }

    @Override
    public void onBindViewHolder(@NonNull optionsViewHolder holder, int position) {
        //replace content of view
        System.out.println("recyclerAdapter : onBind View Holder ");
        holder.textView.setText((CharSequence) data.get(position));

    }

    @Override
    public int getItemCount() { return data.size(); }

        public static class optionsViewHolder extends RecyclerView.ViewHolder{

            public TextView textView;

            public optionsViewHolder(TextView v){

                super(v);
                textView=v;

                System.out.println("recyclerAdapter: optionsViewHolder ");
            }

        }

}
