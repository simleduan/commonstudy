package com.sime.designmode.simpleFactory;

public class Test {

    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        Zoo zoo = factory.createZoo(1);
        zoo.eat();

    }
}
