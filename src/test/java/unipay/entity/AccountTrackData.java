package unipay.entity;

import unipay.utils.Login;

/**
 * @author <a href="andrey.chizhikov@gmail.com">Andrey Chizhikov</a>
 */
public class AccountTrackData {
    private String requestType = "sale";
    private String userName = Login.USER_NAME;
    private String password = Login.PASSWORD;
    private String transactionIndustryType = "RE";
    private String amount = "5000";
    private String accountType = "R";
    private String accountData = "%25B4111111111111111%5ESMITH%2FJOHN%5E22041011000%201111A123456789012%3F";
    private String zipCode = "30301";
    private String merchantAccountCode = "2001";
    private String csc = "null";

    public AccountTrackData() {
    }

    public String getRequestType() {
        return requestType;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getTransactionIndustryType() {
        return transactionIndustryType;
    }

    public String getMerchantAccountCode() {
        return merchantAccountCode;
    }

    public String getAmount() {
        return amount;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountData() {
        return accountData;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCsc() {
        return csc;
    }

    public void setCsc(String csc) {
        this.csc = csc;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
