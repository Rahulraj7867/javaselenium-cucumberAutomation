Feature: Sales Data Entry
  Scenario: Upload Excel and fill sales data
    Given the user is logged in
    When the user uploads an excel file "sales_data.xlsx"
    And the user navigates to the PIBO operation section
    And the user selects "Sales Details"
    And the user enters sales details from the excel file
    And the user generates EPR Invoice Number
    Then the user updates the form with the generated EPR invoice number
    And the user uploads the updated excel file