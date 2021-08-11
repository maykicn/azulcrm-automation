package com.azulcrm.stepdefinitions;

import com.azulcrm.pages.LoginPage;
import io.cucumber.java.en.*;

public class creatingPollStepDefs {


    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        new LoginPage().login();

    }

    @When("the user clicks on {string} link on the Active Stream page")
    public void the_user_clicks_on_link_on_the_Active_Stream_page(String string) {

    }

    @Then("add users by selecting multiple contacts from {string} contact lists.")
    public void add_users_by_selecting_multiple_contacts_from_contact_lists(String string) {

    }

    @Then("the user clicks {string} icon on the poll section")
    public void the_user_clicks_icon_on_the_poll_section(String string) {

    }

    @Then("add questions and multiple answers.")
    public void add_questions_and_multiple_answers() {

    }

    @Then("delete questions and multiple answers.")
    public void delete_questions_and_multiple_answers() {

    }

    @Then("provide multiple choice to attendees by selecting the Allow multiple choice checkbox.")
    public void provide_multiple_choice_to_attendees_by_selecting_the_Allow_multiple_choice_checkbox() {

    }

    @Then("the user clicks send button")
    public void the_user_clicks_send_button() {

    }
}
