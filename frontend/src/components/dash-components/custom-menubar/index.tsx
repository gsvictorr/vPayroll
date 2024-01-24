'use client'
import { Menubar } from "@/components/ui/menubar";
import { Button } from "@/components/ui/button";
import { MenubarContent, MenubarItem, MenubarMenu, MenubarSeparator, MenubarSub, MenubarSubContent, MenubarSubTrigger, MenubarTrigger } from "@/components/ui/menubar";

export function MenuBar(){

    return(
        <>
        <div className="container flex justify-between h-14 items-center w-full gap-4 shadow-md bg-gray-50 rounded-md">
        <span className="font-bold text-xl">v<span className="font-bold text-principal text-2xl">Payroll</span></span>
            <Menubar className="ml-6 mr-6 rounded-md divide-x-2 divide-gray-100 divide-solid border-x-2 border-principal border-y-0">
                <MenubarMenu>
                    <MenubarTrigger className="cursor-pointer">Funcionários</MenubarTrigger>
                    <MenubarContent>
                        <MenubarItem>Pesquisar</MenubarItem>
                        <MenubarSeparator></MenubarSeparator>
                        <MenubarItem>Cadastrar</MenubarItem>
                        <MenubarSeparator></MenubarSeparator>
                        <MenubarItem>Listar todos</MenubarItem>
                        <MenubarSeparator></MenubarSeparator>
                        <MenubarSub>
            <MenubarSubTrigger>Escalas</MenubarSubTrigger>
            <MenubarSubContent>
              <MenubarItem>Verificar escala</MenubarItem>
              <MenubarItem>Adicionar escala</MenubarItem>
            </MenubarSubContent>
          </MenubarSub>
          <MenubarSeparator />
                    </MenubarContent>
                </MenubarMenu>
                <MenubarMenu>
                <MenubarTrigger className="cursor-pointer">Relatórios</MenubarTrigger>
                    <MenubarContent>
                    <MenubarItem>Férias</MenubarItem>
                        <MenubarSeparator></MenubarSeparator>
                        <MenubarItem>Demonstrativo de pagamento</MenubarItem>
                        </MenubarContent>
                </MenubarMenu>
                <MenubarMenu>
                <MenubarTrigger className="cursor-pointer">Lançamentos</MenubarTrigger>
                    <MenubarContent>
                    <MenubarItem>Atestado</MenubarItem>
                        <MenubarSeparator></MenubarSeparator>
                        <MenubarItem>Falta injustificada</MenubarItem>
                        <MenubarSeparator></MenubarSeparator>
                        <MenubarItem>Hora extra</MenubarItem>
                        </MenubarContent>
                </MenubarMenu>
                <MenubarMenu>
                <MenubarTrigger className="cursor-pointer">Usuários</MenubarTrigger>
                    <MenubarContent>
                    <MenubarItem>Adicionar perfil</MenubarItem>
                        <MenubarSeparator></MenubarSeparator>
                        <MenubarItem>Editar perfil</MenubarItem>
                        <MenubarSeparator></MenubarSeparator>
                        <MenubarItem>Ativar perfil</MenubarItem>
                        </MenubarContent>
                </MenubarMenu>
            </Menubar>
            <Button className="bg-principal text-slate-50 font-normal rounded-none w-20 transition ease-in-out delay-130 hover:bg-red-900 duration-300">Logout</Button>
        </div>
        
        </>
    );

}