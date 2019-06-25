package com.sime.designmode.abstractFactory;

public abstract class PersonFactory {
    abstract ChinaPerson createChinaPerson();
    abstract ForeignerPerson createForeignerPerson();
}
