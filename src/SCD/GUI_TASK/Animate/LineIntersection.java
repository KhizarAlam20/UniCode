package SCD.GUI_TASK.Animate;

public class LineIntersection {
    public static void main(String[] args) {
        // Line 1
        int x1_line1 = 1, y1_line1 = 2;
        int x2_line1 = 3, y2_line1 = 1;

        // Line 2
        int x1_line2 = 4, y1_line2 = 1;
        int x2_line2 = 2, y2_line2 = 3;

        // Calculate slopes
        double slopeLine1 = calculateSlope(x1_line1, y1_line1, x2_line1, y2_line1);
        double slopeLine2 = calculateSlope(x1_line2, y1_line2, x2_line2, y2_line2);

        // Check if lines intersect
        if (areSlopesEqual(slopeLine1, slopeLine2)) {
            System.out.println("Lines are either parallel or coincident.");
        } else {
            System.out.println("Lines intersect.");
        }
    }

    // Function to calculate slope
    private static double calculateSlope(int x1, int y1, int x2, int y2) {
        if (x2 - x1 == 0) {
            // Vertical line, slope is undefined
            return Double.POSITIVE_INFINITY;
        } else {
            return (double) (y2 - y1) / (x2 - x1);
        }
    }

    // Function to check if slopes are equal, handling vertical lines
    private static boolean areSlopesEqual(double slope1, double slope2) {
        return slope1 == slope2 || Double.isInfinite(slope1) && Double.isInfinite(slope2);
    }
}


