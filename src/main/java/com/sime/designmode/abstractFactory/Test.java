package com.sime.designmode.abstractFactory;

public class Test {
    public static void main(String[] args) {
        CreateAnimalFactory animalFactory = new CreateAnimalFactory();
        LuDiAnimal luDiAnimal = animalFactory.createLuDiAnimal();
        WaterAnimal waterAnimal = animalFactory.createWaterAnimal();

    }
}
