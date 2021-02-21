import React from 'react'
import { Card } from 'react-bootstrap'

const SingleResult = ({value}) => {
    
    return (
        <Card className='single-result'>
            <Card.Header as='h5'>【{value.word}】 {value.reading}</Card.Header>
            <Card.Body>{
                value.definition.split("\n")
                    .map( (line,idx) => 
                        <Card.Text key={idx}>{line}</Card.Text>
                    )
            }</Card.Body>
        </Card>
    )
}

export default SingleResult