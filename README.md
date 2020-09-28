# Dictionary-Backend
This is the backend for a Japanese dictionary app written in Java using Spring Boot. Currently, the Japanese parser program Kuromoji has been implemented in the service package. 

## How to use: 

### Interactive web app:
Look up a word or phrase at [http://jisho-kg.herokuapp.com](http://jisho-kg.herokuapp.com). Currently only the parser has been implemented.

### API:
Query the parser API directly with a get request to [http://jisho-api-kg.herokuapp.com/api/parser/{phrase}](http://sudoku-api-kg.herokuapp.com/api/parser/{phrase}). The get request will return a Word object consisting of the queried word, reading, part of speech, and base word (e.g. unconjugated verb).

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
This class contains the API to call the solver. Currently the API only has a get mapping to the ParserService located at /api/parser/{query}.
