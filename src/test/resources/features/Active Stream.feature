
  Feature:  Under Active Stream
    Background:
      Given the user is logged in

    @wip
    Scenario: Create a Poll by Clicking on Poll tab under Active Stream
      When the user clicks on "poll" link on the Active Stream page
      Then add users by selecting multiple contacts from "Employees and Departments" contact lists.
      Then  the user clicks "link" icon on the poll section
      Then  the user clicks "mention" icon on the poll section
      Then add questions and multiple answers.
      Then delete questions and multiple answers.
      Then provide multiple choice to attendees by selecting the Allow multiple choice checkbox.
      And the user clicks send button