# Editorial Organizer

## *An application to keep track of magazine stories and prepare freelance payments after publication*

**Main functions:**
- Add stories to a magazine editorial lineup list, including author, title and word count.
- Display story lists and calculate and display story list costs. 


This application will keep track of all the relevant information required for a magazine's editorial story lineup. 
I am currently the editor of British Columbia Magazine and plan to use this application to organize the stories in upcoming issues. I currently use a combination of paper, excel and a 
calculator so this application will help save time and aggravation. With regards to a lineup list, I am interested in adding stories to the list, knowing how many total stories are in the list and how much they cost.


**User Stories:**

- As a user, I would like to add a story to the editorial lineup list. (via formpanel)
- As a user, I would like to view the editorial lineup list. (via tablepanel)
- As a user, I would like to clear the editorial lineup list. (via button in toolbar)
- As a user, I would like a count of all stories in editorial lineup list. (via Show Cost graphic display in toolbar)
- As a user, I would like to get the total cost of all the stories in the list. (via Show Cost graphic display in toolbar)
- As a user, I would like to save the current editorial lineup list. (via Save and Exit item in File menu)
- As a user, I would like to load a saved editorial lineup list. (via Load Stories item in File menu)
- As a user, I would like to choose whether a story is a Feature or Column, each of which have different freelance rates. (via story type combobox in formpanel)


**Instructions for Grader**

- Start the application by running Main in the GUI. Story data is saved in stories.txt file in data.

- You can generate the first required event by inputting a story title, story author, wordcount and story type into the fields in the formpanel. Press the OK button to add the story to the list displayed in the tablepanel.
- You can generate the second required event by pressing the "Clear List" button in the toolbar, which clears the stories displayed in the tablepanel.
- You can locate my visual component by first making sure there are a number of stories in the tablepanel, then pressing the "Show Cost" button in the toolbar. Note that columns and features have different costs. This will display a pie chart comparing the current editorial cost (calculated using a rate of $0.50/word and the wordcount) with the total cost limit for the issue ($10000). Note that in addition to displaying the issue cost, this chart also displays the story count, which is another of my user stories.  
- You can save the state of my application by clicking on the "Save and Exit" item in the File menu. 
- You can reload the state of my application by restarting the application and clicking the "Load Stories" item in the File menu.


**Phase 4: Task 2**

- Added a type hierarchy for Story. This involved making Story an abstract class that is extended by two new Feature and Column classes.
- Feature and Column inherit most of the functionality from Story, but each have their own getCost() method, that calculates the cost of each story type using a different rate. 
- I added a ComboBox into the FormPanel that allows you to select Feature or Column, which creates either a new Feature or Column of type Story.


**Phase 4: Task 3**

- I reduced coupling by eliminating duplicate code in Controller's loadFromFile() method by calling on the readStories method in Reader.
- I improved the cohesion by creating a new class for CostFrame, since it was the only panel / frame in my GUI class that did not already have its own class.
- A NOTE about coupling and cohesion of my project. I originally designed the Controller, mainframe and gui classes with reduced coupling and improved cohesion in mind. Main calls on MainFrame, which organizes the main gui frame of the program via ToolBar, FormPanel and TablePanel, while Controller acts as the sole point of contact between the Model classes and the gui. Hopefully this is sufficent for Phase 4 of the project!! Thanks for everything! :)

