import * as React from 'react';

import {
    useLocation,
    NavLink,
    Outlet,
    useSearchParams, useParams,
} from 'react-router-dom';
import { getInvoices } from '../data';
import {useEffect, useState} from "react";

function QueryNavLink({ to, ...props }) {
    let location = useLocation();
    return <NavLink to={to + location.search} {...props} />;
}



export default function Sensors() {
    // let invoices = getInvoices();
    let [searchParams, setSearchParams] = useSearchParams({ replace: true });


    const [Sensor, setSensor] = useState(null);


    let param = useParams();

    useEffect(()=>{
        fetch('http://localhost:8080/test/sensor?id='+param.deviceId) //restaurants/product?id=
            .then(response => response.json())
            .then(data => setSensor(data));
    }, [param]);


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
                    Sensor ?
                        Sensor
                            .filter((sensor) => {
                                let filter = searchParams.get('filter');
                                if (!filter) return true;
                                let name = sensor.name.toLowerCase();
                                return name.startsWith(filter.toLowerCase());
                            })
                            .map((product) => (
                                    <div
                                        key={product.sensorId}
                                        // style={({ isActive }) => {
                                        //     return {
                                        //         display: 'block',
                                        //         margin: '1rem 0',
                                        //         color: isActive ? 'red' : '',
                                        //     };
                                        // }}
                                    >
                                        <br/>
                                        {/*{product.price}*/}
                                        {/*<br/>*/}
                                        {/*{product.category}*/}
                                        {/*<br/>*/}
                                        <QueryNavLink
                                            key={product.sensorId}
                                            style={({ isActive }) => {
                                                return {
                                                    display: 'block',
                                                    margin: '1rem 0',
                                                    color: isActive ? 'red' : '',
                                                };
                                            }}
                                            to={`./${product.sensorId}`}
                                        >
                                            {product.name}
                                            <br/>
                                            {product.description}
                                            <br/>
                                            <div></div>
                                            {/*{device.deliveryZones}*/}
                                        </QueryNavLink>
                                    </div>
                                )
                            ):null}
            </nav>
            <Outlet />
        </div>
    );
}
