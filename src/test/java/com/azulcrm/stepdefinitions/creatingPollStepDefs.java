package com.azulcrm.stepdefinitions;

import com.azulcrm.pages.ActivityStream;
import com.azulcrm.pages.LoginPage;
import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.sql.DriverManager;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class creatingPollStepDefs {


    ActivityStream activityStream = new ActivityStream();

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        new LoginPage().login();
    }

    @When("Click on {string} link on the Active Stream page")
    public void click_on_link_on_the_Active_Stream_page(String tabActivityStream) {
        if (tabActivityStream.equals("poll")) {
            activityStream.poll.click();
        }

    }

    @When("Click {string}")
    public void click(String icon) {
        if (icon.equals("add more")) {
            activityStream.addMore.click();
        } else if (icon.equals("employees and departments destination")) {
            activityStream.employmeesAndDepartmentsDestination.click();
        } else if (icon.equals("link")) {
            activityStream.link.click();
        } else if (icon.equals("add mention")) {
            activityStream.addMention.click();
        } else if (icon.equals("employees and departments mention")) {
            activityStream.employmeesAndDepartmentsMention.click();
        }else if(icon.equals("send")){
            BrowserUtils.hover(activityStream.sendBttn);
            activityStream.sendBttn.click();
        }

    }

    @When("User add {int} contacts from {string}")
    public void user_should_be_add_contacts_from(int count, String icon) {
        activityStream.addContact(count, icon);
    }

    @When("Enter {string} link text  and {string} for url text")
    public void enter_link_text_and_for_url_text(String linkText, String linkUrl) {
        activityStream.linkTextInput.sendKeys(linkText);
        activityStream.linkUrlInput.sendKeys(linkUrl);
        BrowserUtils.waitFor(1);
        activityStream.saveBtn.click();

    }

    @Then("User should be able to attach {string} link")
    public void user_should_be_able_to_attach_link(String expectedUrl) {
        try {
            activityStream.addedLink.click();
        }catch (org.openqa.selenium.StaleElementReferenceException e){
            activityStream.addedLink.click();
        }
        for (String winHandle : Driver.get().getWindowHandles()) {
            Driver.get().switchTo().window(winHandle);
        }
        String actualUrl= Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Then("User should be able to {int} add mention by clicking on the add mention icon")
    public void user_should_be_able_to_add_mention_by_clicking_on_the_add_mention_icon(int int1) {
        activityStream.employmeesAndDepartmentsMention.click();
        String pathAdd="(//div[@class='bx-finder-company-department-employee-name'])["+int1+"]";
        BrowserUtils.waitFor(1);
        String expectedText= Driver.get().findElement(By.xpath(pathAdd)).getText();
        Driver.get().switchTo().frame(activityStream.iframe);
        BrowserUtils.waitFor(1);
        String actualText=activityStream.getMentionText(int1);


        Assert.assertTrue(actualText.contains(expectedText));
        Driver.get().switchTo().parentFrame();



    }






    @When("Add questions and answers")
    public void add_questions_and_answers(Map<String,List<String>>questionsAnswers) {
        int numberOfQuestion=0;
        //Set<String> keySetOfMap=questionsAnswers.keySet();

        for (String question: questionsAnswers.keySet()) {
            activityStream.addQuestions(numberOfQuestion,question);
            List<String> answerList=questionsAnswers.get(question);

            for (int numberOfAnswer = 0; numberOfAnswer <answerList.size(); numberOfAnswer++) {

                activityStream.addAnswer(numberOfQuestion,numberOfAnswer,answerList.get(numberOfAnswer));
            }
            activityStream.addQuestionBttn.click();
            numberOfQuestion++;


        }


    }

    @Then("User should be able to add questions and multiple answers.")
    public void user_should_be_able_to_add_questions_and_multiple_answers() {
        Assert.assertNotEquals(activityStream.getQuestionText(0),null);
        Assert.assertNotEquals(activityStream.getAnswerText(0,0),null);

    }


    @Then("User should be able to delete answer {int} of question {int} and question {int}")
    public void user_should_be_able_to_delete_answer_of_question_and_question(int numberOfAnswer, int answerOfQuestion, int numberOfQuestion ) {
        activityStream.deleteQuestion(numberOfQuestion);
        activityStream.deleteAnswer(numberOfAnswer,answerOfQuestion);

    }

    @Then("Click Allow multiple choice for question {int}")
    public void click_for_question(int numberOfQuestion) {

        Driver.get().findElement(By.xpath("//input[@id='multi_"+(numberOfQuestion-1)+"']")).click();

    }

    @Then("User should be able to select Allow multiple choice checkbox of question {int}.")
    public void user_should_be_able_to_select_Allow_multiple_choice_checkbox_of_question(int numberOfQuestion) {
       Boolean selected=Driver.get().findElement(By.xpath("//input[@id='multi_"+(numberOfQuestion-1)+"']")).isSelected();
       Assert.assertTrue(selected);

    }


    @Then("Enter title for question")
    public void send_title_for_question(String title) {
        Driver.get().switchTo().frame(activityStream.iframe);
        BrowserUtils.waitFor(1);
        activityStream.iframeText.sendKeys(title);
        Driver.get().switchTo().parentFrame();

    }

    @Then("User should be able to send a poll")
    public void user_should_be_able_to_send_a_poll() {
        System.out.println("activityStream.deneme.getText() = " + activityStream.titleOfQuestion.getText());
        System.out.println("activityStream.deneme.getAttribute(\"value\") = " + activityStream.titleOfQuestion.getAttribute("value"));

    }

    @Then("User should be able to send question with {string} title a poll")
    public void user_should_be_able_to_send_question_with_title_a_poll(String title) {
        try {
            BrowserUtils.waitForVisibility(activityStream.titleOfQuestion,5);
            Assert.assertEquals(title,activityStream.titleOfQuestion.getText());
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            BrowserUtils.waitForVisibility(activityStream.titleOfQuestion,5);
            Assert.assertEquals(title,activityStream.titleOfQuestion.getText());
        }


    }

}
