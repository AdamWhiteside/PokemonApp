package com.example.PokeTypeCalc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class TypeFragment extends Fragment {
    private final static String typp1 = "ty1";
    private final static String typp2 = "ty2";
    private final static String s_state = "state";

    private int tp1, tp2;
    private AdView mAdView1;
    private int state = 0;

   private Spinner dropDown11, dropDown12;
    private ImageView typ1, typ2, typ3, typ4, typ5, typ6, typ7, typ8, typ9, typ10, typ11, typ12, typ13, typ14, typ15, typ16, typ17, typ18;
    private static TextView   ef1, ef2, ef3, ef4, ef5, ef6, ef7, ef8, ef9, ef10, ef11, ef12, ef13, ef14, ef15, ef16, ef17, ef18;
    private ImageButton srt;

    private final double[][] typeEffect = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, .5, 0, 1, 1, .5, 1},
            {1, 1, .5, .5, 1, 2, 2, 1, 1, 1, 1, 1, 2, .5, 1, .5, 1, 2, 1},
            {1, 1, 2, .5, 1, .5, 1, 1, 1, 2, 1, 1, 1, 2, 1, .5, 1, 1, 1},
            {1, 1, 1, 2, .5, .5, 1, 1, 1, 0, 2, 1, 1, 1, 1, .5, 1, 1, 1},
            {1, 1, .5, 2, 1, .5, 1, 1, .5, 2, .5, 1, .5, 2, 1, .5, 1, .5, 1},
            {1, 1, .5, .5, 1, 2, .5, 1, 1, 2, 2, 1, 1, 1, 1, 2, 1, .5, 1},
            {1, 2, 1, 1, 1, 1, 2, 1, .5, 1, .5, .5, .5, 2, 0, 1, 2, 2, .5},
            {1, 1, 1, 1, 1, 2, 1, 1, .5, .5, 1, 1, 1, .5, .5, 1, 1, 0, 2},
            {1, 1, 2, 1, 2, .5, 1, 1, 2, 1, 0, 1, .5, 2, 1, 1, 1, 2, 1},
            {1, 1, 1, 1, .5, 2, 1, 2, 1, 1, 1, 1, 2, .5, 1, 1, 1, .5, 1},
            {1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, .5, 1, 1, 1, 1, 0, .5, 1},
            {1, 1, .5, 1, 1, 2, 1, .5, .5, 1, .5, 2, 1, 1, .5, 1, 2, .5, .5},
            {1, 1, 2, 1, 1, 1, 2, .5, 1, .5, 2, 1, 2, 1, 1, 1, 1, .5, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, .5, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, .5, 0},
            {1, 1, 1, 1, 1, 1, 1, .5, 1, 1, 1, 2, 1, 1, 2, 1, .5, 1, .5},
            {1, 1, .5, .5, .5, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, .5, 2},
            {1, 1, 1, 1, 1, 1, 1, 1, 2, .5, 1, 1, 1, 1, 1, 2, 2, .5, 1}
    };

