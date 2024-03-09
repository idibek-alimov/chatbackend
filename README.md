# Chat backend-приложения
Это бэкенд приложения чата, созданный с использованием Spring Boot, PostgreSQL и технологии Websocket.

## Возможности
1. Регистрация пользователей: Пользователи могут зарегистрировать аккаунт для доступа к чат-приложению.
2. Обмен сообщениями в реальном времени: Пользователи могут отправлять и получать текстовые сообщения в реальном времени.
3. Поддержка Docker: Проект включает файл docker-compose.yml для простого развертывания с помощью Docker.

## Используемые технологии
1. Spring Boot: Предоставляет надежный фреймворк для создания приложений на Java.
2. PostgreSQL: Используется в качестве системы управления базами данных для хранения данных пользователей и сообщений.
3. Websocket: Обеспечивает обмен данными в реальном времени между клиентами и сервером.
4. Docker: Позволяет легко развертывать и масштабировать приложение с использованием контейнеров.

## Установка
1. Клонируйте репозиторий:

```

git clone https://github.com/idibek-alimov/chatbackend.git
```
2. Перейдите в директорию проекта:

```
 
cd chatbackend
```
3. Соберите и запустите приложение с помощью Docker:

```

docker-compose up --build
```
Перейдите к приложению по адресу http://localhost:8080.

## Использование
1. Зарегистрируйте аккаунт в приложении.
2. Войдите с вашими учетными данными.
3. Начните отправлять сообщения другим зарегистрированным пользователям в реальном времени.
