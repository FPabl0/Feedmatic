package com.lzro.feedmatic.PetList.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lzro.feedmatic.PetList.adapter.OnPetItemClickListener;
import com.lzro.feedmatic.PetList.adapter.PetAdapter;
import com.lzro.feedmatic.PetList.contentModel.PetModel;
import com.lzro.feedmatic.PetList.methods.ActionItemClickIntegration;
import com.lzro.feedmatic.R;

/**
 * Created by pablofuentes on 3/6/17.
 */

public class PetListFragment extends Fragment implements PetListFragmentListener, OnPetItemClickListener{

    RecyclerView recyclerView;
    private PetAdapter adapter;
    private PetModel[] tempPetModel;
    private ActionItemClickIntegration actionItemClickIntegration;

    public PetListFragment() {
        // Required empty public constructor
    }

    public void setPetActionItemClickIntegration(ActionItemClickIntegration actionItemClickIntegration){
        this.actionItemClickIntegration = actionItemClickIntegration;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pet_list_fragment, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewPetList);
        initAdapter();
        initRecyclerView();
        return view;
    }

    private void initAdapter() {
        if(adapter == null){
            adapter = new PetAdapter(getActivity().getApplicationContext(), this);
        }
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onPetItemClick(PetModel petModel) {
        actionItemClickIntegration.onPetItemClick(petModel);
    }

    @Override
    public void initTempModel(int nbrOfTempModel) {
        tempPetModel = new PetModel[nbrOfTempModel];
    }

    @Override
    public void addTempModel(int index, PetModel temp) {
        index = index - 1;
        tempPetModel[index] = temp;
    }

    @Override
    public PetModel getTempModel(int index) {
        index = index - 1;
        return tempPetModel[index];
    }

    @Override
    public void addToList(PetModel record) {
        adapter.add(record);
    }

    @Override
    public void clearList() {
        adapter.clear();
    }
}
