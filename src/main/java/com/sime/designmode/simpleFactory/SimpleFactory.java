package com.sime.designmode.simpleFactory;

public class SimpleFactory {

    public Zoo createZoo(int type){
        if (1==type){
            return new Dog();
        } else if (2==type){
            return new Cat();
        }else {
            return null;
        }
    }
}
