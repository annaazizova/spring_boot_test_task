[![Build Status](https://travis-ci.org/annaazizova/spring-boot-test-task-back.svg?branch=master)](https://travis-ci.org/annaazizova/spring-boot-test-task-back) [![codecov](https://codecov.io/gh/annaazizova/spring-boot-test-task-back/branch/master/graph/badge.svg)](https://codecov.io/gh/annaazizova/spring-boot-test-task-back)

This project is simple inventory system with different available functionality depending on user's role (User or Admin).

## Tech/framework used

<ul>
  <li>Java 8</li>
  <li>Spring Boot 2</li>
  <li>Basic auth</li>
  <li>JWT (<a href="https://github.com/annaazizova/spring-boot-test-task-back/tree/feat/jwt">feat/jwt branch</a>)</li>
  <li>H2</li>
  <li>Siren4J</li>
  <li>Lombok</li>
  <li>Swagger2</li>
</ul>

**Built with
[Maven](https://maven.apache.org/), JaCoCo, Travis CI, Checkstyle**

## Features

User is able to
<ul>
  <li>get all products or one of them (but only Admin can create, update or delete product)</li>
  <li>see all leftovers</li>
  <li>export search result in an xlsx file</li>
  <li>healthcheck on <a href="http://localhost:8080/healthcheck">http://localhost:8080/healthcheck</a> (available without authorization)</li>
  <li>api documentation and testing on <a href="http://localhost:8080/swagger-ui.html">http://localhost:8080/swagger-ui.html</a></li>
</ul>

## How to use?

Run maven app with `spring-boot:run` command on [http://localhost:8080](http://localhost:8080), main branch is [master](https://github.com/annaazizova/spring_boot_test_task_back). Login page is [http://localhost:8080/login](http://localhost:8080/login), after successful auth redirect to all products info. Go to [http://localhost:8080/logout](http://localhost:8080/logout) to logout.

**Login/password**

**Role User: user/password**

**Role Admin: admin/admin**
