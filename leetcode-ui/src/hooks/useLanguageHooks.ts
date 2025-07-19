import { fetchAllLanguages } from "@/services";
import type { Language } from "@/types/api";
import { useQuery } from "@tanstack/react-query";

export const useAllLanguages = () =>
    useQuery<Language[], Error>({
        queryKey: ['languages'],
        queryFn: fetchAllLanguages,
        staleTime: 24 * 60 * 60 * 1000, // 24h
    });
