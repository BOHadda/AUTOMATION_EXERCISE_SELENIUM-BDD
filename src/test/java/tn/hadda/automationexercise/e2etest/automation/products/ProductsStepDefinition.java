package tn.hadda.automationexercise.e2etest.automation.products;

import java.util.List;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tn.hadda.automationexercise.e2etest.automation.utils.CommonMethods;
import tn.hadda.automationexercise.e2etest.automation.utils.Setup;

public class ProductsStepDefinition extends CommonMethods {

	public WebDriver driver;
	public ProductsPage productsPage = new ProductsPage();

	public ProductsStepDefinition() {
		super();
		driver = Setup.driver;
		PageFactory.initElements(driver, ProductsPage.class);

	}

	@Given("I click on Products button")
	public void iClickOnProductsButton() {
		productsPage.clickProductsButton();
	}

	@When("I verify user is navigated to ALL PRODUCTS page successfully")
	public void iVerifyUserIsNavigatedToALLPRODUCTSPageSuccessfully() {

		if (productsPage.verifyAllProductsIsVisible()) {
			System.out.println("ALL PRODUCTS is visible");
		} else {
			System.out.println("ALL PRODUCTS is not visible");
		}
	}

	@When("I enter product name {string} in search input")
	public void iEnterProductNameInSearchInput(String nameP) {
		productsPage.enterProductName(nameP);
	}

	@When("I click search button")
	public void iClickSearchButton() {
		productsPage.clickSearchProduct();
	}

	@Then("I verify {string} is visible")
	public void iVerifyIsVisible(String msgSearched) {
		String searchedProductsMsg = productsPage.getSearchedProductsText();
		System.out.println("The message of searched products is : " + searchedProductsMsg);
		Assert.assertTrue(searchedProductsMsg.contains(msgSearched));
	}

	@Then("I verify all the products related to search are visible")
	public void iVerifyAllTheProductsRelatedToSearchAreVisible() {
		super.scrollVertical(driver);
		boolean allProductsVisible = productsPage.areAllSearchedProductsVisible();
		System.out.println(allProductsVisible);
		Assert.assertTrue("Not all products are visible", allProductsVisible);
	}

	@When("I hover over on first product")
	public void iHoverOverOnFirstProduct() {
		super.scrollVertical(driver);
		productsPage.mouseHoverOnFirstProduct();

	}

	@When("I click Add to cart")
	public void iClickAddToCart() {
		productsPage.clickAddToCart();
	}

	@When("I click continue Shopping button")
	public void iClickContinueShoppingButton() {
		productsPage.clickContinueShopping();
	}

	@When("I hover over on second product")
	public void iHoverOverOnSecondProduct() {
		productsPage.mouseHoverOnSecondProduct();
	}
	@When("I click Add to cart the second product")
	public void iClickAddToCartTheSecondProduct() {
		productsPage.clickAddToCartSecondProduct();
	}
	

	@When("I click View cart button")
	public void iClickViewCartButton() {
		productsPage.clickViewCartButton();
	}

	@Then("I verify both products are added to Cart")
	public void iVerifyBothProductsAreAddedToCart() {
		productsPage.verifyBothProductsAreDislpayed();
	}

	@Then("I verify caracteristics of first products")
	public void iVerifyCaracteristicsOfFirstProducts(DataTable CaraFirstProduct) {
		List<List<String>> data = CaraFirstProduct.asLists(String.class);
		String prcFirsProduct = productsPage.getPriceFirstProduct();
		System.out.println(prcFirsProduct);
		Assert.assertTrue(prcFirsProduct.contains(data.get(1).get(1)));
		String qtyFirstProduct = productsPage.getQuantityFirstProduct();
		System.out.println(qtyFirstProduct);
		Assert.assertTrue(qtyFirstProduct.contains(data.get(2).get(1)));
		String totalPrcFirstProduct = productsPage.getTotalPriceFirstProduct();
		System.out.println(totalPrcFirstProduct);
		Assert.assertTrue(totalPrcFirstProduct.contains(data.get(3).get(1)));

	}

	@Then("I verify caracteristics of second products")
	public void iVerifyCaracteristicsOfSecondProducts(DataTable CaraSecondProduct) {
		List<List<String>> data = CaraSecondProduct.asLists(String.class);
		String prcScndProduct = productsPage.getPriceSecondProduct();
		System.out.println(prcScndProduct);
		Assert.assertTrue(prcScndProduct.contains(data.get(1).get(1)));
		String qtyScndProduct = productsPage.getQuantitySecondProduct();
		System.out.println(qtyScndProduct);
		Assert.assertTrue(qtyScndProduct.contains(data.get(2).get(1)));
		String totalPrcScndProduct = productsPage.getTotalPriceSecondProduct();
		System.out.println(totalPrcScndProduct);
		Assert.assertTrue(totalPrcScndProduct.contains(data.get(3).get(1)));
	}

}
