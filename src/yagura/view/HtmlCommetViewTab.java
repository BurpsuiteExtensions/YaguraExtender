package yagura.view;

import burp.BurpExtender;
import burp.IMessageEditorController;
import burp.IMessageEditorTab;
import burp.IMessageEditorTabFactory;
import burp.IResponseInfo;
import extend.view.base.HttpMessage;
import extend.view.base.HttpResponse;
import extend.util.BurpWrap;
import extend.util.HttpUtil;
import yagura.external.TransUtil;
import extend.util.Util;
import java.awt.Component;
import java.awt.Font;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isayan
 */
public class HtmlCommetViewTab extends javax.swing.JPanel implements IMessageEditorTabFactory, IMessageEditorTab {

    /**
     * Creates new form HtmlCommetViewTab
     */
    public HtmlCommetViewTab() {
        initComponents();
        customizeComponents();
    }

    private QuickSearchTab quickSearchTab = new QuickSearchTab();

    private void customizeComponents() {
        this.quickSearchTab.setSelectedTextArea(this.txtHtmlComment);
        this.quickSearchTab.getEncodingComboBox().addItemListener(encodingItemStateChanged);
        this.quickSearchTab.getUniqCheckBox().setVisible(true);
        this.quickSearchTab.getUniqCheckBox().addItemListener(encodingItemStateChanged);
        add(this.quickSearchTab, java.awt.BorderLayout.SOUTH);
    }

    private final java.awt.event.ItemListener encodingItemStateChanged = new java.awt.event.ItemListener() {
        @Override
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            String encoding = quickSearchTab.getSelectedEncoding();
            if (encoding != null) {
                setMessageView(encoding);
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

        scrollHtmlComment = new javax.swing.JScrollPane();
        txtHtmlComment = new javax.swing.JTextArea();

        setLayout(new java.awt.BorderLayout());

        txtHtmlComment.setColumns(20);
        txtHtmlComment.setLineWrap(true);
        txtHtmlComment.setRows(5);
        scrollHtmlComment.setViewportView(txtHtmlComment);

        add(scrollHtmlComment, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollHtmlComment;
    private javax.swing.JTextArea txtHtmlComment;
    // End of variables declaration//GEN-END:variables

    public void setMessageFont(Font font) {
        this.txtHtmlComment.setFont(font);
    }

    private HttpMessage message = null;

    public void setMessageView(String encoding) {
        try {
            if (this.message == null) {
                return;
            }
            BurpExtender burp = BurpExtender.getInstance();
//            if (burp != null) {
//                this.setMessageFont(burp.getMessageFont());
//            }
            if (this.message != null) {
                // Raw
                this.setHTMLCommentEncoding(encoding, this.quickSearchTab.getUniqCheckBox().isSelected());
                // View                
            } else {
                this.txtHtmlComment.setText("");
            }
            this.quickSearchTab.clearView();
        } catch (Exception ex) {
            Logger.getLogger(HtmlCommetViewTab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void setHTMLCommentEncoding(String encoding) {
        this.setHTMLCommentEncoding(encoding, true);
    }

    protected void setHTMLCommentEncoding(String encoding, boolean uniqe) {
        try {
            String comments[] = HttpUtil.extractHTMLComments(Util.decodeMessage(this.message.getBodyBytes(), encoding), uniqe);
            this.txtHtmlComment.setText(TransUtil.join("\r\n", comments));
            this.txtHtmlComment.setCaretPosition(0);
        } catch (Exception ex) {
            Logger.getLogger(HtmlCommetViewTab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setMessage(byte[] content, boolean isRequest) {
        try {
            BurpExtender extenderImpl = BurpExtender.getInstance();
            String guessCharset = null;
            HttpMessage httpmessage = null;
            if (!isRequest) {
                HttpResponse response = HttpResponse.parseHttpResponse(content);
                httpmessage = response;
                guessCharset = response.getGuessCharset();
            }
            this.message = httpmessage;
            this.quickSearchTab.getEncodingComboBox().removeItemListener(encodingItemStateChanged);
            this.quickSearchTab.renewEncodingList(guessCharset, extenderImpl.getSelectEncodingList());
            encodingItemStateChanged.itemStateChanged(null);
            this.quickSearchTab.getEncodingComboBox().addItemListener(encodingItemStateChanged);
        } catch (ParseException ex) {
            Logger.getLogger(HtmlCommetViewTab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public byte[] getMessage() {
        if (this.message != null) {
            return this.message.getMessageBytes();
        } else {
            return new byte[]{};
        }
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public byte[] getSelectedData() {
        try {
            String selectText = this.txtHtmlComment.getSelectedText();
            return selectText.getBytes(this.quickSearchTab.getSelectedEncoding());
        } catch (UnsupportedEncodingException ex) {
            return new byte[]{};
        }
    }

    public String getSelectedText() {
        String selectText = this.txtHtmlComment.getSelectedText();
        return selectText;
    }

    @Override
    public IMessageEditorTab createNewInstance(IMessageEditorController controller, boolean editable) {
        this.txtHtmlComment.setEditable(false);
        return this;
    }

    @Override
    public String getTabCaption() {
        return "HTML Comment";
    }

    @Override
    public Component getUiComponent() {
        return this;
    }

    @Override
    public boolean isEnabled(byte[] content, boolean isMessageRequest) {
        if (content == null || content.length == 0) {
            return false;
        }
        boolean mimeHTMLType = false;
        byte [] body = new byte [0]; 
        if (!isMessageRequest) {
            IResponseInfo resInfo = BurpExtender.getHelpers().analyzeResponse(content);
            String mimeType = resInfo.getInferredMimeType();
            mimeHTMLType = ("HTML".equals(mimeType) || "XML".equals(mimeType));
            body = BurpWrap.getResponseBody(resInfo, content);
        }
        if (body.length > 0 && mimeHTMLType)  {
            return HttpUtil.existsHTMLComments(Util.getRawStr(body));
        } else {
            return false;
        }
    }

    public void clearView() {
        this.quickSearchTab.clearView();
    }

}
