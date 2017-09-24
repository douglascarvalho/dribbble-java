# Dribbble Java

**dribbble-java** foi desenvolvido para um teste usando SpringBoot e AngularJS 4. A aplicação visa acessar coleções de imagens do site [Dribbble](https://dribbble.com/shots) através da [Dribble API](http://developer.dribbble.com/v1/), mostrar essas imagens e criar uma lista personalizada de imagens favoritas.

## Tecnologias
* **spring-boot** - utilizando os módulos spring-boot-starter-data-jpa para persistencia com hibernate e spring-boot-starter-web para criar RESTful Web Service.
* **h2database** - base de dados em memória.
* **angular-js 4.2.4** - tecnologia para desenvolver o front-end.
* **bootstrap 4** - componentes responsivos.
* **npm** - gerenciador de dependencias do front-end.
* **maven** - gerenciador de dependencias para o backend. 


## Para iniciar o backend (maven)
Acesse a pasta backend e rode os seguinte comando:
```
$ mvn spring-boot:run
```

## Para iniciar o frontend (angular/cli)
Acesse a pasta frontend e rode os seguinte comando:
```
$ ng serve
```
e acesse:
```
$ localhost:4200
```
