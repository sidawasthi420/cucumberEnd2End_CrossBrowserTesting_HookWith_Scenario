Feature: Snapdeal Product Search

@ChromeBrowser @chrome
Scenario Outline: Test the snapdeal application opening on different browsers

And Launch the application
And Enter "<username>" and "<password>"

Examples:
| username  | password  |
| user1     | pass1     |
| user2     | pass2     |

@DataTable @chrome
Scenario: Data Table value fetching

Then Enter userdetails for snapdeal
    | siddhant | awasthi | 31 | M | 9876543210 |
    | avinash | kaushik | 32 | M | 9854763210 |