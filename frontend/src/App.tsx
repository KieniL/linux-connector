import React, { useState, useEffect } from "react";
import logo from './logo.svg';
import './App.css';
import { connstoreApiService } from "./api";

const App: React.FC = () => {
  const [pets, setPets] = useState<any>({});

  useEffect(() => {
    getPets();
  }, []);

  const getPets = async () => {
    const response = await connstoreApiService.getConnectionStores();
    setPets(response);
  };

  return (
    <div>
      <ul>
        <li>Name: {process.env.REACT_APP_APISERVER}</li>
        <li>Status: {pets.status}</li>
      </ul>
    </div>
  );
};


/*
function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}*/

export default App;
