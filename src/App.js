import React from 'react';
import Navbar from './Components/Navbar/Navbar';
import { Routes, Route } from 'react-router-dom';
import Booking from './Components/Booking/Booking';
import Login from './Components/Login/Login'; // New import
import Signup from './Components/Signup/Signup'; // New import

function App() {
  return (
    <div>
      <Navbar />
      <Routes>
        <Route path="/" element={<Booking />} />
        <Route path="/login" element={<Login />} /> // New route
        <Route path="/signup" element={<Signup />} /> // New route
        <Route path="*" element={<Booking />} />
      </Routes>
    </div>
  );
}

export default App;
