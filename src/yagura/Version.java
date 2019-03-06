package yagura;

import burp.BurpExtender;
import static burp.BurpExtender.getExtensionLogDir;
import extend.util.CustomVersion;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author isayan
 */
public final class Version extends CustomVersion {

    protected final java.util.ResourceBundle BUNDLE = java.util.ResourceBundle.getBundle("burp/release");

    private Version() {
        String ver = BUNDLE.getString("version");
        parseVersion(ver);
    }

    private static Version version = null;

    /**
     * Versionインスタンスの取得
     *
     * @return バージョン
     */
    public static synchronized Version getInstance() {
        if (version == null) {
            version = new Version();
        }
        return version;
    }
    
    private final static String VERSION_INFO_FMT = 
            "Product Version: YaguraExtender %s\n" + 
            "Log Dir: %s\n" +
            "User Dir: %s\n";    

    public String getVersionInfo() {
        return String.format(VERSION_INFO_FMT, 
                Version.getInstance().getVersion(), 
                BurpExtender.getExtensionLogDir().getAbsoluteFile(),
                Config.getUserDir());    
    }
    
}
