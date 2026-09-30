package src;

public class LogEntry {
    private final String timestamp;
    private final LogLevel level;
    private final String message;

    public LogEntry(String timestamp, LogLevel level, String message) {
        this.timestamp = timestamp;
        this.level = level;
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }
    
}
