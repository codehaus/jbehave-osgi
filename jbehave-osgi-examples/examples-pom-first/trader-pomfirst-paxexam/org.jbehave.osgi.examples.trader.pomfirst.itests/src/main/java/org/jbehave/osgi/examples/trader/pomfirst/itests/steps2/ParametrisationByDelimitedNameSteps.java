package org.jbehave.osgi.examples.trader.pomfirst.itests.steps2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.Set;
import java.util.TreeSet;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class ParametrisationByDelimitedNameSteps {

  private String user;    
  private Set<String> products; // null means no cart...

  @BeforeScenario
  public void init() {
    user = null;
    products = null;
  }

  @Given("$user is logged in")
  public void loggedIn(String user) {
    this.user = user;
  }

  @Given("$customer has a cart")
  public void aCustomerHasACart(String customer) {
    assertThat(user, notNullValue());
    assertThat(customer, equalTo(user));
    if (products == null) products = new TreeSet<String>();
  }

  @Given("a user $user has borrowed books $isbns")
  public void createListOfBorrowedBooks(String user, String isbns) {
	  System.out.println(user+", "+isbns);
  }
  
  @When("a $product is added to the cart")
  public void aProductIsAddedToCart(String product) {
    assertThat(products, notNullValue());
    products.add(product);
  }

  @Then("cart contains $product")
  public void cartContains(String product) {
    assertThat(products, notNullValue());
    assertThat(products.contains(product), is(true));
  }
}