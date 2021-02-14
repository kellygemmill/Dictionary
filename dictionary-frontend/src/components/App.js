import React, { useState } from 'react'
import axios from 'axios'
import Footer from './Footer'
import MyButton from './MyButton'
import Results from './Results'
import SearchBar from './SearchBar'

function App() {
  const [query, setQuery] = useState('')
  const [parsed,setParsed] = useState([])

  const parseWord = () => {
    axios
        .get(`http://jisho-api-kg.herokuapp.com/api/parse/${query}`)
        .then(response => {
          setParsed(response.data)
        })
  }

  const handleSearchQuery = (event) => {
    setQuery(event.target.value)
  }
  
  return (
    <div>
      <SearchBar handleInput={handleSearchQuery} query={query}  />
      <MyButton id="parse" text="Parse" handleClick={parseWord} type="primary" />
      <Results parsed={parsed} />
      <Footer />
    </div>
  );
}

export default App;
