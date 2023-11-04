import java.util.Scanner;

public class K213868_QUESTION01_TASK04 {
    public static void main(String[] args) {
        System.out.println("Q1 TASK4 K213868\n--------------------");
        CIRCLESS c = new CIRCLESS();
        c.draw();

        RECTANGLESS r = new RECTANGLESS();
        r.draw();

        TRIANGLESS t = new TRIANGLESS();
        t.draw();

    }
}

interface drawable{
    void draw();
}

class CIRCLESS implements drawable{

    @Override
    public void draw() {
        System.out.println("In circle class!!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the circle: ");
        int size = scanner.nextInt();

        for (int i = 0; i < size * 2; i++) {
            for (int j = 0; j < size * 2; j++) {
                double distance = Math.sqrt(Math.pow(i - size, 2) + Math.pow(j - size, 2));
                if (distance < size) {
                    System.out.print("o ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}


class RECTANGLESS implements drawable{

    @Override
    public void draw() {
        System.out.println("In rectangle class!!");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

class TRIANGLESS implements drawable{

    @Override
    public void draw() {
        System.out.println("In Triangle class!!");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("+ ");
            }
            System.out.println();
        }
    }
}