import React from 'react'
import SingleDictionary from 'components/search/SingleDictionary'

const Results = ({results, dictionaryType}) => {
    
    const dictionaries = []
    const map = new Map()
    for (const result of results) {
        if (!map.has(result.dictionary.id) && (dictionaryType === 'ALL' || result.dictionary.type === dictionaryType)) {
            map.set(result.dictionary.id, true)
            dictionaries.push(result.dictionary)
        }    
    }

    dictionaries.sort((dict1,dict2) => {
        return dict1.name.toLowerCase() < dict2.name.toLowerCase() ? -1 : 1
    })

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