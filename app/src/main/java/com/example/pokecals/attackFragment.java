package com.example.pokecals;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.google.android.gms.ads.AdView;


public class attackFragment extends Fragment {
    private final static String atkMode = "atk";
    private final static String type1 = "tp1";
    private final static String type2 = "tp2";
    private final static String type3 = "tp3";
    private final static String type4 = "tp4";
    private final static String effectiveness = "efct";

    protected View mView;

    boolean atk = true;
    int tp1, tp2, tp3, tp4;
    double efct = 1;

    Spinner dropDown1;
    Spinner dropDown2;
    Spinner dropDown3;
    Spinner dropDown4;
    ImageButton arrro;
    ImageView pokepic;
    TextView mode;
    TextView dps;
    LinearLayout wal;



    final double[][] typeEffect = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, .5, 0, 1, 1, .5, 1, 1},
            {1, .5, .5, 1, 2, 2, 1, 1, 1, 1, 1, 2, .5, 1, .5, 1, 2, 1, 1},
            {1, 2, .5, 1, .5, 1, 1, 1, 2, 1, 1, 1, 2, 1, .5, 1, 1, 1, 1},
            {1, 1, 2, .5, .5, 1, 1, 1, 0, 2, 1, 1, 1, 1, .5, 1, 1, 1, 1},
            {1, .5, 2, 1, .5, 1, 1, .5, 2, .5, 1, .5, 2, 1, .5, 1, .5, 1, 1},
            {1, .5, .5, 1, 2, .5, 1, 1, 2, 2, 1, 1, 1, 1, 2, 1, .5, 1, 1},
            {2, 1, 1, 1, 1, 2, 1, .5, 1, .5, .5, .5, 2, 0, 1, 2, 2, .5, 1},
            {1, 1, 1, 1, 2, 1, 1, .5, .5, 1, 1, 1, .5, .5, 1, 1, 0, 2, 1},
            {1, 2, 1, 2, .5, 1, 1, 2, 1, 0, 1, .5, 2, 1, 1, 1, 2, 1, 1},
            {1, 1, 1, .5, 2, 1, 2, 1, 1, 1, 1, 2, .5, 1, 1, 1, .5, 1, 1},
            {1, 1, 1, 1, 1, 1, 2, 2, 1, 1, .5, 1, 1, 1, 1, 0, .5, 1, 1},
            {1, .5, 1, 1, 2, 1, .5, .5, 1, .5, 2, 1, 1, .5, 1, 2, .5, .5, 1},
            {1, 2, 1, 1, 1, 2, .5, 1, .5, 2, 1, 2, 1, 1, 1, 1, .5, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, .5, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, .5, 0, 1},
            {1, 1, 1, 1, 1, 1, .5, 1, 1, 1, 2, 1, 1, 2, 1, .5, 1, .5, 1},
            {1, .5, .5, .5, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, .5, 2, 1},
            {1, 1, 1, 1, 1, 1, 1, 2, .5, 1, 1, 1, 1, 1, 2, 2, .5, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };


    //private AdView mAdView;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_attack, container, false);

        //super.onCreate(savedInstanceState);

        /*
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = mAdView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
*/
        arrro = rootView.findViewById(R.id.imageButton3);
        dropDown1 = rootView.findViewById(R.id.spinner1);
        dropDown2 = rootView.findViewById(R.id.spinner2);
        dropDown3 = rootView.findViewById(R.id.spinner3);
        dropDown4 = rootView.findViewById(R.id.spinner4);
        dps = rootView.findViewById(R.id.textView3);
        mode = rootView.findViewById(R.id.textView);
        pokepic = rootView.findViewById(R.id.imageView);
        wal = rootView.findViewById(R.id.wallp);

        final Integer[] types = new Integer[]{R.drawable.nm, R.drawable.fi, R.drawable.wt, R.drawable.el,
                R.drawable.gs, R.drawable.ic, R.drawable.ft, R.drawable.ps, R.drawable.gd,
                R.drawable.fy, R.drawable.py, R.drawable.bg, R.drawable.rk, R.drawable.gh,
                R.drawable.dg, R.drawable.dk, R.drawable.st, R.drawable.fr};



        if (savedInstanceState != null) {
            atk = savedInstanceState.getBoolean(atkMode);
            tp1 = savedInstanceState.getInt(type1);
            tp2 = savedInstanceState.getInt(type2);
            tp3 = savedInstanceState.getInt(type3);
            tp4 = savedInstanceState.getInt(type4);
            efct = savedInstanceState.getDouble(effectiveness);
            /*
            final SimpleImageArrayAdapter adapter = new SimpleImageArrayAdapter(this, types);
            dropDown1.setAdapter(adapter);
            dropDown2.setAdapter(adapter);
            dropDown3.setAdapter(adapter);
            dropDown4.setAdapter(adapter);
             */
        }






/*
        arrro = rootView.findViewById(R.id.imageButton3);
        dropDown1 = getView().findViewById(R.id.spinner1);
        dropDown2 = getView().findViewById(R.id.spinner2);
        dropDown3 = getView().findViewById(R.id.spinner3);
        dropDown4 = getView().findViewById(R.id.spinner4);
        dps = getView().findViewById(R.id.textView3);
        mode = getView().findViewById(R.id.textView);
        pokepic = getView().findViewById(R.id.imageView);
        wal = getView().findViewById(R.id.wallp);

 */


        SimpleImageArrayAdapter adapter = new SimpleImageArrayAdapter(rootView.getContext(), types);
