import React from 'react'
import SingleDictionary from 'components/search/SingleDictionary'

const Results = ({results}) => {
    
    const dictionaries = []
    const map = new Map()
    for (const result of results) {
        if (!map.has(result.dictionary.id)) {
            map.set(result.dictionary.id, true)
            dictionaries.push(result.dictionary)
        }
    }

    return (
        <div>
            {
                dictionaries
                    .map((value,idx) => 
                    <SingleDictionary key={idx} dictionary={value} results={results} />) 
            }
        </div>
    )
}

export default Results