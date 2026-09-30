package src;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Set;

public class LogAnalyzer {
    private final List<LogEntry> entry;

    public LogAnalyzer(List<LogEntry> entry) {
        this.entry = entry;
    }

    public long countByLevel(LogLevel level) {
        return entry.stream()
                .filter(e -> e.getLevel() == level)
                .count();
    }

    public Map<LogLevel, Long> countLevels() {
        return entry.stream()
                .collect(Collectors.groupingBy(LogEntry::getLevel, Collectors.counting()));
    }

    public Set<String> uniqueMessagesByLevel(LogLevel level) {
        return entry.stream()
                .filter(e -> e.getLevel() == level)
                .map(LogEntry::getMessage)
                .collect(Collectors.toSet());
    }

    public Map<String, Long> mostCommonMessages() {
        return entry.stream()
                .collect(Collectors.groupingBy(LogEntry::getMessage, Collectors.counting()));
    }
}
