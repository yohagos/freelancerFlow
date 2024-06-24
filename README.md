# freelancerFlow

Eine App zum Verwalten von Clients, Projekten und mehr für die tagtägliche Tätigkeit eines Freelancers.

## Backend

- Spring Boot with Hibernate & JPA
- PostgreSQL Database
- Authentication through Keycloak

## Frontend (github.com/yohagos/freelancerFlowNg)

- Angular v. 17
- Angular Material v. 17

## Architektur

Im Backend hatte ich mich für einen funktionsbasierten Ansatz entschieden, in denen ich alle Klassen für ihre jeweiligen Funktionen in die dazugehörigen Packages erstellt habe. Sprich, alle Datenmodelle (Entities) im Packages entities.
Anhand dieses Ansatzes, alle Controller in controllers und so weiter.

## Anpassungen in der Zukunft

Gegenwärtig funktioniert die Verbindung zwischen Datenbank und Keycloak, sodass alle Keycloak Informationen in der Datenbank gespeichert werden. Hierbei müssten gegebenenfalls weitere Tests erstellt werden und der Import von einer Konfiguration nachgebessert werden.

Async Prozesse können gerade aufgrund eines Issues nicht auf den SecurityContextHolder zugreifen und die Informationen für @CreatedBy beziehen.

Beim erstmaligen Start der Spring Boot App, werden trotz gelegentlichen Fehlermeldungen alle Entitäten erstellt, jedoch kann es sein, dass die Erzeugung der event_entity einen Fehler loggt da es die Id nicht als Integer speichern 'kann'. Hierzu via psql mit der Datenbank

------------------------------------------------------------------------------------------------------------------------
# freelancerFlow

An app for managing clients, projects and more for the day-to-day work of a freelancer.

## Backend

- Spring Boot with Hibernate & JPA
- PostgreSQL Database
- Authentication through Keycloak

## Frontend (github.com/yohagos/freelancerFlowNg)

- Angular v. 17
- Angular Material v. 17

## Architecture

In the backend, I opted for a function-based approach in which I created all classes for their respective functions in the corresponding packages. In other words, all data models (entities) in the package entities.
Based on this approach, all controllers in controllers and so on.

## Adjustments in the future

At present, the connection between the database and Keycloak works so that all Keycloak information is stored in the database. If necessary, further tests would have to be created and the import of a configuration would have to be improved.

Async processes cannot access the SecurityContextHolder and obtain the information for @CreatedBy due to an issue.

When the Spring Boot App is started for the first time, all entities are created despite occasional error messages, but it may be that the creation of the event_entity logs an error because it cannot 'save' the ID as an integer. To do this via psql with the database
