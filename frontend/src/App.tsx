import React, { useState, useEffect } from "react";
import './App.css';
import { Nav, About, Contact, Projects } from './component/export';
import { connstoreApiService } from "./api";
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

const App: React.FC = () => {
  const [stores, setStores] = useState<any[]>([]);

  useEffect(() => {
    getStores();
  });

  const getStores = async () => {
    
    const response = await connstoreApiService.getConnectionStores();
    setStores(response.data);
  };


  return (
      <div className="app">
        <Router>
          <Nav/>
          <Switch>
            <Route path="/about" component={About}></Route>
            <Route path="/contact" component={Contact}></Route>
            <Route path="/projects" component={Projects}></Route>
          </Switch>
        </Router>
        
      </div>
    
  );
};


export default App;

/*
<div>
      <table>
        <thead>
          <tr>
            <th>Hostname</th>
            <th>port</th>
            <th>Add Command</th>
          </tr>
        </thead>
        <tbody>
        {stores.map(store => (
          <tr key={store.id}>
            <td>{store.hostname}</td>
            <td>{store.port}</td>
            <td><button type="button" className="btn btn-primary">Add Command</button></td>
            <td><button type="button" className="btn btn-primary" id={store.id} >Delete</button></td>
          </tr>
      ))}
        </tbody>
      </table>
    </div>
    */