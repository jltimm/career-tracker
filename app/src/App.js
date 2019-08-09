import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  state = {
    isLoading: true,
    careers: []
  };

  async componentDidMount() {
    const response = await fetch('/careers');
    const body = await response.json();
    this.setState({ careers: body, isLoading: false });
  }

  render() {
    const{ careers, isLoading } = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <div className="App-intro">
            <h2>Career List</h2>
            {careers.map(career =>
              <div key={career.id}>
                {career.positionName}, {career.status}, {career.companyName}
              </div>
            )}
          </div>
        </header>
      </div>
    );
  }
}

export default App;
