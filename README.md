# CodeBench – Full-Stack Coding Practice Platform

**Live Demo:** https://codebench-demo.pages.dev/

A professional coding practice platform inspired by LeetCode, enabling real-time code execution and problem solving across multiple languages.

---

## Table of Contents

- [Live Demo](#live-demo)  
- [Project Structure](#project-structure)  
- [Features & Performance](#features--performance)  
- [Architecture Overview](#architecture-overview)  
- [Tech Stack](#tech-stack)  
- [Running Locally](#running-locally)  
- [Screenshots](#screenshots)  
- [Acknowledgements](#acknowledgements)  

---

## Live Demo

Try it now in your browser:  
https://codebench-demo.pages.dev/

---

## Project Structure

```
codebench/
├── rce/               # Backend (Spring Boot, MySQL, Judge0, GitHub OAuth2)
├── leetcode-ui/       # Frontend (React, Vite, TypeScript, Monaco Editor)
├── mysql-init/        # MySQL initialization scripts
├── docker-compose.yml # Service orchestration
└── README.md          # Project documentation
```

---

## Features & Performance

- **Fast Execution:** Sub-5 second code compilation and execution  
- **Multi-Language Support:** 10+ programming languages (Python, Java, JavaScript, TypeScript, etc.)  
- **Professional Editor:** Monaco Editor with syntax highlighting and IntelliSense  
- **Secure Authentication:** GitHub OAuth2 with server-side session management  
- **Real-Time Results:** Instant feedback and detailed test case outputs  
- **Containerized:** Docker Compose orchestration for reliable deployment  

---

## Architecture Overview

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│ React Frontend  │<──>│ Spring Boot API │<──>│   Judge0 API    │
│ (Vite + TS)     │    │ + MySQL         │    │ (Code Execution │
│ Monaco Editor   │    │ + OAuth2        │    │ & Compilation)  │
└─────────────────┘    └─────────────────┘    └─────────────────┘
```

- **Frontend:** React, Vite, TypeScript, Tailwind CSS, Monaco Editor  
- **Backend:** Spring Boot, Spring Security, GitHub OAuth2, MySQL  
- **Code Execution:** Judge0 API integration  
- **Deployment:** Docker Compose, environment-based configuration  

---

## Tech Stack

### Backend (`/rce`)

- Spring Boot (Java 21)  
- MySQL 8  
- Judge0 API  
- Spring Security + OAuth2 (GitHub)  

### Frontend (`/leetcode-ui`)

- React + Vite + TypeScript  
- Tailwind CSS  
- Monaco Editor  

### DevOps

- Docker + Docker Compose  
- MySQL initialization scripts  
- Environment variables via `.env`  

---

## Running Locally

Requires Docker and Docker Compose.

1. **Clone the repository**  
   ```bash
   git clone https://github.com/gh-yashk/codebench.git
   cd codebench
   ```

2. **Create `.env`**  
   ```ini
   # MySQL
   MYSQL_ROOT_PASSWORD=root

   # Spring Boot
   SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/rce_db?createDatabaseIfNotExist=true
   SPRING_DATASOURCE_USERNAME=root
   SPRING_DATASOURCE_PASSWORD=root
   FRONTEND_ORIGIN=http://localhost:3001

   # External APIs
   GITHUB_CLIENT_ID=your_client_id
   GITHUB_CLIENT_SECRET=your_client_secret
   JUDGE0_API_KEY=your_judge0_key
   ```

3. **Start services**  
   ```bash
   docker compose up --build
   ```

4. **Access the app**  
   - Frontend: http://localhost:3001  
   - Backend:  http://localhost:8081  

---

## Screenshots

![/problemset](./screenshots/Screenshot01.png)

![/problems/two-sum](./screenshots/Screenshot04.png)

> See more in [/screenshots](./screenshots/)

---

## Acknowledgements

- Judge0 API (https://judge0.com/)  
- Spring Boot (https://spring.io/)  
- Vite (https://vite.dev/)  
- Monaco Editor (https://www.npmjs.com/package/@monaco-editor/react)  
- Docker (https://www.docker.com/)  
- GitHub OAuth (https://docs.github.com/en/developers/apps/building-oauth-apps)
