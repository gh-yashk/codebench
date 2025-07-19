import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import { Navigate, Route, Routes } from "react-router-dom";
import ProblemDetail from "./pages/ProblemDetail";
import ProblemHome from "./pages/ProblemHome";
import NotFound from "./pages/NotFoundPage";

const queryClient = new QueryClient();

export default function App() {
    return (
        <QueryClientProvider client={queryClient}>
            <Routes>
                <Route path="/" element={<Navigate to="/problemset/" />} />
                <Route path="/problems" element={<Navigate to="/problemset/" />} />
                <Route path="/problemset/" element={<ProblemHome />} />
                <Route path="/problems/:slug" element={<ProblemDetail />} />
                <Route path="*" element={<NotFound />} />
            </Routes>

            {/* Optional: Devtools */}
            {/* <ReactQueryDevtools initialIsOpen={false} /> */}
        </QueryClientProvider>
    );
}