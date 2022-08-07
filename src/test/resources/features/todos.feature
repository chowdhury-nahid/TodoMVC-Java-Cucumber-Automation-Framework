Feature: Manage todo list
  Description: In order to remember the things I want to do, as a ToDo MVC user,
  I want to manage my todo list


  @sanityTest
  Scenario Outline: User can add new item to the todo list
    When user enters <todo_item>
    Then user presses Enter
    Then <todo_item> should appear in the list
    And the todo count should be <todo_count>
    And the All filter should be selected
    And the Completed filter should be unselected
    And the Active filter should be unselected
    Then <todo_item> should appear in the list
    And initial todo should appear in the list

    Examples:
      | todo_item   | todo_count |
      | Buy cookies | 2          |

  @sanityTest
  Scenario: User can edit todo item
    When user double clicks the todo item
    And Updates the todo item text
    Then the todo item should update
    And the todo count should be 1
    And the All filter should be selected
    And the Completed filter should be unselected
    And the Active filter should be unselected

  @sanityTest
  Scenario: User can remove a todo item
    When user hovers mouse over the todo item
    And clicks on the cross icon
    Then the item should be removed from the list

  @sanityTest
  Scenario: User can complete a todo item
    When user checks the first todo item
    Then the todo item should be completed
    And the todo count should be 0
    And the All filter should be selected
    And the Completed filter should be unselected
    And the Active filter should be unselected
    And the Clear Completed button should appear

  @sanityTest
  Scenario: User can remove a completed todo item
    When user checks the first todo item
    And user clicks Completed filter
    Then user hovers mouse over the todo item
    And clicks on the cross icon
    Then the item should be removed from the list

  @smokeTest
  Scenario Outline: Active Filter only shows uncompleted todo
    When user enters <todo_item>
    Then user presses Enter
    Then <todo_item> should appear in the list
    When user checks the first todo item
    Then the todo item should be completed
    And the todo count should be 1
    And the All filter should be selected
    And the Completed filter should be unselected
    And the Active filter should be unselected
    And the Clear Completed button should appear
    When user clicks Active filter
    Then <todo_item> should appear in the list
    And initial todo should not appear in the list

    Examples:
      | todo_item   |
      | Buy cookies |


  @smokeTest
  Scenario Outline: Completed Filter only shows completed todo
    When user enters <todo_item>
    Then user presses Enter
    Then <todo_item> should appear in the list
    When user checks the first todo item
    Then the todo item should be completed
    And the todo count should be 1
    And the All filter should be selected
    And the Completed filter should be unselected
    And the Active filter should be unselected
    And the Clear Completed button should appear
    When user clicks Completed filter
    Then <todo_item> should not appear in the list
    And initial item should appear in the completed list

    Examples:
      | todo_item   |
      | Buy cookies |

  @smokeTest
  Scenario Outline: User can toggle all todo items as complete and incomplete
    When user enters <todo_item>
    And user presses Enter
    Then <todo_item> should appear in the list
    When user clicks the toggle all button
    Then the todo count should be 0
    And the All filter should be selected
    And the Completed filter should be unselected
    And the Active filter should be unselected
    And the Clear Completed button should appear
    When user clicks Completed filter
    Then <todo_item> should appear in the list
    And initial item should appear in the completed list
    When user clicks the toggle all button
    And user clicks Active filter
    Then <todo_item> should appear in the list
    And initial item should appear in the list
    And the todo count should be 2

    Examples:
      | todo_item   |
      | Buy cookies |

  @smokeTest
  Scenario Outline: User can clear all completed todo by clicking Clear Completed
    When user enters <todo_item>
    And user presses Enter
    Then <todo_item> should appear in the list
    When user enters <another_todo_item>
    And user presses Enter
    Then <another_todo_item> should appear in the list
    When user clicks the toggle all button
    Then the todo count should be 0
    And the All filter should be selected
    And the Completed filter should be unselected
    And the Active filter should be unselected
    And the Clear Completed button should appear
    When user checks the first todo item
    And user clicks on the Clear Completed button
    Then todo item should appear in the list
    And <todo_item> should not appear in the list
    And <another_todo_item> should not appear in the list

    Examples:
      | todo_item   | another_todo_item |
      | Buy cookies | Send document     |

