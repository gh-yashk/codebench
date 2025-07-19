import { LoaderCircle } from "lucide-react";

export default function LoadingAnimation() {
    return (
        <div className="flex flex-grow items-center justify-center">
            <LoaderCircle className="animate-spin" color="#959595" size={64} />
        </div>
    )
}