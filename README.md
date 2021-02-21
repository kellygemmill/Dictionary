# Dictionary

# Dictionary-Frontend
This is the front end of a Japanese dictionary web app written in Javascript using React. The page was styled using React Boostrap. This web app is available online at [https://dictionary.kellygemmill.com](https://dictionary.kellygemmill.com.com). 

Additionally, the API can be queried directly at [https://dictionary.kellygemmill.com/api](https://dictionary.kellygemmill.com/api). See below for details on the API and backend Java code. 

## React Components:

### SearchArea: 
This component contains the search bar and results area. It also makes the API calls to the backend.

### SearchBar:
The search bar containing the query to look up in the dictionary. This search bar also contains a dropdown to select which kind of dictionary should be searched: Japanese-Japanese, Japanese-English, English-Japanese, or all. 

### Results:
Generates a SingleDictionary component for each dictionary that results were found in.

### SingleDictionary: 
Contains all results from a single dictionary. 

### SingleResult:
A single result from the dictionary, including the word, reading, and definition. 

### Footer:
The footer contains links to the Github repositories for both the backend and frontend, as well as a copyright statement.

## State Variables and Callbacks:
All state variables and callback functions are defined in the App component. 

### State Variables:
The state variables include the query, dictionary type, and results, which are all defined in SearchArea.js. 

### Callbacks and Auxiliary Functions:

#### lookupWord(): 
This is the callback function for the "Search" button. The query string is sent to the lookup API via a get request. Upon response, the result state variable is updated in accordance with the response from the API.

#### handleSearchQuery(event):
Handles input in the search field and saves it in the query state variable.

#### handleDictionaryType(event):
Handles input from the dictionary type dropdown and saves it in the dictionaryType state variable.

# Dictionary-Backend
This is the backend for a Japanese dictionary app written in Java using Spring Boot. The dictionaries are contained in a POSTGRES database accessed by Spring Data JPA.

## How to use: 

### Interactive web app:
Look up a word or phrase at [https://dictionary.kellygemmill.com](https://dictionary.kellygemmill.com).

### API:
Query the API directly with a get request to [https://dictionary.kellygemmill.com/api](https://dictionary.kellygemmill.com/api). See below for the different API paths available.

## Model: 
The following models are used in the Dictionary backend.

### Word:
A Word object is created by the parser for each word in the input string. A word object contains the actual word, reading, part of speech, and base word. The base word is, for example, the unconjugaed form of a verb that is looked up, enabling the verb to be looked up in the dictionary.

### Entry:
The Entry object defines the SQL table for a single dictionary entry, consisting of the word, reading, definition, and containing dictionary. Note that the containing dictionary is a foreign key to the Dictionary table.

### Dictionary:
The Dictionary object defines the SQL table for a single dictionary, consisting of the name and type (Japanese to Japanese, Japanese to English, etc). Note that the dictionary type was implemented as an enum, and an attribute converter was implemented to convert between enum and String for saving in the SQL table.

## Data Access Object:
Interfaces in the dao package define queries to the POSTGRES database. 

### DictionaryRepository: 
This interface defines queries to the dictionary table in the database. This repository does not define any methods as the Dictionary service only uses the default methods provided by JPA.

### EntryRepository: 
This interface defines queries to the entry table in the database. This repository defines custom methods to find entries by word, reading, dictionary type, an dictionary name.

## Service: 
This package contains the word parser as well as the dictionary lookup service.

### ParserService: 
The ParserService interface defines the required output from the word parser. This interface was defined so that the actual word parser can be changed out if need be. Currently, Kuromoji is used, but another program such as Mecab could be implemented by adding another parser class that implements this interface. 

### KuromojiParser:
This class implements the ParserService interface and queries the Kuromoji tokenizer to parse any input phrase into individual words. This is also annotated with the @Service("kuromoji") annotation so that Spring Boot will pull in this particular ParserService.

### LookupService:
This class performs lookups in the dictionary. The LookupService has an instance of ParserService as a property in order to parse lookups before querying the dictionary database. The KuromojiParser is injected into this class via the @Qualifier("kuromoji") annotation.

### DictionaryService:
This class interacts with the dictionary repository for performing CRUD operations with the dictionaries themselves.

## API: 

### DictionaryController:
This class contains the API to call the DictionaryService. 

### EntryController:
This class contains the API to call the EntryService and handles lookups in the dictionary.
