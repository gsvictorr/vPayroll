import type { Metadata } from "next";
import { Roboto } from "next/font/google";
import "./globals.css";
import { cn } from "@/lib/utils";
import { AuthContextProvider } from "@/context/auth-context";

const roboto = Roboto({ weight: "300", subsets: ["latin"]});

export const metadata: Metadata = {
  title: "vPayroll | Login",
  description: "Software of payroll.",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <AuthContextProvider>
    <html lang="pt-BR">
      <body className={cn(roboto.className, "bg-gray-100")}>
        {children}
        </body>
    </html>
    </AuthContextProvider>
  );
}
