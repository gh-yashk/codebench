import { fetchUserInfo } from "@/services";
import type { UserInfo } from "@/types/api";
import { useQuery } from "@tanstack/react-query";

export const useUserInfo = () =>
    useQuery<UserInfo, Error>({
        queryKey: ['userInfo'],
        queryFn: fetchUserInfo,
        staleTime: 1000 * 60 * 60 * 24, // 24 hour
    });
