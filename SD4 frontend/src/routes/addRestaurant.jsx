import * as React from 'react';
import {useState} from "react";

export default function AddRestaurant() {
    const [inputs, setInputs] = useState({});

    const handleChange = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        setInputs(values => ({...values, [name]: value}))
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        //alert(inputs.name + inputs.description + inputs.address);
        const requestOptions = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(inputs)
        };
        fetch('http://localhost:8080/test/restaurant/add', {method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify(inputs)})
            .then(response => response.json());
    }

    return (
        <form onSubmit={handleSubmit}>
            <label>Enter the name:
                <input
                    type="text"
                    name="name"
                    value={inputs.name || ""}
                    onChange={handleChange}
                />
            </label><br/>
            <label>Enter the location:
                <input
                    type="text"
                    name="location"
                    value={inputs.location || ""}
                    onChange={handleChange}
                />
            </label><br/>
            <label>Enter the delivery zone:
                <input
                    type="text"
                    name="deliveryZones"
                    value={inputs.deliveryZones || ""}
                    onChange={handleChange}
                />
            </label><br/>
            <input type="submit" />
        </form>
    )
}
