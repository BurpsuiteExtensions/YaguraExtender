package yagura.model;

import com.google.gson.annotations.Expose;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Locale;
import yagura.Config;

/**
 *
 * @author isayan
 */
public class LoggingProperty {

    private final static String DEFAULT_LOG_TIMESTAMP_FORMAT = "yyyyMMdd HH:mm:ss";
    private final static String DEFAULT_LOG_DIR_FORMAT = "yyyyMMdd";

    @Expose
    private boolean autoLogging = false;

    public boolean isAutoLogging() {
        return this.autoLogging;
    }

    public void setAutoLogging(boolean autoLogging) {
        this.autoLogging = autoLogging;
    }

    @Expose
    private String logBaseDir = Config.getUserDir();

    public String getBaseDir() {
        return this.logBaseDir;
    }

    public void setBaseDir(String logBaseDir) {
        this.logBaseDir = logBaseDir;
    }

    @Expose
    private int logFileLimitSize = 0;

    public int getLogFileLimitSize() {
        return this.logFileLimitSize;
    }

    public void setLogFileLimitSize(int logFileLimitSize) {
        this.logFileLimitSize = logFileLimitSize;
    }

    /**
     * @return the logFileLimitSize
     */
    public long getLogFileByteLimitSize() {
        return this.logFileLimitSize * 1024L * 1024L;
    }

    @Expose
    private boolean proxyLog = true;

    public boolean isProxyLog() {
        return this.proxyLog;
    }

    public void setProxyLog(boolean proxyLog) {
        this.proxyLog = proxyLog;
    }

    @Expose
    private boolean toolLog = true;

    public boolean isToolLog() {
        return this.toolLog;
    }

    public void setToolLog(boolean toolLog) {
        this.toolLog = toolLog;
    }

    @Expose
    private String logDirFormat = DEFAULT_LOG_DIR_FORMAT;

    public String getLogDirFormat() {
        return this.logDirFormat;
    }

    public void setLogDirFormat(String logDirFormat) {
        this.logDirFormat = logDirFormat;
    }

    private DateTimeFormatter logDateTimeFormat = DateTimeFormatter.ofPattern(DEFAULT_LOG_TIMESTAMP_FORMAT).withLocale(Locale.ENGLISH).withResolverStyle(ResolverStyle.STRICT);    
    
    private SimpleDateFormat logTimestampDateFormat = new SimpleDateFormat(DEFAULT_LOG_TIMESTAMP_FORMAT);

    @Expose
    private String logTimestampFormat = DEFAULT_LOG_TIMESTAMP_FORMAT;
    
    public String getLogTimestampFormat() {
        return this.logTimestampFormat;
    }

    public void setLogTimestampFormat(String logTimestampFormat) {
        this.logTimestampFormat = logTimestampFormat;
        this.logTimestampDateFormat = new SimpleDateFormat(logTimestampFormat);
    }

    public DateFormat getLogTimestampDateFormat() {
        return this.logTimestampDateFormat;
    }

    @Expose
    private boolean excludeFilter = false;

    public boolean isExclude() {
        return this.excludeFilter;
    }

    public void setExclude(boolean excludeFilter) {
        this.excludeFilter = excludeFilter;
    }

    @Expose
    private String excludeFilterExtension = "gif,jpg,png,css,ico";

    public String getExcludeExtension() {
        return this.excludeFilterExtension;
    }

    public void setExcludeExtension(String excludeFilterExtension) {
        this.excludeFilterExtension = excludeFilterExtension;
    }

    public void setProperty(LoggingProperty property) {
        this.setAutoLogging(property.isAutoLogging());
        this.setBaseDir(property.getBaseDir());
        this.setLogFileLimitSize(property.getLogFileLimitSize());
        this.setProxyLog(property.isProxyLog());
        this.setToolLog(property.isToolLog());
        this.setLogDirFormat(property.getLogDirFormat());
        this.setLogTimestampFormat(property.getLogTimestampFormat());
        this.setExclude(property.isExclude());
        this.setExcludeExtension(getExcludeExtension());
    }

}
