package src;
public class LogParser {
    
    public LogEntry parse(String line) {
        String[] parts = line.split(" ", 3);

        String timestamp = parts[0];
        LogLevel level = LogLevel.valueOf(parts[1]);
        String message = parts[2];

        return new LogEntry(timestamp, level, message);
    }
}
