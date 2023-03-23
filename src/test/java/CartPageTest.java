import StepObject.CartPageSteps;
import StepObject.LaptopsPageSteps;
import Utils.ChromeRunner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends ChromeRunner {

    CartPageSteps cartPageSteps = new CartPageSteps();
    LaptopsPageSteps laptopPageSteps = new LaptopsPageSteps();

    @Test
    @Description("Remove all products one by one from the Cart")
    @Severity(SeverityLevel.NORMAL)
    public void RemoveProductsTest() {
        cartPageSteps.CartBtn();
        Assert.assertTrue(cartPageSteps.emptyMessageText.is(Condition.visible), "'Empty' message is shown");
        cartPageSteps.GoBackToLaptops();
        laptopPageSteps.ChooseAndAddProducts();
        cartPageSteps.CartBtn()
                .RemoveProducts();
        Assert.assertTrue(cartPageSteps.emptyMessageText.is(Condition.visible), "'Empty' message is shown");
    }

    @Test
    @Description("Remove and restore one product")
    @Severity(SeverityLevel.NORMAL)
    public void RestoreItemTest() {
        cartPageSteps.CartBtn()
                .GoBackToLaptops();
        laptopPageSteps.ChooseAndAddProducts();
        cartPageSteps
                .CartBtn()
                .RemoveOneProduct();
        Assert.assertTrue(cartPageSteps.restoreItemText.is(Condition.visible), "'Restore item' text appeared");
        cartPageSteps.RestoreOneProduct();
        Assert.assertTrue(cartPageSteps.restoreItemText.is(Condition.not(Condition.visible)),
                "'Restore item' text disappeared");
    }

}
