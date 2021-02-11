import React, {Component} from "react";
import {Card} from "react-bootstrap";

import BootstrapTable from 'react-bootstrap-table-next';
import 'react-bootstrap-table-next/dist/react-bootstrap-table2.min.css';

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
                sort: true
            }
        ];

        return(
            <Card>
                <Card.Body>
                    <BootstrapTable
                        keyField='modified'
                        data={this.state.notes}
                        columns={columns}
                        bootstrap4={true}
                        noDataIndication="No notes found"
                    />
                </Card.Body>
            </Card>
        )
    }

}
