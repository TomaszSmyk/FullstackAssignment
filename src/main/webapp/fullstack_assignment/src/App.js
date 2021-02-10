import React from "react";
import './App.css';

import NavigationBar from "./components/NavigationBar";
import FooterBar from "./components/FooterBar";
import {Container, Row, Col, Jumbotron} from 'react-bootstrap';

function App() {
    const textCentered = {
        textAlign : "center"
    };

  return (
    <div className="App">
        <NavigationBar/>
        <Container fluid>
            <Jumbotron>
                <Row md={3} className="text-center">
                    <Col sm={4}>Title</Col>
                    <Col sm={4}>Created</Col>
                    <Col sm={4}>Modified</Col>
                </Row>
            </Jumbotron>
        </Container>
        <FooterBar/>
    </div>
  );
}

export default App;
