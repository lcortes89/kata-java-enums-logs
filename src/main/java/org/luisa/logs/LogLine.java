package org.luisa.logs;

/**
 * Represents a single log line and provides parsing utilities for it.
 */
public class LogLine {

    private static final int MESSAGE_OFFSET = 3;

    private final String logLine;

    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    /**
     * Parses the log level from the log line.
     *
     * @return the parsed log level, or {@code LogLevel.UNKNOWN} if not recognized
     */
    public LogLevel getLogLevel() {
        String levelText = logLine.substring(1, logLine.indexOf(']'));
        for (LogLevel level : LogLevel.values()) {
            if (level.getCode().equals(levelText)) {
                return level;
            }
        }
        return LogLevel.UNKNOWN;
    }

    /**
     * Converts the log line to its short encoded format.
     *
     * @return the log line in short format, e.g. "6:Stack Overflow"
     */
    public String getOutputForShortLog() {
        String message = logLine.substring(logLine.indexOf(']') + MESSAGE_OFFSET);
        LogLevel level = getLogLevel();
        return level.getEncodedValue() + ":" + message;
    }

}
