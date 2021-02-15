import React from 'react'

const SingleResult = ({value}) => {
    
    return (
        <div>
            <ul>
                <li>Surface Form: {value.word}</li>
                <li>Reading: {value.reading}</li>
                <li>Part of Speech: {value.partOfSpeech}</li>
                {/* <li>Base Form: {value.baseForm !== null ? value.baseForm.word : value.word}</li> */}
                <li>Base Form: {value.baseForm}</li>
            </ul>
        </div>
    )

}

export default SingleResult