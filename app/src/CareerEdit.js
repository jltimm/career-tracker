import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class CareerEdit extends Component {

  emptyItem = {
    positionName: '',
    status: '',
    companyName: ''
  };

  constructor(props) {
    super(props);
    this.state = {
      item: this.emptyItem
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  async componentDidMount() {
    if (this.props.match.params.id !== 'new') {
      const career = await (await fetch(`/api/careers/${this.props.match.params.id}`)).json();
      this.setState({item: career});
    }
  }

  handleChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;
    let item = {...this.state.item};
    item[name] = value;
    this.setState({item});
  }

  async handleSubmit(event) {
    event.preventDefault();
    const {item} = this.state;

    await fetch('/api/careers', {
      method: (item.id) ? 'PUT' : 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(item),
    });
    this.props.history.push('/careers');
  }

  render() {
    const {item} = this.state;
    const title = <h2>{item.id ? 'Edit Career' : 'Add Career'}</h2>;

    return <div>
      <AppNavbar/>
      <Container>
        {title}
        <Form onSubmit={this.handleSubmit}>
          <FormGroup>
            <Label for="positionName">Position Name</Label>
            <Input type="text" name="positionName" id="positionName" value={item.positionName || ''}
                   onChange={this.handleChange}/>
          </FormGroup>
          <FormGroup>
            <Label for="status">Status</Label>
            <Input type="text" name="status" id="status" value={item.status || ''}
                   onChange={this.handleChange} autoComplete="status"/>
          </FormGroup>
          <FormGroup>
            <Label for="companyName">Company Name</Label>
            <Input type="text" name="companyName" id="companyName" value={item.companyName || ''}
                   onChange={this.handleChange} autoComplete="companyName"/>
          </FormGroup>
          <FormGroup>
            <Button color="primary" type="submit">Save</Button>{' '}
            <Button color="secondary" tag={Link} to="/careers">Cancel</Button>
          </FormGroup>
        </Form>
      </Container>
    </div>
  }
}

export default withRouter(CareerEdit);