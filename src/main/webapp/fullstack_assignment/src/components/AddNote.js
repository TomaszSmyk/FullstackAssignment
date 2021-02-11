import React, {Component} from "react";
import {Form, Button, Col} from "react-bootstrap";
import axios from "axios";

export default class AddNote extends Component{

    constructor(props) {
        super(props);
        this.state ={
            note :[]
        };
    }

    submitNote = event => {
        event.preventDefault();

        const note = {
            title:  event.target.title.value,
            content: event.target.content.value
        };

        axios.post("http://localhost:8080/newNote", note)
            .then(response => {
                if (response.data != null) {
                    alert("Note saved");
                }
            });
    };


    render() {
        return(
            <Form onSubmit={this.submitNote} id="noteFormID">
                <Form.Group controlId="formNoteTitle">
                    <Form.Label>Title: </Form.Label>
                    <Form.Control required size="lg" type="text" placeholder="Title" name="title" />
                    <br />
                </Form.Group>
                <Form.Group controlId="formNoteContent">
                    <Form.Label>Content: </Form.Label>
                    <Form.Control required as="textarea" rows="6" name="content" />
                </Form.Group>
                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
        )
    }

}
