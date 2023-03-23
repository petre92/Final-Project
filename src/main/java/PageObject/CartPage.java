package PageObject;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

    public SelenideElement
            cartPage = $(byClassName("icon-Cart-Stroke")),
            emptyMessageText = $(byText("Your shopping cart is empty")),
            restoreItemText = $(byText("Restore item"), 1),
            emptyCart = $(byClassName("btn_transgrey"));


    public ElementsCollection
            removeList = $$(byClassName("remove"));
}
