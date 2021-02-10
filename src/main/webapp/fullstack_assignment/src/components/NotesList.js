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
        axios.get("http://localhost:8080/notes")
            .then(response => response.data)
            .then((data) => {
                    this.setState({notes : data})
                }
            )
    }

    render() {
        return(
            <Card>
                <Card.Body>
                    <Table responsive="sm" bordered hover striped>
                        <thead className="text-center">
                            <tr>
                                <th>Title</th>
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
                                    <tr key={note.id}>
                                        <td><Link to={"/notes/" + note.id} className="nav-link">{note.title}</Link></td>
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