double[][] maths = new double[2][19];
double[][] backup = new double[2][19];
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragmant_type, container, false);

        AdView mAdView1 = rootView.findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView1.loadAd(adRequest);

        dropDown11 = rootView.findViewById(R.id.spinner11);
        dropDown12 = rootView.findViewById(R.id.spinner12);
        typ1 = rootView.findViewById(R.id.type1);
        typ2 = rootView.findViewById(R.id.type2);
        typ3 = rootView.findViewById(R.id.type3);
        typ4 = rootView.findViewById(R.id.type4);
        typ5 = rootView.findViewById(R.id.type5);
        typ6 = rootView.findViewById(R.id.type6);
        typ7 = rootView.findViewById(R.id.type7);
        typ8 = rootView.findViewById(R.id.type8);
        typ9 = rootView.findViewById(R.id.type9);
        typ10 = rootView.findViewById(R.id.type10);
        typ11 = rootView.findViewById(R.id.type11);
        typ12 = rootView.findViewById(R.id.type12);
        typ13 = rootView.findViewById(R.id.type13);
        typ14 = rootView.findViewById(R.id.type14);
        typ15 = rootView.findViewById(R.id.type15);
        typ16 = rootView.findViewById(R.id.type16);
        typ17 = rootView.findViewById(R.id.type17);
        typ18 = rootView.findViewById(R.id.type18);

        ef1 = rootView.findViewById(R.id.eff1);
        ef2 = rootView.findViewById(R.id.eff);
        ef3 = rootView.findViewById(R.id.eff2);
        ef4 = rootView.findViewById(R.id.eff3);
        ef5 = rootView.findViewById(R.id.eff4);
        ef6 = rootView.findViewById(R.id.eff5);
        ef7 = rootView.findViewById(R.id.eff6);
        ef8 = rootView.findViewById(R.id.eff7);
        ef9 = rootView.findViewById(R.id.eff8);
        ef10 = rootView.findViewById(R.id.eff9);
        ef11 = rootView.findViewById(R.id.eff10);
        ef12 = rootView.findViewById(R.id.eff11);
        ef13 = rootView.findViewById(R.id.eff12);
        ef14 = rootView.findViewById(R.id.eff13);
        ef15 = rootView.findViewById(R.id.eff14);
        ef16 = rootView.findViewById(R.id.eff15);
        ef17 = rootView.findViewById(R.id.eff16);
        ef18 = rootView.findViewById(R.id.eff17);

        srt = rootView.findViewById(R.id.imageButton);

        final Integer[] types = new Integer[]{R.drawable.nn, R.drawable.nm, R.drawable.fi, R.drawable.wt, R.drawable.el,
                R.drawable.gs, R.drawable.ic, R.drawable.ft, R.drawable.ps, R.drawable.gd,
                R.drawable.fy, R.drawable.py, R.drawable.bg, R.drawable.rk, R.drawable.gh,
                R.drawable.dg, R.drawable.dk, R.drawable.st, R.drawable.fr};

        if (savedInstanceState != null) {
            state = savedInstanceState.getInt(s_state);
            tp1 = savedInstanceState.getInt(typp1);
            tp2 = savedInstanceState.getInt(typp2);
        }

        SimpleImageArrayAdapter adapter = new SimpleImageArrayAdapter(rootView.getContext(), types);


