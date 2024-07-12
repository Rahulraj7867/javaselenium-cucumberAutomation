@ui
Feature: LastBounce Dashboard Page

  Background: Open the URL of Lastbounce
    When Open the Url Of Lastbounce Application Validate First and Login with Valid Credentials

  @Dashboard
  Scenario: C347534 : Dashboard_001 - Verify Dashboard
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |

  @Dashboard
  Scenario: C347535: Dashboard_002 - Verify Dashboard details
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Validate  Dashboard Page Contents
      | Dashboard LastBounce logo | Dashboard Top navigation bar | Dashboard List Activity Chart | Dashboard Single Activity Chart | Dashboard List History Table | Dashboard Single History Chart | Dashboard Support side pull-out window | Dashboard  Functionality footer | Dashboard Knowledge footer | Dashboard Complex Verification Simplified footer | Dashboard Copyright information | Dashboard DemandScience logo | Dashboard Privacy Policy links | Dashboard Terms and Conditions link | Dashboard Social media links |
      | LastBounce logo           | Top navigation bar           | List Activity Chart           | Single Activity Chart           | List History Table           | Single History Chart           | Support side pull-out window           | Functionality footer            | Knowledge footer           | Complex Verification Simplified footer           | Copyright information           | DemandScience logo           | Privacy Policy links           | Terms and Conditions link           | Social media links           |

  @Dashboard
  Scenario: C347536 : Dashboard_003 - Verify top navigation menu
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Validate Dashboard Page Navigation Menu
      | Dashboard Navigation | Verify Navigation | Phone Check Navigation | Account Navigation |
      | Dashboard            | Verify            | Phone Check            | Account            |

  @Dashboard
  Scenario: C347537 : Dashboard_004 - Verify Verify submenu
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Hover on the Element
      | ElementName |
      | verifymenu  |
    Then Validate Verify Submenu
      | Verify Submenu1 | Verify Submenu2 |
      | List Verify     | Single Verify   |

  @Dashboard
  Scenario: C347538 : Dashboard_005 - Verify Account Submenu
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Hover on the Element
      | ElementName |
      | Accountmenu |
    Then Validate Account Submenu
      | Logout Submenu |
      | Logout         |

  @Dashboard
  Scenario: C347539: Dashboard_006 - Verify Dashboard - List Activity (Filter by Days options)
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Click on the No of days filter On List Activity chart
    Then Validate  Days filter
      | SingleActivity DaysFilter1 | SingleActivity DaysFilter2 | SingleActivity DaysFilter3 |
      | 7 Days                     | 15 Days                    | 30 Days                    |

  @Dashboard
  Scenario: C347540 : Dashboard_007 - Verify Dashboard - List Activity - Filter by Days
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Click on the No of days filter On List Activity chart
    Then Select fifteen Days option from the days filter On List Activity chart
    Then Validate selected Days option in List Activity chart
      | ListActivitydays15option |
      | 15 Days                  |

  @Dashboard
  Scenario: C347541 : Dashboard_008 - Verify Dashboard - List Activity (Filter by Responses options)
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Click on Response Filter Button on List Activity Chart
    Then Validate Responses Filter Options on List Activity Chart
      | ListActivity ResponseFilter1 | ListActivity ResponseFilter2 | ListActivity ResponseFilter3 | ListActivity ResponseFilter4 | ListActivity ResponseFilter5 | ListActivity ResponseFilter6 | ListActivity ResponseFilter7 |
      | Valid v Invalid              | Valid                        | Invalid                      | Risky                        | Accept All                   | Unknown                      | All                          |

  @Dashboard
  Scenario: C347542 : Dashboard_009 - Verify Dashboard - List Activity (Filter by Responses)
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then On List Activity chart click Response filter
    Then Select All Option filter From Response filter
    Then Validate  Response filter After Selecting All filter Option
      | ListActivityValid | ListActivityInvalid | ListActivityRisky | ListActivityAcceptAll | ListActivityUnknown |
      | Valid             | Invalid             | Risky             | Accept All            | Unknown             |

  @Dashboard
  Scenario: C347543 : Dashboard_010 - Verify Dashboard - Single Activity (Filter by Days options)
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then On Single Activity chart click on the No of days filter
    Then Validate  Days filter
      | SingleActivity DaysFilter1 | SingleActivity DaysFilter2 | SingleActivity DaysFilter3 |
      | 7 Days                     | 15 Days                    | 30 Days                    |

  @Dashboard
  Scenario: C347544: Dashboard_011 - Verify Dashboard - Single Activity - Filter by Days
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then On Single Activity chart click on the No of days filter
    Then Select fifteen Days option from the days filter
    Then Validate selected Days option
      | SingalActivitydaysfilter15 |
      | 15 Days                    |

  @Dashboard
  Scenario:C347545 Dashboard_012 - Verify Dashboard - Single Activity (Filter by Responses options)
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then On Single Activity chart click Response filter
    Then Validate  Response filter
      | SingleActivityValid | SingleActivityInvalid | SingleActivityRisky | SingleActivityAcceptAll | SingleActivityUnknown | SingleActivityValidNInvalid | SingleActivityAll |
      | Valid               | Invalid               | Risky               | Accept All              | Unknown               | Valid v Invalid             | All               |

  @Dashboard
  Scenario:C347546 Dashboard_013 - Verify Dashboard - Single Activity - Filter by Responses
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then On Single Activity chart click Response filter
    Then Select All Option filter From Response filter on Single activity
    Then Validate  Response filter at bottom
      | SingleActivityValid | SingleActivityInvalid | SingleActivityRisky | SingleActivityAcceptAll | SingleActivityUnknown |
      | Valid               | Invalid               | Risky               | Accept All              | Unknown               |


  @Dashboard
  Scenario:C347547 Dashboard_014 - Verify Support pull out window
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then On the left side of the Dashboard click Support
    Then Contact Support pop-out window is shown
      | ContactSupport  |
      | Contact Support |

  @Dashboard
  Scenario:C347548 Dashboard_015 - Verify List History table
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Scroll down to List History table
    Then Validate list History table batch file with corresponding details
      | ListHistoryTablefilename | fileStatus |
      | LB-1141_10K_B.csv        | Completed  |

  @Dashboard
  Scenario:C347549 Dashboard_016 - Verify a Completed batch under List History table
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Scroll down to List History table
    Then Select batch from the table with Completed status
      | Status    |
      | Completed |
    Then Validate batch file details
      | ListHistoryTablefilename | Uploaded timestamp      | Completed timestamp      | fileStatus | Total noof records | Total noof Duplicate records | Responses and their totalpercentage  | percentagewhenhovered |
      | Batch filename           | Uploaded date/timestamp | Completed date/timestamp | fileStatus | Total noof records | Total noof Duplicate records | Responses and their total percentage | percentagewhenhovered |

  @Dashboard
  Scenario:C347550 Dashboard_017 - Verify a Ready to Verify batch under List History table
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Click on batch with ready status
    Then validate batch details
      | preverifyResultdetails | batchfilename         | typosfound      | totalrecords      |
      | Pre Verify Results     | LB-TestFileUpload.csv | Typos Found - 0 | 1  record checked |
    Then Validate verify button and fix typo toggle
      | Verify Button |
      | Verify        |

  @Dashboard
  Scenario:C347551 Dashboard_018 - Verify link to Single Verify page
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Click on link icon beside list verify and validate page is redirected
      | listverifyhyperlink                        |
      | https://dev-app.lastbounce.com/list-verify |

  @Dashboard
  Scenario:C347552 Dashboard_019 - Verify Single History table
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Click on view icon for any email
    Then Validate batch details

  @Dashboard
  Scenario:C347553 Dashboard_020 - Verify link to Single Verify page
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Scroll down to Single Verify table
    Then Click on link icon beside single history and validate page is redirected
      | singlehistoryhyperlink                       |
      | https://dev-app.lastbounce.com/single-verify |

  @Dashboard
  Scenario:C347554 Dashboard_021 - Verify Functionality footer
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Scroll down to bottom of page
    Then Validate functionality footer
      | dashboardfooterlink | listverifyfooterlink | singleverifyfooterlink |
      | Dashboard           | List Verify          | Single Verify          |

  @Dashboard
  Scenario:C347555 Dashboard_022 - Verify the links under Functionality footer
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Scroll down to bottom of page
    Then Validate links under Functionality footer
      | dashboardfooterlink                      | listverifyfooterlink                       | singleverifyfooterlink                       |
      | https://dev-app.lastbounce.com/dashboard | https://dev-app.lastbounce.com/list-verify | https://dev-app.lastbounce.com/single-verify |

  @Dashboard
  Scenario:C347556 Dashboard_023 - Verify Knowledge footer
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Scroll down to bottom of page
    Then validate Knowledge footer
      | validemailsfooter | invalidemailsfooter | riskyemailsfooter | acceptallemailsfooter | unknownemailsfooter |
      | Valid Emails      | Invalid Emails      | Risky Emails      | Accept All Emails     | Unknown Emails      |

  @Dashboard
  Scenario:C347557 Dashboard_024 - Verify links under Knowledge footer
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Scroll down to bottom of page
    Then Validate links under Knowledge footer
      | validemailsfooter | invalidemailsfooter | riskyemailsfooter | acceptallemailsfooter | unknownemailsfooter |
      | Valid Emails      | Invalid Emails      | Risky Emails      | Accept All Emails     | Unknown Emails      |

  @Dashboard
  Scenario:C347558 Dashboard_025 - Verify Complex Verification Simplified footer
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Scroll down to bottom of page
    Then Validate text under Complex Verification Simplified footer


  @Dashboard
  Scenario:C347559 Dashboard_026 - Verify links under Complex Verification Simplified footer
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Scroll down to bottom of page
    Then Validate DS links under Complex Verification Simplified footer
      | complexverificationsimplifiedDSlink |
      | https://demandscience.com/          |

  @Dashboard
  Scenario:C347560 Dashboard_027 - Verify Privacy Policy links
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Scroll down to bottom of page
    Then Validate privacy policy links
      | privacypolicy                             | CCPA                                           |
      | https://demandscience.com/privacy-policy/ | https://demandscience.com/privacy-policy-ccpa/ |

  @Dashboard
  Scenario:C347561 Dashboard_028 - Verify Terms and Conditions link
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Scroll down to bottom of page
    Then Validate Terms and Condition link
      | termsandconditions                      |
      | https://demandscience.com/terms-of-use/ |

  @Dashboard
  Scenario:C347562 Dashboard_029 - Verify Social Media links
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |
    Then Scroll down to bottom of page
    Then Validate Social media link
      | facebookurl                             | twitterurl                        | linkedinurl                                    |
      | https://www.facebook.com/DemandScience/ | https://twitter.com/demandscience | https://www.linkedin.com/company/demandscience |


  Scenario:C347562 Dashboard_029 - Verify Social Media links
    Given Validate the Dashboard Page
      | DashboardPage |
      | Dashboard     |