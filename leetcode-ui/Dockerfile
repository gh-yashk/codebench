# Stage 1 - Build
FROM node:18-alpine AS build
WORKDIR /app
COPY . .
RUN npm install && npm run build

# Stage 2 - Serve with nginx
FROM nginx:stable-alpine
COPY --from=build /app/dist /usr/share/nginx/html
COPY ./nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 3001
CMD ["nginx", "-g", "daemon off;"]
