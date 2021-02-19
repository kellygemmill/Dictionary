import React, { useState } from 'react'
import axios from 'axios'
import { Button, InputGroup, Dropdown, DropdownButton, FormControl } from 'react-bootstrap'
import Results from 'components/Results'
import { Text } from 'containers/Language'



const SearchArea = () => {
    const [query, setQuery] = useState('')
    const [dictionaryType, setDictionaryType] = useState('all')
    const [results,setResults] = useState([])

    const lookupWord = () => {
        // const apiAddr = 'https://jisho.kellygemmill.com'
        const apiAddr = 'http://localhost:8080'
        axios
            .get(`${apiAddr}/api/entry/${query}?type=${dictionaryType}`)
            .then(response => {
                setResults(response.data)
            })
    }

    const handleSearchQuery = (event) => {
        setQuery(event.target.value)
    }

    const handleDictionaryType = (event) => {
        setDictionaryType(event.target.id)
    }

        return (
            <div>
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

                <Results results={results} />
            </div>
          )
    }

export default SearchArea