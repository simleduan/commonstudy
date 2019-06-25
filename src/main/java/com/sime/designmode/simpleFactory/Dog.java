package com.sime.designmode.simpleFactory;

public class Dog implements Zoo {

    public Dog() {
        System.out.println("我被创建了dog");
    }

    @Override
    public void eat() {
        System.out.println("dog eat 骨头");
    }
}
