import { apiClient } from "@/lib/api";
import type { UserInfo } from "@/types/api";

export const fetchUserInfo = (): Promise<UserInfo> => {
    return apiClient<UserInfo>('/users/me');
};