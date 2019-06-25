package com.sime.designmode.abstractFactory;

public class CreatePersonFactory extends PersonFactory {
    @Override
    ChinaPerson createChinaPerson() {
        return new ChinaFanbin();
    }

    @Override
    ForeignerPerson createForeignerPerson() {
        return new ForeignerLucy();
    }
}
