package org.luisa.logs;

/**
 * Represents the severity level of a log line.
 */
public enum LogLevel {

    /** Detailed information used for tracing execution. */
    TRACE("TRC", 1),

    /** Information useful for debugging. */
    DEBUG("DBG", 2),

    /** General information about normal operation. */
    INFO("INF", 4),

    /** Indicates a potential problem. */
    WARNING("WRN", 5),

    /** Indicates that an error occurred. */
    ERROR("ERR", 6),

    /** Indicates a critical failure. */
    FATAL("FTL", 42),

    /** Used when the log level could not be recognized. */
    UNKNOWN("UNKNOWN", 0);

    private final String code;
    private final int encodedValue;

    LogLevel(String code, int encodedValue) {
        this.code = code;
        this.encodedValue = encodedValue;
    }

    /**
     * Returns the three-letter code for this log level.
     *
     * @return the log level code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Returns the numeric value used in the short log format.
     *
     * @return the encoded value
     */
    public int getEncodedValue() {
        return this.encodedValue;
    }
}
