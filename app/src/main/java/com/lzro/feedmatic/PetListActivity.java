package com.lzro.feedmatic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.lzro.feedmatic.PetList.contentModel.PetModel;
import com.lzro.feedmatic.PetList.fragment.PetListFragment;
import com.lzro.feedmatic.PetList.fragment.PetListFragmentListener;
import com.lzro.feedmatic.PetList.methods.ActionItemClickIntegration;

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
            model.setLastFeed(":&");
            fragmentListener.addToList(model);
        }
    }

    @Override
    public void onPetItemClick(PetModel petModel) {

    }

    @Override
    public void onPetItemLongClick(PetModel petModel) {

    }
}
