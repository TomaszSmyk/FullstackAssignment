import React, {Component} from "react";
import axios from "axios";

export default class Note extends Component{

    constructor(props) {
        super(props);
        this.state = {
            note : []
        }
    }

    componentDidMount() {
        axios.get("http://localhost:8080/notes/" + this.props.children)
            .then(response => response.data)
            .then((data) => {
                    this.setState({note : data})
                }
            );
    }

    render() {
        return (
            <div>{this.state.note.content}</div>
        )
    }
}
