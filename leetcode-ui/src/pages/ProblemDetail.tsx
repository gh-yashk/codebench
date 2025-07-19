import LoadingAnimation from "@/components/Loading";
import ProfileAndLogin from "@/components/ProfileAndLogin";
import { Command, CommandGroup, CommandItem, CommandList } from "@/components/ui/command";
import { Popover, PopoverContent, PopoverTrigger } from "@/components/ui/popover";
import { ResizableHandle, ResizablePanel, ResizablePanelGroup } from "@/components/ui/resizable";
import { Separator } from "@/components/ui/separator";
import { useStarterCode } from "@/hooks/useCodeHooks";
import { useAllLanguages } from "@/hooks/useLanguageHooks";
import { useProblemDetail } from "@/hooks/useProblemHooks";
import { useRunCode, useSubmitCode } from "@/hooks/useSubmissionHooks";
import { useUserInfo } from "@/hooks/useUserHooks";
import { useCodeStore } from "@/store/codeStore";
import type { Language } from "@/types/api";
import Editor from "@monaco-editor/react";
import { Braces, Check, ChevronDown, ChevronLeft, ChevronRight, CircleCheckBig, CircleEllipsis, CloudUpload, CodeXml, FileText, List, LoaderCircle, Play, RotateCcw, SquareCheck, X } from "lucide-react";
import { useEffect, useState } from "react";
import Markdown from "react-markdown";
import { useParams } from "react-router-dom";
import lcLogo from "../assets/lc_logo.svg";
import NotFound from "./NotFoundPage";

const toTitleCase = (s: string): string => s.charAt(0).toUpperCase() + s.slice(1).toLowerCase();

