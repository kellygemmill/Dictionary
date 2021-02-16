import React from 'react'

const SingleResult = ({value}) => {
    
    return (
        <div>
            <ul>
                <li>Word: {value.word}</li>
                <li>Reading: {value.reading}</li>
                <li>Definition: {value.definition}</li>
                <li>Dictionary: {value.dictionary.name}</li>
            </ul>
        </div>
    )

}

export default SingleResult