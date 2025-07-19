import { runCode, submitCode } from "@/services";
import type { CodeExecutionResult, CodeSubmissionRequest } from "@/types/api";
import { useMutation } from "@tanstack/react-query";

export const useRunCode = () => {
    return useMutation<CodeExecutionResult, Error, CodeSubmissionRequest>({
        mutationFn: runCode,
    });
};

export const useSubmitCode = () => {
    return useMutation<CodeExecutionResult, Error, CodeSubmissionRequest>({
        mutationFn: submitCode,
    });
};
