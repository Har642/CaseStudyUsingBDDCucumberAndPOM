Feature: Conduit CRUD Functions


Scenario: User Login
Given User is on Login Page
When User provide "hari.harish11135@gmail.com" and "Harish@1735"
Then User should be on Home Page

Scenario: Create New Article
Given User should be on New Article Page
When User enters Article details
 | title | desc | Content |  tag |
 | Critical Thinking Skills. | It is about the critical thinking in IT industry | Selenium Verification | Developer,Tester,Support |
 | Critical Thinking Skills in IT. | It is about the critical thinking in IT industry | Cucummer Implementation | Developer,Tester,Support |
Then Article must be created

Scenario: View Article
Given User must be on My Article page
When User select an Article "Critical Thinking Skills."
Then Article datail page must be displayed

Scenario: Update an Article
Given Article datail page must be displayed
When User update article detail
Then Article detail must be updated

Scenario: Delete an Article
Given Article datail page must be displayed
When User delete Article
Then Article must be deleted

