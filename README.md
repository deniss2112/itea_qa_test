# itea_qa_test
QA Automation Exam

On machine where test will be launched need installed such programs:
1) MozillaFirefox latest version
2) JDK latest version

During the task execution :

Create automated test by following scenario:
- Open FireFox web browser
- Navigate to Google.com
- Enter "ITEA" into search field
- Click on "Search" button
- Verify "searchResults" page is loaded
- Verify there are 7 search results displayed on "searchResults" page !!!(in my case 10)!!!
- Verify that each result item on 1st page contains search term
- Click on 2nd searchResults page link
- Verify there are 10 search results displayed on 2nd "searchResults" page
- Verify that each result item on 2nd page contains search term.

I use such best practices:

1) Create Git repository, readme file(to describe working process) and gitignore file (that need for ignore unnecessary files when cone to repository)
2) Correct classes, methods and variables names
3) Page object and Page factory patterns
4) Generic method to minimize and good looking code
5) Java doc to describe all class, methods and variables