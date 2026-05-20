
import React, { useState } from "react";
import axios from "axios";
import './Add.css';
import { useNavigate } from "react-router-dom";

const Add = () => {
    const usenavigate=useNavigate();

    const [user, setUser] = useState({
        name: "",
        email: "",
        role: ""
    });

    const { name, email, role } = user;

    const onInputChange = (e) => {
        setUser({
            ...user,
            [e.target.name]: e.target.value
        });
    };

    const onsubmit = async (e) => {
        e.preventDefault();

        await axios.post("http://localhost:8080/users", {
            name,
            email,
            role
        });
        alert("SUCCESSFULLY INSERT THE DATA ...");
        usenavigate("/")

    };

    return (
        <>
            <form onSubmit={onsubmit}>
                <table className="form-table">
                    <tbody>

                        <tr>
                            <th>NAME</th>
                            <td>
                                <input
                                    type="text"
                                    name="name"
                                    placeholder="ENTER YOUR NAME"
                                    value={name}
                                    onChange={onInputChange}
                                    pattern="[A-Za-z\s]+"
                                    title="Only alphabets are allowed"
                                    required
                                />
                            </td>
                        </tr>

                        <tr>
                            <th>EMAIL</th>
                            <td>
                                <input
                                    type="email"
                                    name="email"
                                    placeholder="ENTER YOUR EMAIL"
                                    value={email}
                                    onChange={onInputChange}
                                    pattern="^[^\s@]+@[^\s@]+\.[^\s@]{2,}$"
                                    title="Enter a valid email address"
                                    required
                                />
                            </td>
                        </tr>

                        <tr>
                            <th>ROLE</th>
                            <td>
                                <input
                                    type="text"
                                    name="role"
                                    placeholder="ENTER YOUR ROLE"
                                    value={role}
                                    onChange={onInputChange}
                                />
                            </td>
                        </tr>

                    </tbody>
                </table>

                <button className="btn btn-add">ADD</button>

                <button type="button" className="btn btn-cancel">
                    CANCEL
                </button>

            </form>
        </>
    );
};

export default Add;