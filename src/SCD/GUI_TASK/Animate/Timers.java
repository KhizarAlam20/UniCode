package SCD.GUI_TASK.Animate;

import SCD.GUI_TASK.ConvexHullAlgorithms.LineIntersectionCCW;

public class Timers {
    private static boolean condition = true;

    public static void main(String[] args) {

        LineIntersectionCCW d = new LineIntersectionCCW();
        // Create a separate thread for the loop
        Thread loopThread = new Thread(() -> {
            for (int counter = 0; condition && counter < 10; counter++) {
                System.out.println("Elapsed seconds: " + counter);

                // Simulate some work being done
                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Loop finished.");
        });

        // Start the loop thread
        loopThread.start();

        // Simulate some other work in the main thread
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Set the condition to false to stop the loop
        condition = false;
    }
}
