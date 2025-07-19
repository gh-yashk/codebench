import { Command, CommandGroup, CommandItem, CommandList } from "@/components/ui/command";
import { Popover, PopoverContent, PopoverTrigger } from "@/components/ui/popover";
import { useAllProblemSummaries } from "@/hooks/useProblemHooks";
import { ArrowDownNarrowWide, ArrowDownWideNarrow, ArrowUpDown, Check, ChevronDown, CircleCheckBig, CircleEllipsis, Funnel } from "lucide-react";
import { useMemo, useState } from "react";
import LoadingAnimation from "./Loading";

const getDifficultyClass = (difficulty: string): string => {
    switch (difficulty.toUpperCase()) {
        case "EASY":
            return "text-[#1cbaba]";
        case "MEDIUM":
            return "text-[#ffb700]";
        case "HARD":
            return "text-[#f63737]";
        default:
            return "text-gray-400";
    }
};

const capitalize = (s: string) => s.charAt(0).toUpperCase() + s.slice(1).toLowerCase();

type SortState = null | "asc" | "desc";

export default function ProblemList() {
    const { data: problems, isLoading, isError, error } = useAllProblemSummaries();

    const [difficultyFilter, setDifficultyFilter] = useState<string>("ALL");
    const [statusFilter, setStatusFilter] = useState<string>("ALL");
    const [difficultySort, setDifficultySort] = useState<SortState>(null);
    const [difficultyOpen, setDifficultyOpen] = useState(false);
    const [statusOpen, setStatusOpen] = useState(false);

    const handleSortToggle = () => {
        setDifficultySort((prev) =>
            prev === null ? "asc" : prev === "asc" ? "desc" : null
        );
    };

    const filteredProblems = useMemo(() => {
        if (!problems) return [];

        return problems
            .filter((p) =>
                difficultyFilter === "ALL" ? true : p.difficulty.toUpperCase() === difficultyFilter.toUpperCase()
            )
            .filter((p) => {
                switch (statusFilter) {
                    case "ALL":
                        return true;
                    case "SOLVED":
                        return p.solved;
                    case "UNSOLVED":
                        return !p.solved;
                    case "ATTEMPTED":
                        return p.attempted;
                    default:
                        return true;
                }
            });
    }, [problems, difficultyFilter, statusFilter]);

    const sortedProblems = useMemo(() => {
        const order = { EASY: 1, MEDIUM: 2, HARD: 3 };
        if (!filteredProblems) return [];

        if (difficultySort === null) return filteredProblems;

        return [...filteredProblems].sort((a, b) => {
            const aRank = order[a.difficulty.toUpperCase() as keyof typeof order] ?? 0;
            const bRank = order[b.difficulty.toUpperCase() as keyof typeof order] ?? 0;
            return difficultySort === "asc" ? aRank - bRank : bRank - aRank;
        });
    }, [filteredProblems, difficultySort]);

    if (isLoading) return <LoadingAnimation />;
    if (isError) return <div className="p-4 text-red-500">Error: {error.message}</div>;

    return (
        <section className="py-6">

            {/* Controls */}
            <div className="mb-4 flex flex-wrap items-center gap-4">

                {/* Difficulty Filter */}
                <Popover open={difficultyOpen} onOpenChange={setDifficultyOpen}>
                    <PopoverTrigger asChild>
                        <button
                            role="combobox"
                            aria-expanded={difficultyOpen}
                            className={`flex w-32 justify-between bg-[#272727] items-center gap-1 mx-1 cursor-pointer py-2 px-4 rounded-full ${difficultyFilter === "ALL" ? "" : "text-[#1a90ff]"}`}
                        >
                            <Funnel size={16} />
                            <span>{capitalize(difficultyFilter)}</span>
                            <ChevronDown className="h-4 w-4" />
                        </button>
                    </PopoverTrigger>
                    <PopoverContent className="p-0 bg-[#272727] border-0 w-auto">
                        <Command className="bg-[#272727]">
                            <CommandList>
                                <CommandGroup>
                                    {["ALL", "EASY", "MEDIUM", "HARD"].map((option) => (
                                        <CommandItem
                                            key={option}
                                            className="px-3 py-1.5 cursor-pointer !text-[#f5f5f5] !bg-[#272727] hover:!bg-[#333]"
                                            onSelect={() => {
                                                setDifficultyFilter(option);
                                                setDifficultyOpen(false);
                                            }}
                                        >
                                            <Check className={`${difficultyFilter === option ? "opacity-100" : "opacity-0"} mr-2`} color="#ffffff99" />
                                            {capitalize(option)}
                                        </CommandItem>
                                    ))}
                                </CommandGroup>
                            </CommandList>
                        </Command>
                    </PopoverContent>
                </Popover>

                {/* Status Filter */}
                <Popover open={statusOpen} onOpenChange={setStatusOpen}>
                    <PopoverTrigger asChild>
                        <button
                            role="combobox"
                            aria-expanded={statusOpen}
                            className={`flex w-36 justify-between bg-[#272727] items-center gap-1 mx-1 cursor-pointer py-2 px-4 rounded-full ${statusFilter === "ALL" ? "" : "text-[#1a90ff]"}`}
                        >
                            <Funnel size={16} />
                            <span>{capitalize(statusFilter)}</span>
                            <ChevronDown className="h-4 w-4" />
                        </button>
                    </PopoverTrigger>
                    <PopoverContent className="p-0 bg-[#272727] border-0 w-auto">
                        <Command className="bg-[#272727]">
                            <CommandList>
                                <CommandGroup>
                                    {["ALL", "SOLVED", "UNSOLVED", "ATTEMPTED"].map((option) => (
                                        <CommandItem
                                            key={option}
                                            className="px-3 py-1.5 cursor-pointer !text-[#f5f5f5] !bg-[#272727] hover:!bg-[#333]"
                                            onSelect={() => {
                                                setStatusFilter(option);
                                                setStatusOpen(false);
                                            }}
                                        >
                                            <Check className={`${statusFilter === option ? "opacity-100" : "opacity-0"} mr-2`} color="#ffffff99" />
                                            {capitalize(option)}
                                        </CommandItem>
                                    ))}
                                </CommandGroup>
                            </CommandList>
                        </Command>
                    </PopoverContent>
                </Popover>

                {/* Sort Button */}
                <button
                    onClick={handleSortToggle}
                    className="flex items-center gap-2 mx-1 px-4 py-2 rounded-full bg-[#272727] cursor-pointer"
                >
                    {difficultySort === null && (<ArrowUpDown size={16} className="text-[#f5f5f5]" />)}
                    {difficultySort === "asc" && (<ArrowDownNarrowWide size={16} className="text-[#1a90ff]" />)}
                    {difficultySort === "desc" && (<ArrowDownWideNarrow size={16} className="text-[#1a90ff]" />)}
                    <span className={difficultySort === null ? "" : "text-[#1a90ff]"}>Difficulty</span>
                </button>
            </div>

            {/* Table */}
            <table className="w-full border-collapse">
                <tbody>
                    {sortedProblems.map((p, index) => (
                        <tr
                            key={p.id}
                            onClick={() => (window.location.href = `/problems/${p.slug}`)}
                            className={`cursor-pointer ${index % 2 === 0 ? "bg-[#272727]" : "bg-[#1a1a1a]"} rounded-lg`}
                        >
                            <td className="px-4 py-3 rounded-l-lg">
                                <div className="flex items-center">
                                    {
                                        p.solved ? (
                                            <>
                                                <CircleCheckBig className="h-4 w-4 mr-4" color="#28c244" />
                                            </>
                                        ) : p.attempted ? (
                                            <>
                                                <CircleEllipsis className="h-4 w-4 mr-4" color="#ffb700" />
                                            </>
                                        ) : <><div className="h-4 w-4 mr-4"></div></>
                                    } <div className="w-6 text-right mr-4">{p.id}.</div>{p.title}
                                </div>
                            </td>
                            <td className={`px-4 py-3 rounded-r-lg text-center ${getDifficultyClass(p.difficulty)}`}>
                                {capitalize(p.difficulty)}
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </section>
    );
}
