package com.azulcrm.pages;

import com.azulcrm.utilities.BrowserUtils;
import com.azulcrm.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivityStream extends BasePage {


    @FindBy(xpath = "//span[@id='feed-add-post-form-tab-vote']/span")
    public WebElement poll;

    @FindBy(xpath = "//a[@id='bx-destination-tag']")
    public WebElement addMore;

    @FindBy(xpath = "//a[starts-with(@id,'destDepartmentTab_destination')]")
    public WebElement employmeesAndDepartmentsDestination;

    @FindBy(css = "span.bxhtmled-top-bar-btn.bxhtmled-button-link")
    public WebElement link;

    @FindBy(xpath = "//input[@id='linkidPostFormLHE_blogPostForm-text']")
    public WebElement linkTextInput;

    @FindBy(xpath = "//input[@id='linkidPostFormLHE_blogPostForm-href']")
    public WebElement linkUrlInput;

    @FindBy(css = "input#undefined")
    public WebElement saveBtn;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement iframe;

    @FindBy(xpath = "//div[starts-with(@id,'blog_post_body_')]/a")
    public WebElement addedLink;

    @FindBy(xpath = "//span[@id='bx-b-mention-blogPostForm']")
    public WebElement addMention;

    @FindBy(xpath = "//a[starts-with(@id,'destDepartmentTab_mention')]")
    public WebElement employmeesAndDepartmentsMention;

    @FindBy(css = "a.vote-new-question-link.addq")
    public WebElement addQuestionBttn;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendBttn;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement iframeText;

    @FindBy(xpath = "//div[starts-with(@id,'blog_post_outer_')]")
    public WebElement titleOfQuestion;


    public void addQuestions(int number, String question) {
        String questionPath = "";
        questionPath = "//input[starts-with(@id,'question_" + number + "')]";
        WebElement questionText = Driver.get().findElement(By.xpath(questionPath));
        questionText.sendKeys(question);

    }


    public String getQuestionText(int number) {

        String questionPath = "";
        questionPath = "//input[starts-with(@id,'question_" + number + "')]";
        WebElement questionText = Driver.get().findElement(By.xpath(questionPath));
        return questionText.getAttribute("value");
    }

    public void addAnswer(int numberOfQuestion, int numberOfAnswer, String answer) {

        String answerXpath = "//input[starts-with(@id,'answer_" + numberOfQuestion + "__" + numberOfAnswer + "_')]";
        Driver.get().findElement(By.xpath(answerXpath)).sendKeys(answer);

    }

    public String getAnswerText(int numberOfQuestion, int numberOfAnswer) {

        String answerXpath = "//input[starts-with(@id,'answer_" + numberOfQuestion + "__" + numberOfAnswer + "_')]";
        WebElement answerText = Driver.get().findElement(By.xpath(answerXpath));
        return answerText.getAttribute("value");
    }


    public void addContact(int contacts, String icon) {
        int count = (int) contacts;
        if (icon.equals("add more")) {

            for (int i = 1; i <= count; i++) {

                String pathAdd = "(//div[@class='bx-finder-company-department-employee-name'])[" + i + "]";
                WebElement contact = Driver.get().findElement(By.xpath(pathAdd));
                contact.click();
                String pathGet = "(//span[@class='feed-add-post-destination-text'])[" + (i + 1) + "]";

                Assert.assertEquals(contact.getText(), Driver.get().findElement(By.xpath(pathGet)).getText());

            }


        } else if (icon.equals("add mention")) {

            int i = 1;
            do {

                String pathAdd = "(//div[@class='bx-finder-company-department-employee-name'])[" + i + "]";
                WebElement contact = Driver.get().findElement(By.xpath(pathAdd));
                contact.click();
                if (i > count) {
                    break;
                }
                addMention.click();
                employmeesAndDepartmentsMention.click();
                i++;
            } while (i <= count);
        }
    }


    public String getMentionText(int int1) {
        String result = "";
        for (int i = 1; i <= int1; i++) {
            String pathAdd = "(//span[@class='bxhtmled-metion'])[" + i + "]";
            result += Driver.get().findElement(By.xpath(pathAdd)).getText();
        }

        return result;
    }

    public boolean isElementDeleted(WebElement element) {
        try {
            element.isDisplayed();
            return false;
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            return true;
        }
    }


    public void deleteQuestion(int number) {

        String questionLabelXpath = "//label[@for='question_" + (number - 1) + "']";
        WebElement deletLabel = Driver.get().findElement(By.xpath(questionLabelXpath));
        WebElement question = Driver.get().findElement(By.xpath("//input[starts-with(@id,'question_" + (number - 1) + "')]"));
        BrowserUtils.hover(question);
        BrowserUtils.waitForClickability(deletLabel, 5);
        deletLabel.click();
        Alert alert = Driver.get().switchTo().alert();
        BrowserUtils.waitFor(2);
        alert.accept();
        Assert.assertTrue(isElementDeleted(question));


    }

    public void deleteAnswer(int numberOfAnswer, int answerOfQuestion) {

        String answerLabelXpath = "//label[@for='answer_" + (answerOfQuestion - 1) + "__" + (numberOfAnswer - 1) + "_']";
        WebElement deletLabel = Driver.get().findElement(By.xpath(answerLabelXpath));
        WebElement answer = Driver.get().findElement(By.xpath("//input[starts-with(@id,'answer_" + (answerOfQuestion - 1) + "__" + (numberOfAnswer - 1) + "_')]"));
        BrowserUtils.hover(answer);
        BrowserUtils.waitForClickability(deletLabel, 5);
        deletLabel.click();
        Alert alert = Driver.get().switchTo().alert();
        BrowserUtils.waitFor(2);
        alert.accept();
        Assert.assertTrue(isElementDeleted(answer));


    }


}
