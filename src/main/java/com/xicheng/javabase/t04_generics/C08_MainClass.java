package com.xicheng.javabase.t04_generics;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-06-14 10:16
 */
public class C08_MainClass {

    public static void main(String[] args) {
        C08_CoffeeGenerator generator = new C08_CoffeeGenerator();
        C08_Coffee coffee = generator.generate(C08_CoffeeCategoryEnum.MOCHA);
        coffee.saySomething();
    }
}
