package SCD;

public class substring {
    public static void main(String[] args) {
        String str = "123+4";

        String[] numbers = str.split("\\+");

        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);

        int sum = num1 + num2;
        System.out.println("Sum: " + sum);
    }
}
