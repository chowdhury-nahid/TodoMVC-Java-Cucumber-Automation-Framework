package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class todomvcPage {

    WebDriver driver;

    @FindBy(css = ".new-todo")
    WebElement todo_input_field;
    @FindBy(css = "[href='#/all']")
    WebElement all_filter;

    @FindBy(css = ".todo-list")
    List<WebElement> item_list;
    @FindBy(css = "[href='#/completed']")
    WebElement completed_filter;
    @FindBy(css = "[href='#/active']")
    WebElement active_filter;
    @FindBy(css = "strong")
    WebElement item_count;
    @FindBy(css = "li:nth-of-type(1) > .view > label")
    WebElement first_todo_item;
    @FindBy(css = "li:nth-of-type(1) > .edit")
    WebElement first_todo_item_edit;
    @FindBy(css = ".clear-completed")
    WebElement clear_completed_button;

    @FindBy(css = "section.main ul.todo-list:nth-child(3) li.todo div.view > input.toggle:nth-child(1)")
    WebElement first_todo_checkbox;

    @FindBy(css = "body.learn-bar:nth-child(2) section.todoapp:nth-child(2) section.main ul.todo-list:nth-child(3) li.todo:nth-child(2) div.view > label:nth-child(2)")
    WebElement second_todo;

    @FindBy(css = "section.main ul.todo-list:nth-child(3) > li.todo.completed:nth-child(1) ")
    WebElement first_todo_status;

    @FindBy(css = "section.main ul.todo-list:nth-child(3) li.todo div.view > button.destroy:nth-child(3)")
    WebElement first_todo_destroy_button;

    @FindBy(css="[for='toggle-all']")
    WebElement toggle_all_button;


    public todomvcPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterTodoItem(String todoItem) {
        todo_input_field.sendKeys(todoItem);
    }

    public void pressEnter() {
        todo_input_field.sendKeys(Keys.ENTER);
    }

    public void itemAppearsInList(String itemText) {

        if (item_list.size() != 0) {
            for (WebElement items : item_list) {
                if (items.getText().equals(itemText))
                    Assert.assertEquals(itemText, items.getText());
            }
        }
    }

    public void itemDoNotAppearsInList(String itemText) {

        if (item_list.size() != 0) {
            for (WebElement items : item_list) {
                    Assert.assertNotEquals(itemText, items.getText());
            }
        }
    }

    public void isAllFilterSet(Boolean isSelected) {
        if (isSelected) {
            Assert.assertEquals(all_filter.getAttribute("class"), "selected");
        } else {
            Assert.assertEquals(all_filter.getAttribute("class"), "");
        }
    }

    public void isCompletedFilterSet(Boolean isSelected) {
        if (isSelected) {
            Assert.assertEquals(completed_filter.getAttribute("class"), "selected");
        } else {
            Assert.assertEquals(completed_filter.getAttribute("class"), "");
        }
    }

    public void isActiveFilterSet(Boolean isSelected) {
        if (isSelected) {
            Assert.assertEquals(active_filter.getAttribute("class"), "selected");
        } else {
            Assert.assertEquals(active_filter.getAttribute("class"), "");
        }
    }

    public void checkItemCount(String count) {
        Assert.assertEquals(count, item_count.getText());
    }

    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

    public void doubleClickFirstTodoItem() {
        Actions actions = new Actions(driver);
        actions.doubleClick(first_todo_item).perform();
    }

    public void updateFirstTodoItem(String updateText) {
        first_todo_item_edit.sendKeys(updateText);
        waitForElementToBeInteractable(first_todo_item_edit);
    }

    public void waitForElementToBeInteractable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickCompletedFilter() {
        completed_filter.click();
    }

    public void clickClearCompleted() {
        clear_completed_button.click();
    }

    public void checkFirstTodo() {
        first_todo_checkbox.click();
    }

    public void verifyFirstTodoStatus(String status){
        Assert.assertEquals(status, first_todo_status.getAttribute("class"));
    }

    public void clearCompletedButtonAppears(){
        clear_completed_button.isDisplayed();
    }

    public void clickActiveFilter(){
        active_filter.click();
    }

    public void mouseHoverOnFirstTodo(){
        Actions actions = new Actions(driver);
        actions.moveToElement(first_todo_item).perform();
    }

    public void clickFirstTodoDestroyButton(){
        first_todo_destroy_button.click();
    }

    public void clickToggleAllButton(){
        toggle_all_button.click();
    }

}
