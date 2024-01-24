import { Input } from "@/components/ui/input";
import { Employee, columns } from "./columns"
import { DataTable } from "./data-table"
import { Label } from "@/components/ui/label";
import { Button } from "@/components/ui/button";
import { Search } from "lucide-react";

const data: Employee[] =  [
    {
    id: "2",
    name: "Victor Silva",
    job_role: "Software Developer"
},
{
    id: "63",
    name: "João Pereira",
    job_role: "Product Owner"
},
{
    id: "21",
    name: "José de Assis",
    job_role: "QA"
},

]

 function getData(): Employee[] {
  // Fetch data from your API here.
  return data;
}

export function CustomTable() {
  const data =  getData()

  return (
    <div className="container mx-auto py-10">
      <div className="flex mb-4">
      <Input type='text' placeholder='Pesquisar funcionário' className='rounded-none border-2 border-s-principal w-96'/>
      <Button className="bg-principal text-white ml-2 rounded-md shadow-md transition ease-in-out delay-130 hover:bg-red-900 duration-300">
        <Search className="text-white"></Search>
      </Button>
      </div>
      <DataTable columns={columns} data={data} />
    </div>
  )
}
