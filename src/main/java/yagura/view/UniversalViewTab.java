/*
 * UniversalViewTab.java
 *
 * Created on 2010/11/27, 12:50:08
 */
package yagura.view;

import burp.ITab;
import extend.model.base.CustomListModel;
import yagura.model.UniversalViewProperty;
import extend.util.Util;
import java.awt.Component;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author isayan
 */
public class UniversalViewTab extends javax.swing.JPanel implements ITab {

    /**
     * Creates new form EncodingTab
     */
    public UniversalViewTab() {
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

        popEncodeMenu = new javax.swing.JPopupMenu();
        tabEncoding = new javax.swing.JPanel();
        pnlCenter = new javax.swing.JPanel();
        lblSelect = new javax.swing.JLabel();
        lblTarget = new javax.swing.JLabel();
        scrollTarget = new javax.swing.JScrollPane();
        listTarget = new javax.swing.JList();
        btnEncRightArraw = new javax.swing.JButton();
        btnEncLerftArraw = new javax.swing.JButton();
        scrollSelect = new javax.swing.JScrollPane();
        listSelect = new javax.swing.JList();
        pop = new javax.swing.JButton();
        btnEncDownArraw = new javax.swing.JButton();
        chkClipboardAutoDecode = new javax.swing.JCheckBox();
        btnSelectDown = new javax.swing.JButton();
        lblSelectEncode = new javax.swing.JLabel();
        cmbDefaultLangEncoding = new javax.swing.JComboBox<>();
        btnReset = new javax.swing.JButton();
        tabMessageView = new javax.swing.JPanel();
        chkUniversalParams = new javax.swing.JCheckBox();
        chkUniversalRaw = new javax.swing.JCheckBox();
        chkJSON = new javax.swing.JCheckBox();
        chkHTMLComment = new javax.swing.JCheckBox();
        chkGeneratePoC = new javax.swing.JCheckBox();
        chkJWT = new javax.swing.JCheckBox();
        spnDispayMaxLength = new javax.swing.JSpinner();
        lblDispayMaxLength = new javax.swing.JLabel();

        setName("Encoding"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 450));
        setRequestFocusEnabled(false);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        tabEncoding.setPreferredSize(new java.awt.Dimension(550, 300));
        tabEncoding.setLayout(new java.awt.BorderLayout());

        pnlCenter.setBorder(javax.swing.BorderFactory.createTitledBorder("Encoding"));

        lblSelect.setText("Select:");

        lblTarget.setText("Target:");

        scrollTarget.setViewportView(listTarget);

