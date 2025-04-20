import type { Car } from "../types"
import CarCard from "./CarCard"

interface CarListProps {
  cars: Car[]
}

export default function CarList({ cars }: CarListProps) {
  if (cars.length === 0) {
    return (
      <div className="text-center py-10">
        <p className="text-gray-500">No cars found matching your criteria.</p>
      </div>
    )
  }

  return (
    <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6 mt-6">
      {cars.map((car) => (
        <CarCard key={car.id} car={car} />
      ))}
    </div>
  )
}