//type selector 1
        dropDown11.setAdapter(adapter);
        dropDown11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemvalue = Integer.parseInt(parent.getItemAtPosition(position).toString());

                //Toast.makeText(MainActivity.this, "Selected: "+ itemvalue, Toast.LENGTH_SHORT).show();
                dropDown11.setBackgroundResource(itemvalue);
                tp1 = position;
                setPics(types);
                //types[tp2] = R.drawable.nn;
                //Toast.makeText(MainActivity.this, "Selected: "+ tp1, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//type selector 2
        dropDown12.setAdapter(adapter);
        dropDown12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemvalue = Integer.parseInt(parent.getItemAtPosition(position).toString());

                //Toast.makeText(MainActivity.this, "Selected: "+ itemvalue, Toast.LENGTH_SHORT).show();
                dropDown12.setBackgroundResource(itemvalue);
                tp2 = position;
                setPics(types);
                //types[tp1] = R.drawable.nn;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        if (state == 0) {
            srt.setBackgroundResource(R.drawable.sort_none);
        } else if (state == 1){
            srt.setBackgroundResource(R.drawable.sort_desc);
        } else if (state == 2){
            srt.setBackgroundResource(R.drawable.sort_asc);
        }

        //switch between sort types
        srt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state == 0) {
                    srt.setBackgroundResource(R.drawable.sort_desc);
                    state = 1;
                } else if (state == 1){
                    srt.setBackgroundResource(R.drawable.sort_asc);
                    state = 2;
                } else if (state == 2){
                    srt.setBackgroundResource(R.drawable.sort_none);
                    state = 0;
                }
                setPics(types);
            }
        });


        return rootView;
    }

    //caculates type effectiveness
    public void calcAllDps(){
        for(int i = 0; i < 19; i++){
            maths[0][i] = typeEffect[i][tp1] * typeEffect[i][tp2];
            maths[1][i] = i;
        }
double backup[][] = maths;
    }


    public void sortAsc(){
        maths = backup;


        // loop for column of matrix
        for (int j = 0; j < maths[1].length; j++) {

            // loop for comparison and swapping
            for (int k = 1; k < maths[1].length - j - 1; k++) {
                if (maths[0][k] < maths[0][k + 1]) {

                    // swapping of elements
                    double t = maths[1][k];
                    double q = maths[0][k];

                    maths[1][k] = maths[1][k + 1];
                    maths[0][k] = maths[0][k + 1];

                    maths[1][k + 1] = t;
                    maths[0][k + 1] = q;
                }
            }
        }
    }


    public void sortDesc(){
        maths = backup;
        //maths[1][1] = 1;


        // loop for column of matrix
        for (int j = 0; j < maths[1].length; j++) {

            // loop for comparison and swapping
            for (int k = 1; k < maths[1].length - j - 1; k++) {
                if (maths[0][k] > maths[0][k + 1]) {

                    // swapping of elements
                    double t = maths[1][k];
                    double q = maths[0][k];

                    maths[1][k] = maths[1][k + 1];
                    maths[0][k] = maths[0][k + 1];

                    maths[1][k + 1] = t;
                    maths[0][k + 1] = q;
                }
            }
        }
    }

    public void unsort(){
        maths = backup;

    }


    public void sort(){
        if (state == 0) {
            unsort();
        } else if (state == 1){
            sortDesc();
        } else if (state == 2){
            sortAsc();
        }
    }

    public void setPics(Integer[] types){
        calcAllDps();
        sort();
        ef1.setText("X"+ maths[0][1]);
        typ1.setBackgroundResource(types[(int) maths[1][1]]);
        ef2.setText("X"+ maths[0][2]);
        typ2.setBackgroundResource(types[(int) maths[1][2]]);
        ef3.setText("X"+ maths[0][3]);
        typ3.setBackgroundResource(types[(int) maths[1][3]]);
        ef4.setText("X"+ maths[0][4]);
        typ4.setBackgroundResource(types[(int) maths[1][4]]);
        ef5.setText("X"+ maths[0][5]);
        typ5.setBackgroundResource(types[(int) maths[1][5]]);
        ef6.setText("X"+ maths[0][6]);
        typ6.setBackgroundResource(types[(int) maths[1][6]]);
        ef7.setText("X"+ maths[0][7]);
        typ7.setBackgroundResource(types[(int) maths[1][7]]);
        ef8.setText("X"+ maths[0][8]);
        typ8.setBackgroundResource(types[(int) maths[1][8]]);
        ef9.setText("X"+ maths[0][9]);
        typ9.setBackgroundResource(types[(int) maths[1][9]]);
        ef10.setText("X"+ maths[0][10]);
        typ10.setBackgroundResource(types[(int) maths[1][10]]);
        ef11.setText("X"+ maths[0][11]);
        typ11.setBackgroundResource(types[(int) maths[1][11]]);
        ef12.setText("X"+ maths[0][12]);
        typ12.setBackgroundResource(types[(int) maths[1][12]]);
        ef13.setText("X"+ maths[0][13]);
        typ13.setBackgroundResource(types[(int) maths[1][13]]);
        ef14.setText("X"+ maths[0][14]);
        typ14.setBackgroundResource(types[(int) maths[1][14]]);
        ef15.setText("X"+ maths[0][15]);
        typ15.setBackgroundResource(types[(int) maths[1][15]]);
        ef16.setText("X"+ maths[0][16]);
        typ16.setBackgroundResource(types[(int) maths[1][16]]);
        ef17.setText("X"+ maths[0][17]);
        typ17.setBackgroundResource(types[(int) maths[1][17]]);
        ef18.setText("X"+ maths[0][18]);
        typ18.setBackgroundResource(types[(int) maths[1][18]]);
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(s_state, state);
        savedInstanceState.putInt(typp1, tp1);
        savedInstanceState.putInt(typp2, tp2);
    }
}
