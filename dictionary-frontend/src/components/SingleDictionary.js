import React from 'react'
import SingleResult from 'components/SingleResult'
import { Card } from 'react-bootstrap'

const SingleDictionary = ({dictionary, results}) => {

    return (
        <div>
            <Card className='single-dictionary' bg='dark' text='white'>
                <Card.Header as = 'h5'>{dictionary.name}</Card.Header>
            </Card>
                    {
                    results
                        .filter((result) => result.dictionary.id === dictionary.id)
                        .map((value,idx) => 
                        <SingleResult key={idx} value={value} />)
                    }
        </div>
    )
}

export default SingleDictionary