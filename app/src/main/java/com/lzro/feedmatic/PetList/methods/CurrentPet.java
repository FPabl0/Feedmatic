package com.lzro.feedmatic.PetList.methods;

import com.lzro.feedmatic.PetList.contentModel.PetModel;

/**
 * Created by pablofuentes on 5/6/17.
 */

public class CurrentPet {
    private PetModel petModel;
    private static final CurrentPet ourInstance = new CurrentPet();
    public static CurrentPet getInstance() {
        return ourInstance;
    }
    private CurrentPet() {
    }

    public void set(PetModel petModel){
        this.petModel = petModel;
    }

    public PetModel get(){
        return petModel;
    }
}
