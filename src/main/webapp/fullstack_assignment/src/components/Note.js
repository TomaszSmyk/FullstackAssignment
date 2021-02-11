import React, {Component} from "react";
import {Button, Card, Form, Table} from "react-bootstrap";
import {Link} from "react-router-dom";
import axios from "axios";

export default class Note extends Component{

    constructor(props) {
        super(props);
        this.state = {
            note : []
        }
    }

    componentDidMount() {
        const noteId = +this.props.match.params.id;
        axios.get("http://localhost:8080/notes/" + noteId)
            .then(response => response.data)
            .then((data) => {
                    this.setState({note : data})
                }
            );
        this.state.note.id = noteId;

    }

    submitNote = event => {
        const noteId = +this.props.match.params.id;
        event.preventDefault();

        const note = {
            id: noteId,
            title: event.target.title.value,
            content: event.target.content.value,
            created: this.state.note.created
        };

        axios.put("http://localhost:8080/notes/" + noteId, note)
            .then(response => {
                if (response.data != null) {
                    // this.setState(this.initialState);
                    alert("Note saved");
                }
            });
    };

    deleteNote() {
        const noteId = +this.props.match.params.id;
        alert("Note deleted");
        axios.delete("http://localhost:8080/notes/" + noteId);
    }

    render() {
        const noteId = +this.props.match.params.id;
        return (
            <Card>
                <Card.Body>
                    <Form onSubmit={this.submitNote} id="noteFormID">
                        <Form.Group controlId="formNoteTitle">
                            <Form.Label>Title: </Form.Label>
                            <Form.Control required size="lg" type="text" placeholder="Title" name="title" defaultValue={this.state.note.title}/>
                            <br />
                        </Form.Group>
                        <Form.Group controlId="formNoteContent">
                            <Form.Label>Content: </Form.Label>
                            <Form.Control required as="textarea" rows="6" name="content" defaultValue={this.state.note.content}/>
                        </Form.Group>
                        <Button variant="info" type="submit">
                            Save
                        </Button>
                    </Form>
                </Card.Body>
            </Card>
        )
    }
}
