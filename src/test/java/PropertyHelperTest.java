import org.junit.Assert;
import org.junit.Test;

import helpers.PropertyHelper;

public class PropertyHelperTest {

    @Test
    public void getMaxFair() {
        float maxFair = PropertyHelper.INSTANCE.getMaxFair();
        Assert.assertNotNull(maxFair);
    }

    @Test
    public void getTopUpAmout() {
        float topUp = PropertyHelper.INSTANCE.getTopUpAmout();
        Assert.assertNotNull(topUp);

    }

}
