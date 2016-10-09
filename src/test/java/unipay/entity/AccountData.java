package unipay.entity;

import unipay.utils.Login;

/**
 * @author <a href="andrey.chizhikov@gmail.com">Andrey Chizhikov</a>
 */
public class AccountData {
    private String requestType = "sale";
    private String userName = Login.USER_NAME;
    private String password = Login.PASSWORD;
    private String transactionCode = "0000000001";
    private String zipCode = "30301";
    private String customerAccountCode = "0000000001";
    private String state = "CO";
    private String city = "Denver";
    private String street = "12 Main St";
    private String accountAccessory = "0422";
    private String accountNumber = "4111111111111111";
    private String holderName = "John Smith";
    private String holderType = "P";
    private String transactionIndustryType = "RE";
    private String accountType = "R";
    private String amount = "100";
    private String merchantAccountCode = "2001";
    private String csc = "null";

    public AccountData() {
    }

    public String getRequestType() {
        return requestType;
    }

    public String getUserName() {
        return userName;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public String getCustomerAccountCode() {
        return customerAccountCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getAccountAccessory() {
        return accountAccessory;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getHolderType() {
        return holderType;
    }

    public String getTransactionIndustryType() {
        return transactionIndustryType;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAmount() {
        return amount;
    }

    public String getMerchantAccountCode() {
        return merchantAccountCode;
    }

    public String getPassword() {
        return password;
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
