import React from 'react'
import SingleResult from './SingleResult'

const Results = ({result}) => {
    // console.log(parsed)
    // parsed.map((value,idx) => console.log(value))
    return (
        <div>
            {
                result
                    .map((value,idx) => 
                    <SingleResult key={idx} value={value} />) 
            }
        </div>
    )
    
}

export default Results