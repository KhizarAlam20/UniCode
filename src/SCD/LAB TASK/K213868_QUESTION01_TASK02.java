public class K213868_QUESTION01_TASK02 {
    public static void main(String[] args) {
        System.out.println("Q1 TASK2 K213868\n--------------------");
        dog d = new dog();
        d.bark();
    }
}

interface animal {
    void bark();
}
class dog implements animal{

    @Override
    public void bark() {
        System.out.println("Dog is Barking!!!");
    }
}