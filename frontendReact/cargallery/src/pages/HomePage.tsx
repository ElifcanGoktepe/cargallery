"use client"

import { useState, useEffect } from "react"
import CarList from "../components/CarList"
import FilterBar from "../components/FilterBar"
import type { Car, FilterOptions } from "../types"
import { brands, getModelsByBrand } from "../data/cars"

interface HomePageProps {
  cars: Car[]
}

export default function HomePage({ cars }: HomePageProps) {
  const [filteredCars, setFilteredCars] = useState<Car[]>(cars)
  const [filters, setFilters] = useState<FilterOptions>({ brand: "", model: "" })
  const [availableModels, setAvailableModels] = useState<string[]>([])

  useEffect(() => {
    let result = [...cars]

    if (filters.brand) {
      result = result.filter((car) => car.brand === filters.brand)
      setAvailableModels(getModelsByBrand(filters.brand))
    } else {
      setAvailableModels([])
    }

    if (filters.model) {
      result = result.filter((car) => car.model === filters.model)
    }

    setFilteredCars(result)
  }, [cars, filters])

  const handleFilterChange = (name: keyof FilterOptions, value: string) => {
    if (name === "brand") {
      setFilters({ brand: value, model: "" })
    } else {
      setFilters({ ...filters, [name]: value })
    }
  }

  return (
    <div>
      <h1 className="text-3xl font-bold mb-6">Car Gallery</h1>
      <FilterBar brands={brands} models={availableModels} filters={filters} onFilterChange={handleFilterChange} />
      <CarList cars={filteredCars} />
    </div>
  )
}
