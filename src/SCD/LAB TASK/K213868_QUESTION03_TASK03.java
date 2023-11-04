public class K213868_QUESTION03_TASK03 {
    public static void main(String[] args) {
        Eagle eagle = new Eagle();
        System.out.println("Eagle:");
        eagle.fly();
        eagle.makeSound();
        System.out.println();
        Hawk hawk = new Hawk();
        System.out.println("Hawk:");
        hawk.fly();
        hawk.makeSound();
    }
}

abstract class BirdS {
    public abstract void fly();

    public abstract void makeSound();
}

class Eagle extends BirdS {
    @Override
    public void fly() {
        System.out.println("Eagle soars high in the sky.");
    }

    @Override
    public void makeSound() {
        System.out.println("Eagle makes a high-pitched screech.");
    }
}

class Hawk extends BirdS {
    @Override
    public void fly() {
        System.out.println("Hawk glides gracefully through the air.");
    }

    @Override
    public void makeSound() {
        System.out.println("Hawk emits a sharp cry.");
    }
}
