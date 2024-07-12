@ui
Feature: LastBounce ListVerify Page

  Background: Open the URL of Lastbounce
    When Open the Url Of Lastbounce Application Validate First and Login with Valid Credentials

  @ListVerify
  Scenario:C347793 List-Verify_001 - Verify List Verify page
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Hover on the Element
      | ElementName |
      | verifymenu  |
    Then Click List Verify
    Then Verify page heading
      | ListVerifypageHeading |
      | List Verify           |

  @ListVerify
  Scenario:C347794 List-Verify_002 - Verify parts of List Verify page
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Hover on the Element
      | ElementName |
      | verifymenu  |
    Then Click List Verify
    Then Validate List Verify page Elements
      | ListVerifyFileUpload | Single Verify window | Results History table |
      | ListVerifyFileUpload | Single Verify window | Results History table |

  @ListVerify
  Scenario: C347795 List-Verify_003 - Verify Upload/Drag & Drop section
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Hover on the Element
      | ElementName |
      | verifymenu  |
    Then Click List Verify
    Then Verify the details in upload section
      | ListVerifyFileUpload | DragandDropYourCSVfilehereorclicktoupload         | Upload icon                        |
      | Drag & Drop section  | Drag & drop your CSV file here or click to upload | Upload icon is shown in the middle |

  @ListVerify
  Scenario:C347796 List-Verify_004 - Verify Drag & Drop section - click anywhere to upload
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Hover on the Element
      | ElementName |
      | verifymenu  |
    Then Click List Verify
    Then Click and Verify that user is able to click anywhere on the Drag & Drop section to upload a document

 @upload_test
  Scenario:C347797 List-Verify_005 - Verify Drag & Drop a batch file
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Hover on the Element
      | ElementName |
      | verifymenu  |
    Then Click List Verify
    Then Drag & Drop a batch file to the upload section
      | ListVerifyFileUpload  |
      | LB_TestFileUpload.csv |
    Then Validate uploaded file
      | VerifyBtnfromfileupload |
      | Verify                  |

  @ListVerify
  Scenario:C347798 List-Verify_006 - Verify Results History table
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Hover on the Element
      | ElementName |
      | verifymenu  |
    Then Click List Verify
    Then verify columns name of Results History table
      | File Name | Records | Uploaded | Processed | Status | Action | Delete | View |
      | File Name | Records | Uploaded | Processed | Status | Action | Delete | View |

  @ListVerify
  Scenario:C347799 List-Verify_007 - Verify Results History table
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Hover on the Element
      | ElementName |
      | verifymenu  |
    Then Click List Verify
    Then Verify the tabs are displayed under Results History table
      | AllTab | Completed | Verifying | Ready to verify | Error | Trash |
      | All    | Completed | Verifying | Ready to verify | Error | Trash |
      
   @ListVerify2306
  Scenario: C347800 List-Verify_008 - Verify Single Verify controls
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Hover on the Element
      | ElementName |
      | verifymenu  |
    Then Click List Verify
    Then Verify options for quick single verification
      | SingleVerifyText | EmailTextBox                   |
      | Single Verify    | Enter an email address here... |
  @ListVerify
  Scenario:C347820  List-Verify_028 - Verify column on Results History table
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Hover on the Element
      | ElementName |
      | verifymenu  |
    Then Click List Verify
    Then Click on all tab
    Then verify columns name of Results History table
      | File Name | Records | Uploaded | Processed | Status | Action | Delete | View |
      | File Name | Records | Uploaded | Processed | Status | Action | Delete | View |

  @ListVerify
  Scenario:C347821  List-Verify_029 - Verify tabs on Results History table
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Hover on the Element
      | ElementName |
      | verifymenu  |
    Then Click List Verify
    Then Go to the Results History table
    Then Verify the tabs are displayed under Results History table
      | AllTab | Completed | Verifying | Ready to verify | Error | Trash |
      | All    | Completed | Verifying | Ready to verify | Error | Trash |

  Scenario:C347822 List-Verify_030 - Verify Completed tab
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Hover on the Element
      | ElementName |
      | verifymenu  |
    Then Click List Verify
    Then Go to the Results History table
    Then Click On Completed tab
    Then verify columns name of Results History table
      | File Name | Records | Uploaded | Processed | Status | Action | Delete | View |
      | File Name | Records | Uploaded | Processed | Status | Action | Delete | View |
