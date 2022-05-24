import React from "react";
import { useState } from "react";
import {Link} from "react-router-dom";

export default function Login({setToken}) {

    const [inputs, setInputs] = useState({});

    const handleChange = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        setInputs(values => ({...values, [name]: value}))
    }

    const [username, setUserName] = useState();
    const [password, setPassword] = useState();

    const handleSubmit = async event => {
        event.preventDefault();
        const token = await loginUser(inputs)
        setToken(token);
    }

    const handleSubmit2 = (event) => {
        event.preventDefault();
        //alert(inputs.name + inputs.description + inputs.address);
        const requestOptions = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(inputs)
        };
        fetch('http://localhost:8080/test/register', {method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify(inputs)})
            .then(response => response.json());
    }

    async function loginUser(credentials){
        return fetch('http://localhost:8080/test/login2', {method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify(credentials)})
            .then(response => response.json());

        // fetch("http://localhost:8080/test/login", {
        //     method: 'POST',
        //     headers: {
        //         "Authorization": 'Basic ' + window.btoa(username + ":" + password)
        //         // "Authorization": 'Basic ' + username + ":" + password
        //         // 'Authorization': 'Basic ' + 'admin' + ':' + 'admin'
        //     }
        // }).then(resp => {
        //     console.log(resp);
        //     if (resp.ok) {
        //         this.setState({
        //             isLoginSucces: true});
        //     } else {
        //         this.setState({isLoginSucces: false});
        //     }
        //     return resp.text();
        // });
    }



    return (
        <div className="login-wrapper">
            <h1>Log in or create an account</h1>
            {/*<Link to="/Register">Register</Link>|{" "}*/}
            <form onSubmit={handleSubmit}>
                <label>Enter the username:
                    <input
                        type="text"
                        name="username"
                        value={inputs.username || ""}
                        onChange={handleChange}
                    />
                </label>
                <br/>
                <label>Enter the password:
                    <input
                        type="password"
                        name="password"
                        value={inputs.password || ""}
                        onChange={handleChange}
                    />
                </label>
                <br/>
                <input type="submit" value="Login" />
            </form>

            <form onSubmit={handleSubmit2}>
                <div style={{ display: 'none'}} ><label>Enter the username:
                    <input
                        type="text"
                        name="username"
                        value={inputs.username || ""}
                        onChange={handleChange}
                    />
                </label></div>
                <br/>
                <div style={{ display: 'none'}} ><label>Enter the password:
                    <input
                        type="password"
                        name="password"
                        value={inputs.password || ""}
                        onChange={handleChange}
                    />
                </label></div>
                <input type="submit" value="Register" />
            </form>
        </div>
    )
    // Login.propTypes = {
    //     setToken: PropTypes.func.isRequired
    // }
}