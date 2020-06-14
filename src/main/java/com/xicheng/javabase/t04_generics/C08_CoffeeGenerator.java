package com.xicheng.javabase.t04_generics;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-06-14 10:09
 */
public class C08_CoffeeGenerator implements C08_Generator<C08_CoffeeCategoryEnum, C08_Coffee> {

    @Override
    public C08_Coffee generate(C08_CoffeeCategoryEnum coffeeCategory) {
        switch (coffeeCategory) {
            case MOCHA:
                return new C08_Mocha();
            case CAPPUCCINO:
                return new C08_Cappuccino();
            default:
                return null;
        }
    }
}
