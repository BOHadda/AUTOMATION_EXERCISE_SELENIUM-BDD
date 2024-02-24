package tn.hadda.automationexercise.e2etest.automation.products;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import tn.hadda.automationexercise.e2etest.automation.utils.Setup;
import tn.hadda.automationexercise.e2etest.automation.utils.WaitMethods;

public class ProductsPage {

	/* Locators */
	final static String PRODUCTS_BUTTON = "//a[@href='/products']";
	final static String ALL_PRODUCTS = "//h2[contains(text(),'All Products')]";
	final static String PRODUCT_NAME_INPUT = "search_product";
	final static String SEARCH_PRODUCT_BUTTON = "submit_search";
	final static String SEARCHED_PRODUCTS = "//h2[contains(text(),'Searched Products')]";
	final static String ALL_PRODUCTS_VISIBLE = "//div[@class='single-products']";
	final static String FIRST_PRODUCT = "//img[@src='/get_product_picture/1']";
	final static String ADD_TO_CART = "//a[@class='btn btn-default add-to-cart']";
	final static String CONTINUE_SHOPPING = "//button[contains(text(),'Continue Shopping')]";
	final static String SECOND_PRODUCT = "//img[@src='/get_product_picture/2']";
	final static String VIEW_CART_BUTTON = "//u[contains(text(),'View Cart')]";
	final static String PRICE_FIRST_PRODUCT = "//p[contains(text(),'Rs. 500')]";
	final static String QUANTITY_FIRST_PRODUCT = "//button[contains(text(),'1')]";
	final static String TOTAL_PRICE_FIRST_PRODUCT = "//p[contains(text(),'Rs. 500')]";
	final static String PRICE_SECOND_PRODUCT = "//p[contains(text(),'Rs. 400')]";
	final static String QUANTITY_SECOND_PRODUCT = "//button[contains(text(),'1')]";
	final static String TOTAL_PRICE_SECOND_PRODUCT = "//p[contains(text(),'Rs. 400')]";

	/* @FindBy */
	@FindBy(how = How.XPATH, using = PRODUCTS_BUTTON)
	public static WebElement productsBtn;

	@FindBy(how = How.XPATH, using = ALL_PRODUCTS)
	public static WebElement allProducts;

	@FindBy(how = How.ID, using = PRODUCT_NAME_INPUT)
	public static WebElement productName;

	@FindBy(how = How.ID, using = SEARCH_PRODUCT_BUTTON)
	public static WebElement searchProductName;

	@FindBy(how = How.XPATH, using = SEARCHED_PRODUCTS)
	public static WebElement searchedProductsMsg;

	@FindBy(how = How.XPATH, using = ALL_PRODUCTS_VISIBLE)
	public List<WebElement> products;

	@FindBy(how = How.XPATH, using = FIRST_PRODUCT)
	public static WebElement firstProductToHover;

	@FindBy(how = How.XPATH, using = ADD_TO_CART)
	public static WebElement addToCart;

	@FindBy(how = How.XPATH, using = CONTINUE_SHOPPING)
	public static WebElement continueShopping;

	@FindBy(how = How.XPATH, using = SECOND_PRODUCT)
	public static WebElement secondProductToHover;

	@FindBy(how = How.XPATH, using = VIEW_CART_BUTTON)
	public static WebElement viewCartBtn;

	@FindBy(how = How.XPATH, using = PRICE_FIRST_PRODUCT)
	public static WebElement priceFirstProduct;

	@FindBy(how = How.XPATH, using = QUANTITY_FIRST_PRODUCT)
	public static WebElement quantityFirstProduct;

	@FindBy(how = How.XPATH, using = TOTAL_PRICE_FIRST_PRODUCT)
	public static WebElement totalPriceFirstProduct;

	@FindBy(how = How.XPATH, using = PRICE_SECOND_PRODUCT)
	public static WebElement priceSecondProduct;

	@FindBy(how = How.XPATH, using = QUANTITY_SECOND_PRODUCT)
	public static WebElement quantitySecondProduct;

	@FindBy(how = How.XPATH, using = TOTAL_PRICE_SECOND_PRODUCT)
	public static WebElement totalPriceSecondProduct;

	/* Initialisation */

	WaitMethods waitMethod = new WaitMethods();
	WebDriver driver = Setup.driver;
	Actions action = new Actions(driver);

	/* Methods */

	public void clickProductsButton() {
		productsBtn.click();

	}

	public boolean verifyAllProductsIsVisible() {
		// waitMethod.explicitWaitUntilVisibilityOfWEXpath(driver, ALL_PRODUCTS, 5);
		return allProducts.isDisplayed();
	}

	public void enterProductName(String nameP) {
		productName.sendKeys(nameP);
	}

	public void clickSearchProduct() {
		searchProductName.click();

	}

	public String getSearchedProductsText() {
		waitMethod.explicitWaitUntilVisibilityOfWEXpath(driver, SEARCHED_PRODUCTS, 5);
		return searchedProductsMsg.getText();
	}

	public boolean areAllSearchedProductsVisible() {
		waitMethod.explicitWaitUntilVisibilityOfWEXpath(driver, ALL_PRODUCTS_VISIBLE, 10);
		boolean allProductsVisible = true;
		for (WebElement product : products) {
			if (!product.isDisplayed()) {
				allProductsVisible = false;
				break;
			}
		}
		return allProductsVisible;
	}

	public void mouseHoverOnFirstProduct() {
		waitMethod.explicitWaitUntilVisibilityOfWEXpath(driver, FIRST_PRODUCT, 5);
		action.moveToElement(firstProductToHover).perform();
	}

	public void clickAddToCart() {
		waitMethod.explicitWaitUntilVisibilityOfWEXpath(driver, ADD_TO_CART, 5);
		addToCart.click();

	}

	public void clickContinueShopping() {
		waitMethod.explicitWaitUntilButtonIsClickableXpath(driver, CONTINUE_SHOPPING, 5);
		continueShopping.click();

	}

	public void mouseHoverOnSecondProduct() {
		waitMethod.explicitWaitUntilVisibilityOfWEXpath(driver, SECOND_PRODUCT, 10);
		action.moveToElement(secondProductToHover).perform();
	}
	public void clickAddToCartSecondProduct() {
		waitMethod.explicitWaitUntilVisibilityOfWEXpath(driver, ADD_TO_CART, 5);
		addToCart.click();

	}
	
	
	public void clickViewCartButton() {
		waitMethod.explicitWaitUntilButtonIsClickableXpath(driver, VIEW_CART_BUTTON, 10);
		viewCartBtn.click();

	}

	public boolean verifyBothProductsAreDislpayed() {
		if ((firstProductToHover).isDisplayed() & (secondProductToHover).isDisplayed())
			return true;
		else
			return false;
	}

	public String getPriceFirstProduct() {

		return priceFirstProduct.getText();
	}

	public String getQuantityFirstProduct() {

		return quantityFirstProduct.getText();
	}

	public String getTotalPriceFirstProduct() {

		return totalPriceFirstProduct.getText();
	}

	public String getPriceSecondProduct() {

		return priceSecondProduct.getText();
	}

	public String getQuantitySecondProduct() {

		return quantitySecondProduct.getText();
	}

	public String getTotalPriceSecondProduct() {

		return totalPriceSecondProduct.getText();
	}
}
