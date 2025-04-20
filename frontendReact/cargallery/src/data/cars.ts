import type { Car } from "../types"

export const carsData: Car[] = [
  {
    id: "1",
    brand: "BMW",
    model: "X5",
    year: 2022,
    price: 65000,
    imageUrl: "/placeholder.svg?height=200&width=300",
    description: "Luxury SUV with advanced features and powerful engine.",
  },
  {
    id: "2",
    brand: "Mercedes",
    model: "C-Class",
    year: 2021,
    price: 45000,
    imageUrl: "/placeholder.svg?height=200&width=300",
    description: "Elegant sedan with premium interior and smooth ride.",
  },
  {
    id: "3",
    brand: "Audi",
    model: "A4",
    year: 2023,
    price: 50000,
    imageUrl: "/placeholder.svg?height=200&width=300",
    description: "Sophisticated sedan with cutting-edge technology.",
  },
  {
    id: "4",
    brand: "BMW",
    model: "3 Series",
    year: 2022,
    price: 48000,
    imageUrl: "/placeholder.svg?height=200&width=300",
    description: "Sports sedan with dynamic performance and luxury features.",
  },
  {
    id: "5",
    brand: "Mercedes",
    model: "GLE",
    year: 2023,
    price: 72000,
    imageUrl: "/placeholder.svg?height=200&width=300",
    description: "Premium SUV with spacious interior and advanced safety features.",
  },
  {
    id: "6",
    brand: "Audi",
    model: "Q5",
    year: 2021,
    price: 55000,
    imageUrl: "/placeholder.svg?height=200&width=300",
    description: "Compact luxury SUV with Quattro all-wheel drive.",
  },
]

export const brands = [...new Set(carsData.map((car) => car.brand))]

export const getModelsByBrand = (brand: string) => {
  return [...new Set(carsData.filter((car) => car.brand === brand).map((car) => car.model))]
}

export const users = [
  {
    id: "1",
    username: "admin",
    password: "admin123",
    role: "admin" as const,
  },
]
