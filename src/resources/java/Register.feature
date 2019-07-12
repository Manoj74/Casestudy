Feature: SignUp
Scenario Outline: Test signup function with different set of input

Given user opens signup page in TestMe App
When user enters username as "<username>"
And user enters firstname as "<firstname>"
And user enters lastname as "<lastname>"
And user enters pwd as "<password>"
And user enters confirmpwd as "<confirmpassword>"
And user enters gender 
And user enters email as "<email>"
And user enters mob as "<mob>"
And user enters dob as "<dob>"
And user enters address as "<address>"
And user enters sec_ques as "<sec_ques>"
And user enters sec_ans as "<sec_ans>"
And click signup button
Then verify signup success message
Then close application

Examples: 

|username|firstname|lastname|password|confirmpassword|email|mob|dob|address|sec_ques|sec_ans|
|manojjk|manoj|jk|manoj1234|manoj123|manojjk12@gmail.com|8122197576|07-04-1995|coimbatore|what is your favour color?|black|
|arun|arun|k|arun123|arun123|arun@gmail.com|1234567890|05-04-1997|chennai|what is your favour color?|white|
