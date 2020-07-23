package com.webstraunt.stepDefinitions;

import com.webstraunt.pages.POsHomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SDsHomePage {
	
	POsHomePage posHomePage = new POsHomePage();
	
	
	@Given("User navigates to home page")
	public void user_navigates_to_home_page() {
		posHomePage.navigateTo();
	}

	@When("User searches for stainless work table")
	public void user_searches_for_stainless_work_table() {
	    posHomePage.searchAnItem();
	}

	@When("User verifies search results' titles includes Table word")
	public void user_verifies_search_results_titles_includes_table_word() {
	  posHomePage.verifySearchResult();
	}

	@When("User adds last item in the list to the Cart")
	public void user_adds_last_item_in_the_list_to_the_cart() {
	   posHomePage.addLatestItemToCart();
	}

	@When("User empties the Cart")
	public void user_empties_the_cart() {
	  posHomePage.emptyCart();
	}

	@Then("User gets succsess message")
	public void user_gets_succsess_message() {
	    posHomePage.validateSuccessMessage();
	}
}
