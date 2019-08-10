import React, { Component } from 'react';
import './App.css';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';
import CareerList from './CareerList';

class Home extends Component {
  render() {
    return (
      <div>
        <CareerList />
        <Container fluid>
          <Button color="link"><Link to="/careers">View all applications</Link></Button>
        </Container>
      </div>
    );
  }
}

export default Home;