package com.sime.designmode.factoryMethod;

public class CatFactory extends Factory {
    @Override
    public Zoo factoryMethod() {
        return new Cat();
    }
}
