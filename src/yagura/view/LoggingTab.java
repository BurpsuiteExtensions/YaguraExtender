/*
 * LoggingTab.java
 *
 * Created on 2010/11/27, 13:30:59
 */
package yagura.view;

import burp.ITab;
import yagura.model.LoggingProperty;
import extend.util.SwingUtil;
import extend.util.Util;
import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author isayan
 */
public class LoggingTab extends javax.swing.JPanel implements ITab {

    /**
     * Creates new form LoggingTab
     */
    public LoggingTab() {
        initComponents();
        customizeComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabLogging = new javax.swing.JPanel();
        pnlCenter = new javax.swing.JPanel();
        chkHistoryLogInclude = new javax.swing.JCheckBox();
        chkToolLog = new javax.swing.JCheckBox();
        chkProxyLog = new javax.swing.JCheckBox();
        lblFileUnit = new javax.swing.JLabel();
        txtFileLimitSize = new javax.swing.JTextField();
        lblToolTip = new javax.swing.JLabel();
        lblLogDir = new javax.swing.JLabel();
        btnSelectImage = new javax.swing.JButton();
        txtLogDir = new javax.swing.JTextField();
        lblLogDir2 = new javax.swing.JLabel();
        lblLogDir1 = new javax.swing.JLabel();
        chkAutoLogging = new javax.swing.JCheckBox();
        txtExcludeExtension = new javax.swing.JTextField();
        chkExclude = new javax.swing.JCheckBox();

        setPreferredSize(new java.awt.Dimension(550, 450));
        setLayout(new java.awt.BorderLayout());

        tabLogging.setPreferredSize(new java.awt.Dimension(550, 300));
        tabLogging.setLayout(new java.awt.BorderLayout());

        chkHistoryLogInclude.setText("history log is included(Proxy Log only)");
        chkHistoryLogInclude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkHistoryLogIncludeActionPerformed(evt);
            }
        });

        chkToolLog.setText("ToolLog:(proxy, spider, scanner, intruder, repeater tool)");
        chkToolLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkToolLogActionPerformed(evt);
            }
        });

        chkProxyLog.setText("ProxyLog(proxy history modifyed log)");
        chkProxyLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkProxyLogActionPerformed(evt);
            }
        });

        lblFileUnit.setText("MB");

        txtFileLimitSize.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtFileLimitSize.setText("0");
        txtFileLimitSize.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFileLimitSizeFocusLost(evt);
            }
        });

        lblToolTip.setText("(If this is zero, then there is no limit)");

        lblLogDir.setText("LogDir:");

        btnSelectImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yagura/resources/folder_image.png"))); // NOI18N
        btnSelectImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectImageActionPerformed(evt);
            }
        });

        txtLogDir.setEditable(false);
        txtLogDir.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLogDirFocusLost(evt);
            }
        });

        lblLogDir2.setText("logging target:");

        lblLogDir1.setText("LogSize:");

        chkAutoLogging.setText("auto logging");
        chkAutoLogging.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkAutoLoggingStateChanged(evt);
            }
        });
        chkAutoLogging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAutoLoggingActionPerformed(evt);
            }
        });

        txtExcludeExtension.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtExcludeExtension.setEnabled(false);
        txtExcludeExtension.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtExcludeExtensionFocusLost(evt);
            }
        });
        txtExcludeExtension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExcludeExtensionActionPerformed(evt);
            }
        });

        chkExclude.setText("Exclude Extension");
        chkExclude.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkExcludeStateChanged(evt);
            }
        });
        chkExclude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkExcludeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addComponent(lblLogDir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLogDir, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelectImage, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCenterLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkToolLog)
                            .addComponent(chkProxyLog)))
                    .addComponent(chkExclude, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogDir2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCenterLayout.createSequentialGroup()
                        .addComponent(lblLogDir1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFileLimitSize, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblFileUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblToolTip, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chkHistoryLogInclude, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCenterLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtExcludeExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(222, Short.MAX_VALUE))
            .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCenterLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(chkAutoLogging, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(534, Short.MAX_VALUE)))
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLogDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLogDir))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCenterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSelectImage, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogDir1)
                    .addComponent(txtFileLimitSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFileUnit)
                    .addComponent(lblToolTip))
                .addGap(18, 18, 18)
                .addComponent(lblLogDir2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkProxyLog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkToolLog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkHistoryLogInclude)
                .addGap(2, 2, 2)
                .addComponent(chkExclude)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtExcludeExtension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
            .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCenterLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(chkAutoLogging, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(423, Short.MAX_VALUE)))
        );

        tabLogging.add(pnlCenter, java.awt.BorderLayout.CENTER);

        add(tabLogging, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public String getTabCaption() {
        return "Logging";
    }

    @Override
    public Component getUiComponent() {
        return this;
    }
        
    private void chkAutoLoggingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAutoLoggingActionPerformed
        this.firePropertyChange(TabbetOption.LOGGING_PROPERTY, null, this.getLoggingProperty());
    }//GEN-LAST:event_chkAutoLoggingActionPerformed

    private void chkAutoLoggingStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkAutoLoggingStateChanged
        boolean enable = this.chkAutoLogging.isSelected();
        this.chkHistoryLogInclude.setEnabled(!enable);
    }//GEN-LAST:event_chkAutoLoggingStateChanged

    private void btnSelectImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectImageActionPerformed
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        filechooser.setSelectedFile(new File(this.txtLogDir.getText()));
        int selected = filechooser.showOpenDialog(this);
        if (selected == JFileChooser.APPROVE_OPTION) {
            File file = filechooser.getSelectedFile();
            if (file.isDirectory() && file.exists()) {
                this.txtLogDir.setText(file.getAbsolutePath());
            } else {
                JOptionPane.showMessageDialog(this, "Logging", BUNDLE.getString("view.logging.choosedir"), JOptionPane.OK_OPTION);
            }
        }
        this.firePropertyChange(TabbetOption.LOGGING_PROPERTY, null, this.getLoggingProperty());
    }//GEN-LAST:event_btnSelectImageActionPerformed

    private void txtExcludeExtensionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtExcludeExtensionFocusLost
        this.firePropertyChange(TabbetOption.LOGGING_PROPERTY, null, this.getLoggingProperty());
    }//GEN-LAST:event_txtExcludeExtensionFocusLost

    private void txtLogDirFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLogDirFocusLost
        this.firePropertyChange(TabbetOption.LOGGING_PROPERTY, null, this.getLoggingProperty());
    }//GEN-LAST:event_txtLogDirFocusLost

    private void txtFileLimitSizeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFileLimitSizeFocusLost
        this.firePropertyChange(TabbetOption.LOGGING_PROPERTY, null, this.getLoggingProperty());
    }//GEN-LAST:event_txtFileLimitSizeFocusLost

    private void chkHistoryLogIncludeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkHistoryLogIncludeActionPerformed
       this.firePropertyChange(TabbetOption.LOGGING_PROPERTY, null, this.getLoggingProperty());
    }//GEN-LAST:event_chkHistoryLogIncludeActionPerformed

    private void chkExcludeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkExcludeActionPerformed
       this.firePropertyChange(TabbetOption.LOGGING_PROPERTY, null, this.getLoggingProperty());
    }//GEN-LAST:event_chkExcludeActionPerformed

    private void chkProxyLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkProxyLogActionPerformed
       this.firePropertyChange(TabbetOption.LOGGING_PROPERTY, null, this.getLoggingProperty());
    }//GEN-LAST:event_chkProxyLogActionPerformed

    private void chkToolLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkToolLogActionPerformed
       this.firePropertyChange(TabbetOption.LOGGING_PROPERTY, null, this.getLoggingProperty());
    }//GEN-LAST:event_chkToolLogActionPerformed

    private void chkExcludeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkExcludeStateChanged
        this.txtExcludeExtension.setEnabled(this.chkExclude.isSelected());
    }//GEN-LAST:event_chkExcludeStateChanged

    private void txtExcludeExtensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExcludeExtensionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExcludeExtensionActionPerformed
    protected final java.util.ResourceBundle BUNDLE = java.util.ResourceBundle.getBundle("yagura/resources/Resource");

    private void customizeComponents() {
        this.txtFileLimitSize.setDocument(new SwingUtil.IntegerDocument());
        // Logging Tab
        this.chkAutoLogging.setSelected(this.isAutoLogging());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelectImage;
    private javax.swing.JCheckBox chkAutoLogging;
    private javax.swing.JCheckBox chkExclude;
    private javax.swing.JCheckBox chkHistoryLogInclude;
    private javax.swing.JCheckBox chkProxyLog;
    private javax.swing.JCheckBox chkToolLog;
    private javax.swing.JLabel lblFileUnit;
    private javax.swing.JLabel lblLogDir;
    private javax.swing.JLabel lblLogDir1;
    private javax.swing.JLabel lblLogDir2;
    private javax.swing.JLabel lblToolTip;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel tabLogging;
    private javax.swing.JTextField txtExcludeExtension;
    private javax.swing.JTextField txtFileLimitSize;
    private javax.swing.JTextField txtLogDir;
    // End of variables declaration//GEN-END:variables
    private boolean beforeAutoLogging = false;

    /**
     * @return the autoLogging
     */
    public boolean isAutoLogging() {
        return this.chkAutoLogging.isSelected();
    }

    /**
     * @param autoLogging the autoLogging to set
     */
    public void setAutoLogging(boolean autoLogging) {
        this.beforeAutoLogging = autoLogging;
        this.chkAutoLogging.setSelected(autoLogging);
    }
    private String beforeLogDir = "";

    public String getBaseDir() {
        return this.txtLogDir.getText();
    }

    public void setLogDir(String logdir) {
        this.beforeLogDir = logdir;
        this.txtLogDir.setText(logdir);
    }

    public boolean isLogDirChanged() {
        return this.isAutoLogging() && (beforeAutoLogging != this.isAutoLogging()
                || (!this.beforeLogDir.equalsIgnoreCase(this.txtLogDir.getText())) || isHistoryLogInclude());
    }

    /**
     * @return the logFileLimitSize
     */
    public int getLogFileLimitSize() {
        return Util.parseIntDefault(this.txtFileLimitSize.getText(), 0); // MB
    }

    /**
     * @param logFileLimitSize the logFileLimitSize to set
     */
    public void setLogFileLimitSize(int logFileLimitSize) {
        this.txtFileLimitSize.setText(String.valueOf(logFileLimitSize));
    }

    /**
     *
     * @return
     */
    public boolean isProxyLog() {
        return this.chkProxyLog.isSelected();
    }

    /**
     *
     * @param value
     */
    public void setProxyLog(boolean value) {
        this.chkProxyLog.setSelected(value);
    }

    /**
     *
     * @return
     */
    public boolean isToolLog() {
        return this.chkToolLog.isSelected();
    }

    /**
     *
     * @param value
     */
    public void setToolLog(boolean value) {
        this.chkToolLog.setSelected(value);
    }

    /**
     * @return the HistoryLogSave
     */
    public boolean isHistoryLogInclude() {
        return this.chkHistoryLogInclude.isSelected();
    }

    /**
     * @return the ExcludeFilter
     */
    public boolean isExclude() {
        return this.chkExclude.isSelected();
    }

    /**
     * @param exclude
     */
    public void setExclude(boolean exclude) {
        this.chkExclude.setSelected(exclude);
    }

    /**
     * @return the Exclude
     */
    public String getExcludeExtension() {
        return this.txtExcludeExtension.getText();
    }

    /**
     * @param extensionFilter
     */
    public void setExcludeExtension(String extensionFilter) {
        this.txtExcludeExtension.setText(extensionFilter);
    }

    public void setLoggingProperty(LoggingProperty loggingProperty) {
        this.setAutoLogging(loggingProperty.isAutoLogging());
        this.setLogDir(loggingProperty.getBaseDir());
        this.setLogFileLimitSize(loggingProperty.getLogFileLimitSize());
        this.setProxyLog(loggingProperty.isProxyLog());
        this.setToolLog(loggingProperty.isToolLog());
        this.setExclude(loggingProperty.isExclude());
        this.setExcludeExtension(loggingProperty.getExcludeExtension());
    }

    public LoggingProperty getLoggingProperty() {
        LoggingProperty loggingProperty = new LoggingProperty();
        loggingProperty.setAutoLogging(this.isAutoLogging());
        loggingProperty.setBaseDir(this.getBaseDir());
        loggingProperty.setLogFileLimitSize(this.getLogFileLimitSize());
        loggingProperty.setProxyLog(this.isProxyLog());
        loggingProperty.setToolLog(this.isToolLog());
        loggingProperty.setExclude(this.isExclude());
        loggingProperty.setExcludeExtension(this.getExcludeExtension());
        return loggingProperty;
    }

}
