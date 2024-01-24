Feature: Build Tool All Steps

  @digital
Scenario:Build Tool 2 - Grade step
  Given User visits mazda home page
  Then Validate All Broken links
  Then Clicks "Buying Tools" from homepage
  And Clicks Build your mazda
  And Close postcode pop-up
  And Selects "MAZDA CX-60" model
  Then Enter and Select postcode "3000"
  And Selects buyer type "Personal" if not selected
  And Click on Submit
  Then Verify different grades cards
  Then Clicks on "Estimate Repayments" CTA
  And Validate Finance calculator opened and RDP price shown with other parameters
  Then Clicks on "Save and close" finance calculator popup
  And Finance calculator options shown on popup should be shown in the grade cards
  Then clicks on "See key features explained"
  And User should be able to scroll through different key feature cards
  Then clicks on "Compare grades"
#  And Compare page should be opened in a new tab, with the selected grade already selected.
  Then clicking on mazda logo to land on home page
  And Validate build abandonment popup
  Then Selects Build Yours CTA
  And Validate User stays on the Grade step
  Then clicking on mazda logo to land on home page
  And Validate User is navigated back to mazda home page
  Then selects "Build your CX-60" CTA
  And Validate navigated back to grade step of CX-60
  Then Clicks on "NEXT" button
  And Validate Build step page

  @digital
Scenario:Build Tool 2 - Build step
  Given User lands on Build Step of build tool
  Then User selects different engine options
  And The engine card should be selected
  Then User clicks on  Help me choose
  And User is displayed with different engine options
  Then User selects different exterior colour options and select "Soul Red Crystal Metallic"
  Then User selects different interior options and select "Black Leather"
  Then User selects different wheel options and select "CX-60 18 inch Graphite Alloy Wheel"
  Then User selects different wheel options and select "18-Inch Alloy"
  Then Clicks on Estimate Repayments CTA on Footer
  And Validate Finance calculator opened and RDP price shown with other parameters
  Then Clicks on "Save and close" finance calculator popup
  Then clicking on mazda logo to land on home page
  And Validate build abandonment popup for Build Step
  Then User selects "save your build" CTA
  And User is presented with a Build save form
  Then clicking on mazda logo to land on home page
  Then User selects "Continue your cx-60 build" CTA
  And User lands on Build Step of build tool
  Then clicking on mazda logo to land on home page
  Then User selects "continue build" CTA
  And User stays on the build step with the selections unchanged
  Then Clicks on "Continue" button on Build Page
  And User is navigated to the personalization step

  @digital
  Scenario:Build Tool 2 - Personalise step
   Given User lands on personalise step of build tool
   Then User selects different option packs available
   Then User selects different accessory options available
   Then Clicks on Estimate Repayments CTA on Footer
   And Validate Finance calculator opened and RDP price shown with other parameters
    Then Clicks on "Save and close" finance calculator popup
    Then clicking on mazda logo to land on home page
    And Validate build abandonment popup for Personalise Step
    Then User selects "save your build" CTA
    And User is presented with a Build save form
    Then clicking on mazda logo to land on home page
    Then User selects "Continue your cx-60 build" CTA
    And User lands on personalise step of build tool
    Then clicking on mazda logo to land on home page
    Then User selects "continue build" CTA
    Then Clicks on "NEXT" button
    And User is navigated to the Make It Yours step

  @digital
  Scenario:Build Tool 2 - MIY step
    Given User lands on the MIY step of build tool
    Then User is presented with different CTA's
    And "BOOK YOUR TEST DRIVE" when price is selected - Navigates to Book a test drive form
    And "ENQUIRY" when finance is selected - Navigates to Make an Enqiry form
    And "Save and Email your build" is standard for both selections - Navigates to Build Save form
    Then Final price is shown as default for the configurations selected in build journey
    And The accordians when expanded Drive Away Price should be accurate
    Then User selections should be shown under "My Design" section
    And Validate User selections
    Then User should be able to edit selections made using the edit under "My Design" section
    And User should be navigated back to the specific fields of configuration, in the respective steps
    And My design section should be updated with the latest selections
    Then User selects "Save" CTA
    And User should be presented with a build save form
    Then clicking on mazda logo to land on home page
    Then User selects "Exit Build" CTA
















