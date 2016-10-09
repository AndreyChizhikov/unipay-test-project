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
public class AVSVerificationTest {

    private static final String URL = "https://sandbox-secure.unitedthinkers.com/gates/xurl";
    AccountData accountData = new AccountData();
    RequestHelper requestHelper =new RequestHelper();
    AccountTrackData accountTrackData = new AccountTrackData();



    @Test
    public void checkAvsResponseCode_00_UsingAccountNumber() throws Exception {
        accountData.setZipCode("11111");
        Assert.assertEquals(requestHelper.
                getExpectedCode(URL, accountData, CodeName.AVS_RESPONSE_CODE.getCodeName()),"00");
    }

    @Test
    public void checkAvsResponseCode_46_UsingAccountNumber() throws Exception{
        accountData.setZipCode("22222");
        Assert.assertEquals(requestHelper.
                getExpectedCode(URL, accountData,CodeName.AVS_RESPONSE_CODE.getCodeName()),"46");
    }

    @Test
    public void checkAvsResponseCode_43_UsingTrackData()throws Exception{

        RequestHelper requestHelper =new RequestHelper();
        accountTrackData.setZipCode("33333");
        Assert.assertEquals(requestHelper.
                getExpectedCode(URL, accountTrackData,CodeName.AVS_RESPONSE_CODE.getCodeName()),"43");
    }

    @Test
    public void checkAvsResponseCode_40_UsingTrackData()throws Exception{
        accountTrackData.setZipCode("44444");
        Assert.assertEquals(requestHelper.
                getExpectedCode(URL, accountTrackData,CodeName.AVS_RESPONSE_CODE.getCodeName()),"40");
    }
}
