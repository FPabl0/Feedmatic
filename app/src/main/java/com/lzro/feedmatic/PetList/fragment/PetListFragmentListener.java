package com.lzro.feedmatic.PetList.fragment;

import com.lzro.feedmatic.PetList.contentModel.PetModel;

/**
 * Created by pablofuentes on 2/6/17.
 */

public interface PetListFragmentListener {
    void initTempModel(int nbrOfTempModel);
    void addTempModel(int index, PetModel temp);
    PetModel getTempModel(int index);
    void addToList(PetModel record);
    void clearList();
}
