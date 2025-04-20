"use client"

import { Link } from "react-router-dom"
import { Button } from "@/components/ui/button"

interface NavbarProps {
  isAuthenticated: boolean
  onLogout: () => void
}

export default function Navbar({ isAuthenticated, onLogout }: NavbarProps) {
  return (
    <nav className="bg-white shadow-sm">
      <div className="container mx-auto px-4 py-3 flex justify-between items-center">
        <Link to="/" className="text-xl font-bold">
          Car Gallery
        </Link>

        <div className="flex gap-4">
          <Link to="/">
            <Button variant="ghost">Home</Button>
          </Link>

          {isAuthenticated ? (
            <>
              <Link to="/admin">
                <Button variant="ghost">Admin</Button>
              </Link>
              <Button variant="outline" onClick={onLogout}>
                Logout
              </Button>
            </>
          ) : (
            <Link to="/login">
              <Button>Login</Button>
            </Link>
          )}
        </div>
      </div>
    </nav>
  )
}
