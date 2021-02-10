import React, {Component} from "react";
import {Form, Button, Col} from "react-bootstrap";
import axios from "axios";

export default class AddNote extends Component{

    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.fieldChange = this.fieldChange.bind(this);
        this.submitNote = this.submitNote.bind(this);
    }

    initialState = {
        title : '',
        content : ''
    };

    submitNote = event => {
        event.preventDefault();

        const note = {
            title: this.state.title,
            content: this.state.content
        };

        axios.post("http://localhost:8080/newNote", note)
            .then(response => {
                if (response.data != null) {
                    this.setState(this.initialState);
                    alert("Note saved");
                }
            });
    };

    fieldChange = event => {
        this.setState({
            [event.target.name] : event.target.value
        });
    };

    render() {
        return(
            <Form onSubmit={this.submitNote} id="noteFormID">
                <Form.Group controlId="formNoteTitle">
                    <Form.Label>Title: </Form.Label>
                    <Form.Control required size="lg" type="text" placeholder="Title" name="title" value={this.state.title} onChange={this.fieldChange}/>
                    <br />
                </Form.Group>
                <Form.Group controlId="formNoteContent">
                    <Form.Label>Content: </Form.Label>
                    <Form.Control required as="textarea" rows="6" name="content" value={this.state.content} onChange={this.fieldChange}/>
                </Form.Group>
                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
        )
    }

}
