import React from "react";
import {Navbar, Nav} from "react-bootstrap";


class NavigationBar extends React.Component{
    render() {
        return (
            <Navbar bg="light" variant="light">
                <Navbar.Brand href="/notes">Notes</Navbar.Brand>
                <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="mr-auto">
                        <Nav.Link href="/newNote">Create new note</Nav.Link>
                        <Nav.Link href="/notes">See all notes</Nav.Link>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>

        )
    }
}

export default NavigationBar;