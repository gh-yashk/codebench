import type { Language } from "@/types/api";
import { create } from "zustand";
import { persist } from "zustand/middleware";

interface CodeState {
    defaultLanguage: Language | null;
    codeMap: Record<string, string>; // key: `${problemId}-${languageId}`
    setDefaultLanguage: (language: Language) => void;
    setCode: (problemId: number, languageId: number, code: string) => void;
    getCode: (problemId: number, languageId: number) => string | undefined;
}

export const useCodeStore = create(
    persist<CodeState>(
        (set, get) => ({
            defaultLanguage: null,
            codeMap: {},

            setDefaultLanguage: (language) => {
                set({ defaultLanguage: language });
            },

            setCode: (problemId, languageId, code) => {
                const key = `${problemId}-${languageId}`;
                set((state) => ({
                    codeMap: { ...state.codeMap, [key]: code },
                }));
            },

            getCode: (problemId, languageId) => {
                const key = `${problemId}-${languageId}`;
                return get().codeMap[key];
            },
        }),
        {
            name: "code-storage"
        }
    )
);
