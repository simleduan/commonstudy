package com.sime.designmode.factoryMethod;

/**
 * 工厂方法
 */
public abstract class Factory {
    abstract public Zoo factoryMethod();
    public void doSomeThing(){
        Zoo zoo = factoryMethod();
        System.out.println("工厂方法执行了");
    }
}
