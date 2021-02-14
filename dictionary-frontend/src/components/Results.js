import React from 'react'
import SingleResult from './SingleResult'

const Results = ({parsed}) => {
    // console.log(parsed)
    // parsed.map((value,idx) => console.log(value))
    return (
        <div>
            {
                parsed
                    .map((value,idx) => 
                    <SingleResult key={idx} value={value} />) 
            }
        </div>
    )
    
}

export default Results