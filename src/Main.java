package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        LogParser parser = new LogParser();

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("sample.log"));
            String line = reader.readLine();

            while (line != null) {
                LogEntry entry = parser.parse(line);
                System.out.println("Timestamp: " + entry.getTimestamp());
                System.out.println("Level: " + entry.getLevel());
                System.out.println("Message: " + entry.getMessage());
                System.out.println();

                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    
}
