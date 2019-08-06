package yagura.view;

import burp.BurpExtender;
import burp.IMessageEditorController;
import burp.IMessageEditorTab;
import extend.view.base.HttpMessage;
import extend.view.base.HttpRequest;
import extend.view.base.HttpResponse;
import extend.util.Util;
import java.awt.Component;
import java.awt.Font;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.StyledEditorKit;
import yagura.model.UniversalViewProperty;

/**
 *
 * @author isayan
 */
public class RawViewTab extends javax.swing.JPanel implements IMessageEditorTab {

    private boolean request = false;
    private boolean textModified = false;
    private boolean editable = false;
    private IMessageEditorController controller = null;

    private final EditorKit htmlStyleEditorKit = new StyledEditorKit() {
        @Override
        public Document createDefaultDocument() {
            return new HTMLSyntaxDocument();
        }
    };

    /**
     * Creates new form RawViewTab
     *
     * @param request
     */
    public RawViewTab(boolean request) {
        this.request = request;
        initComponents();
        customizeComponents();
    }

    /**
     * Creates new form RawViewTab
     */
    public RawViewTab(IMessageEditorController controller, boolean editable, boolean isResuest) {
        this.request = isResuest;
        this.controller = controller;
        this.editable = editable;
        this.editable = false;
        initComponents();
        customizeComponents();
    }

    private final QuickSearchTab quickSearchTab = new QuickSearchTab();

    private void customizeComponents() {
        this.quickSearchTab.setSelectedTextArea(this.txtRaw);
        this.quickSearchTab.getEncodingComboBox().addItemListener(this.encodingItemStateChanged);
        this.txtRaw.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                textModified = true;
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                textModified = true;
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                textModified = true;
            }

        });
        this.txtRaw.setEditable(this.editable);

        this.txtRaw.setEditorKitForContentType("text/html", this.htmlStyleEditorKit);
        this.txtRaw.setContentType("text/html");

        this.add(this.quickSearchTab, java.awt.BorderLayout.SOUTH);
    }

    private final java.awt.event.ItemListener encodingItemStateChanged = new java.awt.event.ItemListener() {
        @Override
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            String encoding = quickSearchTab.getSelectedEncoding();
            if (encoding != null) {
                setMessageEncoding(encoding);
            }
        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollRaw = new javax.swing.JScrollPane();
        txtRaw = new javax.swing.JEditorPane();

        setLayout(new java.awt.BorderLayout());

        txtRaw.setEditable(false);
        scrollRaw.setViewportView(txtRaw);

        add(scrollRaw, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollRaw;
    private javax.swing.JEditorPane txtRaw;
    // End of variables declaration//GEN-END:variables

    public void setMessageFont(Font font) {
        this.txtRaw.setFont(font);
        this.quickSearchTab.setMessageFont(font);
    }

    public void setMessageEncoding(String encoding) {
        try {
            if (this.content == null) {
                return;
            }
            if (this.content != null) {
                // Raw
                this.txtRaw.setText(Util.decodeMessage(this.content, encoding));
                this.txtRaw.setCaretPosition(0);
                // View                
            } else {
                this.txtRaw.setText("");
            }
//            this.quickSearchTab.clearView();
            this.quickSearchTab.clearViewAndSearch();
        } catch (Exception ex) {
            Logger.getLogger(RawViewTab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getTabCaption() {
        return "JRaw";
    }

    @Override
    public Component getUiComponent() {
        return this;
    }

    @Override
    public boolean isEnabled(byte[] content, boolean isRequest) {
        if (content == null || content.length == 0) {
            return false;
        }
        EnumSet<UniversalViewProperty.UniversalView> view = BurpExtender.getInstance().getProperty().getEncodingProperty().getMessageView();
        if (!view.contains(UniversalViewProperty.UniversalView.JRAW)) {
            return false;
        }
        if (this.request && isRequest && content.length > 0) {
            return true;
        } else if (!this.request && !isRequest && content.length > 0) {
            return true;
        }
        return false;
    }

    private byte[] content = null;

    @Override
    public void setMessage(byte[] content, boolean isRequest) {
        try {
            if (content == null) {
                this.clearView();
            } else {
                this.content = content;
                BurpExtender extenderImpl = BurpExtender.getInstance();
                String guessCharset = null;
                HttpMessage httpmessage = null;
                if (isRequest) {
                    HttpRequest request = HttpRequest.parseHttpRequest(content);
                    httpmessage = request;
                    guessCharset = request.getGuessCharset();
                } else {
                    HttpResponse response = HttpResponse.parseHttpResponse(content);
                    httpmessage = response;
                    guessCharset = response.getGuessCharset();
                }
                if (guessCharset == null) {
                    guessCharset = StandardCharsets.ISO_8859_1.name();
                }
                this.quickSearchTab.getEncodingComboBox().removeItemListener(this.encodingItemStateChanged);
                this.quickSearchTab.renewEncodingList(guessCharset, extenderImpl.getSelectEncodingList());
                this.encodingItemStateChanged.itemStateChanged(null);
                this.quickSearchTab.getEncodingComboBox().addItemListener(this.encodingItemStateChanged);

                this.textModified = false;
            }
        } catch (ParseException ex) {
            Logger.getLogger(RawViewTab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public byte[] getMessage() {
        if (this.content != null) {
            if (this.textModified) {
                String modifiedText = this.txtRaw.getText();
                String encoding = quickSearchTab.getSelectedEncoding();
                if (encoding != null) {
                    return Util.encodeMessage(modifiedText, encoding);
                } else {
                    return this.content;
                }
            } else {
                return this.content;
            }
        } else {
            return new byte[]{};
        }
    }

    @Override
    public boolean isModified() {
        return this.textModified;
    }

    @Override
    public byte[] getSelectedData() {
        return null;
    }

    public String getSelectedText() {
        return this.txtRaw.getSelectedText();
    }

    public void clearView() {
        this.txtRaw.setText("");
        this.txtRaw.setEditable(false);
        this.quickSearchTab.clearView();
        this.content = null;
    }

}