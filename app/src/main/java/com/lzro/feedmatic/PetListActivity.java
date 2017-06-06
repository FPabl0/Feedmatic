package com.lzro.feedmatic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lzro.feedmatic.PetList.contentModel.PetModel;
import com.lzro.feedmatic.PetList.fragment.PetListFragment;
import com.lzro.feedmatic.PetList.fragment.PetListFragmentListener;
import com.lzro.feedmatic.PetList.methods.ActionItemClickIntegration;
import com.lzro.feedmatic.PetList.methods.CurrentPet;

public class PetListActivity extends AppCompatActivity implements ActionItemClickIntegration {

    private PetListFragment fragment;
    private PetListFragmentListener fragmentListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_list);

        fragment = (PetListFragment) getFragmentManager().findFragmentById(R.id.petFragmentList);
        fragment.setRetainInstance(true);
        fragment.setPetActionItemClickIntegration(this);
        fragmentListener = (PetListFragmentListener)fragment;

        fragmentListener.clearList();

        for(int i = 3; i > 0; i--){
            PetModel model = new PetModel();
            model.setName("Scrapy"+String.valueOf(i));
            model.setOnline(true);
            model.setLastFeed("01:04 pm");
            fragmentListener.addToList(model);
        }
    }

    @Override
    public void onPetItemClick(PetModel petModel) {
        CurrentPet.getInstance().set(petModel);
        Intent i = new Intent(PetListActivity.this, PetDetailActivity.class);
        startActivity(i);
    }

    @Override
    public void onPetItemLongClick(PetModel petModel) {

    }
}
