import React from 'react'
import { Text } from '../containers/Language'

const SearchBar = ({handleInput,query}) => {
    const placeholder = Text({"textId": "searchDescription"})
    // const style = {
    //     height: 'auto',
    //     margin: '20px 10px auto'
    // }
    
    return (
        // <input onChange={handleInput} value={query} placeholder={placeholder} style={style} />
        <input onChange={handleInput} value={query} placeholder={placeholder} className='search-bar' />
    )

}

export default SearchBar