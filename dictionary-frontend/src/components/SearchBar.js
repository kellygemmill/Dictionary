import React from 'react'

const SearchBar = ({handleInput,query}) => {

    return (
        <div>
            <h3>Japanese word to define: </h3>
            <input onChange={handleInput} value={query} />
            <p>Note: Currently defined test words: 食べる、行く、犬、本</p>
        </div>
    )

}

export default SearchBar