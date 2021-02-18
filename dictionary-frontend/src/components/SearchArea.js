import React, { useState } from 'react'
import axios from 'axios'
import Results from './Results'
import Button from 'react-bootstrap/Button'
import InputGroup from 'react-bootstrap/InputGroup'
import Dropdown from 'react-bootstrap/Dropdown'
import DropdownButton from 'react-bootstrap/DropdownButton'
import FormControl from 'react-bootstrap/FormControl'
import { Text } from '../containers/Language'

const SearchArea = () => {
    const [query, setQuery] = useState('')
    const [dictionaryType, setDictionaryType] = useState(Text({'textId': 'all'}))
    const [result,setResult] = useState([])

    const lookupWord = () => {
        const apiAddr = 'http://localhost:8080'
        axios
            .get(`${apiAddr}/api/entry/${query}?type=${dictionaryType}`)
            .then(response => {
                setResult(response.data)
                console.log(result)
            })
    }

    const handleSearchQuery = (event) => {
        setQuery(event.target.value)
    }

    const handleDictionaryType = (event) => {
        setDictionaryType(event.target.id)
    }

    const buttonStyle = {
        marginRight: '2px',
        marginLeft: '2px',
        marginTop: '2px',
        marginBottom: '2px',
        width: '23%',
        border: '0px'
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

                <Results result={result} />
            </div>
          )
    }

export default SearchArea