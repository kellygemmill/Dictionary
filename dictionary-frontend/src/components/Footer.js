import React from 'react'
import Button from 'react-bootstrap/Button'
import { Text } from 'containers/Language'

const style = {
    position: 'static',
    marginTop: '30px',
    textAlign: 'center'
}

const buttonStyle = {
    margin: "5px 5px 10px",
    width: "150px"
}

const Footer = () => {
    return (
        <div style={style}>
            <Button style={buttonStyle} variant="outline-dark" href="https://github.com/kellygemmill/Dictionary.git"
                target="_blank" rel="noopener noreferrer"><Text textId="viewOnGitHub" /></Button>
            <p style={{ marginTop: "5px" }}>&copy; {new Date().getFullYear()} {' '}
                <a href="https://www.kellygemmill.com" target="_blank" rel="noopener noreferrer">Kelly Gemmill</a></p>
        </div>
    )
}

export default Footer