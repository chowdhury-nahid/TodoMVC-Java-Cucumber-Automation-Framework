package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.todomvcPage;

import java.time.Duration;

public class TodoStepsPOM {

    WebDriver driver = null;
    todomvcPage page;

    String initial_todo = "Buy milk";

    @Before
    public void Initialize() {

        String projectDirectory = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectDirectory + "/src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();

        driver.navigate().to("https://todomvc.com/examples/vue/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));

        page = new todomvcPage(driver);
        page.enterTodoItem(initial_todo);
        page.pressEnter();
        page.itemAppearsInList(initial_todo);
    }

    @When("user enters {}")
    public void userEntersATodoItem(String arg1) {
        page.enterTodoItem(arg1);
    }

    @Then("user presses Enter")
    public void userPressesEnter() {
        page.pressEnter();
    }

    @Then("{} should appear in the list")
    public void theTodoItemShouldAppearInTheList(String todoItem) {
        page.itemAppearsInList(todoItem);
    }

    @And("the All filter should be selected")
    public void theAllFilterIsSet() {

        page.isAllFilterSet(true);
    }

    @And("the Completed filter should be unselected")
    public void theCompletedFilterIsUnset() {

        page.isCompletedFilterSet(false);
    }

    @And("the Active filter should be unselected")
    public void theActiveFilterIsUnset() {

        page.isActiveFilterSet(false);
    }

    @And("the todo count should be {}")
    public void theTodoCountIs(String count) {

        page.checkItemCount(count);
    }

    @When("user double clicks the todo item")
    public void userDoubleClicksTheTodoItem() {

        page.doubleClickFirstTodoItem();
    }

    @And("Updates the todo item text")
    public void updatesTheTodoItemText() {

        page.updateFirstTodoItem(" updated");
        page.pressEnter();
    }

    @Then("the todo item should update")
    public void theTodoItemShouldUpdate() {

        page.itemAppearsInList(initial_todo + " updated");
    }

    @After
    public void tearDown() {

        page.closeBrowser();
    }

    @When("user checks the first todo item")
    public void userChecksTheTodoItem() {

        page.checkFirstTodo();
    }

    @Then("the todo item should be completed")
    public void theTodoItemShouldBeCompleted() {

        page.verifyFirstTodoStatus("todo completed");
    }

    @And("the Clear Completed button should appear")
    public void clearCompletedButtonAppears() {

        page.clearCompletedButtonAppears();
    }

    @When("user clicks Active filter")
    public void userClicksActiveFilter() {

        page.clickActiveFilter();
    }

    @And("initial item should not appear in the list")
    public void initialTodoShouldNotAppearInTheList() {

        page.itemDoNotAppearsInList(initial_todo);
    }

    @When("user clicks Completed filter")
    public void userClicksCompletedFilter() {

        page.clickCompletedFilter();
    }

    @Then("{} should not appear in the list")
    public void todoItemShouldNotAppearInTheList(String todo_item) {

        page.itemDoNotAppearsInList(todo_item);
    }

    @And("initial item should appear in the completed list")
    public void initialItemShouldAppearInTheCompletedList() {

        page.itemAppearsInList(initial_todo);
    }

    @When("user hovers mouse over the todo item")
    public void userHoversMouseOverTheTodoItem() {

        page.mouseHoverOnFirstTodo();
    }

    @And("clicks on the cross icon")
    public void clicksOnTheCrossIcon() {

        page.clickFirstTodoDestroyButton();
    }

    @Then("the item should be removed from the list")
    public void theItemIsRemovedFromTheList() {

        page.itemDoNotAppearsInList(initial_todo);
    }

    @When("user clicks the toggle all button")
    public void userClicksTheToggleButton() {

        page.clickToggleAllButton();
    }

    @When("user clicks on the Clear Completed button")
    public void userClicksOnTheClearCompletedButton() {
        page.clickClearCompleted();

    }

    @Then("the todo list should be empty")
    public void theTodoListShouldBeEmpty() {
        page.todoListShouldBeEmpty();
    }

}
