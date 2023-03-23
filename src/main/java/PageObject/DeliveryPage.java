package PageObject;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class DeliveryPage {

    public SelenideElement
    continueBtn = $(byId("continue")),
    searchZipCode = $(byId("searchZip")),
    continueAsGuest = $(byText("Continue as guest")),
    zipCodeError = $(byText("Order cannot be shipped")),
    backToZipSearch = $(byClassName("icon-Chevron-Left"),1),
    zipCodeSearchInput = $(byId("zipcode")),
    storeAtPickup = $(byId("storePickupBtn")),
    selectShop = $(by("for", "radioSelect0")),
    continueToSubmit = $(byId("sifsubmit")),
    differentInvoice = $(by("for", "diffinv_switch")),
    scrollToInvoice = $(byCssSelector("#el_inv_firstname")),
    scrollDown = $(byCssSelector("#sifsubmit")),
    firstNameError = $(byText("\"First name\" is required!")),
    lastNameError = $(byText("\"Last name\" is required!")),
    phoneNumberError = $(byText("The phone number is invalid!"),0),
    emailAddressError = $(byText("The e-mail address is invalid.")),
    firstNameInvoiceError = $(byText("\"First name\" is required! (Invoice information)")),
    lastNameInvoiceError = $(byText("\"Last name\" is required! (Invoice information)")),
    addressError = $(byText("\"Address\" is required! (Invoice information)")),
    postCodeError = $(byText("\"Post code\" is required! (Invoice information)")),
    cityError = $(byText("\"City\" is required! (Invoice information)")),
    emailAddressInvoiceError = $(byText("\"E-mail\" is required! (Invoice information)")),
    phoneNumberInvoiceError = $(byText("The phone number is invalid!"), 1),
    companyInvoiceError = $(byText("\"Company\" is required! (Invoice information)"));


}
