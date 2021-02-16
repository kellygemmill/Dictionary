# Dictionary

# Dictionary-Frontend
This is the front end of a Japanese dictionary web app written in Javascript using React. The page was styled using React Boostrap. This web app is available online at [http://jisho-kg.herokuapp.com](http://jisho-kg.herokuapp.com). 

Additionally, the API can be queried directly at [http://jisho-api-kg.herokuapp.com](http://jisho-api-kg.herokuapp.com). See the repository for [Dictionary-Backend](https://github.com/kellygemmill/Dictionary-Backend) for details on the API and backend Java code. 

## React Components:

### SearchBar:
The search bar containing the query to look up in the dictionary.

### Results:
Generates a SingleResult component for each result from the dictionary.

### SingleResult:
A single result from the dictionary. Currently this is the contents of the Word objects returned by the word parser in the backend. Likely will be refactored once dictionary defintions are returned.

### Footer:
The footer contains links to the Github repositories for both the backend and frontend, as well as a copyright statement with a link to Kelly Gemmill's LinkedIn profile.

## State Variables and Callbacks:
All state variables and callback functions are defined in the App component. 

### State Variables:
The state variables currently include the query and parsed result.

### Callbacks and Auxiliary Functions:

#### parseWord(): 
This is the callback function for the "Parse" button. The query string is send to the lookup API via a get request. Upon response, the parsed state variable is updated in accordance with the response from the API.

#### handleSearchQuery(event):
Handles input in the search field and saves it in the query state variable.
