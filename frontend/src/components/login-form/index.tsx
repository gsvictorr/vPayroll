'use client'

import { frontendAPI } from "@/lib/api";
import { zodResolver } from "@hookform/resolvers/zod";
import { useContext, useState } from "react";
import { useForm } from "react-hook-form";
import { z } from "zod"
import { Button } from "../ui/button";
import { Form, FormControl, FormField, FormItem, FormMessage } from "../ui/form";
import { Label } from "../ui/label";
import { Input } from "../ui/input";
import { LoginResponseType } from "@/app/api/auth/login/route";
import { AuthContext } from "@/context/auth-context";
import { useRouter } from "next/navigation";
import { CustomAlert, CustomAlertType } from "../alerts/custom-alert";


const loginFormSchema = z.object({
    email: z.string().email({message: "Insira um email válido."}).min(10, {message: "Insira um email com no mínimo 10 caracteres."}),
    password: z.string().min(8, {message: "Insira uma senha com no mínimo 8 caracteres."})
});

type LoginFormType = z.infer<typeof loginFormSchema>;

export function LoginForm(){

    const [message, setMessage] = useState(<></>);

    const authContext = useContext(AuthContext);

    const router = useRouter();

    const loginForm = useForm<LoginFormType>({
        resolver: zodResolver(loginFormSchema),
        defaultValues: {
            email: "",
            password: ""
        }
    });

    async function clickLogin({ email, password }: LoginFormType){
        const data = JSON.stringify({
            email, password
        });

        try {
            const result = await frontendAPI.post("/auth/login", data);

            const {token, error} = result.data as LoginResponseType;

            if(token){
                authContext.signIn(token);
                router.push("/dashboard");

            } else{
                const message = <CustomAlert
                type={CustomAlertType.ERROR}
                title="Erro ao logar!"
                message={error || "Erro desconhecido."}
                >
                </CustomAlert>;

                setMessage(message);
            }
            
        } catch (e) {

            const message = <CustomAlert
                type={CustomAlertType.ERROR}
                title="Erro ao logar-se!"
                message="API fora do ar, tente novamente mais tarde!"
            />;

            setMessage(message);    
        }

    };

    return(
        <>
            <div className="flex items-center h-screen">
                <div className="container space-y-2 p-8 max-w-md bg-gray-50 rounded-xl shadow-md">
                    <span className="flex items-center gap-2 justify-center">
                        <span className="font-bold text-xl">v<span className="font-bold text-principal text-2xl">Payroll</span></span>
                        </span>
                    <h1 className='flex justify-center text-lg'>Realize seu login</h1>
                    <Form{...loginForm}>
                        <form onSubmit={loginForm.handleSubmit(clickLogin)}>
                            {message}
                            <FormField
                                control={loginForm.control}
                                name="email"
                                render={({ field }) => {
                                    return (
                                        <FormItem className="mb-2">
                                            <Label htmlFor='text' className='font-bold text-sm'>Email</Label>
                                            <FormControl>
                                                <Input type='text' placeholder='Digite seu email' className='rounded-none border-2 border-s-principal'  {...field} />
                                            </FormControl>
                                            <FormMessage />
                                        </FormItem>
                                    )
                                }}
                            />

                            <FormField

                                control={loginForm.control}
                                name="password"
                                render={({ field }) => {
                                    return (
                                        <FormItem>
                                            <Label htmlFor='password' className='font-bold text-sm'>Senha</Label>
                                            <FormControl>
                                                <Input type='password' placeholder='Digite sua senha' className='rounded-none border-2 border-s-principal' {...field} />
                                            </FormControl>
                                            <FormMessage />
                                        </FormItem>
                                    )

                                }}
                            />
                            <div className='flex justify-end'>
                                <Button type="submit" className='bg-principal mt-5 text-slate-50 font-normal rounded-none w-20 transition ease-in-out delay-130 hover:bg-red-600 duration-300'>Login</Button>
                            </div>
                        </form>
                    </Form>
                </div>
            </div >
        </>

    );
    
}