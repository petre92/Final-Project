package StepObject;
import PageObject.CartPage;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

public class CartPageSteps extends CartPage {

    @Step("Click on Cart button")
    public CartPageSteps CartBtn() {
        cartPage.click();
        return this;
    }

    @Step("Remove all products from Cart")
    public CartPageSteps RemoveProducts() {
        int remove = removeList.size();
        for (int i = 0; i < remove; i++) {
            removeList.get(i).click();
            sleep(1000);
        }
        return this;
    }

    @Step("Go back to the Laptops page")
    public CartPageSteps GoBackToLaptops() {
        open("https://www.multitronic.fi/computers---tablets/notebooks");
        return this;
    }

    @Step("Remove one product from the Cart")
    public CartPageSteps RemoveOneProduct() {
        int remove = removeList.size();
        for (int i = 0; i < remove; i++) ;
        removeList.get(1).click();
        sleep(5000);
        return this;
    }

    @Step("Click on Restore item button")
    public CartPageSteps RestoreOneProduct() {
        restoreItemText.click();
        sleep(2000);
        return this;
    }

}
