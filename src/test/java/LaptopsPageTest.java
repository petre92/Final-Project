import StepObject.LaptopsPageSteps;
import Utils.ChromeRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Collections;
import static DataObject.LaptopsPageData.*;
public class LaptopsPageTest extends ChromeRunner {

    LaptopsPageSteps laptopPageSteps = new LaptopsPageSteps();
    @Test
    @Description("Comparing laptops quantity for search and filter results")
    @Severity(SeverityLevel.NORMAL)
    public void ProductsQuantityTest() {
        laptopPageSteps.ChooseBrandFilter();
        int amountByBrand = Integer.parseInt(laptopPageSteps.amountOfProducts.innerText());
        laptopPageSteps.CloseBrandFilter()
                .Search_Input(searchBrand)
                .SearchBtn();
        int amountBySearch = Integer.parseInt(laptopPageSteps.amountOfProducts.innerText());
        Assert.assertEquals(amountByBrand, amountBySearch, "Compare number of products");
    }

    @Test
    @Description("Add laptops list to the cart")
    @Severity(SeverityLevel.NORMAL)
    public void AddToCartTest() {
        laptopPageSteps.ChooseBrandFilter()
                .ChooseRamFilter()
                .ChooseStorageFilter()
                .AddToCart();
        Assert.assertEquals(laptopPageSteps.addToCartQuantity.size(),
                Integer.parseInt(laptopPageSteps.productsInCart.innerText()),
                "The same amount of products are added to the Cart as shown under Cart button");
    }

    @Test
    @Description("Verifying the laptops are sorted by price")
    @Severity(SeverityLevel.CRITICAL)
    public void SortTest() {
        laptopPageSteps.ChooseAndAddProducts()
                .CreatePriceList_BeforeSort()
                .SortBtn()
                .LowToHigh()
                .CreatePriceList_AfterSort();
        Collections.sort(laptopPageSteps.beforeSort);
        Assert.assertEquals(laptopPageSteps.beforeSort,laptopPageSteps.afterSort, "Products are sorted correctly");

    }
}