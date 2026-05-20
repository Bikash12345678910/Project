import React from "react";

import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import Add from "./Component/Add";
import Edit from "./Component/Edit";
import View from "./Component/View";
import { BrowserRouter } from "react-router-dom";

function App(){
  return(
    <>
      <Router>
      <Routes >
      <Route
        path="/add" element={<Add/>}
       
       
      />
      <Route
      
       path="/" element={<View/>}
      />
      <Route
       path="/Edit/:id" element={<Edit/>}
      
      />
      </Routes>

      </Router>
    </>
  )
}
export default App;