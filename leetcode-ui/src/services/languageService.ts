import { apiClient } from "@/lib/api";
import type { Language } from "@/types/api";

export const fetchAllLanguages = (): Promise<Language[]> => {
    return apiClient<Language[]>('/languages');
};
