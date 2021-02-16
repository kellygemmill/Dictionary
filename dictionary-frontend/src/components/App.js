import React, { useState } from 'react'
import axios from 'axios'
import Footer from './Footer'
import MyButton from './MyButton'
import Results from './Results'
import SearchBar from './SearchBar'

function App() {
  const [query, setQuery] = useState('')
  const [result,setResult] = useState([])

  const lookupWord = () => {
    axios
        .get(`http://localhost:8080/api/define/${query}`)
        .then(response => {
          setResult(response.data)
          console.log(result)
        })
  }

  const handleSearchQuery = (event) => {
    setQuery(event.target.value)
  }
  
  return (
    <div>
      <SearchBar handleInput={handleSearchQuery} query={query}  />
      <MyButton id="lookup" text="Search" handleClick={lookupWord} type="primary" />
      <Results result={result} />
      <Footer />
    </div>
  );
}

export default App;
