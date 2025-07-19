import { fetchStarterCode } from "@/services";
import type { CodeSnippet } from "@/types/api";
import { useQuery } from "@tanstack/react-query";

export const useStarterCode = (problemId?: number, languageId?: number) =>
    useQuery<CodeSnippet, Error>({
        queryKey: ['starterCode', problemId, languageId],
        queryFn: () => fetchStarterCode(problemId!, languageId!),
        enabled: !!problemId && !!languageId,
        staleTime: 60 * 60 * 1000,
    });
