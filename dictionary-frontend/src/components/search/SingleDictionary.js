import React from 'react'
import SingleDictionaryResults from 'components/search/SingleDictionaryResults'
import { Card, Accordion } from 'react-bootstrap'

const SingleDictionary = ({dictionary, results}) => {

    return (
        <Accordion className="directions" defaultActiveKey="0">
            <Card bg='dark' text='white'>
                <Accordion.Toggle as={Card.Header} className = "directions-title" eventKey="0">
                    <h5>{dictionary.name}</h5>
                </Accordion.Toggle>
                </Card>
                <Accordion.Collapse eventKey="0">
                <Card className="single-dictionary">
                    <SingleDictionaryResults dictionary={dictionary} results={results} />
                </Card>
                </Accordion.Collapse>
            
        </Accordion>
    )
}

export default SingleDictionary