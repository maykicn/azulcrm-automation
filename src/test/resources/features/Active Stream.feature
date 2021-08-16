
Feature:  As a user, I should be able to create a poll by clicking on Poll tab under Active Stream

  Background:
    Given the user is logged in
    When Click on "poll" link on the Active Stream page


  Scenario:Select multiple contacts from Employees and Departments contact lists.
    And Click "add more"
    And Click "employees and departments destination"
    Then User add 2 contacts from "add more"

  Scenario:Attach a link by clicking on the link icon.
    And Click "link"
    And Enter "text for facebook" link text  and "https://www.facebook.com/" for url text
    And Click "send"
    Then User should be able to attach "https://www.facebook.com/" link


  Scenario: Add mention by clicking on the add mention icon.
    And Click "add mention"
    And Click "employees and departments mention"
    And User add 2 contacts from "add mention"
    Then User should be able to 2 add mention by clicking on the add mention icon


  Scenario:Add questions and multiple answers.
    And Add questions and answers
      | QUESTION1 | answer11 | answer12 | answer13 |
      | question2 | answer21 | answer22 | answer23 |
    Then User should be able to add questions and multiple answers.
    Then User should be able to delete answer 2 of question 1 and question 2
    And Click Allow multiple choice for question 1
    Then User should be able to select Allow multiple choice checkbox of question 1.
    And Enter title for question
    |title4|
    And Click "send"
    Then User should be able to send question with "title4" title a poll








