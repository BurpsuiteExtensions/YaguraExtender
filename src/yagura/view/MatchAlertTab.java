/*
 * MatchAlertTab.java
 *
 * Created on 2010/11/27, 13:26:35
 */
package yagura.view;

import extend.model.base.CustomTableModel;
import yagura.model.MatchAlertItem;
import yagura.model.MatchAlertProperty;
import extend.util.SwingUtil;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author isayan
 */
public class MatchAlertTab extends javax.swing.JPanel {

    /**
     * Creates new form MatchAlertTab
     */
    public MatchAlertTab() {
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

        tabAutoAlert = new javax.swing.JPanel();
        pnlCenter = new javax.swing.JPanel();
        btnAlertAdd = new javax.swing.JButton();
        scrollAlert = new javax.swing.JScrollPane();
        tableAlert = new javax.swing.JTable();
        btnAlertRemove = new javax.swing.JButton();
        btnAlertEdit = new javax.swing.JButton();
        chkEnableAlert = new javax.swing.JCheckBox();

        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(550, 300));
        setRequestFocusEnabled(false);
        setLayout(new java.awt.BorderLayout());

        tabAutoAlert.setPreferredSize(new java.awt.Dimension(550, 300));
        tabAutoAlert.setVerifyInputWhenFocusTarget(false);
        tabAutoAlert.setLayout(new java.awt.BorderLayout());

