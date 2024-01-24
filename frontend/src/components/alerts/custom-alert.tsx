import { AlertCircleIcon, CheckCircleIcon } from "lucide-react";
import { Alert, AlertDescription, AlertTitle } from "../ui/alert";
import { cn } from "@/lib/utils";

export const enum CustomAlertType {
    SUCCESS = "success",
    ERROR = "error"
}


export type CustomAlertProps = {
    type: CustomAlertType.SUCCESS | CustomAlertType.ERROR;
    title: string;
    message: string;
    className?: string;
}

export function CustomAlert({ type, title, message, className="" }: CustomAlertProps) {

    const alert = type === CustomAlertType.SUCCESS
        ? <SuccessAlert title={title} message={message} className={className} />
        : <ErrorAlert title={title} message={message} className={className}/>

    return alert;
}

type SuccessAlertProps = {
    title: string;
    message: string;
    className: string;
};

function SuccessAlert({ title, message, className }: SuccessAlertProps) {
    return (
        <Alert className={cn("flex-row border-emerald-500 mb-2", className)}>
            <CheckCircleIcon className="h-8 w-8 stroke-emerald-500"></CheckCircleIcon>
            <AlertTitle className="font-bold mx-4">
                {title}
            </AlertTitle>
            <AlertDescription className="font-thin mx-4">
                {message}
            </AlertDescription>
        </Alert>
    )
}

type ErrorAlertProps = {
    title: string;
    message: string;
    className: string;
}

function ErrorAlert({ title, message, className }: ErrorAlertProps) {
    return (
        <Alert className={cn("flex-row border-principal mb-2", className)}>
<AlertCircleIcon className="h-8 w-8 stroke-principal"></AlertCircleIcon>
            <AlertTitle className="font-bold mx-4">
                {title}
            </AlertTitle>
            <AlertDescription className="font-thin mx-4">
                {message}
            </AlertDescription>
        </Alert>
    )
}
