Feature: Random tests on the PT site

  Background:
    Given I am on the PrincesTrust homepage

  @runOnly
  Scenario Outline: User should be to use Main search to look for success stories
    When I use Search to find "<searchTerm>"
    And I should see first few results containing "<searchTerm>"

    Examples:
      |searchTerm|
      |Joel|
      |Shannon|

  @runOnly
  Scenario: User should not be able to use main search to find opportunities
    When I use Search to find "RM6 5QT"
    Then I should see error message appear

  @runOnly
  Scenario: News landing page hero banner should contain Image, Title, Date and Excerpt
    When I navigate to the News and views homepage
    Then I see displayed Landing page image
    And the News title
    And Date publish
    And excerpt

