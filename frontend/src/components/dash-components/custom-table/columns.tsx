"use client"
 
import { Button } from "@/components/ui/button"
import { ColumnDef } from "@tanstack/react-table"
import { CalendarDays, Eye, icons } from "lucide-react"
 
// This type is used to define the shape of our data.
// You can use a Zod schema here if you want.
export type Employee = {
    id: string,
    name: string,
    job_role: string
}
 
export const columns: ColumnDef<Employee>[] = [
  {
    accessorKey: "id",
    header: "ID",
  },
  {
    accessorKey: "name",
    header: "Nome",
  },
  {
    accessorKey: "job_role",
    header: "Cargo",
  },
  {
    id: "actions",
    header:"",
    cell: ({row}) => {
        return(
            <>
            <Button className="rounded-md bg-gray-100 text-gray-300 shadow-md transition ease-in-out delay-130 hover:bg-red-900 hover:text-white duration-300">
                <Eye className="text-gray-300 mr-2"></Eye>
                Visualizar
            </Button>
            <Button className="rounded-md ml-2 bg-gray-100 text-gray-300 shadow-md transition ease-in-out delay-130 hover:bg-red-900 hover:text-white duration-300">
                <CalendarDays className="text-gray-300 mr-2"></CalendarDays>
            Escala
            </Button>
            </>
        )
    }
  }
]