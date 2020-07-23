Feature: Assigment

@runNow
Scenario: Search an item and add to the Cart
Given User navigates to home page
When User searches for stainless work table
And User verifies search results' titles includes Table word
And User adds last item in the list to the Cart
When User empties the Cart 
Then User gets succsess message 
