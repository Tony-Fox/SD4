import React from "react";
import { useState } from "react";
import {useParams} from "react-router-dom";

export default function AddProduct() {

    let param = useParams();
    const [inputs, setInputs] = useState({});

    const handleChange = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        setInputs(values => ({...values, [name]: value}))
    }

    const handleSubmit = (event) => {
        inputs.restaurantId = param.restaurantId;
        event.preventDefault();
        //alert(inputs.name + inputs.description + inputs.address);
        const requestOptions = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(inputs)
        };
        fetch('http://localhost:8080/test/product/add', {method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify(inputs)})
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
            <label>Enter the description:
                <input
                    type="text"
                    name="description"
                    value={inputs.description || ""}
                    onChange={handleChange}
                />
            </label><br/>
            <label>Enter the price:
                <input
                    type="number"
                    name="price"
                    value={inputs.price || ""}
                    onChange={handleChange}
                />
            </label><br/>
            <label>Enter the category:
                <select
                    name="category"
                    value={inputs.category || ""}
                    onChange={handleChange}

                >
                    <option value="Breakfast">Breakfast</option>
                    <option value="Lunch">Lunch</option>
                    <option value="Dinner">Dinner</option>
                </select>
            </label><br/>
            <input type="submit" />
        </form>
    )
}