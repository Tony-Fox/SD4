import * as React from 'react';
import { Outlet, Link } from 'react-router-dom';
import useToken from "./routes/useToken";
import Login from "./routes/login";

export default function App() {
    const {token, setToken} = useToken();
    if (!token){
        return <Login setToken={setToken}/>
    }


    const handleClick = (event) => {
        event.preventDefault();
        sessionStorage.removeItem("token");
        // sessionStorage.removeItem("email");
        window.location.reload();
    }
    return (
    <div>
      <h1>Device Manager</h1>
        <div>
        <button onClick={handleClick}>
            Logout
        </button>
        </div>
      <nav style={{ borderBottom: 'solid 1px', paddingBottom: '1rem' }}>
        <Link to="/devices">Devices</Link> |{' '}
          <div style={{ display: (token === 'administrator' ? 'block' : 'none') }}><Link to="/device/add">Add Device</Link></div>
      </nav>

      <Outlet />
    </div>
  );
}
