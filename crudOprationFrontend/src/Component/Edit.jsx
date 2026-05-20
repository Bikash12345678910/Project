import React, { useEffect, useState } from "react";
import './Edit.css';
import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";

const Edit = () => {

    let navigate = useNavigate();

    const { id } = useParams();

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

    useEffect(() => {
        loadUser();
    }, []);

    const loadUser = async () => {

        const result = await axios.get(
            `http://localhost:8080/fetchSingle/${id}`
        );

        setUser(result.data.data);
    };

    const onSubmit = async (e) => {

        e.preventDefault();

        await axios.put(
            `http://localhost:8080/update/${id}`,
            user
        );

        alert("User Updated Successfully");

        navigate("/");
    };

    return (
        <>
            <div className="first-div">

                <form onSubmit={onSubmit}>

                    <table className="form-table">

                        <tbody className="form-body">

                            <tr>
                                <th>NAME</th>

                                <td>
                                    <input
                                        type="text"
                                        name="name"
                                        value={name}
                                        placeholder="ENTER THE NAME"
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
                                        type="text"
                                        name="email"
                                        value={email}
                                        placeholder="ENTER THE EMAIL"
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
                                        value={role}
                                        placeholder="ENTER THE ROLE"
                                        onChange={onInputChange}
                                    />
                                </td>
                            </tr>

                        </tbody>

                    </table>

                    <button type="submit" className="btn btn-add">
                        UPDATE
                    </button>

                </form>

            </div>
        </>
    );
};

export default Edit;