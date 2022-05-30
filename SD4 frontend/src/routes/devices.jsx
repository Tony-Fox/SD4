import * as React from 'react';

import {
  useLocation,
  NavLink,
  Outlet,
  useSearchParams,
} from 'react-router-dom';
import { getInvoices } from '../data';
import {useEffect, useState} from "react";
import useToken from "./useToken";

function QueryNavLink({ to, ...props }) {
  let location = useLocation();
  return <NavLink to={to + location.search} {...props} />;
}



export default function Devices() {
 // let invoices = getInvoices();

 let [searchParams, setSearchParams] = useSearchParams({ replace: true });


    const {token, setToken} = useToken();
    const [Devices, setDevices] = useState(null);

    useEffect(()=>{
        fetch('http://localhost:8080/test/devices')
            .then(response => response.json())
            .then(data => setDevices(data));
    }, []);

  return (
    <div style={{ display: 'flex' }}>
      <nav style={{ borderRight: 'solid 1px', padding: '1rem' }}>
        <input
          value={searchParams.get('filter') || ''}
          onChange={(event) => {
            let filter = event.target.value;
            if (filter) {
              setSearchParams({ filter }, { replace: true });
            } else {
              setSearchParams({}, { replace: true });
            }
          }}
        />
        {
            Devices ?
            Devices
          .filter((device) => {
            let filter = searchParams.get('filter');
            if (!filter) return true;
            let name = device.name.toLowerCase();
            return name.startsWith(filter.toLowerCase());
          })
          .map((sensor) => (
              <div style={{ display: ((token === 'administrator')||(sensor.name === token) ? 'block' : 'none') }}>
            <QueryNavLink
              key={sensor.deviceId}
              style={({ isActive }) => {
                return {
                  display: 'block',
                  margin: '1rem 0',
                  color: isActive ? 'red' : '',
                };
              }}
              to={`/devices/${sensor.deviceId}`}
            >
              {sensor.name}
                <div></div>
                {sensor.location}
                <div></div>
                {/*{sensor.deliveryZones}*/}
            </QueryNavLink>
                  <div ><QueryNavLink
                      // style={{ display: (token === 'administrator' ? 'block' : 'none') }}
                    // key={sensor.deviceId}
                    style={({ isActive }) => {
                        return {
                            display: 'block',
                            margin: '1rem 0',
                            color: isActive ? 'red' : '',
                        };
                    }}
                    to={`/devices/${sensor.deviceId}/add`}
                >
                    add sensor
                  </QueryNavLink></div>
                  <div><br/></div>
              </div>
          )
          ):null}
      </nav>
      <Outlet />
    </div>
  );
}
