package StepObject;
import PageObject.DeliveryPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.Assert;
import static com.codeborne.selenide.Selenide.sleep;

public class DeliveryPageSteps extends DeliveryPage {

    @Step("Click on Continue button")
    public DeliveryPageSteps ContinueBtn() {
        continueBtn.click();
        sleep(2000);
        return this;
    }
    @Step("Click on Continue as guest button")
    public DeliveryPageSteps ContinueAsGuestBtn() {
        continueAsGuest.click();
        sleep(2000);
        return this;
    }
    @Step("Click on Search button")
    public DeliveryPageSteps SearchZipCodeBtn() {
        searchZipCode.click();
        sleep(2000);
        return this;
    }
    @Step("Click on Back button")
    public DeliveryPageSteps BackToPreviousSectionBtn() {
        backToZipSearch.click();
        sleep(1000);
        return this;
    }
    @Step("Input fake ZIP code: {searchZip}")
    public DeliveryPageSteps SearchZipCode_Input(String searchZip) {
        zipCodeSearchInput.setValue(searchZip);
        sleep(2000);
        return this;
    }
    @Step("Click on Store at pickup button")
    public DeliveryPageSteps StoreAtPickupBtn() {
        storeAtPickup.click();
        sleep(1000);
        return this;
    }
    @Step("Select store")
    public DeliveryPageSteps SelectShop() {
        selectShop.click();
        sleep(1000);
        return this;
    }
    @Step("Click on Continue button")
    public DeliveryPageSteps Continue_Btn() {
        continueToSubmit.click();
        sleep(1000);
        return this;
    }
    @Step("Switch to Invoice information section")
    public DeliveryPageSteps DifferentInvoiceSwitch() {
        differentInvoice.click();
        sleep(1000);
        return this;
    }
    @Step("Scroll down to the Invoice")
    public DeliveryPageSteps ScrollToInvoice() {
        scrollToInvoice.scrollIntoView(true);
        sleep(3000);
        return  this;
    }
    @Step("Scroll to the Continue button")
    public DeliveryPageSteps ScrollToContinue() {
        scrollDown.scrollIntoView(true);
        sleep(1000);
        return  this;
    }
    @Step("Verify error messages are not shown for Contact details")
    public DeliveryPageSteps VerifyCDErrors_AreNotShown() {
        Assert.assertFalse(firstNameError.is(Condition.visible), "First name error is not shown in CD");
        Assert.assertFalse(lastNameError.is(Condition.visible), "Last name error is not shown in CD");
        Assert.assertFalse(phoneNumberError.is(Condition.visible), "Phone number error is not shown in CD");
        Assert.assertFalse(emailAddressError.is(Condition.visible), "Email error is not shown in CD");
        return this;
    }
    @Step("Verify error messages are shown for Contact details")
    public DeliveryPageSteps VerifyCDErrors_AreShown() {
        Assert.assertTrue(firstNameError.is(Condition.visible),"First name error is shown in CD");
        Assert.assertTrue(lastNameError.is(Condition.visible), "Last name error is shown in CD");
        Assert.assertTrue(phoneNumberError.is(Condition.visible), "Phone number error is shown in CD");
        Assert.assertTrue(emailAddressError.is(Condition.visible),"Email error is shown in CD");
        return this;
    }
    @Step("Verify error messages are not shown for Invoice")
    public DeliveryPageSteps VerifyInvoiceErrors_AreNotShown() {
        Assert.assertFalse(firstNameInvoiceError.is(Condition.visible), "First name error is not shown in Invoice");
        Assert.assertFalse(lastNameInvoiceError.is(Condition.visible), "Last name error is not shown in Invoice");
        Assert.assertFalse(addressError.is(Condition.visible), "Address error is not shown in Invoice");
        Assert.assertFalse(postCodeError.is(Condition.visible), "Postcode error is not shown in Invoice");
        Assert.assertFalse(cityError.is(Condition.visible), "City error is shown not in Invoice");
        Assert.assertFalse(emailAddressInvoiceError.is(Condition.visible), "Email error is not shown in Invoice");
        Assert.assertFalse(phoneNumberInvoiceError.is(Condition.visible), "Phone error is not shown in Invoice");
        Assert.assertFalse(companyInvoiceError.is(Condition.visible), "Company error is not shown in Invoice");
        return this;
    }
    @Step("Verify error messages are shown for Invoice")
    public DeliveryPageSteps VerifyInvoiceErrors_AreShown() {
        Assert.assertTrue(firstNameInvoiceError.is(Condition.visible), "First name error is shown in Invoice");
        Assert.assertTrue(lastNameInvoiceError.is(Condition.visible), "Last name error is shown in Invoice");
        Assert.assertTrue(addressError.is(Condition.visible), "Address error is shown in Invoice");
        Assert.assertTrue(postCodeError.is(Condition.visible), "Postcode error is shown in Invoice");
        Assert.assertTrue(cityError.is(Condition.visible), "City error is shown in Invoice");
        Assert.assertTrue(emailAddressInvoiceError.is(Condition.visible), "Email error is shown in Invoice");
        Assert.assertTrue(phoneNumberInvoiceError.is(Condition.visible), "Phone error is shown in Invoice");
        Assert.assertTrue(companyInvoiceError.is(Condition.visible), "Company error is shown in Invoice");
        return this;
    }

}
