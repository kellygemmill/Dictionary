import React from 'react'
import { Button, InputGroup, Dropdown, DropdownButton, FormControl } from 'react-bootstrap'
import { Text } from 'containers/Language'

const SearchBar = ({ handleDictionaryType, handleSearchQuery, handleKeyPress, lookupWord, dictionaryType, query }) => {

    return(
        <InputGroup className='search-bar' size='md'>
                        
            <DropdownButton as={InputGroup.Prepend} variant='secondary' id='type-dropdown' title={Text({'textId': dictionaryType})}>
                <Dropdown.Item id='ALL' onClick={handleDictionaryType}><Text textId="allDescription" /></Dropdown.Item>
                <Dropdown.Item id='JtoJ' onClick={handleDictionaryType}><Text textId="jjDescription" /></Dropdown.Item>
                <Dropdown.Item id='JtoE' onClick={handleDictionaryType}><Text textId="jeDescription" /></Dropdown.Item>
            </DropdownButton>
            
            <FormControl 
                placeholder={Text({"textId": "searchDescription"})} 
                onChange={handleSearchQuery}
                value={query}
                onKeyPress={handleKeyPress}
                />
            <InputGroup.Append>
                <Button variant='primary' id='search-button'　onClick={lookupWord}>
                    <Text textId='searchButton' />
                </Button>
            </InputGroup.Append> 

        </InputGroup>
    )
}

export default SearchBar