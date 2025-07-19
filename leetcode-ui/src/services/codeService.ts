import { apiClient } from "@/lib/api";
import type { CodeSnippet } from "@/types/api";

export const fetchStarterCode = (problemId: number, languageId: number): Promise<CodeSnippet> => {
    if (!problemId || !languageId) {
        throw new Error('problemId and languageId are required.');
    }
    return apiClient<CodeSnippet>(`/codes?problemId=${problemId}&languageId=${languageId}`);
};
