package com.example.coinpurchaseaid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.optionsViewHolder> {


    private ArrayList<ArrayList<Map<String,Double>>> data;

    public String getOptionsOnly(ArrayList<Map<String,Double>> data){

        String optionsList="";

             System.out.println("getOptionsOnly");

            for(Map<String,Double> option: data){

                for(String key:option.keySet()){

                    if(key!="price") { optionsList += option.get(key) + " x " + key + "\n";}

                }
            }

            System.out.println(optionsList);


        return optionsList;



    };

    public String getPriceOnly(ArrayList<Map<String,Double>> data){

        String priceTag="";

            int lastItemIndexNo=data.size()-1;

            Map<String,Double> priceData;

            priceData= data.remove(lastItemIndexNo);

            System.out.println("price Data: " + priceData);

            priceTag=priceData.get("price").toString();

            System.out.println("price Tag: " + priceTag);

        return priceTag;

    };

//    public CharSequence structureCardData_combinations(ArrayList<HashMap<String,Double>> option){};

    public class optionsViewHolder extends RecyclerView.ViewHolder{

        public TextView view;

        public optionsViewHolder(View v){

            super(v);
            view=(TextView) v.findViewById(R.id.textView);

            System.out.println("recyclerAdapter: optionsViewHolder ");
        }

    }

    public recyclerAdapter(ArrayList<ArrayList<Map<String,Double>>> dataReceived){

        data=dataReceived;

        System.out.println(dataReceived);

        System.out.println("recyclerAdapter : data=dataReceived ");

        System.out.println(data);
    }

    //views
    @Override
    public recyclerAdapter.optionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        System.out.println("recyclerAdapter : onCreate View Holder ");

        View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem,parent,false);

        optionsViewHolder vh = new optionsViewHolder(v);

        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull optionsViewHolder holder, int position) {
        //replace content of view
        System.out.println("recyclerAdapter : onBind View Holder ");

        System.out.println("data" + data);
        System.out.println("data.get(position)" + data.get(position));

        String price=getPriceOnly(data.get(position));
        String combinations=getOptionsOnly(data.get(position));

        holder.view.setText(combinations);

//        holder.view.setText((CharSequence) data.get(position));

    }

    @Override
    public int getItemCount() { System.out.print("data size: " + data.size());return data.size(); }



}