if(rootView.getContext() != null) {
    if (atk) {
        //arrro.setBackgroundResource(R.drawable.arr);
        arrro.setBackgroundResource(R.drawable.arr);
        pokepic.setBackgroundResource(R.drawable.atk);
        dropDown4.setVisibility(View.VISIBLE);
        dropDown2.setVisibility(View.GONE);
        mode.setText(R.string.atk);
        calcDps();
    } else {
        arrro.setBackgroundResource(R.drawable.arrl);
        pokepic.setBackgroundResource(R.drawable.def);
        dropDown4.setVisibility(View.GONE);
        dropDown2.setVisibility(View.VISIBLE);
        mode.setText(R.string.def);
        calcDps();
    }
}
        //arrow to toggle between attacking and defending
        arrro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (atk) {
                    arrro.setBackgroundResource(R.drawable.arrl);
                    dropDown4.setVisibility(View.GONE);
                    dropDown2.setVisibility(View.VISIBLE);
                    mode.setText(R.string.def);
                    atk = false;
                    calcDps();
                } else {
                    arrro.setBackgroundResource(R.drawable.arr);
                    dropDown4.setVisibility(View.VISIBLE);
                    dropDown2.setVisibility(View.GONE);
                    mode.setText(R.string.atk);
                    atk = true;
                    calcDps();
                }

            }
        });

//type selector 1
        dropDown1.setAdapter(adapter);
        dropDown1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemvalue = Integer.parseInt(parent.getItemAtPosition(position).toString());

                //Toast.makeText(MainActivity.this, "Selected: "+ itemvalue, Toast.LENGTH_SHORT).show();
                dropDown1.setBackgroundResource(itemvalue);
                tp1 = position;
                calcDps();
                //types[tp2] = R.drawable.nn;
                //Toast.makeText(MainActivity.this, "Selected: "+ tp1, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//type selector 2
        dropDown2.setAdapter(adapter);
        dropDown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemvalue = Integer.parseInt(parent.getItemAtPosition(position).toString());

                //Toast.makeText(MainActivity.this, "Selected: "+ itemvalue, Toast.LENGTH_SHORT).show();
                dropDown2.setBackgroundResource(itemvalue);
                tp2 = position;
                calcDps();
                //types[tp1] = R.drawable.nn;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//type selector 3
        dropDown3.setAdapter(adapter);
        dropDown3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemvalue = Integer.parseInt(parent.getItemAtPosition(position).toString());

                //Toast.makeText(MainActivity.this, "Selected: "+ tp4, Toast.LENGTH_SHORT).show();
                dropDown3.setBackgroundResource(itemvalue);
                tp3 = position;
                calcDps();
                //types[tp4] = R.drawable.nn;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//type selector 4
        dropDown4.setAdapter(adapter);
        dropDown4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemvalue = Integer.parseInt(parent.getItemAtPosition(position).toString());

                //Toast.makeText(MainActivity.this, "Selected: "+ itemvalue, Toast.LENGTH_SHORT).show();
                dropDown4.setBackgroundResource(itemvalue);
                tp4 = position;
                calcDps();
                //types[tp3] = R.drawable.nn;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //wallpaper on rotation
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            wal.setBackgroundResource(R.drawable.bak2);
        } else {
            wal.setBackgroundResource(R.drawable.bak1);
        }



        return rootView;
    }

    //caculates type effectiveness
    public void calcDps(){
        if (atk){
            efct = (typeEffect[tp1][tp3] * typeEffect[tp1][tp4]);
            dps.setText(efct + "");
        }else{
            efct = (typeEffect[tp3][tp1] * typeEffect[tp3][tp2]);
            dps.setText(efct + "");
        }
        setImg();
    }

    public void setImg(){
        if (efct == .25){
            if(atk){
                pokepic.setBackgroundResource(R.drawable.atk1);
            }else{
                pokepic.setBackgroundResource(R.drawable.def1);
            }
        }
        if (efct == .5){
            if(atk){
                pokepic.setBackgroundResource(R.drawable.atk2);
            }else{
                pokepic.setBackgroundResource(R.drawable.def2);
            }
        }
        if (efct == 1){
            if(atk){
                pokepic.setBackgroundResource(R.drawable.atk3);
            }else{
                pokepic.setBackgroundResource(R.drawable.def3);
            }
        }
        if (efct == 2){
            if(atk){
                pokepic.setBackgroundResource(R.drawable.atk4);
            }else{
                pokepic.setBackgroundResource(R.drawable.def4);
            }
        }
        if (efct == 4){
            if(atk){
                pokepic.setBackgroundResource(R.drawable.atk5);
            }else{
                pokepic.setBackgroundResource(R.drawable.def5);
            }
        }


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(atkMode, atk);
        savedInstanceState.putInt(type1, tp1);
        savedInstanceState.putInt(type2, tp2);
        savedInstanceState.putInt(type3, tp3);
        savedInstanceState.putInt(type4, tp4);
        savedInstanceState.putDouble(effectiveness, efct);
    }

}
