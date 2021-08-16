@EUG18-288
Feature: 

	Background:
		#@EUG18-292
		Given the user is logged in
		When Click on "poll" link on the Active Stream page
		

	#*+{color:#de350b}User Story:{color}+*
	# As a user, I should be able to create a poll by clicking on Poll tab under Active Stream
	#
	#{color:#de350b}+*Acceptance Criteria*+{color}
	#
	#*User should be able to add users by selecting multiple contacts from Employees and Departments contact lists.*
	# User should be able to attach a link by clicking on the link icon.
	# User should be able to add mention by clicking on the add mention icon.
	# User should be able to add questions and multiple answers.
	# User should be able to delete questions and multiple answers.
	# User should be able to provide multiple choice to attendees by selecting the Allow multiple choice checkbox.
	# User should be able to send a poll
	@EUG18-287 @EUG18-286
	Scenario: Select multiple contacts from Employees and Departments contact lists.
		And Click "add more"
		And Click "employees and departments destination"
		Then User add 2 contacts from "add more"	

	#*+{color:#de350b}User Story:{color}+*
	# As a user, I should be able to create a poll by clicking on Poll tab under Active Stream
	#
	#{color:#de350b}+*Acceptance Criteria*+{color}
	#
	#User should be able to add users by selecting multiple contacts from Employees and Departments contact lists.
	# *User should be able to attach a link by clicking on the link icon.*
	# User should be able to add mention by clicking on the add mention icon.
	# User should be able to add questions and multiple answers.
	# User should be able to delete questions and multiple answers.
	# User should be able to provide multiple choice to attendees by selecting the Allow multiple choice checkbox.
	# User should be able to send a poll
	@EUG18-289 @EUG18-286
	Scenario: Attach a link by clicking on the link icon
		And Click "link"
		And Enter "text for facebook" link text  and "https://www.facebook.com/" for url text
		And Click "send"
		Then User should be able to attach "https://www.facebook.com/" link	

	#*+{color:#de350b}User Story:{color}+*
	#As a user, I should be able to create a poll by clicking on Poll tab under Active Stream
	#
	#{color:#de350b}+*Acceptance Criteria*+{color}
	#
	#User should be able to add users by selecting multiple contacts from Employees and Departments contact lists.
	#User should be able to attach a link by clicking on the link icon.
	#*User should be able to add mention by clicking on the add mention icon.*
	#User should be able to add questions and multiple answers.
	#User should be able to delete questions and multiple answers.
	#User should be able to provide multiple choice to attendees by selecting the Allow multiple choice checkbox.
	#User should be able to send a poll
	@EUG18-290 @EUG18-286
	Scenario: Add mention by clicking on the add mention icon
		And Click "add mention"
		And Click "employees and departments mention"
		And User add 2 contacts from "add mention"
		Then User should be able to 2 add mention by clicking on the add mention icon	

	#*+{color:#de350b}User Story:{color}+*
	# As a user, I should be able to create a poll by clicking on Poll tab under Active Stream
	#
	#{color:#de350b}+*Acceptance Criteria*+{color}
	#
	#User should be able to add users by selecting multiple contacts from Employees and Departments contact lists.
	# User should be able to attach a link by clicking on the link icon.
	# User should be able to add mention by clicking on the add mention icon.
	# *User should be able to add questions and multiple answers.*
	# *User should be able to delete questions and multiple answers.*
	# *User should be able to provide multiple choice to attendees by selecting the Allow multiple choice checkbox.*
	# *User should be able to send a poll*
	@EUG18-291 @EUG18-286
	Scenario: Add/Delete questions and multiple answers-Allow multiple choice-Send a poll
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