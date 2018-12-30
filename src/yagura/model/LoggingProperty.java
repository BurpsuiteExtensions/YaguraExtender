package yagura.model;

import yagura.Config;
import java.text.SimpleDateFormat;

/**
 *
 * @author isayan
 */
public class LoggingProperty {
    private final static String DEFAULT_LOG_TIMESTAMP_FORMAT = "yyyyMMdd HH:mm:ss";
    private final static String DEFAULT_LOG_DIR_FORMAT = "yyyyMMdd";
    private String logTimestampFormat = DEFAULT_LOG_TIMESTAMP_FORMAT;

    private boolean autoLogging = false;
    
    public boolean isAutoLogging() {
        return this.autoLogging;
    }

    public void setAutoLogging(boolean autoLogging) {
        this.autoLogging = autoLogging;
    }
    
    private String logBaseDir = Config.getUserDir();
    
    public String getBaseDir() {
        return this.logBaseDir;
    }
    
    public void setBaseDir(String logBaseDir) {
        this.logBaseDir = logBaseDir;
    }

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
    public int getLogFileByteLimitSize() {
        return this.logFileLimitSize * 1024 * 1024;
    }

    private boolean proxyLog = true;

    public boolean isProxyLog() {
        return this.proxyLog;
    }
    
    public void setProxyLog(boolean proxyLog) {
        this.proxyLog = proxyLog;
    }

    private boolean toolLog = true;
    
    public boolean isToolLog() {
        return this.toolLog;
    }
    
    public void setToolLog(boolean toolLog) {
        this.toolLog = toolLog;
    }

    private String logDirFormat = DEFAULT_LOG_DIR_FORMAT;
    
    public String getLogDirFormat() {
        return this.logDirFormat;
    }
    
    public void setLogDirFormat(String logDirFormat) {
        this.logDirFormat = logDirFormat;
    }

    private SimpleDateFormat logTimestampDateFormat = new SimpleDateFormat(DEFAULT_LOG_TIMESTAMP_FORMAT);

    public String getLogTimestampFormat() {
        return this.logTimestampFormat;
    }

    public void setLogTimestampFormat(String logTimestampFormat) {
        this.logTimestampFormat = logTimestampFormat;
        this.logTimestampDateFormat = new SimpleDateFormat(logTimestampFormat);       
    }

    public SimpleDateFormat getLogTimestampDateFormat() {
        return this.logTimestampDateFormat;
    }

    private boolean exludeFilter = false;
    
    public boolean isExludeFilter() {
        return this.exludeFilter;
    }

    public void setExludeFilter(boolean exludeFilter) {
        this.exludeFilter = exludeFilter;
    }

    private String exludeFilterExtension = "gif,jpg,png,css,ico";
    
    public String getExludeFilterExtension() {
        return this.exludeFilterExtension;
    }

    public void setExludeFilterExtension(String exludeFilterExtension) {
        this.exludeFilterExtension = exludeFilterExtension;
    }

    public void setProperty(LoggingProperty property) {
        this.setAutoLogging(property.isAutoLogging());
        this.setBaseDir(property.getBaseDir());
        this.setLogFileLimitSize(property.getLogFileLimitSize());
        this.setProxyLog(property.isProxyLog());
        this.setToolLog(property.isToolLog());
        this.setLogDirFormat(property.getLogDirFormat());
        this.setLogTimestampFormat(property.getLogTimestampFormat());
        this.setExludeFilter(property.isExludeFilter());
        this.setExludeFilterExtension(getExludeFilterExtension());
    }
        
}
