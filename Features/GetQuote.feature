Feature: Get Quotation for renewal of insurance for Scooty Pep 

Scenario: Get Quotation for renewal of insurance for Scooty Pep
Given User navigates to Google 
When User types String
Then All prompts should be displayed in screen
When User clicks enter and selects policy bazaar website
Then User should be redirected to policy bazaar website
When User types Vehicle Number
And User types Vehicle Make 
And User types Vehicle Model
And User types Vehicle Version
And User types Vehicle Year
And User types Vehicle Contract
And User types Vehicle Last Detail
Then All Quotes Should be displayed in Screen
When User types value for Customer Name
And User types value for Mobile Number
And User types value for Email
And User types value for Address1
And User types value for Pincode
And User types value for Nominee name
And User types value for Chasis Number
And User types value for Engine Number
Then User is able to see the Insurance details