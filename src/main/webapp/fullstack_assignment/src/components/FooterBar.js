import React, {Component} from "react";
import {Navbar} from "react-bootstrap";
import {Container, Col} from "react-bootstrap";

export default class FooterBar extends Component{



    render() {
        return (
            <Navbar fixed="bottom" bg="light" variant="light" >
                <Container className="text-center">
                        <Col>(c) 2021 Tomasz Smyk. All rights reserved.</Col>
                </Container>
            </Navbar>

        )
    }
}
