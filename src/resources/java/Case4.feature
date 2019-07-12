Feature: Cart Test

Scenario Outline: The one where the user moves to cart without adding item in it 
Given Alex has registered into TestMeApp and do login
When user enters username as "<username>" and password as "<password>"
And user clicks submit button
When user search a particular product like headphones
And user tries to access cart page
Then Testme app doesn't display the cart icon
Examples:
|username|password|
|alex123|alex123|