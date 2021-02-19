import React from 'react'
import { Navbar, Nav } from 'react-bootstrap'
import LanguageSelector from './LanguageSelector'
import { Text } from '../containers/Language';

const NavigationBar = () => {

    return(
        <Navbar bg="dark" variant="dark" expand="lg">
            <Navbar.Brand href='https://kellygemmil..com'><Text textId='kellygemmill' /></Navbar.Brand>
            <Navbar.Toggle aria-controls='basic-navbar-nav' />
            <Navbar.Collapse id='basic-navbar-nav'>
                <Nav className="mr-auto">
                    <Nav.Link href='https://kellygemmill.com'><Text textId='home' /></Nav.Link>
                    <Nav.Link href='https://kellygemmill.com/projects'><Text textId='projects' /></Nav.Link>
                    <Nav.Link href='https://github.com/kellygemmill' target="_blank" rel="noopener noreferrer"><Text textId='github' /></Nav.Link>
                </Nav>
            </Navbar.Collapse>
            <Nav>
                <LanguageSelector />
            </Nav>

        </Navbar>
    )
}

export default NavigationBar