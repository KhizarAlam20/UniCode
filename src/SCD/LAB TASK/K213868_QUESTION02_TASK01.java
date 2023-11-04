public class K213868_QUESTION02_TASK01 {
    public static void main(String[] args) {
        System.out.println("Q2 TASK1 K213868\n--------------------");


        System.out.println("\n====================\n");
        BIRD b = new BIRD();
        b.move();
        b.makeSound();

        System.out.println("\n====================\n");
        PANTHERA p = new PANTHERA();
        p.makeSound();
        p.move();

    }
}

abstract class ANIMAL {
    void move() {
        System.out.println("In animal class");
    }

    void makeSound() {
        System.out.println("in animal class ! producing sounds");
    }


}

class BIRD extends ANIMAL {

    @Override
    void move() {
        System.out.println("Birds Fly!!!");
    }

    @Override
    void makeSound() {
        System.out.println("Birds Chirps!!!");
    }

}

class PANTHERA extends ANIMAL {

    @Override
    void move() {
        System.out.println("Animals Move by LEGS!!!");
    }

    @Override
    void makeSound() {
        System.out.println("Animals Bark and Roar!!!");
    }

}