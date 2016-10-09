package unipay.entity;

/**
 * @author <a href="andrey.chizhikov@gmail.com">Andrey Chizhikov</a>
 */
public enum CodeName {
    AVS_RESPONSE_CODE("avsResponseCode"),
    CSC_RESPONSE_CODE("cscResponseCode"),
    RESPONSE_CODE("responseCode");

    private String codeName;

    CodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeName() {
        return codeName;
    }
}
