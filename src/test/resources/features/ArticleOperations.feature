Feature: Article Page Function
 
Scenario: Invalid Login into app
Given User is on login Page
When User enter inValid credentials
| emailid | password |
| Username@gmail.com | Userna |
Then Should display the invalid login message
| Wrong email/password combination |
 
Scenario: Valid Login into app
Given User is on login Page
When User enter Valid Credentials
| emailid | password |
| Username@gmail.com | Username |
Then Should display the success login message
|Username|
 
Scenario: User Create the Article with duplicate Title
Given User is on newArticleCreationPage
When   User Create the duplicate article
| articleTitle | description | body | tags |
| Testing12 | 2 | des | auto |
Then   Should display the duplicate article message
 
Scenario: User Create the new Article
Given User is on newArticleCreationPage
When User create the new Article
| articleTitle | description | body | tags |
| Testing13 | 2 | des | auto |
Then Should display the new Article Title
|Testing13|
 
Scenario: User update the Article
Given User is on updateArticlePage
| title |
| Testing13 |
When User Update the Article
| title |about|desc|
| Testing14 | sample article |sample article|
Then Should display the updated Article Title
| title |
| Testing14 |
 
 
Scenario: User delete the Article
Given User is on deleteArticlePage
| title |
| Testing14 |
When User delete the Article
Then Should display the article deletion msg
| msg |
| Articles not available. |