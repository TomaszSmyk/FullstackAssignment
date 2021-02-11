import React, {Component} from "react";
import {Card, Table, Button} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';
import {Link} from "react-router-dom";
import BootstrapTable from 'react-bootstrap-table-next';
import 'react-bootstrap-table-next/dist/react-bootstrap-table2.min.css';

import NoteContent from "./NoteContent";
import axios from "axios";

export default class NotesList extends Component{

    constructor(props) {
        super(props);
        this.state = {
            // hoverIndex: null,
            notes : []
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8080/notes")
            .then(response => response.data)
            .then((data) => {
                    this.setState({notes : data})
                }
            )
    }

    deleteNote(noteId) {
        axios.delete("http://localhost:8080/notes/" + noteId)
            .then(response => {
                if (response.data !== null) {
                    alert("Note deleted");
                    this.setState({
                        notes : this.state.notes.filter(x => x.id !== noteId)
                    });
                }
            });
    }

    render() {
        const columns =[
            {
                dataField: 'id',
                hidden: true
            },
            {
                dataField: 'title',
                text: 'Title',
                sort: true
            },
            {
                dataField: 'created',
                text: 'Created',
                sort: true
            },
            {
                dataField: 'modified',
                text: 'Modified',
                sort: true
            },
            {
                dataField: 'content',
                text: 'Content',
                hidden: true
            }
        ];



        const expandRow = {
            renderer: row => (
                <div>
                    <NoteContent children={row.id}/>
                    <Link to={"/notes/" + row.id}>
                    <Button variant="info">EDIT</Button>
                    </Link> {     }
                    <Button variant={"danger"} onClick={this.deleteNote.bind(this, row.id)}>DELETE</Button> {     }
                    <Link to={"/notes/" + row.id + "/history"}>
                        <Button variant="info" type="button">
                            SHOW HISTORY
                        </Button>
                    </Link>
                </div>
            )
        };

        return(
            <Card>
                <Card.Body>
                    <BootstrapTable
                        keyField='id'
                        data={this.state.notes}
                        columns={columns}
                        bootstrap4={true}
                        noDataIndication="No notes found"
                        expandRow={expandRow}
                    />
                </Card.Body>
            </Card>
        )
    }

}
