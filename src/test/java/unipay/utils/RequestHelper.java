package unipay.utils;

import unipay.entity.AccountData;

import unipay.entity.AccountTrackData;
import org.apache.http.client.utils.URIBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Arrays;
import java.util.List;


/**
 * @author <a href="andrey.chizhikov@gmail.com">Andrey Chizhikov</a>
 */
public class RequestHelper {

    public String getExpectedCode(String url, AccountData accountData, String codeName) throws Exception {
        String expectedCode = "";
        URI uri = new URIBuilder(url).
                addParameter("requestType", accountData.getRequestType()).
                addParameter("userName", accountData.getUserName()).
                addParameter("password", accountData.getPassword()).
                addParameter("merchantAccountCode", accountData.getMerchantAccountCode()).
                addParameter("amount", accountData.getAmount()).
                addParameter("accountType", accountData.getAccountType()).
                addParameter("transactionIndustryType", accountData.getTransactionIndustryType()).
                addParameter("holderType", accountData.getHolderType()).
                addParameter("holderName", accountData.getHolderName()).
                addParameter("accountNumber", accountData.getAccountNumber()).
                addParameter("accountAccessory", accountData.getAccountAccessory()).
                addParameter("street", accountData.getStreet()).
                addParameter("city", accountData.getCity()).
                addParameter("state", accountData.getState()).
                addParameter("zipCode", accountData.getZipCode()).
                addParameter("customerAccountCode", accountData.getCustomerAccountCode()).
                addParameter("transactionCode", accountData.getTransactionCode()).
                addParameter("csc", accountData.getCsc()).
                build();

        HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
        connection.setUseCaches(false);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(30000);
        String line;
        StringBuilder sb = new StringBuilder();

        if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException(
                    String.format("Cannot connected to: %s.", connection.getURL()));
        }
        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        while ((line = input.readLine()) != null)
            sb.append(line);
        input.close();
        
        List<String> keyValueResponse = Arrays.asList(sb.toString().split("&"));

        for (String keyValuePair : keyValueResponse) {
            if (keyValuePair.contains(codeName)) {
                expectedCode = keyValuePair.split("=")[1];
            }
        }
        return expectedCode;
    }

    public String getExpectedCode(String url, AccountTrackData accountTrackData, String codeName) throws Exception {
        String expectedCode = "";
        URI uri = new URIBuilder(url).
                    addParameter("requestType", accountTrackData.getRequestType()).
                    addParameter("userName",accountTrackData.getUserName()).
                    addParameter("password",accountTrackData.getPassword()).
                    addParameter("merchantAccountCode",accountTrackData.getMerchantAccountCode()).
                    addParameter("transactionIndustryType", accountTrackData.getTransactionIndustryType()).
                    addParameter("amount", accountTrackData.getAmount()).
                    addParameter("accountType", accountTrackData.getAccountType()).
                    addParameter("accountData",accountTrackData.getAccountData()).
                    addParameter("csc",accountTrackData.getCsc()).
                    addParameter("zipCode",accountTrackData.getZipCode()).
                build();
        
        HttpURLConnection connection =(HttpURLConnection)uri.toURL().openConnection();
        connection.setConnectTimeout(30000);
        connection.setUseCaches(false);
        connection.setRequestMethod("POST");
        connection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        String line;
        StringBuilder sb = new StringBuilder();
        
        if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException(
                    String.format("Cannot connected to: %s.", connection.getURL()));
        }
        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        while ((line = input.readLine()) != null)
            sb.append(line);
        input.close();

        List<String> keyValueResponse = Arrays.asList(sb.toString().split("&"));

        for (String keyValuePair : keyValueResponse) {
            if (keyValuePair.contains(codeName)) {
                expectedCode = keyValuePair.split("=")[1];
            }
        }
        return expectedCode;
    }
}
