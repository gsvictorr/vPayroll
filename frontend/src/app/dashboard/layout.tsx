import { MenuBar } from "@/components/dash-components/custom-menubar";
import { Metadata } from "next";
import React from "react";

export const metadata: Metadata = {
    title: 'vPayroll | Dashboard',
    description: 'Software of payroll'
};

export default function DashboardLayout({children}: {children: React.ReactNode}){
    return(
        <>
        <MenuBar></MenuBar>
        <div className="container gap-4 bg-gray-50 w-md m-auto mt-6 rounded-md p-4 shadow-md">
            {children}
            </div>
        </>
    );
}