import React, {Component} from "react";
import {Navbar, Nav} from "react-bootstrap";
import {Container, Row, Col} from "react-bootstrap";
import axios from "axios";

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
