import { apiClient } from "@/lib/api";
import type { CodeExecutionResult, CodeSubmissionRequest } from "@/types/api";

export const runCode = (submission: CodeSubmissionRequest): Promise<CodeExecutionResult> => {
    return apiClient<CodeExecutionResult>('/codes/run', {
        method: 'POST',
        body: JSON.stringify(submission),
    });
};

export const submitCode = (submission: CodeSubmissionRequest): Promise<CodeExecutionResult> => {
    return apiClient<CodeExecutionResult>('/codes/submit', {
        method: 'POST',
        body: JSON.stringify(submission),
    });
};
