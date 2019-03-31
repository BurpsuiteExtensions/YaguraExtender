package yagura.model;

import java.io.IOException;
import yagura.external.JsonUtil;

/**
 *
 * @author isayan
 */
public class JWTObject extends JWTToken {

    public JWTObject(JWTToken token) {
        super(token);
    }
    
        /**
     * @return the header
     */
    public String getHeaderJSON(boolean pretty) {
        try {
            return JsonUtil.prettyJSON(decodeB64(this.getHeader()), pretty);
        } catch (IOException ex) {
            return null;
        }
    }

    /**
     * @return the payload
     */
    public String getPayloadJSON(boolean pretty) {
        try {
            return JsonUtil.prettyJSON(decodeB64(this.getPayload()), pretty);
        } catch (IOException ex) {
            return null;
        }
    }
    
    /**
     * @return the signature
     */
    public byte [] getSignatureByte() {
        return decodeB64Byte(this.getSignature());
    }
    
}