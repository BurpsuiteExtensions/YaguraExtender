package yagura.model;

import burp.IHttpRequestResponse;
import extend.model.base.ObjectTableColumn;
import extend.model.base.ObjectTableMapping;
import extend.util.BurpWrap;
import extend.util.Util;
import extend.view.base.HttpRequest;
import extend.view.base.MatchItem;
import extend.view.base.NamedColor;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isayan
 */
public class ResultView extends HttpMessageItem implements ObjectTableMapping {

    public ResultView() {
    }

    public ResultView(HttpMessageItem item) {
        super(item);
    }

    public ResultView(IHttpRequestResponse item, int ordinal) {
        super(item, ordinal);
    }

    private final String[] columns = new String[]{
        "Data", "#", "host", "method", "URL", "status", "length", "comment"
    };

    public ObjectTableColumn getColumn() {
        return new ObjectTableColumn() {

            public String getColumnName(int column) {
                return columns[column];
            }

            public int getColumnCount() {
                return columns.length;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return Object.class;
            }

        };
    }

    private final boolean[] canEdit = new boolean[]{
        false, true, false, false, false, false, false, true
    };

    @Override
    public boolean isCellEditable(int columnIndex) {
        return canEdit[columnIndex];
    }

    @Override
    public Object getObject(int column) {
        Object value = null;
        try {
            HttpMessageItem msg = this;
            switch (column) {
                case 0: // 
                    value = msg;
                    break;
                case 1: // #
                    int ordinal = msg.getOrdinal();
                    Color highlightColor = null;
                    String color = BurpWrap.getHighlightColor(msg);
                    if (color != null) {
                        MatchItem.HighlightColor hc = MatchItem.HighlightColor.parseValue(color);
                        highlightColor = hc.toColor();
                        value = new NamedColor(highlightColor, Util.toString(ordinal + 1));
                    }
                    if (value == null) {
                        value = new NamedColor(Color.WHITE, Util.toString(ordinal + 1));
                    }
                    break;
                case 2: // host
                    value = msg.getProtocol() + "://" + msg.getHost();
                    break;
                case 3: // method
                    HttpRequest reqmsg = HttpRequest.parseHttpRequest(msg.getRequest());
                    value = reqmsg.getMethod();
                    break;
                case 4: // url
                    value = Util.toString(msg.getUrl());
                    break;
                case 5: // status code
                    value = 0;
                    if (this.getResponse() != null) {
                        value = Util.toString((int) msg.getStatusCode());
                    }
                    break;
                case 6: // length
                    value = 0;
                    if (this.getResponse() != null) {
                        value = msg.getResponse().length;
                    }
                    break;
                case 7: // comment
                    value = msg.getComment();
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(ResultView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;

    }

    @Override
    public void setObject(int column, Object value) {
        try {
            HttpMessageItem msg = this;
            switch (column) {
                case 0: // Data
                    break;
                case 1: // #
                    if (value instanceof NamedColor) {
                        NamedColor nc = (NamedColor) value;
                        BurpWrap.setHighlightColor(msg, nc.toString());
                    } else {
                        BurpWrap.setHighlightColor(msg, null);
                    }
                    break;
                case 2: // host
                    break;
                case 3: // method
                    break;
                case 4: // url
                    break;
                case 5: // status code
                    break;
                case 6: // length
                    break;
                case 7: // commment
                    msg.setComment((String) value);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(ResultView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
