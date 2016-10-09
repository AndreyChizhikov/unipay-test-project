package unipay.responsetests;

import unipay.entity.AccountData;
import unipay.entity.AccountTrackData;
import unipay.entity.CodeName;
import unipay.utils.RequestHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="andrey.chizhikov@gmail.com">Andrey Chizhikov</a>
 */
public class ResponseCodeTest {
   
    private static final String URL = "https://sandbox-secure.unitedthinkers.com/gates/xurl";
    
    AccountData accountData = new AccountData();
    RequestHelper requestHelper = new RequestHelper();
    AccountTrackData accountTrackData = new AccountTrackData();
    
    @Test
    public void checkResponseCode_A01_UsingAccountNumber() throws Exception {
        accountData.setAmount("500");
        Assert.assertEquals("A01",requestHelper.
                getExpectedCode(URL, accountData, CodeName.RESPONSE_CODE.getCodeName()));
        accountData.setAmount("4500");
        Assert.assertEquals("A01",requestHelper.
                getExpectedCode(URL, accountData, CodeName.RESPONSE_CODE.getCodeName()));
        accountData.setAmount("6999");
        Assert.assertEquals("A01",requestHelper.
                getExpectedCode(URL, accountData, CodeName.RESPONSE_CODE.getCodeName()));
    }

    @Test
    public void checkResponseCode_D03_UsingAccountNumber() throws Exception {
        accountData.setAmount("12000");
        Assert.assertEquals("D03",requestHelper.
                getExpectedCode(URL, accountData, CodeName.RESPONSE_CODE.getCodeName()));
        accountData.setAmount("12500");
        Assert.assertEquals("D03",requestHelper.
                getExpectedCode(URL, accountData, CodeName.RESPONSE_CODE.getCodeName()));
        accountData.setAmount("12999");
        Assert.assertEquals("D03",requestHelper.
                getExpectedCode(URL, accountData, CodeName.RESPONSE_CODE.getCodeName()));

    }

    @Test
    public void checkResponseCode_D05_UsingTrackData() throws Exception {
        accountTrackData.setAmount("7000");
        Assert.assertEquals("D05",requestHelper
                .getExpectedCode(URL, accountTrackData, CodeName.RESPONSE_CODE.getCodeName()));
        accountTrackData.setAmount("7500");
        Assert.assertEquals("D05",requestHelper
                .getExpectedCode(URL, accountTrackData, CodeName.RESPONSE_CODE.getCodeName()));
        accountTrackData.setAmount("7999");
        Assert.assertEquals("D05",requestHelper
                .getExpectedCode(URL, accountTrackData, CodeName.RESPONSE_CODE.getCodeName()));
    }

    @Test
    public void checkResponseCode_E02_UsingTrackData() throws Exception {
        accountTrackData.setAmount("13000");
        Assert.assertEquals("E02",requestHelper.getExpectedCode(URL, accountTrackData,
                CodeName.RESPONSE_CODE.getCodeName()));
        accountTrackData.setAmount("13500");
        Assert.assertEquals("E02",requestHelper.getExpectedCode(URL, accountTrackData,
                CodeName.RESPONSE_CODE.getCodeName()));
        accountTrackData.setAmount("13999");
        Assert.assertEquals("E02",requestHelper.getExpectedCode(URL, accountTrackData,
                CodeName.RESPONSE_CODE.getCodeName()));
    }
}
