package com.sime.designmode.factoryMethod;

public class DogFactory extends Factory {
    @Override
    public Zoo factoryMethod() {
        return new Dog();
    }
}
