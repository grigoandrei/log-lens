package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LogParser parser = new LogParser();
        List<LogEntry> entries = new ArrayList<>();

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("sample.log"));
            String line = reader.readLine();

            while (line != null) {
                LogEntry entry = parser.parse(line);
                entries.add(entry);
                line = reader.readLine();
            }

            LogAnalyzer analyzer = new LogAnalyzer(entries);
            System.out.println(analyzer.countLevels());
            System.out.println(analyzer.uniqueMessagesByLevel(LogLevel.ERROR));
            System.out.println(analyzer.mostCommonMessages());

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    
}
