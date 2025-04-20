import type { Car } from "../types"
import { Card, CardContent, CardFooter, CardHeader } from "@/components/ui/card"
import { Badge } from "@/components/ui/badge"

interface CarCardProps {
  car: Car
}

export default function CarCard({ car }: CarCardProps) {
  return (
    <Card className="overflow-hidden transition-all hover:shadow-md">
      <div className="aspect-video overflow-hidden">
        <img
          src={car.imageUrl || "/placeholder.svg"}
          alt={`${car.brand} ${car.model}`}
          className="w-full h-full object-cover transition-transform hover:scale-105"
        />
      </div>

      <CardHeader className="pb-2">
        <div className="flex justify-between items-start">
          <div>
            <h3 className="text-lg font-bold">
              {car.brand} {car.model}
            </h3>
            <p className="text-sm text-gray-500">{car.year}</p>
          </div>
          <Badge variant="outline">${car.price.toLocaleString()}</Badge>
        </div>
      </CardHeader>

      <CardContent>
        <p className="text-sm text-gray-700">{car.description}</p>
      </CardContent>

      <CardFooter>
        <div className="flex justify-between w-full">
          <Badge variant="secondary">{car.brand}</Badge>
          <Badge variant="secondary">{car.model}</Badge>
        </div>
      </CardFooter>
    </Card>
  )
}
