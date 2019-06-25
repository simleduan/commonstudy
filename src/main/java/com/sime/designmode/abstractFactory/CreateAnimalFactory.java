package com.sime.designmode.abstractFactory;

public class CreateAnimalFactory extends AnimalFactory {

    @Override
    LuDiAnimal createLuDiAnimal() {
        return new LuDiDog();
    }

    @Override
    WaterAnimal createWaterAnimal() {
        return new WaterFish();
    }
}
