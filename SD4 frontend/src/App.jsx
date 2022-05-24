import * as React from 'react';
import { Outlet, Link } from 'react-router-dom';
import useToken from "./routes/useToken";
import Login from "./routes/login";

export default function App() {
    const {token, setToken} = useToken();
    if (!token){
        return <Login setToken={setToken}/>
    }

    return (
    <div>
      <h1>Restaurant Manager</h1>
      <nav style={{ borderBottom: 'solid 1px', paddingBottom: '1rem' }}>
        <Link to="/restaurants">Restaurants</Link> |{' '}
          <div style={{ display: (token === 'administrator' ? 'block' : 'none') }}><Link to="/restaurant/add">Add Restaurant</Link></div>
      </nav>
      <Outlet />
    </div>
  );
}
