package SCD.servlets;


import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MainServ {
    public static void main(String[] args) throws IOException, URISyntaxException {
        // Assuming your web app is running on http://localhost:8080/YourWebAppName
        String webAppUrl = "http://localhost:9494/HelloWorld/";

        try {
            // Open the default web browser with the specified URL
            Desktop.getDesktop().browse(new URI(webAppUrl));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}

/***
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class MainServ {
    public static void main(String[] args) throws IOException, URISyntaxException {
        // Assuming your web app is running on http://localhost:8080/YourWebAppName
        String webAppUrl = "http://localhost:9494/MyWebApp/add";

        // Open the web page in Chrome
        try {
            Desktop.getDesktop().browse(new URI(webAppUrl));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        // Wait for user input (you may need to add some delay or use a different approach)
        // For simplicity, this example uses a manual sleep, but in a real-world scenario, you might use event-driven programming or some other approach.
        try {
            Thread.sleep(10000); // Wait for 5 seconds (adjust as needed)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Make an HTTP request to the servlet and read the response
        URL url = new URL(webAppUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            // Print or process the response as needed
            System.out.println("Response from the server:\n" + response.toString());
        } finally {
            connection.disconnect();
        }
    }
}

*/