package com.example.coinpurchaseaid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {

    public Double calculatePrice(Map<String, Integer> CoinPackageandPrice){

        double price=0.00;

        //switch
        //final EditText fifty = findViewById(R.id.fifty_coins);

        //double price_50=Double.parseDouble(String.valueOf(fifty.getText()));
        // price+=Double.parseDouble(String.valueOf(fifty.getText()));



        for (Map.Entry<String, Integer> entry : CoinPackageandPrice.entrySet()) {

//            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());

            int coinVal = Integer.parseInt(entry.getKey());


            switch (coinVal) {
                case 50:

                    final EditText fifty = findViewById(R.id.fifty_coins);

                    double price_50 = Double.parseDouble(String.valueOf(fifty.getText()));

                    price = price_50;


                    break;

                case 100:

                    final EditText hundred = findViewById(R.id.hundred_coins);

                    double price_100 = Double.parseDouble(String.valueOf(hundred.getText()));

                    price = price_100;

                    break;

                case 150:

                    final EditText hundred_fifty = findViewById(R.id.hundred_fifty_coins);

                    double price_150 = Double.parseDouble(String.valueOf(hundred_fifty.getText()));

                    price = price_150;

                    break;

                case 200:

                    final EditText two_hundred = findViewById(R.id.two_hundred_coins);

                    double price_200 = Double.parseDouble(String.valueOf(two_hundred.getText()));

                    price = price_200;

                    break;

                case 400:

                    final EditText four_hundred = findViewById(R.id.four_hundred_coins);

                    double price_400 = Double.parseDouble(String.valueOf(four_hundred.getText()));

                    price = price_400;

                    break;

                case 600:

                    final EditText six_hundred = findViewById(R.id.six_hundred_coins);

                    double price_600 = Double.parseDouble(String.valueOf(six_hundred.getText()));

                    price = price_600;

                    break;

                case 1200:

                    final EditText thousand_two_hundred = findViewById(R.id.thousand_two_hundred_coins);

                    double price_1200 = Double.parseDouble(String.valueOf(thousand_two_hundred.getText()));

                    price = price_1200;

                    break;

                case 1500:

                    final EditText thousand_five_hundred = findViewById(R.id.thousand_five_hundred_coins);

                    double price_1500 = Double.parseDouble(String.valueOf(thousand_five_hundred.getText()));

                    price = price_1500;

                    break;

                case 2400:

                    final EditText two_thousand_four_hundred = findViewById(R.id.two_thousand_four_hundred_coins);

                    double price_2400 = Double.parseDouble(String.valueOf(two_thousand_four_hundred.getText()));

                    price = price_2400;

                    break;
            }

        }

        return price;
    }

    public ArrayList returnListofArrays(String arr){  // [50,150,200]

        System.out.println("=" + arr);

        String[] setArray= arr.split(",");

        ArrayList<Map<String,Integer>> CombinationsAndPriceArray = new ArrayList<Map<String,Integer>>();

        double combinationPrice=0.00;

        //Generate map

//        while (iter.hasNext()) {

            for(String val : setArray) {

                Map<String, Integer> map = new HashMap<String, Integer>();

//                System.out.println("Iterator");
//
//                System.out.println(iter.next());

                    map.put(val,1);

                CombinationsAndPriceArray.add(0, map); // ["50":"1"]
            }

//        }

        //CombinationsAndPriceArray.add(map) // ["price":"setPrice"]

        //determinePrice

        //CombinationsAndPriceArray ["50":"1","50":"1","50":"1","price:100"]

//        price=calculatePrice(CombinationsAndPriceArray); //determine price per Set

        for(Map<String,Integer> map: CombinationsAndPriceArray){
            double pricePerCoinPackage=0.00;
            pricePerCoinPackage=calculatePrice(map);
            combinationPrice+=pricePerCoinPackage;
        }

//        CombinationsAndPriceArray.add(combinationPrice)

        return CombinationsAndPriceArray;

    }


    public void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {

        int s = 0;

        for (int x: partial) s += x;

        if (s == target) {
//            System.out.println("sum(" + Arrays.toString(partial.toArray()) + ")=" + target);

            returnListofArrays(Arrays.toString(partial.toArray()));
        }


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


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_b);

        final EditText amount_of_coins = findViewById(R.id.total_amount);


        final Button button = findViewById(R.id.button_submit);


        button.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onClick(View v) {

                Log.d("clicked","clicked");
                Log.d("clicked", String.valueOf(amount_of_coins.getText()));

                int coin_amount=Integer.parseInt(String.valueOf(amount_of_coins.getText()));
                System.out.println(coin_amount);

                final EditText amount_of_coins = findViewById(R.id.total_amount);

                //get priceVals

                final EditText fifty = findViewById(R.id.fifty_coins);
                double price_50=Double.parseDouble(String.valueOf(fifty.getText()));

                final EditText hundred = findViewById(R.id.hundred_coins);
                double price_100=Double.parseDouble(String.valueOf(hundred.getText()));

                final EditText hundred_fifty = findViewById(R.id.hundred_fifty_coins);
                double price_150=Double.parseDouble(String.valueOf(hundred_fifty.getText()));

                final EditText two_hundred = findViewById(R.id.two_hundred_coins);
                double price_200=Double.parseDouble(String.valueOf(two_hundred.getText()));

                final EditText four_hundred = findViewById(R.id.four_hundred_coins);
                double price_400=Double.parseDouble(String.valueOf(four_hundred.getText()));

                final EditText six_hundred = findViewById(R.id.six_hundred_coins);
                double price_600=Double.parseDouble(String.valueOf(six_hundred.getText()));

                final EditText thousand_two_hundred = findViewById(R.id.thousand_two_hundred_coins);
                double price_1200=Double.parseDouble(String.valueOf(thousand_two_hundred.getText()));

                final EditText thousand_five_hundred = findViewById(R.id.thousand_five_hundred_coins);
                double price_1500=Double.parseDouble(String.valueOf(thousand_five_hundred.getText()));

                final EditText two_thousand_four_hundred = findViewById(R.id.two_thousand_four_hundred_coins);
                double price_2400=Double.parseDouble(String.valueOf(two_thousand_four_hundred.getText()));


                vlive_coin_object fiftyCoins = new vlive_coin_object(50,price_50);

                vlive_coin_object hundredCoins = new vlive_coin_object(100,price_100);

                vlive_coin_object hundredFiftyCoins = new vlive_coin_object(150,price_150);

                vlive_coin_object twohundredCoins = new vlive_coin_object(200,price_200);

                vlive_coin_object fourhundredCoins = new vlive_coin_object(400,price_400);

                vlive_coin_object sixhundredCoins = new vlive_coin_object(600,price_600);

                vlive_coin_object onethousandtwohundredCoins = new vlive_coin_object(1200,price_1200);

                vlive_coin_object onethousandfivehundredCoins = new vlive_coin_object(1500,price_1500);

                vlive_coin_object twothousandfourhundredCoins = new vlive_coin_object(2400,price_2400);

                //get combinations

                int[] arr={50,100,150,200,400,600,1200,1500,2400};

                int tar=coin_amount;

                int i=0;


                //1) by factors

                while(i<arr.length){

                    int val=0;
                    int cnt=0;

                    while(val<tar){

                        val+=arr[i];

                        cnt++;

                        if(val==tar) {
                            System.out.println(cnt + " of " + arr[i] + " make " + tar);
                        }

                        if(val>tar){
                            System.out.println(arr[i] + " is not a factor");
                        }

                    }
                    i++;
                }


                //2)

                Integer[] numbers = {50,100,150,200,400,600,1200,1500,2400};
                int target = 1500;

                sum_up(new ArrayList<Integer>(Arrays.asList(numbers)),target);


                //determine price

                //determine lowest

                //return combination

                //3)

                ArrayList combinations= new ArrayList();

                ArrayList combinations_factors = new ArrayList();

                //4)

                List<Map<String,String>> ListofMap = new ArrayList<Map<String,String>>();

            }

        });
    }

}
