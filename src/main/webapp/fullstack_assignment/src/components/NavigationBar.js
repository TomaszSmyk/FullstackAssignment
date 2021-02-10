import React, {Component} from "react";
import {Navbar, Nav} from "react-bootstrap";
import {Link} from "react-router-dom";

export default class NavigationBar extends Component{
    render() {
        return (
            <Navbar bg="light" variant="light">
                <Link to={"/notes"} className="navbar-brand" >
                    Notes
                </Link>

                <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="mr-auto">
                        <Link to={"/newNote"} className="nav-link">Create new note</Link>
                        <Link to={"/notes"} className="nav-link">See all notes</Link>
                        {/*<Nav.Link href="/newNote">Create new note</Nav.Link>*/}
                        {/*<Nav.Link href="/notes">See all notes</Nav.Link>*/}
                    </Nav>
                </Navbar.Collapse>
            </Navbar>

        )
    }
}
