package com.example.coinpurchaseaid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity{

    ArrayList<ArrayList<Map<String,Double>>> allOptions = new ArrayList<>();

    public Double calculatePrice(Map<String, Double> CoinPackageandPrice){

        double price=0.00;

        //switch
        //final EditText fifty = findViewById(R.id.fifty_coins);

        //double price_50=Double.parseDouble(String.valueOf(fifty.getText()));
        // price+=Double.parseDouble(String.valueOf(fifty.getText()));



        for (Map.Entry<String, Double> entry : CoinPackageandPrice.entrySet()) {

//            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());

            String coinVal = entry.getKey().trim();
            Double count=entry.getValue();

            System.out.println("coinVals: " + entry.getKey());


            switch (coinVal) {
                case "50":

                    final EditText fifty = findViewById(R.id.fifty_coins);

                    double price_50 = Double.parseDouble(String.valueOf(fifty.getText()));

                    price = price_50*count;


                    break;

                case "100":

                    final EditText hundred = findViewById(R.id.hundred_coins);

                    double price_100 = Double.parseDouble(String.valueOf(hundred.getText()));

                    price = price_100*count;

                    break;

                case "150":

                    final EditText hundred_fifty = findViewById(R.id.hundred_fifty_coins);

                    double price_150 = Double.parseDouble(String.valueOf(hundred_fifty.getText()));

                    price = price_150*count;

                    break;

                case "200":

                    final EditText two_hundred = findViewById(R.id.two_hundred_coins);

                    double price_200 = Double.parseDouble(String.valueOf(two_hundred.getText()));

                    price = price_200*count;

                    break;

                case "400":

                    final EditText four_hundred = findViewById(R.id.four_hundred_coins);

                    double price_400 = Double.parseDouble(String.valueOf(four_hundred.getText()));

                    price = price_400*count;

                    break;

                case "600":

                    final EditText six_hundred = findViewById(R.id.six_hundred_coins);

                    double price_600 = Double.parseDouble(String.valueOf(six_hundred.getText()));

                    price = price_600*count;

                    break;

                case "1200":

                    final EditText thousand_two_hundred = findViewById(R.id.thousand_two_hundred_coins);

                    double price_1200 = Double.parseDouble(String.valueOf(thousand_two_hundred.getText()));

                    price = price_1200*count;

                    break;

                case "1500":

                    final EditText thousand_five_hundred = findViewById(R.id.thousand_five_hundred_coins);

                    double price_1500 = Double.parseDouble(String.valueOf(thousand_five_hundred.getText()));

                    price = price_1500*count;

                    break;

                case "2400":

                    final EditText two_thousand_four_hundred = findViewById(R.id.two_thousand_four_hundred_coins);

                    double price_2400 = Double.parseDouble(String.valueOf(two_thousand_four_hundred.getText()));

                    price = price_2400*count;

                    break;
            }

        }
        System.out.println("price: " + price);

        return price;
    }

    public ArrayList returnListofArrays(String arr){  // [50,150,200]

        System.out.println("=" + arr);

        String[] setArray= arr.split(",");

        ArrayList<Map<String,Double>> CombinationsAndPriceArray = new ArrayList<>();

        double combinationPrice=0.00;

            for(String val : setArray) {

                Map<String, Double> map = new HashMap<String, Double>();

                if(val.contains("[") ){val=val.substring(1);}
                if(val.contains("]") ){val=val.substring(0,val.length()-1);}

                    map.put(val,1.00);

                CombinationsAndPriceArray.add(0, map); // ["50":"1"]
            }


        for(Map<String,Double> map: CombinationsAndPriceArray){
            double pricePerCoinPackage=0.00;
            pricePerCoinPackage=calculatePrice(map);
            combinationPrice+=pricePerCoinPackage;
            System.out.println("combinationPrice: " + combinationPrice);

        }

        Map<String, Double> price_tag = new HashMap<String, Double>();
        price_tag.put("price",combinationPrice);
        CombinationsAndPriceArray.add(price_tag);

        System.out.println(CombinationsAndPriceArray);


        Options.setArrayListofOptions(CombinationsAndPriceArray);
        return CombinationsAndPriceArray;

    }

    public ArrayList returnListofArrays(Map<String, Double> coinValAndCount){  // [50,150,200]

        ArrayList<Map<String,Double>> CombinationsAndPriceArray = new ArrayList<>();

        CombinationsAndPriceArray.add(coinValAndCount);

        double combinationPrice=0.00;
        double pricePerCoinPackage=0.00;
        pricePerCoinPackage=calculatePrice(coinValAndCount);
        combinationPrice+=pricePerCoinPackage;


        Map<String, Double> price_tag = new HashMap<String, Double>();
        price_tag.put("price",combinationPrice);

        CombinationsAndPriceArray.add(price_tag);

        System.out.println(CombinationsAndPriceArray);

        Options.setArrayListofOptions(CombinationsAndPriceArray);

        return CombinationsAndPriceArray;

    }

    public void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {

        int s = 0;

        for (int x: partial) s += x;

        if (s == target) { returnListofArrays(Arrays.toString(partial.toArray())); }


        if (s >= target)
            return;

        for(int i=0;i<numbers.size();i++) {

            ArrayList<Integer> remaining = new ArrayList<Integer>();
            int n = numbers.get(i);
            for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
            ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
            partial_rec.add(n);
            sum_up_recursive(remaining,target,partial_rec);

        }
    }

    public void sum_up(ArrayList<Integer> numbers, int target) {

        sum_up_recursive(numbers,target,new ArrayList<Integer>());

    }

    //[{100=1.0},{price=10.09}]

    public void switchView(){

        System.out.println("Main Activity: switch view ");

        Intent options=new Intent(this,Options.class);

        startActivity(options);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_b);

        final EditText amount_of_coins = findViewById(R.id.total_amount);

        final Button button = findViewById(R.id.button_submit);


        button.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onClick(View v) {

                Log.d("clicked", "clicked");
                Log.d("clicked", String.valueOf(amount_of_coins.getText()));

                int coin_amount = Integer.parseInt(String.valueOf(amount_of_coins.getText()));

                System.out.println(coin_amount);

                final EditText amount_of_coins = findViewById(R.id.total_amount);

                int[] arr = {50,100,150,200,400,600,1200,1500,2400};

                int tar = coin_amount;

                int i = 0;

//                //1) by factors

                while (i < arr.length) {

                    int val = 0;
                    int cnt = 0;

                    while (val < tar) {

                        val += arr[i];

                        cnt++;

                        if (val == tar) {
                            System.out.println(cnt + " of " + arr[i] + " make " + tar);

                            Map<String, Double> coinValAndCountPair = new HashMap<String, Double>();

                            String coinVal= String.valueOf(arr[i]);
                            Double count=Double.valueOf(cnt);

                            coinValAndCountPair.put(coinVal,count);
                            returnListofArrays(coinValAndCountPair);

    
                        }

                    }
                    i++;
                }

//                //2)

                Integer[] numbers = {50,100,150,200,400,600,1200,1500,2400};

                sum_up(new ArrayList<Integer>(Arrays.asList(numbers)), coin_amount);

                //determine price

                //determine lowest

                //return combination

                //3)
                //4)

                switchView();

                System.out.println(allOptions);

            }

        });

    }




}
