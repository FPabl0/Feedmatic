package com.lzro.feedmatic.PetList.methods;

import com.lzro.feedmatic.PetList.contentModel.PetModel;

/**
 * Created by pablofuentes on 2/6/17.
 */

public interface ActionItemClickIntegration {
    public void onPetItemClick(PetModel petModel);
    public void onPetItemLongClick(PetModel petModel);
}
