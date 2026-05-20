

import React, { useEffect, useState } from "react";
import './View.css';
import axios from "axios";
import { useNavigate } from "react-router-dom";
import Edit from "./Edit";


const View = () => {

     const navigate = useNavigate();

    const [users, setUsers] = useState([]);
    // const{id,name,email,role}=users;

    // ===== GET ALL USERS =====
    useEffect(() => {
        onGet();
    }, []);

    const onGet = async () => {

        const result = await axios.get("http://localhost:8080/fetch");
        console.log(result.data);
        

        setUsers(Array.isArray(result.data.data) ? result.data.data : []);
    };

    // ===== DELETE USER =====
    const onDelete = async (id) => {

        await axios.delete(`http://localhost:8080/deleteuser/${id}`);

        alert("User Deleted Successfully");

         onGet();
    };
        // console.log(user.name);
        
    return (
        <>
            <div className="first-div">

                <div className="add-button">
                    <button className="btn btn-add-records"  onClick={() => navigate("/add")}>ADD Record</button>
                </div>

                <h1 className="table-title">
                    CRUD OPERATION
                </h1>

                <table className="first-table">

                    <thead>
                        <tr className="table-head">
                            <th>ID</th>
                            <th>NAME</th>
                            <th>EMAIL</th>
                            <th>ROLE</th>
                            <th>ACTION</th>
                        </tr>
                    </thead>

                    <tbody className="first-body">

                        {
                            users.length > 0 ? (
                                users.map((user) => (

                                    <tr className="table-body" key={user.id}>

                                        <td>{user.id}</td>
                                        <td>{user.name}</td>
                                        <td>{user.email}</td>
                                        <td>{user.role}</td>

                                        <td>

                                            <button
                                                className="btn btn-edit"
                                                onClick={() => navigate(`/edit/${user.id}`)}
                                            >
                                                EDIT
                                            </button>

                                            <button
                                                className="btn btn-delete"
                                                onClick={() => onDelete(user.id)}
                                            >
                                                DELETE
                                            </button>


                                        </td>

                                    </tr>

                                ))
                            ) : (
                                <tr>
                                    <td colSpan="5">No Users Found</td>
                                </tr>
                            )
                        }
                        
                    </tbody>

                </table>

            </div>
        </>
    );
}

export default View;