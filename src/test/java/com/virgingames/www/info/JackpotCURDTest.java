package com.virgingames.www.info;

import com.virgingames.www.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class JackpotCURDTest extends TestBase {

    static String currency;
    static int jackportId;

    @Steps
    JackPotSteps jackPortSteps;

    @Title("This method will get all users records")
    @Test
    public void test001() {
       jackPortSteps.getJackPort();

    }

    @Title("This method will verify currency")
    @Test
    public void test002() {
        HashMap<String, Object> jackpotMap = jackPortSteps.getJackportInfoByCurrency(currency);
       jackportId = (int) jackpotMap.get("id");
        Assert.assertThat(jackpotMap, hasValue(currency));
    }


}
