# Overview

Emlak uygulamasınında kullanıcılar, bu sistem üzerinden ilan oluşturabilir, düzenleyebilir, silebilir ve detaylarına
ulaşabilir. Kendi ilanlarını aktif ve pasif duruma getirebilir ve paket satın alıp kendi ilanları için kullanabilir.
Proje Mimarisi 4 Mikroservis ve bir Discovery(Eureka) Servisten oluşmaktadır. Veritabanı olarak Postgresql
kullanılmıştır. Ödeme akışlarını asenkron ve sıralı bir hale getirebilmek adına ise RabbitMQ kullanılmıştır.

# Services

-Discovery Service (Eureka Service) => http://localhost:8761/

-Advertisement Service => http://localhost:8093/swagger-ui/index.html#/

-Payment Service => http://localhost:8055/swagger-ui/index.html#/

-Product Service => http://localhost:8092/swagger-ui/index.html#/

-User Service => http://localhost:8091/swagger-ui/index.html#/

## What technologies did we try to use?

- Java 8

- JUnit 5

- Spring Boot

- Restfull

- Postgre

- RabbitMQ

- Microservice Mimarisi

## Documentation

- UML Diagram
- Swagger
- Readme

**Eureka**
![Eureka](https://github.com/user-attachments/assets/989ff9e3-927b-42d1-8033-56d12aa68549)

**RabbitMQ**
![RabbitMQ](https://github.com/user-attachments/assets/dc6b8def-0ba4-4dee-84b7-15825d231f73)

**Swagger**
![Swagger](https://github.com/user-attachments/assets/5e2f2bf7-0cd6-494e-8f98-4da73e5b1109)

**ProductDB**
![ProductDB](https://github.com/user-attachments/assets/c8f08952-8b93-4514-9e8d-af1651969936)

