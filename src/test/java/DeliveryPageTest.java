import StepObject.CartPageSteps;
import StepObject.DeliveryPageSteps;
import StepObject.LaptopsPageSteps;
import Utils.ChromeRunner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static DataObject.DeliveryPageData.fakeZipCode;

public class DeliveryPageTest extends ChromeRunner {

    CartPageSteps cartPageSteps = new CartPageSteps();
    LaptopsPageSteps laptopPageSteps = new LaptopsPageSteps();
    DeliveryPageSteps deliveryPageSteps = new DeliveryPageSteps();
    SoftAssert soft = new SoftAssert();


    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("Check error messages for ZIP code")
    public void SearchByZipCode() {
        laptopPageSteps.ChooseAndAddProducts();
        cartPageSteps.CartBtn();
        deliveryPageSteps.ContinueBtn()
                .ContinueAsGuestBtn()
                .SearchZipCodeBtn();
        soft.assertTrue(deliveryPageSteps.zipCodeError.is(Condition.visible), "ZIP code error is shown");
        deliveryPageSteps.BackToPreviousSectionBtn()
                .SearchZipCode_Input(fakeZipCode)
                .SearchZipCodeBtn();
        soft.assertTrue(deliveryPageSteps.zipCodeError.is(Condition.not(Condition.visible)), "ZIP code error is not shown");
        soft.assertAll();
    }

    @Test
    @Description("Check error messages for Contact details and Invoice")
    @Severity(SeverityLevel.BLOCKER)
    public void InvoiceInfoCheck() {
        laptopPageSteps.ChooseAndAddProducts();
        cartPageSteps.CartBtn();
        deliveryPageSteps.ContinueBtn()
                .ContinueAsGuestBtn()
                .StoreAtPickupBtn()
                .SelectShop()
                .VerifyCDErrors_AreNotShown()
                .Continue_Btn()
                .VerifyCDErrors_AreShown()
                .DifferentInvoiceSwitch()
                .VerifyInvoiceErrors_AreNotShown()
                .ScrollToContinue()
                .Continue_Btn()
                .ScrollToInvoice()
                .VerifyInvoiceErrors_AreShown();
    }
}
