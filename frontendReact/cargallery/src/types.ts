export interface Car {
  id: string
  brand: string
  model: string
  year: number
  price: number
  imageUrl: string
  description: string
}

export interface User {
  id: string
  username: string
  password: string
  role: "admin" | "user"
}

export interface FilterOptions {
  brand: string
  model: string
}
