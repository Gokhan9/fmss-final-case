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



