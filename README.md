# UI и API тестирование веб-приложения банка

## **Использованный стек**
* Java 8
* JUnit 4
* Selenium
* Selenide
* Rest Assured
* Allure

## Описание

Протестировать онлайн банк https://parabank.parasoft.com/parabank/index.htm
Описание REST API https://parabank.parasoft.com/parabank/api-docs/index.html#/

Регистрация
- проверить успешную регистрацию

Вход в акаунт
- проверить вход по кнопке "Log in" на главной странице под существующей учетной записью

Выход из аккаунта
- проверить выход по кнопке "Log out"

API тесты
- залогинить клиента
- получить данные клиента по клиентскому id
- получить данные счета клиента по клиентскому id

## Инструкция

Запустить тесты в папке test

Отчет Allure в папке target/allure-results