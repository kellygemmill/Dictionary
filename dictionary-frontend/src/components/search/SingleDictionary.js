import React from 'react'
import SingleDictionaryResults from 'components/search/SingleDictionaryResults'
import { Card, Accordion } from 'react-bootstrap'

const SingleDictionary = ({dictionary, results}) => {

    return (
        <Accordion className="directions" defaultActiveKey="0">
            <Card bg='dark' text='white'>
                <Accordion.Toggle as={Card.Header} className = "directions-title" eventKey="0">
                <h5 className="demo-mode-title">{dictionary.name}</h5><h5 className="demo-min-symbol">—</h5>
                </Accordion.Toggle>
            </Card>
            <Card className="single-dictionary">
                <Accordion.Collapse eventKey="0">
                    <SingleDictionaryResults dictionary={dictionary} results={results} />
                </Accordion.Collapse>
            </Card>
        </Accordion>
    )
}

export default SingleDictionary