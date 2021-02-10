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
            title: this.state.title,
            content: this.state.content
        };

        console.log(note);


        axios.put("http://localhost:8080/notes/" + noteId, note)
            .then(response => {
                if (response.data != null) {
                    // this.setState(this.initialState);
                    alert("Note saved");
                }
            });
    };

    fieldChange = event => {
        this.setState({
            [event.target.name] : event.target.value
        });
    };


    deleteNote() {
        const noteId = +this.props.match.params.id;
        // alert(noteId);
        axios.delete("http://localhost:8080/notes/" + noteId);
        // return this.props.history.push("/notes");
    }

    render() {
        const noteId = +this.props.match.params.id;
        return (
            <Card>
                <Card.Body>
                    <Form onSubmit={this.submitNote} id="noteFormID">
                        <Form.Group controlId="formNoteTitle">
                            <Form.Label>Title: </Form.Label>
                            <Form.Control required size="lg" type="text" placeholder="Title" name="title" defaultValue={this.state.note.title} onChange={this.fieldChange}/>
                            <br />
                        </Form.Group>
                        <Form.Group controlId="formNoteContent">
                            <Form.Label>Content: </Form.Label>
                            <Form.Control required as="textarea" rows="6" name="content" defaultValue={this.state.note.content} onChange={this.fieldChange}/>
                        </Form.Group>
                        <Button variant="info" type="submit">
                            Save
                        </Button>
                        <Button variant="danger" type="button" onClick={this.deleteNote.bind(this)}>
                            <Link to={"/notes"}>Delete</Link>
                        </Button>
                        <Button variant="info" type="button">
                            <Link to={"/notes/" + noteId + "/history"}>See History</Link>
                        </Button>
                    </Form>
                </Card.Body>
            </Card>
        )
    }
}
