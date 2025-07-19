import { fetchAllProblemSummaries, fetchProblemDetail } from "@/services";
import type { ProblemDetail, ProblemSummary } from "@/types/api";
import { useQuery } from "@tanstack/react-query";

export const useAllProblemSummaries = () =>
    useQuery<ProblemSummary[], Error>({
        queryKey: ['problems'],
        queryFn: fetchAllProblemSummaries,
        // staleTime: 5 * 60 * 1000,
    });

export const useProblemDetail = (slug?: string) =>
    useQuery<ProblemDetail, Error>({
        queryKey: ['problem', slug ?? ''],
        queryFn: () => fetchProblemDetail(slug!),
        enabled: !!slug,
        // staleTime: 5 * 60 * 1000,
    });
