@Tchibo
  Feature: Machines Page Test Cases

    @CheckBeanLidTheProduct
    Scenario: Validate the Bean Lid Exists on Machines Page
      Given Direct User to Home Page
      When Click the Machines Dropdown
      When Click the Shop Machines Parts Button
      Then Check Bean Lid the Product