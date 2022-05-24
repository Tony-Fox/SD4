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



export default function Restaurants() {
 // let invoices = getInvoices();

 let [searchParams, setSearchParams] = useSearchParams({ replace: true });


    const {token, setToken} = useToken();
    const [Restaurants, setRestaurants] = useState(null);

    useEffect(()=>{
        fetch('http://localhost:8080/test/restaurants')
            .then(response => response.json())
            .then(data => setRestaurants(data));
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
            Restaurants ?
            Restaurants
          .filter((restaurant) => {
            let filter = searchParams.get('filter');
            if (!filter) return true;
            let name = restaurant.name.toLowerCase();
            return name.startsWith(filter.toLowerCase());
          })
          .map((restaurant) => (
              <div>
            <QueryNavLink
              key={restaurant.restaurantId}
              style={({ isActive }) => {
                return {
                  display: 'block',
                  margin: '1rem 0',
                  color: isActive ? 'red' : '',
                };
              }}
              to={`/restaurants/${restaurant.restaurantId}`}
            >
              {restaurant.name}
                <div></div>
                {restaurant.location}
                <div></div>
                {restaurant.deliveryZones}
            </QueryNavLink>
                  <div style={{ display: (token === 'administrator' ? 'block' : 'none') }}><QueryNavLink
                    // key={restaurant.restaurantId}
                    style={({ isActive }) => {
                        return {
                            display: 'block',
                            margin: '1rem 0',
                            color: isActive ? 'red' : '',
                        };
                    }}
                    to={`/restaurants/${restaurant.restaurantId}/add`}
                >
                    add food
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
