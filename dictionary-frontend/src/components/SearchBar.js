import React from 'react'

const SearchBar = ({handleInput,query}) => {

    return (
        <div>
            Japanese phrase to parse: <br></br>
            <input onChange={handleInput} value={query} />
        </div>
    )

}

export default SearchBar