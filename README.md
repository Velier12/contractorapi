# Contractor API

Contractor API - это Spring Boot REST API для работы с контрагентами финтех приложения. API предоставляет возможность сохранять, получать и логически удалять данные контрагентов, стран, промышленностей и организационных форм.

## Контроллеры

### Org-Form Controller

- **PUT /org-form/save**
    - Сохранение организационной формы

- **GET /org-form/{id}**
    - Получение организационной формы по id

- **GET /org-form/all**
    - Вывод всех активных организационных форм

- **DELETE /org-form/delete/{id}**
    - Логическое удаление организационной формы

### Industry Controller

- **PUT /industry/save**
    - Сохранение промышленности

- **GET /industry/{id}**
    - Получение промышленности по id

- **GET /industry/all**
    - Вывод всех активных промышленностей

- **DELETE /industry/delete/{id}**
    - Логическое удаление промышленности

### Country Controller

- **PUT /country/save**
    - Сохранение страны

- **GET /country/{id}**
    - Получение страны по id

- **GET /country/all**
    - Вывод всех активных стран

- **DELETE /country/delete/{id}**
    - Логическое удаление страны

### Contractor Controller

- **PUT /contractor/save**
    - Сохранение контрагента

- **GET /contractor/{id}**
    - Получение контрагента по id

- **GET /contractor/all**
    - Вывод всех активных контрагентов

- **DELETE /contractor/delete/{id}**
    - Логическое удаление контрагента по id

## Настройка и запуск проекта

### Системные требования

- Java 22.0.1
- Maven

### Установка

1. Клонируйте репозиторий
   ```sh
   git clone https://github.com/Velier12/contractorapi

2. Перейдите в директорию проекта

    ```sh
   cd contractorapi
   
3. Установите зависимости

    ```sh
    mvn install
   
### Запуск приложения

1. Соберите проект 

    ```sh
    mvn clean package
   
2. Запустите приложение

    ```sh
    java -jar target/contractorapi-0.0.1-SNAPSHOT.jar

### Использование

Для взаимодействия с API используйте инструменты, такие как Postman или curl.
Так же можно перести по адресу http://{host}:{port}/swagger-ui/index.html и работать с api напрямую