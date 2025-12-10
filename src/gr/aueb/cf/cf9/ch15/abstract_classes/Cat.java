package gr.aueb.cf.cf9.ch15.abstract_classes;

public class Cat extends Animal {

    @Override
    public void speak() {
        System.out.println("Meow!");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("She ate all her food!");
    }
}
