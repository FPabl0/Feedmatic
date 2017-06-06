package com.lzro.feedmatic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.lzro.feedmatic.PetList.methods.CurrentPet;

public class PetDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_detail);

        Log.d("CURRENT PET", CurrentPet.getInstance().get().getName());


    }
}
