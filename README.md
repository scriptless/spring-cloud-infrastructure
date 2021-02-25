## Spring Cloud Infrastructure - Projektseminar "Microservices"
### Services Overview
* Gateway Service (Spring Boot Gateway)
* Registry/Discovery Service (Spring Cloud Eureka Server)
* Service-Factory Service
* Dynamic Service (dynamisch generierter Service von der Service-Factory)
* Client (Postman Kollektion mit allen Routes)

### 1. Gateway Service
#### Features:
* Routet alle Anfragen zu den jeweiligen Services
* Bei mehreren dynamischen Services wird bei Anfrage ein Service ausgewählt und der Nutzer wird zu diesem Service geroutet (Loadbalancing -> Lastverteilung auf die verschiedenen dynamischen Services)
* Zwei verschiedene Darstellungen von einer Liste von den verfügbaren Instanzen
#### Routes:
* IP-Adresse: localhost:8080
* /service/** -> Anfrage zu einem dynamischen Service
* /factory/** -> Anfrage zur Service-Factory
* /instances -> Darstellung von verfügbaren Instanzen
* /instancesFull -> Darstellung von verfügbaren Instanzen (detailliert)

### 2. Registry & Discovery Service
#### Features:
* Verzeichnis von allen Services
* Services können sich mit diesem Service registrieren/deregistrieren
* Services können bei dem Registry-Discovery Service einen bestimmten Service und deren URL nachfragen
#### Routes:
* IP-Adresse: localhost:8081
* http://localhost:8081 -> Eureka Userinterface (Überblick Services)
* /eureka -> Service URL (Eureka HTTP Endpoints, Services machen Anfragen zu dieser URL)

### 3. Service-Factory Service
Features:
* Kann mehrere dynamische Services erstellen bzw. starten
* Spawnt einen dynamischen Service mithilfe des ProcessBuilders ("java -jar dynamicservice.jar")
* Ausführbare JAR des dynamischen Services befindet sich unter /resources/services/dynamicservice.jar
* Konfiguration des dynamischen Services befindet sich unter /resources/services/dynamicservice.properties
#### #### Routes:
* IP-Adresse: localhost:8010
* /factory/create -> Erstellt einen dynamischen Service mit zufälligem Port

### 4. Dynamic Service
#### Features:
* Ein dynamisch erstellter Service von der Service-Factory
* Port 0 bzw. ein zufälliger Port wird zugewiesen
* Service hat eine einmalige zufällige Instance-ID zur Unterscheidung
* Service kann sich durch Anfrage an /service/stop selber beenden
#### Routes:
* IP-Adresse: localhost:ZUFÄLLIGER_PORT
* /service -> Zeigt Instance-ID des dyn. Services an
* /service/stop -> Stoppt den Service und deregistriert sich vom Registry-Discovery Service

### 5. Client
#### Features:
* Beinhaltet eine Postman-Kollektion von Routes zum Testen der Infrastruktur
#### Routes:
* /instances
* /instancesFull
* /factory/create
* /service
* /service/stop
