package cc.niushuai.projects.misportchange.stepchange.bean;

/**
 * 微信开发者接入指南数据
 */
public class WxOpenData {
    /**
     * 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     */
    private String signature;


    /**
     * 时间戳
     */
    private long timestamp;

    /**
     * 随机数
     */
    private String nonce;

    /**
     * 随机字符串
     */
    private String echostr;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }
}
