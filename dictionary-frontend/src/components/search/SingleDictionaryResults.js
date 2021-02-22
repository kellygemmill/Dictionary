import React from 'react'
import SingleResult from 'components/search/SingleResult'

const SingleDictionaryResults = ({dictionary, results}) => {

    return(
        <div>
            {
                results
                    .filter((result) => result.dictionary.id === dictionary.id)
                    .map((value,idx) => 
                    <SingleResult key={idx} value={value} />)
            }
        </div>
    )

}

export default SingleDictionaryResults