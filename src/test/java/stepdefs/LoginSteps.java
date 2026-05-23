package stepdefs;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static hooks.Hooks.page;

public class LoginSteps {

    @Given("I open SauceDemo login page")
    public void i_open_saucedemo_login_page() {
        page.navigate("https://www.saucedemo.com/");
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        page.fill("#user-name", username);
        page.fill("#password", password);
    }

    @When("I click login button")
    public void i_click_login_button() {
        page.click("#login-button");
    }

    @Then("I should see products page")
    public void i_should_see_products_page() {
        PlaywrightAssertions.assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");
        PlaywrightAssertions.assertThat(page.locator(".title")).hasText("Products");
    }
}
