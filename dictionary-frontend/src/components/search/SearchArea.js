import React, { useState } from 'react'
import axios from 'axios'
import Results from 'components/search/Results'
import SearchBar from 'components/search/SearchBar'

const SearchArea = () => {
    const [query, setQuery] = useState('')
    const [dictionaryType, setDictionaryType] = useState('ALL')
    const [results,setResults] = useState([])

    const lookupWord = () => {
        const apiAddr = 'https://dictionary.kellygemmill.com'
        // const apiAddr = 'http://localhost:8080'
        
        const apiQuery = `${apiAddr}/api/entry/${query}`
        
        axios
            .get(apiQuery)
            .then(response => {
                setResults(response.data)
            })
    }

    const handleSearchQuery = (event) => {
        setQuery(event.target.value)
    }

    const handleKeyPress = (target) => {
        if (target.charCode === 13) {
            lookupWord();
        }
    }

    const handleDictionaryType = (event) => {
        setDictionaryType(event.target.id)
    }

        return (
            <div>
                <SearchBar 
                    handleDictionaryType={handleDictionaryType} 
                    handleSearchQuery={handleSearchQuery}
                    handleKeyPress={handleKeyPress}
                    lookupWord={lookupWord}
                    dictionaryType={dictionaryType}
                    query={query} />
                <Results results={results} dictionaryType={dictionaryType} />
            </div>
          )
    }

export default SearchArea