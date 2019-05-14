package yagura.view;

import extend.util.SwingUtil;
import extend.util.external.FormatUtil;
import extend.util.external.JsonUtil;
import java.awt.Font;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.StyledEditorKit;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author isayan
 */
public class JSONView extends javax.swing.JPanel {

    /**
     * Creates new form JSONView
     */
    public JSONView() {
        initComponents();
        customizeComponents();
    }

    private final EditorKit jsonStyleEditorKit = new StyledEditorKit()
    {
         @Override
         public Document createDefaultDocument()
         {
              return new JSONSyntaxDocument();
         }
    };    
    
    private DefaultTreeModel modelJSON;
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbetJSON = new javax.swing.JTabbedPane();
        scrollJSON = new javax.swing.JScrollPane();
        txtJSON = new javax.swing.JEditorPane();
        pnlTree = new javax.swing.JPanel();
        scrollTree = new javax.swing.JScrollPane();
        treeJSON = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        btnExpand = new javax.swing.JButton();
        btnCollapse = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        scrollJSON.setViewportView(txtJSON);

        tabbetJSON.addTab("pretty", scrollJSON);

        pnlTree.setLayout(new java.awt.BorderLayout());

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        treeJSON.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        scrollTree.setViewportView(treeJSON);

        pnlTree.add(scrollTree, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        btnExpand.setText("expand");
        btnExpand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpandActionPerformed(evt);
            }
        });
        jPanel1.add(btnExpand);

        btnCollapse.setText("collapse");
        btnCollapse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCollapseActionPerformed(evt);
            }
        });
        jPanel1.add(btnCollapse);

        pnlTree.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tabbetJSON.addTab("Tree", pnlTree);

        add(tabbetJSON, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unchecked")
    private void customizeComponents() {        
        this.txtJSON.setEditable(false);

        this.txtJSON.setEditorKitForContentType("text/json", this.jsonStyleEditorKit);
        this.txtJSON.setContentType("text/json");

        Icon emptyIcon = SwingUtil.createEmptyIcon();
        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) this.treeJSON.getCellRenderer();
        renderer.setOpenIcon(emptyIcon);
        renderer.setClosedIcon(emptyIcon);
        renderer.setLeafIcon(emptyIcon);
        this.modelJSON = (DefaultTreeModel)this.treeJSON.getModel();
        
    }
    
    private void btnExpandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpandActionPerformed
        expandJsonTree();
    }//GEN-LAST:event_btnExpandActionPerformed

    private void btnCollapseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCollapseActionPerformed
        collapseJsonTree();
    }//GEN-LAST:event_btnCollapseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCollapse;
    private javax.swing.JButton btnExpand;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlTree;
    private javax.swing.JScrollPane scrollJSON;
    private javax.swing.JScrollPane scrollTree;
    private javax.swing.JTabbedPane tabbetJSON;
    private javax.swing.JTree treeJSON;
    private javax.swing.JEditorPane txtJSON;
    // End of variables declaration//GEN-END:variables

    public void setMessage(String content) {
        try {
            if (content != null) {
                // Raw
                this.txtJSON.setText(FormatUtil.prettyJSON(content));
                this.txtJSON.setCaretPosition(0);
                // Tree View
                this.modelJSON = (DefaultTreeModel) JsonUtil.toJSONTreeModel(JsonUtil.parse(content));

                SwingUtil.allNodesChanged(this.treeJSON);
                this.treeJSON.setModel(this.modelJSON);        
                this.expandJsonTree();
            }
            else {
                this.txtJSON.setText("");
                DefaultMutableTreeNode root = (DefaultMutableTreeNode) this.modelJSON.getRoot();
                root.removeAllChildren();        
            }        
        } catch (IOException ex) {
            Logger.getLogger(JSONView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getMessage() {
        return this.txtJSON.getText();        
    }
    
    public javax.swing.text.JTextComponent getTextArea() {
        return this.txtJSON;
    } 

public void setMessageFont(Font font) {
        this.txtJSON.setFont(font);
        this.treeJSON.setFont(font);
    }
        
    public void expandJsonTree() {
        TreePath path = this.treeJSON.getSelectionPath();
        if (path == null) {
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) this.modelJSON.getRoot();
            path = new TreePath(root.getPath());
        }
        SwingUtil.expandAll(this.treeJSON, path);                
    }

    public void collapseJsonTree() {
        TreePath path = this.treeJSON.getSelectionPath();
        if (path == null) {
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) this.modelJSON.getRoot();
            path = new TreePath(root.getPath());
        }
        SwingUtil.collapseAll(this.treeJSON, path);                
    }


}
