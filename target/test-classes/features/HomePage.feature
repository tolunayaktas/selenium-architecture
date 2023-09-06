@Tchibo

  Feature: Tchibo Test Automation

    @OpenSite
    Scenario: Validate the Site Opened
      Given Direct User to Home Page
      Then Check the Title of Browser as it is:"Tchibo - Meet one of Europe’s #1 Coffeehouses."

    @ControltheAboutCoffeeButton
    Scenario: Validate the Coffee button and below items
      Given Direct User to Home Page
      When Check the About Coffee Button and Click That
      Then Check the below items: "Our Process", "Aroma Protect Technology", "How to Store Coffee", "Our History","Coffee Blog"

    @ControltheSecondNavbarsItem
    Scenario: Validate 3 items of Second Navbar
      Given Direct User to Home Page
      Then Check the items of Second Navbar