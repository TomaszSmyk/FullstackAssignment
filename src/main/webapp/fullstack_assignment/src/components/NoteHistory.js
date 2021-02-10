import React, {Component} from "react";
import {Card, Table} from "react-bootstrap";
import {Link} from "react-router-dom";

import axios from "axios";

export default class NotesList extends Component{

    constructor(props) {
        super(props);
        this.state = {
            notes : []
        }
    }

    componentDidMount() {
        const noteId = +this.props.match.params.id;
        axios.get("http://localhost:8080/notes/" + noteId + "/history")
            .then(response => response.data)
            .then((data) => {
                    this.setState({notes : data})
                }
            )
    }

    render() {
        const noteId = +this.props.match.params.id;
        return(
            <Card>
                <Card.Body>
                    <Table responsive="sm" bordered hover striped>
                        <thead className="text-center">
                        <tr>
                            <th>Title</th>
                            <th>Content</th>
                            <th>Created</th>
                            <th>Modified</th>
                        </tr>
                        </thead>
                        <tbody className="text-center">
                        {

                            this.state.notes.length === 0 ?
                                <tr>
                                    <td>0</td>
                                    <td>notes</td>
                                    <td>created</td>
                                </tr> :

                                this.state.notes.map((note) => (
                                    <tr>
                                        <td> {note.title}</td>
                                        <td> {note.content}</td>
                                        <td> {note.created}</td>
                                        <td> {note.modified}</td>
                                    </tr>
                                ))

                        }
                        </tbody>
                    </Table>
                </Card.Body>
            </Card>
        )
    }

}