        btnEncRightArraw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yagura/resources/arrow_right.png"))); // NOI18N
        btnEncRightArraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncRightArrawActionPerformed(evt);
            }
        });

        btnEncLerftArraw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yagura/resources/arrow_left.png"))); // NOI18N
        btnEncLerftArraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncLerftArrawActionPerformed(evt);
            }
        });

        scrollSelect.setViewportView(listSelect);

        pop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yagura/resources/arrow_up.png"))); // NOI18N
        pop.setText("up");
        pop.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        pop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popActionPerformed(evt);
            }
        });

        btnEncDownArraw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yagura/resources/arrow_down.png"))); // NOI18N
        btnEncDownArraw.setText("down");
        btnEncDownArraw.setHideActionText(true);
        btnEncDownArraw.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnEncDownArraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncDownArrawActionPerformed(evt);
            }
        });

        chkClipboardAutoDecode.setText("clip board auto decode");
        chkClipboardAutoDecode.setEnabled(false);
        chkClipboardAutoDecode.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkClipboardAutoDecodeStateChanged(evt);
            }
        });
        chkClipboardAutoDecode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkClipboardAutoDecodeActionPerformed(evt);
            }
        });

        btnSelectDown.setText("▼");
        btnSelectDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectDownActionPerformed(evt);
            }
        });

        lblSelectEncode.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cmbDefaultLangEncoding.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default", "Japanese", "Chinese", "Korean", "Other" }));
        cmbDefaultLangEncoding.setSelectedItem("Japanese");

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkClipboardAutoDecode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEncRightArraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEncLerftArraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addComponent(scrollSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEncDownArraw)))
                    .addComponent(lblSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbDefaultLangEncoding, 0, 163, Short.MAX_VALUE)
                            .addComponent(lblSelectEncode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelectDown)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCenterLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(517, Short.MAX_VALUE)))
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblSelect)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrollTarget, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(scrollSelect)))
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(pop)
                        .addGap(41, 41, 41)
                        .addComponent(btnEncDownArraw))
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btnEncRightArraw)
                        .addGap(35, 35, 35)
                        .addComponent(btnEncLerftArraw)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkClipboardAutoDecode)
                    .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbDefaultLangEncoding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReset)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSelectEncode, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelectDown))
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCenterLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblTarget)
                    .addContainerGap(357, Short.MAX_VALUE)))
        );

        tabEncoding.add(pnlCenter, java.awt.BorderLayout.CENTER);

        add(tabEncoding);

        tabMessageView.setBorder(javax.swing.BorderFactory.createTitledBorder("CJK MessageView"));

        chkUniversalParams.setText("Universal Params");
        chkUniversalParams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkUniversalParamsActionPerformed(evt);
            }
        });

        chkUniversalRaw.setText("Universal Raw");
        chkUniversalRaw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkUniversalRawActionPerformed(evt);
            }
        });

        chkJSON.setSelected(true);
        chkJSON.setText("JSON");
        chkJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkJSONActionPerformed(evt);
            }
        });

        chkHTMLComment.setSelected(true);
        chkHTMLComment.setText("HTML Comment");
        chkHTMLComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkHTMLCommentActionPerformed(evt);
            }
        });

        chkGeneratePoC.setSelected(true);
        chkGeneratePoC.setText("Generate PoC");
        chkGeneratePoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkGeneratePoCActionPerformed(evt);
            }
        });

        chkJWT.setSelected(true);
        chkJWT.setText("JWT");
        chkJWT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkJWTActionPerformed(evt);
            }
        });

        spnDispayMaxLength.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnDispayMaxLength.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnDispayMaxLengthStateChanged(evt);
            }
        });

        lblDispayMaxLength.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDispayMaxLength.setText("Display max length:");

        javax.swing.GroupLayout tabMessageViewLayout = new javax.swing.GroupLayout(tabMessageView);
        tabMessageView.setLayout(tabMessageViewLayout);
        tabMessageViewLayout.setHorizontalGroup(
            tabMessageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabMessageViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabMessageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkJSON)
                    .addGroup(tabMessageViewLayout.createSequentialGroup()
                        .addGroup(tabMessageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabMessageViewLayout.createSequentialGroup()
                                .addGroup(tabMessageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkGeneratePoC)
                                    .addComponent(chkHTMLComment))
                                .addGap(34, 34, 34))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabMessageViewLayout.createSequentialGroup()
                                .addComponent(lblDispayMaxLength, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(tabMessageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkUniversalParams)
                            .addComponent(chkUniversalRaw)
                            .addComponent(spnDispayMaxLength, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(chkJWT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabMessageViewLayout.setVerticalGroup(
            tabMessageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabMessageViewLayout.createSequentialGroup()
                .addGroup(tabMessageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkGeneratePoC)
                    .addComponent(chkUniversalRaw))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabMessageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkHTMLComment)
                    .addComponent(chkUniversalParams))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkJSON)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkJWT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tabMessageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnDispayMaxLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDispayMaxLength))
                .addGap(0, 298, Short.MAX_VALUE))
        );

        add(tabMessageView);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public String getTabCaption() {
        return "CJK View";
    }

    @Override
    public Component getUiComponent() {
        return this;
    }

    private final CustomListModel modelTarget = new CustomListModel();
    private final CustomListModel modelSelect = new CustomListModel();

    @SuppressWarnings("unchecked")
    private void customizeComponents() {

        // Encoding Tab
        this.listTarget.setModel(this.modelTarget);
        for (String item : Util.getAvailableEncodingList()) {
            if (!modelSelect.contains(item)) {
                this.modelTarget.addElement(item);
            }
        }
        this.modelSelect.addListDataListener(new ListDataListener() {
            @Override
            public void intervalAdded(ListDataEvent e) {
                renewPopup();
            }

            @Override
            public void intervalRemoved(ListDataEvent e) {
                renewPopup();
            }

            @Override
            public void contentsChanged(ListDataEvent e) {
                renewPopup();
            }

        });
        this.listSelect.setModel(this.modelSelect);
        this.lblSelectEncode.setVisible(false);
        this.btnSelectDown.setVisible(false);
    }

    private void btnEncRightArrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncRightArrawActionPerformed
        this.moveItemList(this.listTarget, this.listSelect);
        this.firePropertyChange(TabbetOption.CJK_VIEW_PROPERTY, null, this.getEncodingProperty());
}//GEN-LAST:event_btnEncRightArrawActionPerformed

    private void btnEncLerftArrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncLerftArrawActionPerformed
        this.moveItemList(this.listSelect, this.listTarget);
        this.firePropertyChange(TabbetOption.CJK_VIEW_PROPERTY, null, this.getEncodingProperty());
}//GEN-LAST:event_btnEncLerftArrawActionPerformed

    private void popActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popActionPerformed
        int index = this.modelSelect.moveUp(this.listSelect.getSelectedIndex());
        this.listSelect.setSelectedIndex(index);
        this.firePropertyChange(TabbetOption.CJK_VIEW_PROPERTY, null, this.getEncodingProperty());
}//GEN-LAST:event_popActionPerformed

    private void btnEncDownArrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncDownArrawActionPerformed
        int index = this.modelSelect.moveDown(this.listSelect.getSelectedIndex());
        this.listSelect.setSelectedIndex(index);
        this.firePropertyChange(TabbetOption.CJK_VIEW_PROPERTY, null, this.getEncodingProperty());
}//GEN-LAST:event_btnEncDownArrawActionPerformed

    private void chkClipboardAutoDecodeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkClipboardAutoDecodeStateChanged
    }//GEN-LAST:event_chkClipboardAutoDecodeStateChanged

    private void chkClipboardAutoDecodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkClipboardAutoDecodeActionPerformed
        this.firePropertyChange(TabbetOption.CJK_VIEW_PROPERTY, null, this.getEncodingProperty());
    }//GEN-LAST:event_chkClipboardAutoDecodeActionPerformed

    private void btnSelectDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectDownActionPerformed
        this.popEncodeMenu.show(pnlCenter, lblSelectEncode.getX(), lblSelectEncode.getY() + lblSelectEncode.getHeight());
    }//GEN-LAST:event_btnSelectDownActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        String encoding = (String) this.cmbDefaultLangEncoding.getSelectedItem();
        if (encoding.equals("Default")) {
            setEncodingList(UniversalViewProperty.getDefaultEncodingList(null));
        }
        else if (encoding.equals("Japanese")) {
            setEncodingList(UniversalViewProperty.getDefaultEncodingList(Locale.JAPANESE));
        } else if (encoding.equals("Chinese")) {
            setEncodingList(UniversalViewProperty.getDefaultEncodingList(Locale.CHINESE));
        } else if (encoding.equals("Korean")) {
            setEncodingList(UniversalViewProperty.getDefaultEncodingList(Locale.KOREAN));
        } else if (encoding.equals("Other")) {
            setEncodingList(UniversalViewProperty.getDefaultEncodingList(Locale.US));
        }
        this.firePropertyChange(TabbetOption.CJK_VIEW_PROPERTY, null, this.getEncodingProperty());
    }//GEN-LAST:event_btnResetActionPerformed

    private void chkUniversalParamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkUniversalParamsActionPerformed
        this.firePropertyChange(TabbetOption.CJK_VIEW_PROPERTY, null, this.getEncodingProperty());
    }//GEN-LAST:event_chkUniversalParamsActionPerformed

    private void chkUniversalRawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkUniversalRawActionPerformed
        this.firePropertyChange(TabbetOption.CJK_VIEW_PROPERTY, null, this.getEncodingProperty());
    }//GEN-LAST:event_chkUniversalRawActionPerformed

    private void chkJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkJSONActionPerformed
        this.firePropertyChange(TabbetOption.CJK_VIEW_PROPERTY, null, this.getEncodingProperty());
    }//GEN-LAST:event_chkJSONActionPerformed

    private void chkHTMLCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkHTMLCommentActionPerformed
        this.firePropertyChange(TabbetOption.CJK_VIEW_PROPERTY, null, this.getEncodingProperty());
    }//GEN-LAST:event_chkHTMLCommentActionPerformed

    private void chkGeneratePoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkGeneratePoCActionPerformed
        this.firePropertyChange(TabbetOption.CJK_VIEW_PROPERTY, null, this.getEncodingProperty());
    }//GEN-LAST:event_chkGeneratePoCActionPerformed

    private void chkJWTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkJWTActionPerformed
        this.firePropertyChange(TabbetOption.CJK_VIEW_PROPERTY, null, this.getEncodingProperty());
    }//GEN-LAST:event_chkJWTActionPerformed

    private void spnDispayMaxLengthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnDispayMaxLengthStateChanged
        this.firePropertyChange(TabbetOption.CJK_VIEW_PROPERTY, null, this.getEncodingProperty());
    }//GEN-LAST:event_spnDispayMaxLengthStateChanged

    private void renewPopup() {
        String encodeList[] = {"PlatformDefault", "AutoRecognise", "RawBytes"};
        this.popEncodeMenu.removeAll();
        ButtonGroup group = new ButtonGroup();
        for (String enc : encodeList) {
            JRadioButtonMenuItem item = new JRadioButtonMenuItem(enc);
            group.add(item);
            this.popEncodeMenu.add(item);
        }
        if (this.listSelect.getModel().getSize() > 0) {
            this.popEncodeMenu.addSeparator();
        }
        for (int i = 0; i < this.listSelect.getModel().getSize(); i++) {
            String enc = String.valueOf(this.listSelect.getModel().getElementAt(i));
            JRadioButtonMenuItem item = new JRadioButtonMenuItem(enc);
            item.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    JMenuItem menuItem = (JMenuItem) e.getSource();
                    menuItem.getText();
                }
            });
            group.add(item);
            this.popEncodeMenu.add(item);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEncDownArraw;
    private javax.swing.JButton btnEncLerftArraw;
    private javax.swing.JButton btnEncRightArraw;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSelectDown;
    private javax.swing.JCheckBox chkClipboardAutoDecode;
    private javax.swing.JCheckBox chkGeneratePoC;
    private javax.swing.JCheckBox chkHTMLComment;
    private javax.swing.JCheckBox chkJSON;
    private javax.swing.JCheckBox chkJWT;
    private javax.swing.JCheckBox chkUniversalParams;
    private javax.swing.JCheckBox chkUniversalRaw;
    private javax.swing.JComboBox<String> cmbDefaultLangEncoding;
    private javax.swing.JLabel lblDispayMaxLength;
    private javax.swing.JLabel lblSelect;
    private javax.swing.JLabel lblSelectEncode;
    private javax.swing.JLabel lblTarget;
    private javax.swing.JList listSelect;
    private javax.swing.JList listTarget;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JButton pop;
    private javax.swing.JPopupMenu popEncodeMenu;
    private javax.swing.JScrollPane scrollSelect;
    private javax.swing.JScrollPane scrollTarget;
    private javax.swing.JSpinner spnDispayMaxLength;
    private javax.swing.JPanel tabEncoding;
    private javax.swing.JPanel tabMessageView;
    // End of variables declaration//GEN-END:variables

    public void setClipboardAutoDecode(boolean value) {
        this.chkClipboardAutoDecode.setSelected(value);
    }

    public boolean getClipboardAutoDecode() {
        return this.chkClipboardAutoDecode.isSelected();
    }

    public List<String> getEncodingList() {
        List<String> list = new ArrayList<>();
        for (int index = 0; index < this.modelSelect.size(); index++) {
            list.add((String) this.modelSelect.getElementAt(index));
        }
        return list;
    }

    public void setEncodingList(List<String> list) {
        this.modelSelect.clear();
        for (String item : list) {
            this.modelSelect.addElement(item);
        }
        this.modelTarget.clear();
        for (String item : Util.getAvailableEncodingList()) {
            if (!this.modelSelect.contains(item)) {
                this.modelTarget.addElement(item);
            }
        }
    }

    public void setEncodingProperty(UniversalViewProperty property) {
        this.setClipboardAutoDecode(property.getClipbordAutoDecode());
        this.setEncodingList(property.getEncodingList());
        this.setMessageView(property.getMessageView());
        this.setDispayMaxLength(property.getDispayMaxLength());
    }

    public UniversalViewProperty getEncodingProperty() {
        UniversalViewProperty property = new UniversalViewProperty();
        property.setClipbordAutoDecode(this.getClipboardAutoDecode());
        property.setEncodingList(this.getEncodingList());
        property.setMessageView(this.getMessageView());
        property.setDispayMaxLength(this.getDispayMaxLength());
        return property;
    }

    protected void moveItemList(javax.swing.JList srcList, javax.swing.JList dstList) {
        DefaultListModel modelSrc = (DefaultListModel) srcList.getModel();
        DefaultListModel modelDst = (DefaultListModel) dstList.getModel();
        int[] indexs = srcList.getSelectedIndices();
        for (int index : indexs) {
            modelDst.addElement(modelSrc.getElementAt(index));
        }
        for (int index = indexs.length; index > 0; index--) {
            modelSrc.removeElementAt(indexs[index - 1]);
        }
    }

    private void setMessageView(EnumSet<UniversalViewProperty.UniversalView> view) {
        this.chkGeneratePoC.setSelected(view.contains(UniversalViewProperty.UniversalView.GENERATE_POC));
        this.chkHTMLComment.setSelected(view.contains(UniversalViewProperty.UniversalView.HTML_COMMENT));
        this.chkJSON.setSelected(view.contains(UniversalViewProperty.UniversalView.JSON));
        this.chkJWT.setSelected(view.contains(UniversalViewProperty.UniversalView.JWT));
        this.chkUniversalRaw.setSelected(view.contains(UniversalViewProperty.UniversalView.JRAW));
        this.chkUniversalParams.setSelected(view.contains(UniversalViewProperty.UniversalView.JPARAM));
    }

    private EnumSet<UniversalViewProperty.UniversalView> getMessageView() {
        EnumSet<UniversalViewProperty.UniversalView> view = EnumSet.noneOf(UniversalViewProperty.UniversalView.class);
        if (this.chkGeneratePoC.isSelected()) {
            view.add(UniversalViewProperty.UniversalView.GENERATE_POC);
        }
        if (this.chkHTMLComment.isSelected()) {
            view.add(UniversalViewProperty.UniversalView.HTML_COMMENT);
        }
        if (this.chkJSON.isSelected()) {
            view.add(UniversalViewProperty.UniversalView.JSON);
        }
        if (this.chkJWT.isSelected()) {
            view.add(UniversalViewProperty.UniversalView.JWT);
        }
        if (this.chkUniversalRaw.isSelected()) {
            view.add(UniversalViewProperty.UniversalView.JRAW);
        }
        if (this.chkUniversalParams.isSelected()) {
            view.add(UniversalViewProperty.UniversalView.JPARAM);
        }
        return view;
    }

    public void setDispayMaxLength(int dispayMaxLength) {
        this.spnDispayMaxLength.getModel().setValue(dispayMaxLength);
    }

    public int getDispayMaxLength() {
        return (int)this.spnDispayMaxLength.getModel().getValue();
    }

    
    
}