export default function ProblemDetail() {

    const { slug } = useParams<{ slug: string }>();

    const { defaultLanguage, setDefaultLanguage, setCode, getCode } = useCodeStore();

    const { data: user } = useUserInfo();

    const { data: problem, isLoading: isLoadingProblem, isError: isErrorProblem } = useProblemDetail(slug);
    const { data: languages, isLoading: isLoadingLanguage } = useAllLanguages();
    const { data: codeSnippet } = useStarterCode(problem?.id, defaultLanguage?.id);

    const { mutate: runUserCode, isPending: isRunningPending, data: runCodeResult } = useRunCode();
    const { mutate: submitUserCode, isPending: isSubmissionPending, data: submitCodeResult } = useSubmitCode();

    const [open, setOpen] = useState(false);
    const [selectedLang, setSelectedLang] = useState<Language | null>(null);
    const [editorCode, setEditorCode] = useState<string>("");

    useEffect(() => {
        if (!defaultLanguage && languages?.length) {
            setDefaultLanguage(languages[0]);
        }
    }, [languages]);

    useEffect(() => {
        if (defaultLanguage) {
            setSelectedLang(defaultLanguage);
        }
    }, [defaultLanguage]);

    useEffect(() => {
        if (problem?.id && selectedLang?.id && codeSnippet?.starterCode) {
            const savedCode = getCode(problem.id, selectedLang.id);

            if (savedCode !== null && savedCode !== undefined) {
                setEditorCode(savedCode);
            } else {
                setEditorCode(codeSnippet.starterCode);
                setCode(problem.id, selectedLang.id, codeSnippet.starterCode);
            }
        }
    }, [problem?.id, selectedLang?.id, codeSnippet, getCode, setCode]);

    useEffect(() => {
        document.title = problem?.title ? `${problem.title} - LeetCode` : "LeetCode";
    }, [problem?.title]);

    const handleEditorChange = (value: string | undefined) => {
        if (value !== undefined && problem?.id && selectedLang?.id) {
            setEditorCode(value);
            setCode(problem.id, selectedLang.id, value);
        }
    };

    const getPayload = () => {
        if (!problem?.id || !selectedLang?.id || !editorCode.trim()) {
            console.warn("Missing data to run code.");
            return null;
        }

        if (!user?.authenticated) {
            console.warn("User is not authenticated.");
            return null;
        }

        return {
            problemId: problem.id,
            languageId: selectedLang.id,
            userCode: editorCode,
        };
    }

    const runCode = () => {
        const payload = getPayload();
        if (!payload) return;
        runUserCode(payload);
    };

    const submitCode = () => {
        const payload = getPayload();
        if (!payload) return;
        submitUserCode(payload);
    };

    if (isErrorProblem) return <NotFound />;

    return (
        <>
            <div className="bg-[#0f0f0f] w-screen h-screen flex flex-col">

                <nav className="px-4 pl-6 h-12 flex items-center justify-between">
                    <div className="min-w-60 flex items-center gap-2">
                        <a href="/">
                            <img src={lcLogo} alt="LeetCode Logo" className="h-5 w-5" />
                        </a>
                        <div className="h-4">
                            <Separator orientation="vertical" className="bg-[#2f2f2f]" />
                        </div>
                        <div className="flex items-center hover:bg-[#1f2020] rounded-sm">
                            <button className="cursor-pointer hover:bg-[#2f2f2f] py-1.5 flex items-center gap-1 px-2 rounded-l-sm">
                                <List className="h-5" color="#b7b7b7" />
                                <span>Problem List</span>
                            </button>
                            <div className="h-6">
                                <Separator orientation="vertical" className="bg-[#0f0f0f]" />
                            </div>
                            <button className="cursor-pointer hover:bg-[#2f2f2f] py-1.5 w-8 flex justify-center">
                                <ChevronLeft className="h-5" color="#b7b7b7" />
                            </button>
                            <div className="h-6">
                                <Separator orientation="vertical" className="bg-[#0f0f0f]" />
                            </div>
                            <button className="cursor-pointer hover:bg-[#2f2f2f] py-1.5 w-8 flex justify-center rounded-r-sm">
                                <ChevronRight className="h-5" color="#b7b7b7" />
                            </button>
                        </div>
                    </div>

                    <div className="min-w-60 flex justify-center">
                        <div className="flex justify-center items-center bg-[#1f2020] rounded-sm">
                            <button
                                onClick={runCode}
                                disabled={isRunningPending}
                                title={user?.authenticated ? "Run" : "You need to log in to Run"}
                                className="hover:bg-[#2f2f2f] py-1.5 w-8 flex justify-center rounded-l-sm cursor-pointer"
                            >
                                {
                                    isRunningPending ?
                                        <LoaderCircle className="h-5 animate-spin" color="#b7b7b7" />
                                        :
                                        <Play className="h-5" color="#b7b7b7" fill="#b7b7b7" />
                                }
                            </button>
                            <div className="h-8">
                                <Separator orientation="vertical" className="bg-[#0f0f0f]" />
                            </div>
                            <button
                                onClick={submitCode}
                                disabled={isSubmissionPending}
                                title={user?.authenticated ? "Submit" : "You need to log in to Submit"}
                                className="cursor-pointer hover:bg-[#2f2f2f] py-1.5 px-2 flex justify-center rounded-r-sm gap-1"
                            >
                                {
                                    isSubmissionPending ?
                                        <LoaderCircle className="h-5 animate-spin" color="#28c244" />
                                        :
                                        <CloudUpload className="h-5" color="#28c244" />
                                }
                                <span className="text-[#28c244]">Submit</span>
                            </button>
                        </div>
                    </div>

                    <div className="min-w-60 flex justify-end">
                        <ProfileAndLogin />
                    </div>
                </nav>

                {(isLoadingProblem || isLoadingLanguage) ? <LoadingAnimation /> :
                    <div className="flex-1 overflow-hidden px-2 pb-2">
                        <ResizablePanelGroup direction="horizontal">

                            <ResizablePanel defaultSize={50} minSize={30}>
                                <div className="pr-[3px] h-full flex flex-col min-h-0">
                                    <div className="bg-[#1e1e1e] rounded-md h-full flex flex-col min-h-0">
                                        <div className="flex bg-[#262626] h-9 items-center justify-between px-2 rounded-t-md shrink-0">
                                            <div className="flex gap-0.5 items-center">
                                                <FileText color="#1990ff" className="h-4" />
                                                <span>Description</span>
                                            </div>
                                            <div className="flex items-center text-[#a8a8a8]">
                                                {
                                                    problem?.solved ? (
                                                        <>
                                                            <span>Solved</span>
                                                            <CircleCheckBig className="h-4" color="#28c244" />
                                                        </>
                                                    ) : problem?.attempted ? (
                                                        <>
                                                            <span>Attempted</span>
                                                            <CircleEllipsis className="h-4" color="#ffb700" />
                                                        </>
                                                    ) : <></>
                                                }
                                            </div>
                                        </div>
                                        <div className="flex-1 overflow-y-auto p-5 custom-scrollbar mb-2">
                                            <Markdown
                                                components={{
                                                    h1: (props) => <h1 className="text-2xl" {...props} />,
                                                    h2: (props) => <h2 className="text-base mt-8 mb-4" {...props} />,
                                                    p: (props) => <p className="py-2 font-[400]" {...props} />,
                                                    img: (props) => <img className="my-4" {...props} />,
                                                    strong: (props) => <strong className="font-[500]" {...props} />,
                                                    code: (props) => <code className="bg-[#333] px-1 py-0.5 rounded-sm" {...props} />,
                                                    ul: (props) => <ul className="border-l-2 border-[#444] pl-4" {...props} />,
                                                    li: (props) => <li className="my-1" {...props} />,
                                                }}
                                            >
                                                {problem?.description}
                                            </Markdown>
                                        </div>
                                    </div>
                                </div>
                            </ResizablePanel>

                            <ResizableHandle className="bg-[#0f0f0f] w-[2px] hover:bg-[#1990ff] rounded-md" />

                            <ResizablePanel defaultSize={50} minSize={40}>

                                <ResizablePanelGroup direction="vertical">

                                    <ResizablePanel defaultSize={70} minSize={30}>
                                        <div className="pl-[3px] pb-[3px] h-full flex flex-col min-h-0">
                                            <div className="bg-[#1e1e1e] rounded-md h-full flex flex-col min-h-0">
                                                <div className="flex bg-[#262626] h-9 items-center px-2 rounded-t-md gap-0.5 shrink-0">
                                                    <CodeXml color="#28c244" className="h-4" />
                                                    <span>Code</span>
                                                </div>
                                                <div className="h-8 border-b border-[#262626] flex justify-between px-4 shrink-0">
                                                    <div className="flex items-center">
                                                        <Popover open={open} onOpenChange={setOpen}>
                                                            <PopoverTrigger asChild>
                                                                <button
                                                                    role="combobox"
                                                                    aria-expanded={open}
                                                                    className="min-w-20 flex bg-[#1e1e1e] text-[#ffffff99] justify-between items-center gap-0.5 p-0 cursor-pointer hover:bg-[#2f2f2f] py-0.5 px-3 rounded-sm font-[400]"
                                                                >
                                                                    {selectedLang?.name}
                                                                    <ChevronDown className="h-4 w-4" color="#ffffff99" />
                                                                </button>
                                                            </PopoverTrigger>
                                                            <PopoverContent className="p-0 bg-[#262626] border-[#333] w-auto min-w-fit max-w-max">
                                                                <Command className="bg-[#262626] text-[#ffffff99]">
                                                                    <CommandList>
                                                                        <CommandGroup>
                                                                            {languages?.map((lang) => (
                                                                                <CommandItem
                                                                                    key={lang.id}
                                                                                    className="px-3 py-1.5 cursor-pointer !text-[#ffffff99] !bg-[#262626] hover:!bg-[#444] hover:!text-[#ffffff99]"
                                                                                    onSelect={() => {
                                                                                        setDefaultLanguage(lang);
                                                                                        setOpen(false);
                                                                                    }}
                                                                                >
                                                                                    <Check
                                                                                        className={`${selectedLang?.id === lang.id ? "opacity-100" : "opacity-0"}`}
                                                                                        color="#ffffff99"
                                                                                    />
                                                                                    {lang.name}
                                                                                </CommandItem>
                                                                            ))}
                                                                        </CommandGroup>
                                                                    </CommandList>
                                                                </Command>
                                                            </PopoverContent>
                                                        </Popover>
                                                    </div>
                                                    <div className="flex gap-4 items-center">
                                                        <button className="cursor-pointer hover:bg-[#2f2f2f] h-6 w-6 flex justify-center items-center rounded-sm" title="Retrieve last submitted code">
                                                            <Braces className="h-4 w-4" color="#777" />
                                                        </button>
                                                        <button className="cursor-pointer hover:bg-[#2f2f2f] h-6 w-6 flex justify-center items-center rounded-sm" title="Reset to default code definition">
                                                            <RotateCcw className="h-4 w-4" color="#777" />
                                                        </button>
                                                    </div>
                                                </div>
                                                <div className="flex-grow min-h-0 p-1">
                                                    <Editor
                                                        language={selectedLang?.name.toLowerCase() || undefined}
                                                        value={editorCode ?? ""}
                                                        onChange={handleEditorChange}
                                                        theme="vs-dark"
                                                        options={{
                                                            minimap: { enabled: false },
                                                            wordWrap: "on",
                                                            tabSize: 4,
                                                            insertSpaces: true,
                                                            detectIndentation: false,
                                                            formatOnPaste: true,
                                                            formatOnType: true
                                                        }}
                                                    />
                                                </div>
                                                {!user?.authenticated && <div className="bg-[#21374d] rounded-b-md h-8 shrink-0 flex items-center px-6">
                                                    <span>You need to</span>
                                                    <a className="mx-1 text-[#94c5f6] hover:underline" href={`http://localhost:8081/api/auth/login/oauth2?redirect=${encodeURIComponent(window.location.pathname)}`}>log in</a>
                                                    <span>to run or submit</span>
                                                </div>}
                                            </div>
                                        </div>
                                    </ResizablePanel>

                                    <ResizableHandle className="bg-[#0f0f0f] !h-[2px] hover:bg-[#1990ff] rounded-md" />

                                    <ResizablePanel defaultSize={30} minSize={10}>
                                        <div className="pl-[3px] pt-[3px] h-full flex flex-col min-h-0">
                                            <div className="bg-[#1e1e1e] rounded-md h-full flex flex-col min-h-0">
                                                <div className="flex bg-[#262626] h-9 items-center justify-between px-2 rounded-t-md shrink-0">
                                                    <div className="flex gap-0.5 items-center">
                                                        <SquareCheck color="#28c244" className="h-4" />
                                                        <span>Test Results</span>
                                                    </div>
                                                    <div className="flex items-center">
                                                        {
                                                            runCodeResult ?
                                                                runCodeResult.overallResult === "pass" ?
                                                                    <>
                                                                        <Check className="h-4" color="#28c244" />
                                                                        <span>Pass</span>
                                                                    </> : <>
                                                                        <X className="h-4" color="#ef4743" />
                                                                        <span>Fail</span>
                                                                    </>
                                                                : <></>
                                                        }
                                                    </div>
                                                </div>
                                                <div className="flex-1 overflow-y-auto p-5 custom-scrollbar mb-2">
                                                    {!runCodeResult && !submitCodeResult && <div className="text-[#626265] font-[400] flex justify-center items-center h-full">
                                                        You must run your code first
                                                    </div>}
                                                    {(runCodeResult?.testcases || submitCodeResult?.testcases) &&
                                                        <>
                                                            {
                                                                (runCodeResult?.testcases ?? submitCodeResult?.testcases ?? []).map((testcase, index) => (
                                                                    <div key={index} className="pb-8">
                                                                        <div className="flex items-center justify-between mb-4">
                                                                            <span className="bg-[#2f2f2f] px-4 py-1 rounded-md">Case {index + 1}</span>
                                                                            <span className={`text-[12px] ${testcase.result === "pass" ? "text-[#28c244]" : "text-[#ef4743]"}`}>{toTitleCase(testcase.result)}</span>
                                                                        </div>
                                                                        <div className="flex flex-col gap-2 ml-4">
                                                                            <p className="flex flex-col gap-1">
                                                                                <span className="text-[12px] text-[#b4b4b4]">Input:</span>
                                                                                <span className="font-mono bg-[#333] px-4 py-2 rounded-md">{testcase.input}</span>
                                                                            </p>
                                                                            <p className="flex flex-col gap-1">
                                                                                <span className="text-[12px] text-[#b4b4b4]">Expected output:</span>
                                                                                <span className="font-mono bg-[#333] px-4 py-2 rounded-md">{testcase.expectedOutput}</span>
                                                                            </p>
                                                                            <p className="flex flex-col gap-1">
                                                                                <span className="text-[12px] text-[#b4b4b4]">Output:</span>
                                                                                <span className="font-mono bg-[#333] px-4 py-2 rounded-md">{testcase.actualOutput || "No output"}</span>
                                                                            </p>
                                                                        </div>
                                                                    </div>
                                                                ))
                                                            }
                                                        </>
                                                    }
                                                </div>
                                            </div>
                                        </div>
                                    </ResizablePanel>

                                </ResizablePanelGroup>

                            </ResizablePanel>

                        </ResizablePanelGroup>
                    </div>
                }

            </div>
        </>
    )
}
