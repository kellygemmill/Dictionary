import React from 'react'

const SingleResult = ({value}) => {
    return (
        <div>
            <ul>
                <li>Surface Form: {value.surfaceForm}</li>
                <li>Reading: {value.reading}</li>
                <li>Part of Speech: {value.partOfSpeech}</li>
                <li>Base Form: {value.baseForm}</li>
            </ul>
        </div>
    )

}

export default SingleResult