        btnAlertAdd.setText("Add");
        btnAlertAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlertAddActionPerformed(evt);
            }
        });

        tableAlert.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "type", "match", "regex", "icase", "notify", "target tool", "highlight color", "comment", "issue name", "severity", "confidence"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAlert.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tableAlertKeyTyped(evt);
            }
        });
        scrollAlert.setViewportView(tableAlert);
        if (tableAlert.getColumnModel().getColumnCount() > 0) {
            tableAlert.getColumnModel().getColumn(0).setResizable(false);
            tableAlert.getColumnModel().getColumn(1).setResizable(false);
            tableAlert.getColumnModel().getColumn(2).setResizable(false);
            tableAlert.getColumnModel().getColumn(4).setResizable(false);
        }

        btnAlertRemove.setText("Remove");
        btnAlertRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlertRemoveActionPerformed(evt);
            }
        });

        btnAlertEdit.setText("Edit");
        btnAlertEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlertEditActionPerformed(evt);
            }
        });

        chkEnableAlert.setText("Enable Alert");
        chkEnableAlert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEnableAlertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollAlert, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlertEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkEnableAlert, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAlertRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlertAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollAlert, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addComponent(chkEnableAlert)
                        .addGap(11, 11, 11)
                        .addComponent(btnAlertEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAlertRemove)
                        .addGap(10, 10, 10)
                        .addComponent(btnAlertAdd)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabAutoAlert.add(pnlCenter, java.awt.BorderLayout.CENTER);

        add(tabAutoAlert, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private CustomTableModel modelAlert = null;
    private final MatchAlertItemDlg matchAlertDlg = new MatchAlertItemDlg(null, true);

    protected final java.util.ResourceBundle BUNDLE = java.util.ResourceBundle.getBundle("yagura/resources/Resource");

    @SuppressWarnings("unchecked")
    private void customizeComponents() {
        // MatchAlert Tab
        this.modelAlert = new CustomTableModel(this.tableAlert.getModel());
        this.tableAlert.setModel(this.modelAlert);
        this.chkEnableAlert.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                firePropertyChange(TabbetOption.MATCHALERT_PROPERTY, null, getMatchAlertProperty());
            }
        } );        
        this.btnAlertEdit.setEnabled(this.tableAlert.getSelectedRowCount() > 0);
        this.modelAlert.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                firePropertyChange(TabbetOption.MATCHALERT_PROPERTY, null, getMatchAlertProperty());
            }
        });

        this.tableAlert.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                int rowCount = tableAlert.getSelectedRowCount();
                btnAlertEdit.setEnabled((rowCount > 0));
            }
        });

        this.tableAlert.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        // selected
        this.tableAlert.getColumnModel().getColumn(0).setMinWidth(20);
        this.tableAlert.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.tableAlert.getColumnModel().getColumn(0).setMaxWidth(30);

        // type
        this.tableAlert.getColumnModel().getColumn(1).setMinWidth(40);
        this.tableAlert.getColumnModel().getColumn(1).setPreferredWidth(60);
        this.tableAlert.getColumnModel().getColumn(1).setMaxWidth(80);

        // regex
        this.tableAlert.getColumnModel().getColumn(3).setMinWidth(20);
        this.tableAlert.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.tableAlert.getColumnModel().getColumn(3).setMaxWidth(40);

        // icase
        this.tableAlert.getColumnModel().getColumn(4).setMinWidth(20);
        this.tableAlert.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.tableAlert.getColumnModel().getColumn(4).setMaxWidth(40);

        // highlight color
        this.tableAlert.getColumnModel().getColumn(7).setMinWidth(0);
        this.tableAlert.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.tableAlert.getColumnModel().getColumn(7).setMaxWidth(0);

        // comment
        this.tableAlert.getColumnModel().getColumn(8).setMinWidth(0);
        this.tableAlert.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.tableAlert.getColumnModel().getColumn(8).setMaxWidth(0);

        // issue name
        this.tableAlert.getColumnModel().getColumn(9).setMinWidth(40);
        this.tableAlert.getColumnModel().getColumn(9).setPreferredWidth(60);
        this.tableAlert.getColumnModel().getColumn(9).setMaxWidth(80);

        // severity
        this.tableAlert.getColumnModel().getColumn(10).setMinWidth(0);
        this.tableAlert.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.tableAlert.getColumnModel().getColumn(10).setMaxWidth(0);

        // confidence
        this.tableAlert.getColumnModel().getColumn(11).setMinWidth(0);
        this.tableAlert.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.tableAlert.getColumnModel().getColumn(11).setMaxWidth(0);
        
    }

    private void btnAlertEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlertEditActionPerformed
        this.showMatchAlertItemDlg(true);
        //this.firePropertyChange(TabbetOption.MATCHALERT_PROPERTY, null, this.getMatchAlertProperty());        
    }//GEN-LAST:event_btnAlertEditActionPerformed

    private void btnAlertRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtil.removeItem(this.tableAlert);
        //this.firePropertyChange(TabbetOption.MATCHALERT_PROPERTY, null, this.getMatchAlertProperty());        
    }

    private void btnAlertAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlertAddActionPerformed
        this.showMatchAlertItemDlg(false);
        //this.firePropertyChange(TabbetOption.MATCHALERT_PROPERTY, null, this.getMatchAlertProperty());        
    }//GEN-LAST:event_btnAlertAddActionPerformed

    private void chkEnableAlertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEnableAlertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkEnableAlertActionPerformed

    private void tableAlertKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableAlertKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_SPACE) {
            int[] rowSelect = this.tableAlert.getSelectedRows();
            for (int i = 0; i < rowSelect.length; i++) {
                int rowIndex = this.tableAlert.convertRowIndexToModel(rowSelect[i]);
                DefaultTableModel modelTable = (DefaultTableModel) this.tableAlert.getModel();                
                Object[] editRows = new Object[this.tableAlert.getColumnCount()];
                for (int k = 0; k < editRows.length; k++) {
                    editRows[k] = modelTable.getValueAt(rowIndex, this.tableAlert.convertColumnIndexToModel(k));
                }
                MatchAlertItem item = MatchAlertItem.fromObjects(editRows);
                item.setSelected(!item.isSelected());
                editRows = MatchAlertItem.toObjects(item);
                SwingUtil.updateItem(this.tableAlert, editRows, rowSelect[i]);
            }            
        }
    }//GEN-LAST:event_tableAlertKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlertAdd;
    private javax.swing.JButton btnAlertEdit;
    private javax.swing.JButton btnAlertRemove;
    private javax.swing.JCheckBox chkEnableAlert;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JScrollPane scrollAlert;
    private javax.swing.JPanel tabAutoAlert;
    private javax.swing.JTable tableAlert;
    // End of variables declaration//GEN-END:variables

    public void setMatchAlertItemList(List<MatchAlertItem> list) {
        if (list == null) {
        } else {
            this.modelAlert.beginUpdate();
            this.modelAlert.removeAll();
            Object editRows[] = new Object[0];
            for (int i = 0; i < list.size(); i++) {
                MatchAlertItem alertItem = list.get(i);
                editRows = MatchAlertItem.toObjects(alertItem);
                this.modelAlert.addRow(editRows);
            }
            this.modelAlert.endUpdate();
        }
    }

    public List<MatchAlertItem> getMatchAlertItemList() {
        javax.swing.JTable srcTable = this.tableAlert;
        List<MatchAlertItem> list = new ArrayList<MatchAlertItem>();
        for (int i = 0; i < srcTable.getRowCount(); i++) {
            Object editRows[] = this.modelAlert.getRows(i);
            list.add(MatchAlertItem.fromObjects(editRows));
        }
        return list;
    }

    private MatchAlertItem getEditItem() {
        MatchAlertItem item = new MatchAlertItem();
        Object editRows[] = SwingUtil.editItem(this.tableAlert);
        if (editRows != null) {
            item = MatchAlertItem.fromObjects(editRows);
        }
        return item;
    }

    private void setEditItem(MatchAlertItem item, boolean update) {
        Object[] rows = MatchAlertItem.toObjects(item);
        SwingUtil.addOrUpdateItem(this.tableAlert, rows, update);
    }

    @SuppressWarnings("unchecked")
    private void showMatchAlertItemDlg(boolean editMode) {
        this.matchAlertDlg.setLocationRelativeTo(this);
        if (editMode) {
            this.matchAlertDlg.setItem(getEditItem());
        } else {
            MatchAlertItem item = new MatchAlertItem();
            this.matchAlertDlg.setItem(item);
        }
        this.matchAlertDlg.setVisible(true);
        if (this.matchAlertDlg.getModalResult() == JOptionPane.OK_OPTION) {
            MatchAlertItem item = this.matchAlertDlg.getItem();
            this.setEditItem(item, editMode);
        }
    }

    public MatchAlertProperty getMatchAlertProperty() {
        MatchAlertProperty matchAlertProperty = new MatchAlertProperty();
        matchAlertProperty.setMatchAlertEnable(this.chkEnableAlert.isSelected());
        matchAlertProperty.setMatchAlertItemList(this.getMatchAlertItemList());
        return matchAlertProperty;
    }

    public void setMatchAlertProperty(MatchAlertProperty matchAlertProperty) {
        this.chkEnableAlert.setSelected(matchAlertProperty.isMatchAlertEnable());
        this.setMatchAlertItemList(matchAlertProperty.getMatchAlertItemList());
    }

}
