import ProblemList from "@/components/ProblemList";
import ProfileAndLogin from "@/components/ProfileAndLogin";
import { useEffect } from "react";
import leetcodeLogo from "../assets/leetcode.svg";

export default function ProblemHome() {

    useEffect(() => {
        document.title = "Problems - LeetCode";
    }, []);

    return (
        <>
            <div className="max-w-3xl mx-auto flex flex-col min-h-screen">
                <nav className="flex items-center justify-between my-6 px-12">
                    <a href="/">
                        <img className="h-7" src={leetcodeLogo} alt="LeetCode Logo" />
                    </a>
                    <ProfileAndLogin />
                </nav>
                <div className="bg-[#333] h-[1px]" />
                <ProblemList />
            </div>
        </>
    )
}