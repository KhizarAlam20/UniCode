package SCD.GUI_TASK;

public class hello {
    public static double calculatePolarAngle(double x, double y, double x0, double y0) {
        // Calculate the differences in coordinates
        double deltaX = x - x0;
        double deltaY = y - y0;

        // Use the Math.atan2 function to find the polar angle
        double theta = Math.atan2(deltaY, deltaX);

        return theta;
    }

    public static void main(String[] args) {
        // Reference Point (x0, y0)
        double x0 = 0.0;
        double y0 = 0.0;

        // Point for which you want to find the polar angle (x, y)
        double x = 2.0;
        double y = 2.0;

        // Calculate the polar angle
        double polarAngle = calculatePolarAngle(x, y, x0, y0);

        System.out.println("Reference Point: (" + x0 + ", " + y0 + ")");
        System.out.println("Point to Calculate Angle For: (" + x + ", " + y + ")");
        System.out.println("Polar Angle (in radians): " + polarAngle);
        System.out.println("Polar Angle (in degrees): " + Math.toDegrees(polarAngle));
    }
}
