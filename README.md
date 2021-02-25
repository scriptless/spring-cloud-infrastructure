# Spring Cloud Infrastructure - Projektseminar "Microservices"
### Services Overview
* Gateway Service (Spring Boot Gateway)
* Registry/Discovery Service (Spring Cloud Eureka Server)
* Service-Factory Service
* Dynamic Service (dynamisch generierter Service von der Service-Factory)
* Client (Postman Kollektion mit allen Routes)

# Gateway Service
Features:
* Routet alle Anfragen zu den jeweiligen Services
* Bei mehreren dynamischen Services wird bei Anfrage ein Service ausgewählt und der Nutzer wird zu diesem Service geroutet (Loadbalancing -> Lastverteilung auf die verschiedenen dynamischen Services)
* Zwei verschiedene Darstellungen von einer Liste von den verfügbaren Instanzen

Routes:
* /service/** -> Anfrage zu einem dynamischen Service
* /factory/** -> Anfrage zur Service-Factory
* /instances -> Darstellung von verfügbaren Instanzen
* /instancesFull -> Darstellung von verfügbaren Instanzen (detailliert)