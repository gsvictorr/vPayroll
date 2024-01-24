import {CustomTable} from "@/components/dash-components/custom-table";


const today = new Date();

const formatDate = (today:Date) => {
  const day = today.getDate().toString().padStart(2, '0');
  const month = (today.getMonth() + 1).toString().padStart(2, '0'); // Os meses começam do zero
  const year = today.getFullYear();
  return `${day}/${month}/${year}`;
};

export default function Dashboard(){

    return(
        <div className="p-4">
            <h1 className="text-xl">Olá, seja bem-vindo(a)!</h1>
            <h2>{formatDate(today)}</h2>
            <CustomTable></CustomTable>
            <div className="flex flex-col items-center">
            <span className="font-bold text-base">v<span className="font-bold text-principal text-lg">Payroll</span>&#169;</span>
            <span className="text-sm">Todos os direitos reservados.</span>
            </div>
        </div>
    );
}