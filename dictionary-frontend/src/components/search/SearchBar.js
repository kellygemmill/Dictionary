import React from 'react'
import { Button, InputGroup, Dropdown, DropdownButton, FormControl } from 'react-bootstrap'
import { Text } from 'containers/Language'

const SearchBar = ({ handleDictionaryType, handleSearchQuery, lookupWord, dictionaryType, query }) => {

    return(
        <InputGroup className='search-bar' size='md'>
                        
            <DropdownButton as={InputGroup.Prepend} variant='secondary' id='type-dropdown' title={Text({'textId': dictionaryType})}>
                <Dropdown.Item id='all' onClick={handleDictionaryType}><Text textId="allDescription" /></Dropdown.Item>
                <Dropdown.Item id='jj' onClick={handleDictionaryType}><Text textId="jjDescription" /></Dropdown.Item>
                <Dropdown.Item id='je' onClick={handleDictionaryType}><Text textId="jeDescription" /></Dropdown.Item>
                <Dropdown.Item id='ej' onClick={handleDictionaryType}><Text textId="ejDescription" /></Dropdown.Item>
            </DropdownButton>
            
            <FormControl 
                placeholder={Text({"textId": "searchDescription"})} 
                onChange={handleSearchQuery}
                value={query}/>
            <InputGroup.Append>
                <Button variant='primary' id='search-button'　onClick={lookupWord}>
                    <Text textId='searchButton' />
                </Button>
            </InputGroup.Append> 

        </InputGroup>
    )
}

export default SearchBar