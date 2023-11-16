package SCD.GUI_TASK.Animate;

public class LineIntersection {

    public static void linesIntersect(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        double m1 = (double)(y2 - y1) / (x2 - x1);
        double m2 = (double)(y4 - y3) / (x4 - x3);


        if (m1 == m2) {
            if (y1 - m1 * x1 == y3 - m2 * x3) {
                System.out.println("Lines are the same (technically intersect everywhere).");
            } else {
                System.out.println("Lines are parallel and do not intersect.");
            }
        } else {
            double b1 = y1 - m1 * x1;
            double b2 = y3 - m2 * x3;

            if (b1 == b2) {
                System.out.println("Lines intersect.");
            } else {
                System.out.println("Lines do not intersect.");
            }
        }
    }

    public static void checkIntersections(int[][] lines) {
        int numLines = lines.length;

        for (int i = 0; i < numLines; i++) {
            for (int j = i + 1; j < numLines; j++) {
                System.out.println("Checking lines " + (i + 1) + " and " + (j + 1) + ":");
                linesIntersect(lines[i][0], lines[i][1], lines[i][2], lines[i][3],
                        lines[j][0], lines[j][1], lines[j][2], lines[j][3]);
                System.out.println();
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        int[][] lines = {
                {1, 1, 4, 4},
                {1, 4, 4, 1},
                {2, 2, 5, 5},
                {2, 5, 5, 2}
        };

        checkIntersections(lines);
    }
}

