# Dictionary

# Dictionary-Frontend
This is the front end of a Japanese dictionary web app written in Javascript using React. The page was styled using React Boostrap. This web app is available online at [https://jisho.kellygemmill.com](https://jisho.kellygemmill.com.com). 

Additionally, the API can be queried directly at [https://jisho.kellygemmill.com/api](https://jisho.kellygemmill.com/api). See below for details on the API and backend Java code. 

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

# Dictionary-Backend
This is the backend for a Japanese dictionary app written in Java using Spring Boot. Currently, the Japanese parser program Kuromoji has been implemented in the service package. 

## How to use: 

### Interactive web app:
Look up a word or phrase at [https://jisho.kellygemmill.com](https://jisho.kellygemmill.com). Currently only the parser has been implemented.

### API:
Query the parser API directly with a get request to [https://jisho.kellygemmill.com/api/parse/{query}](https://sudoku.kellygemmill.com/api/parse/{query}). The get request will return a Word object consisting of the queried word, reading, part of speech, and base word (e.g. unconjugated verb).

## Model: 
The following models are used in the Dictionary backend.

### Word:
A Word object is created by the parser for each word in the input string. A word object contains the actual word, reading, part of speech, and base word. The base word is, for example, the unconjugaed form of a verb that is looked up, enabling the verb to be looked up in the dictionary.

### Definition:
To be implemented.

### Dictionary:
To be implemented.

## Data Access Object:
To be implemented. Dictionaries will be stored in a PostgreSQL database.

## Service: 
This package contains the word parser as well as the dictionary lookup service.

### ParserService: 
The ParserService interface defines the required output from the word parser. This interface was defined so that the actual word parser can be changed out if need be. Currently, Kuromoji is used, but another program such as Mecab could be implemented by adding another parser class that implements this interface. 

### KuromojiParser:
This class implements the ParserService interface and queries the Kuromoji tokenizer to parse any input phrase into individual words. This is also annotated with the @Service("kuromoji") annotation so that Spring Boot will pull in this particular ParserService.

### LookupService:
This class will be used to perform lookups in the dictionary. Currently, the LookupService has an instance of ParserService as a property in order to parse lookups before querying the dictionary database. The KuromojiParser is injected into this class via the @Qualifier("kuromoji") annotation.

## API: 

### DictionaryController:
This class contains the API to call the LookupService. Currently the API only has a get mapping to parse an input, located at /api/parse/{query}.
