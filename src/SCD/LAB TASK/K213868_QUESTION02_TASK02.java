public class K213868_QUESTION02_TASK02 {
    public static void main(String[] args) {
        System.out.println("Q2 TASK2 K213868\n--------------------");


        System.out.println("\n====================\n");
        TIGER T = new TIGER();
        T.eat();
        T.sound();

        System.out.println("\n====================\n");
        LION l = new LION();
        l.eat();
        l.sound();

        System.out.println("\n====================\n");
        PANTHER p = new PANTHER();
        p.eat();
        p.sound();

    }
}

abstract class animals {
    void eat() {
        System.out.println("In animal class");
    }

    void sound() {
        System.out.println("in animal class ! producing sounds");
    }


}

class LION extends animals {

    @Override
    void eat() {
        System.out.println("LION EAT MEAT!!!");
    }

    @Override
    void sound() {
        System.out.println("LION ROAR!!!");
    }

}

class TIGER extends animals {

    @Override
    void eat() {
        System.out.println("TIGER HUNT AND EAT MEAT!!!");
    }

    @Override
    void sound() {
        System.out.println("TIGER ROAR!!!");
    }
}

class PANTHER extends animals {

    @Override
    void eat() {
        System.out.println("PANTHER EAT ANIMALS!!!");
    }

    @Override
    void sound() {
        System.out.println("PANTHER PURRS!!!");
    }
}