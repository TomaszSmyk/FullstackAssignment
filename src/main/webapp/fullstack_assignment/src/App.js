import React from "react";
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'react-bootstrap-table-next/dist/react-bootstrap-table2.min.css';


import NavigationBar from "./components/NavigationBar";
import FooterBar from "./components/FooterBar";
import NotesList from "./components/NotesList";
import AddNote from "./components/AddNote";
import {Jumbotron} from 'react-bootstrap';
import {BrowserRouter as Router, Switch, Route}  from 'react-router-dom';
import Note from "./components/Note";
import NoteHistory from "./components/NoteHistory";

function App() {
    const textCentered = {
        textAlign : "center"
    };

  return (
    <Router>
        <NavigationBar/>
        {/*<Container fluid>*/}
            <Jumbotron>
                <Switch>
                    <Route path="/notes" exact component={NotesList}/>
                    <Route path="/newNote" exact component={AddNote}/>
                    <Route path="/notes/:id" exact component={Note}/>
                    <Route path="/notes/:id/history" exact component={NoteHistory}/>
                </Switch>
            </Jumbotron>
        {/*</Container>*/}
        <FooterBar/>
    </Router>
  );
}

export default App;
