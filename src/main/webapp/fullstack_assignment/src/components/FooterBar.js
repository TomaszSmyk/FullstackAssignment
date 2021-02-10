import React from "react";
import {Navbar, Nav} from "react-bootstrap";


class FooterBar extends React.Component{
    render() {
        return (
            <Navbar fixed="bottom" bg="light" variant="light" >
                <p >Footer</p>
            </Navbar>

        )
    }
}

export default FooterBar;