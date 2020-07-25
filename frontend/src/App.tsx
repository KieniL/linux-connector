import React, { useState, useEffect } from "react";
import './App.css';
import { connstoreApiService } from "./api";

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
  );
};

export default App;
