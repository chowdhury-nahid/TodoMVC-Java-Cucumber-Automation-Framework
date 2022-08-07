package pages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.todomvcPage;

import java.time.Duration;

public class TodoSteps {

//    WebDriver driver = null;
//    todomvcPage page;
//
//    @Given("todomvc is loaded")
//    public void todomvcIsLoaded() {
//
//        String projectDirectory = System.getProperty("user.dir");
//        System.setProperty("webdriver.chrome.driver", projectDirectory + "/src/test/resources/drivers/chromedriver.exe");
//
//        driver = new ChromeDriver();
//
//        driver.navigate().to("https://todomvc.com/examples/vue/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
//    }
//
//    @Then("user clicks on the input field")
//    public void userClicksOnTheInputField() {
//
//        driver.findElement(By.cssSelector(".new-todo")).click();
//    }
//
//    @When("user enters {string}")
//    public void userEntersATodoItem(String todoItem){
//        driver.findElement(By.cssSelector(".new-todo")).sendKeys(todoItem);
//    }
//
//    @Then("user presses Enter")
//    public void userPressesEnter() {
//        driver.findElement(By.cssSelector(".new-todo")).sendKeys(Keys.ENTER);
//    }
//
//    @Then("{string} should appear in the list")
//    public void theTodoItemShouldAppearInTheList(String todoItem) {
//        Assert.assertEquals(driver.findElement(By.cssSelector("li:nth-of-type(1) > .view > label")).getText(),todoItem);
//    }
//
//    @And("the All filter should be selected")
//    public void theAllFilterIsSet() {
//        Assert.assertEquals(driver.findElement(By.cssSelector("[href='#/all']")).getAttribute("class"),"selected");
//    }
//
//    @And("the Completed filter should be unselected")
//    public void theCompletedFilterIsUnset() {
//        Assert.assertEquals(driver.findElement(By.cssSelector("[href='#/completed']")).getAttribute("class"),"");
//    }
//
//    @And("the Active filter should be unselected")
//    public void theActiveFilterIsUnset() {
//        Assert.assertEquals(driver.findElement(By.cssSelector("[href='#/active']")).getAttribute("class"),"");
//    }
//
//    @And("the todo count should be {string}")
//    public void theTodoCountIs(String count) {
//        Assert.assertEquals(driver.findElement(By.cssSelector("strong")).getText(), count);
//    }
}
