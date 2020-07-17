package com.example.PokeTypeCalc;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class colorFragment extends Fragment {
    private AdView mAdView;
    private Button btn1, btn2, btn3, btn4, btn5, btn6;
    //private FrameLayout frm;
     MainActivity mainA;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstaceState){
        View rootView = inflater.inflate(R.layout.fragment_color, container, false);

        AdView mAdView = rootView.findViewById(R.id.adView5);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        btn1 = rootView.findViewById(R.id.color_btn_1);
        btn2 = rootView.findViewById(R.id.color_btn_2);
        btn3 = rootView.findViewById(R.id.color_btn_3);
        btn4 = rootView.findViewById(R.id.color_btn_4);
        btn5 = rootView.findViewById(R.id.color_btn_5);
        btn6 = rootView.findViewById(R.id.color_btn_6);
        //frm = rootView.findViewById(R.id.fragment_contain);





mainA = (MainActivity) getActivity();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            mainA.frm.setBackgroundResource(R.color.colorAccent);
            mainA.saveColor();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainA.frm.setBackgroundResource(R.color.colorGreat);
                mainA.color = 1;
                mainA.saveColor();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainA.frm.setBackgroundResource(R.color.colorUltra);
                mainA.color = 2;
                mainA.saveColor();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainA.frm.setBackgroundResource(R.color.colorMaster);
                mainA.color = 3;
                mainA.saveColor();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainA.frm.setBackgroundResource(R.color.colorPremiere);
                mainA.color = 4;
                mainA.saveColor();
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainA.frm.setBackgroundResource(R.color.colorHeavy);
                mainA. color = 5;
                mainA.saveColor();
            }
        });

        return rootView;
    }


    public void onCreate(){
    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}

