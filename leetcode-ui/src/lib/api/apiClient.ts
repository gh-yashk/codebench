export async function apiClient<T>(endpoint: string, options?: RequestInit): Promise<T> {
    const baseURL = 'http://localhost:8081/api';
    const url = `${baseURL}${endpoint}`;

    const config: RequestInit = {
        ...options,
        headers: {
            'Content-Type': 'application/json',
            ...options?.headers,
        },
        credentials: 'include',
    };

    try {
        const response = await fetch(url, config);

        if (!response.ok) {
            let message = `HTTP error! Status: ${response.status}`;
            try {
                const errorData = await response.json();
                message = errorData?.message || JSON.stringify(errorData);
            } catch {
                message = response.statusText || message;
            }
            throw new Error(message);
        }

        const text = await response.text();
        return text ? (JSON.parse(text) as T) : ({} as T);
    } catch (error) {
        const errMsg =
            error instanceof Error
                ? error.message
                : 'An unknown error occurred during API call.';
        console.error('API client error:', errMsg);
        throw new Error(errMsg);
    }
}
