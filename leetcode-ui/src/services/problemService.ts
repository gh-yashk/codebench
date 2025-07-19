import { apiClient } from "@/lib/api";
import type { ProblemDetail, ProblemSummary } from "@/types/api";

export const fetchAllProblemSummaries = (): Promise<ProblemSummary[]> => {
    return apiClient<ProblemSummary[]>('/problems');
};

export const fetchProblemDetail = (slug: string): Promise<ProblemDetail> => {
    if (!slug) throw new Error('Problem slug is required.');
    return apiClient<ProblemDetail>(`/problems/${slug}`);
};
