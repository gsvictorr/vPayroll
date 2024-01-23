import { MenubarContent, MenubarItem, MenubarMenu, MenubarSeparator, MenubarTrigger } from "@/components/ui/menubar";
import { Menubar } from "@/components/ui/menubar";
import React from "react";

export default function DashboardLayout({children}: {children: React.ReactNode}){

    return(
        <>
        <div className="container flex h-20 rounded-md items-center m-auto gap-4">
            <Menubar>
                <MenubarMenu>
                    <MenubarTrigger>Funcionários</MenubarTrigger>
                    <MenubarContent>
                        <MenubarItem>Pesquisar</MenubarItem>
                        <MenubarSeparator></MenubarSeparator>
                        <MenubarItem>Cadastrar</MenubarItem>
                        <MenubarSeparator></MenubarSeparator>
                        <MenubarItem>Listar todos</MenubarItem>
                        <MenubarSeparator></MenubarSeparator>
                    </MenubarContent>
                </MenubarMenu>
            </Menubar>
        </div>
            {children}
        </>
    );
}