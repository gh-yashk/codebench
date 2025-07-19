export interface ProblemSummary {
    id: number;
    title: string;
    slug: string;
    difficulty: string;
    solved: boolean;
    attempted: boolean;
}

export interface ProblemDetail extends ProblemSummary {
    description: string;
}

export interface Language {
    id: number;
    name: string;
}

export interface UserInfo {
    authenticated: boolean;
    username: string;
    email: string;
    avatarUrl: string;
}

export interface CodeSnippet {
    problemId: number;
    languageId: number;
    starterCode: string;
}

export interface CodeSubmissionRequest {
    problemId: number;
    languageId: number;
    userCode: string;
}

export interface TestcaseResult {
    input: string;
    expectedOutput: string;
    actualOutput: string;
    status: string;
    result: string;
    errorMessage: string;
}

export interface CodeExecutionResult {
    nTestcases: number;
    overallResult: string;
    testcases: TestcaseResult[];
}