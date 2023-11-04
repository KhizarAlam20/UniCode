import java.util.Scanner;

public class PatternExample {
    public static void main(String[] args) {
//        int size = 5; // Adjust the size of the pattern
//        int i, j;

        // Pattern of circles
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
        System.out.println();  // Pattern of rectangles
//        for (i = 1; i <= size; i++) {
//            for (j = 1; j <= size; j++) {
//                System.out.print("r ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//
//        // Pattern of triangles
//        for (i = 1; i <= size; i++) {
//            for (j = 1; j <= i; j++) {
//                System.out.print("t ");
//            }
//            System.out.println();
//        }

//
    }
}