"use client"

import type { FilterOptions } from "../types"
import { Label } from "@/components/ui/label"
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select"
import { Card, CardContent } from "@/components/ui/card"

interface FilterBarProps {
  brands: string[]
  models: string[]
  filters: FilterOptions
  onFilterChange: (name: keyof FilterOptions, value: string) => void
}

export default function FilterBar({ brands, models, filters, onFilterChange }: FilterBarProps) {
  return (
    <Card className="mb-6">
      <CardContent className="pt-6">
        <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
          <div className="space-y-2">
            <Label htmlFor="brand-filter">Filter by Brand</Label>
            <Select value={filters.brand} onValueChange={(value) => onFilterChange("brand", value)}>
              <SelectTrigger id="brand-filter">
                <SelectValue placeholder="All Brands" />
              </SelectTrigger>
              <SelectContent>
                <SelectItem value="all">All Brands</SelectItem>
                {brands.map((brand) => (
                  <SelectItem key={brand} value={brand}>
                    {brand}
                  </SelectItem>
                ))}
              </SelectContent>
            </Select>
          </div>

          <div className="space-y-2">
            <Label htmlFor="model-filter">Filter by Model</Label>
            <Select
              value={filters.model}
              onValueChange={(value) => onFilterChange("model", value)}
              disabled={!filters.brand}
            >
              <SelectTrigger id="model-filter">
                <SelectValue placeholder={filters.brand ? "All Models" : "Select a brand first"} />
              </SelectTrigger>
              <SelectContent>
                <SelectItem value="all">All Models</SelectItem>
                {models.map((model) => (
                  <SelectItem key={model} value={model}>
                    {model}
                  </SelectItem>
                ))}
              </SelectContent>
            </Select>
          </div>
        </div>
      </CardContent>
    </Card>
  )
}
