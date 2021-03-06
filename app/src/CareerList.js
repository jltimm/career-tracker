import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link, withRouter } from 'react-router-dom';

class CareerList extends Component {

  constructor(props) {
    super(props);
    this.state = {careers: []};
    this.remove = this.remove.bind(this);
  }

  componentDidMount() {
    const apiEndpoint = this.props.location.pathname === '/' ? '/api/careers/inProgress' : '/api/careers';
    fetch(apiEndpoint)
      .then(response => response.json())
      .then(data => this.setState({careers: data}));
  }

  async remove(id) {
    await fetch(`/api/career/${id}`, {
      method: 'DELETE',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    }).then(() => {
      let updatedCareers = [...this.state.careers].filter(i => i.id !== id);
      this.setState({careers: updatedCareers});
    });
  }

  render() {
    const {careers} = this.state;
    const careerList = careers.map(career => {
      return <tr key={career.id}>
        <td style={{whiteSpace: 'nowrap'}}>{career.positionName}</td>
        <td>{career.status}</td>
        <td>{career.companyName}</td>
        <td>
          <ButtonGroup>
            <Button size="sm" color="primary" tag={Link} to={"/careers/" + career.id}>Edit</Button>
            <Button size="sm" color="danger" onClick={() => this.remove(career.id)}>Delete</Button>
          </ButtonGroup>
        </td>
      </tr>
    });

    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <div className="float-right">
            <Button color="success" tag={Link} to="/careers/new">Add Career Application</Button>
          </div>
          <h3>Careers</h3>
          <Table className="mt-4">
            <thead>
              <tr>
                <th width="20%">Position Name</th>
                <th width="20%">Status</th>
                <th>Company Name</th>
                <th width="10%">Actions</th>
              </tr>
            </thead>
            <tbody>
            {careerList}
            </tbody>
          </Table>
        </Container>
      </div>
    );
  }
}

export default withRouter(CareerList);