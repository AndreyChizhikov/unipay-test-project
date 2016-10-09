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
public class CSCVerificationTest {
    private static final String URL = "https://sandbox-secure.unitedthinkers.com/gates/xurl";
    AccountData accountData = new AccountData();
    RequestHelper requestHelper = new RequestHelper();
    AccountTrackData accountTrackData = new AccountTrackData();

    @Test
    public void checkCscResponseCode_M_UsingAccountNumber() throws Exception {
        accountData.setCsc("111");
        Assert.assertEquals(requestHelper.
                getExpectedCode(URL, accountData, CodeName.CSC_RESPONSE_CODE.getCodeName()),"M");
    }

    @Test
    public void checkCscResponseCode_U_singAccountNumber() throws Exception{
        accountData.setCsc("222");
        Assert.assertEquals(requestHelper.
                getExpectedCode(URL, accountData, CodeName.CSC_RESPONSE_CODE.getCodeName()),"N");
    }

    @Test
    public void checkCscResponseCode_P_UsingTrackData() throws Exception{
        accountTrackData.setCsc("333");
        Assert.assertEquals(requestHelper.
                getExpectedCode(URL, accountTrackData, CodeName.CSC_RESPONSE_CODE.getCodeName()),"P");
    }
    @Test
    public void checkCscResponseCode_S_UsingTrackData()throws Exception{
        accountTrackData.setCsc("444");
        Assert.assertEquals(requestHelper.getExpectedCode(URL, accountTrackData,
                CodeName.CSC_RESPONSE_CODE.getCodeName()),"S");
    }
}
