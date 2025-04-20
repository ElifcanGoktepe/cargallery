"use client"

import { useState } from "react"
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom"
import HomePage from "./pages/HomePage"
import AdminPage from "./pages/AdminPage"
import LoginPage from "./pages/LoginPage"
import Navbar from "./components/Navbar"
import type { Car, User } from "./types"
import { carsData } from "./data/cars"

export default function App() {
  const [cars, setCars] = useState<Car[]>(carsData)
  const [isAuthenticated, setIsAuthenticated] = useState(false)
  const [currentUser, setCurrentUser] = useState<User | null>(null)

  const handleLogin = (user: User) => {
    setIsAuthenticated(true)
    setCurrentUser(user)
  }

  const handleLogout = () => {
    setIsAuthenticated(false)
    setCurrentUser(null)
  }

  const addCar = (car: Car) => {
    setCars([...cars, { ...car, id: Date.now().toString() }])
  }

  const deleteCar = (id: string) => {
    setCars(cars.filter((car) => car.id !== id))
  }

  return (
    <Router>
      <div className="min-h-screen bg-gray-50">
        <Navbar isAuthenticated={isAuthenticated} onLogout={handleLogout} />
        <main className="container mx-auto py-6 px-4">
          <Routes>
            <Route path="/" element={<HomePage cars={cars} />} />
            <Route
              path="/admin"
              element={
                isAuthenticated ? (
                  <AdminPage cars={cars} onAddCar={addCar} onDeleteCar={deleteCar} />
                ) : (
                  <Navigate to="/login" replace />
                )
              }
            />
            <Route
              path="/login"
              element={isAuthenticated ? <Navigate to="/admin" replace /> : <LoginPage onLogin={handleLogin} />}
            />
          </Routes>
        </main>
      </div>
    </Router>
  )
}
