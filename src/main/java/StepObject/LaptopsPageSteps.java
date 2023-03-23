package StepObject;
import PageObject.LaptopsPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.sleep;

public class LaptopsPageSteps extends LaptopsPage {

    @Step("Choose Lenovo Brand filter")
    public LaptopsPageSteps ChooseBrandFilter() {
        brandsFilter.click();
        chooseLenovo.click();
        brandsFilter.click();
        sleep(3000);
        return this;
    }
    @Step("Close Brand filter")
    public LaptopsPageSteps CloseBrandFilter() {
        ChooseBrandFilter();
        sleep(3000);
        return this;
    }
    @Step("Choose RAM filter")
    public LaptopsPageSteps ChooseRamFilter() {
        ramFilter.click();
        chooseRam.click();
        ramFilter.click();
        return this;
    }
    @Step("Choose Storage filter")
    public LaptopsPageSteps ChooseStorageFilter() {
        storageFilter.click();
        chooseStorage.click();
        storageFilter.click();
        return this;
    }
    @Step("Search input:{searchLenovo}")
    public LaptopsPageSteps Search_Input(String searchLenovo) {
        searchField.setValue(searchLenovo);
        sleep(2000);
        return this;
    }
    @Step("Click on Search button")
    public LaptopsPageSteps SearchBtn() {
        searchBtn.click();
        sleep(5000);
        return this;
    }
    @Step("Add laptops to the Cart")
    public LaptopsPageSteps AddToCart() {
        int itemsQuantity = addToCartQuantity.size();
        for (int i = 0; i < itemsQuantity; i++) {
            addToCartQuantity.get(i).click();
            addToCartText.shouldBe(Condition.visible, Duration.ofMillis(2000));
            sleep(2000);
        }
        return this;
    }
    @Step("Choose Brand,Ram,Storage filters and add laptops to the Cart")
    public LaptopsPageSteps ChooseAndAddProducts() {
        ChooseBrandFilter();
        ChooseRamFilter();
        ChooseStorageFilter();
        AddToCart();
        return this;
    }
    @Step("Convert before sort price list into Double Array")
    public LaptopsPageSteps CreatePriceList_BeforeSort() {
        for (int i = 0; i < priceList.size(); i++){
            beforeSort.add(Double.parseDouble(priceList.get(i).getText().replace("€", "").replace(",", ".")));
        }
        return this;
    }
    @Step("Click on Sort button")
    public LaptopsPageSteps SortBtn() {
        sleep(1000);
        sortOption.click();
        return this;
    }
    @Step("Click on Low to High option")
    public LaptopsPageSteps LowToHigh() {
        lowToHigh.click();
        sleep(2000);
        return this;
    }
    @Step("Convert after sort price list into Double Array")
    public LaptopsPageSteps CreatePriceList_AfterSort() {
        sleep(5000);
        for (int i = 0; i < priceList.size(); i++){
            afterSort.add(Double.parseDouble(priceList.get(i).getText().replace("€", "").replace(",", ".")));
        }
        return this;
    }


}

