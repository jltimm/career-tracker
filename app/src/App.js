import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import CareerList from './CareerList';
import CareerEdit from './CareerEdit';

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/careers' exact={true} component={CareerList}/>
          <Route path='/careers/:id' component={CareerEdit}/>
        </Switch>
      </Router>
    )
  }
}

export default App;