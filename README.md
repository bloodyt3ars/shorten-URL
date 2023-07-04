# Shorten-URL
## Оглавление
* ### [Описание проекта](#defenition)
* ### [Введение](#introduction)
* ### [Функции](#mainfunctions)
* ### [Используемые технологии](#technologies)
* ### [Структура проекта](#structure)
* ### [Запуск проекта](#setup)
* ### [Применение](#usage)
* ### [Документация API](#api)

## Описание проекта <a name="defenition"></a>
Это проект, который позволяет укорачивать ссылки. Он предоставляет функциональность для создания коротких токенов из длинных URL-адресов, а также обратное преобразование, позволяющее перенаправлять пользователей на исходные URL-адреса.

## Введение <a name="introduction"></a>
Проект представляет собой веб-приложение, разработанное на основе Java и Spring Framework. Он использует базу данных для хранения информации о созданных токенах и соответствующих URL-адресах.

## Функции <a name="mainfunctions"></a>
Основные функции проекта включают:

* Сокращение длинных URL-адресов.
* Создание уникальных коротких токенов для каждого URL-адреса.
* Проверка и удаление истекших токенов.
* Перенаправление пользователей на исходные URL-адреса с использованием коротких токенов.

## Используемые технологии <a name="technologies"></a>
Проект использует следующие технологии:

* Java - основной язык программирования.
* Spring Framework - для разработки веб-приложения и управления зависимостями.
* Spring Boot - для автоматической конфигурации приложения и удобного развертывания.
* Spring Data JPA - для взаимодействия с базой данных.
* Swagger - для генерации документации API.
* PostgreSQL - база данных для хранения информации о токенах и URL-адресах.

## Структура проекта <a name="structure"></a>
```linux
C:.
├───java
│   └───com
│       └───example
│           └───shorten_url
│               │   ShortenUrlApplication.java
│               │
│               ├───component
│               │       TokenExpirationChecker.java
│               │       Tokenizer.java
│               │       UrlShortenerService.java
│               │
│               ├───controller
│               │       UrlShortenerController.java
│               │
│               ├───model
│               │       Url.java
│               │
│               ├───repository
│               │       UrlRepository.java
│               │
│               └───swagger
│                       OpenApiConfig.java
│
└───resources
        application.properties
```

### Структура проекта состоит из следующих основных каталогов и файлов:


* component: содержит компоненты, такие как проверка истечения срока действия токенов и генератор токенов.
* controller: содержит контроллеры, отвечающие за обработку HTTP-запросов.
* model: содержит модели данных, такие как класс Url.
* repository: содержит репозитории, используемые для доступа к данным в базе данных.
* swagger: содержит класс OpenApiConfig, определяющий конфигурацию Swagger.
* resources: содержит файлы конфигурации и ресурсы проекта.


## Настройка и установка <a name="setup"></a>
Для настройки и установки проекта, выполните следующие шаги:

* Убедитесь, что у вас установлена Java Development Kit (JDK).
* Склонируйте репозиторий проекта на свой локальный компьютер.
* Откройте проект в вашей среде разработки (например, IntelliJ IDEA или Eclipse).
* Установите все зависимости проекта, указанные в файле pom.xml.
* Создайте базу данных PostgreSQL и настройте соответствующие параметры в файле application.properties.
* Запустите приложение.


### Или

* Склонируйте репозиторий проекта на свой локальный компьютер.
* Установите docker.
* Введите в терминале в корневой папке команду:
```linux
docker-compose up
```
## Применение  <a name="usage"></a>
После успешной установки и запуска проекта, вы можете использовать его для сокращения URL-адресов и перенаправления пользователей.

* Для создания короткого токена для длинного URL-адреса, отправьте POST-запрос на
```
/api/v1/urls
```
с передачей длинного URL-адреса в теле запроса. Получите короткий токен в ответе на запрос.


* Для перенаправления пользователя на исходный URL-адрес, отправьте GET-запрос на
```
/api/v1/urls/{token}
```
, где {token} - это короткий токен. Пользователь будет перенаправлен на исходный URL-адрес.
## Документация API <a name="api"></a>
Для получения документации по API приложения необходимо запустить приложение и перейти по адресу http://localhost:8080/swagger-ui.html.


Или в файле openapi.yaml и вставив все по ссылке: https://editor.swagger.io/


В Swagger документации описаны все доступные запросы и ответы на них.

