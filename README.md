## Conference Management bruno e naty
Overview about the architecture of solution in [screen](https://www.loom.com/share/0256e2553f0846b5a2f62062b556bf6f)

### Prerequisites
* Java 8 or above
* Maven (for building)

### How to Run 

```bash
mvn spring-boot:run
```

### How to Run Tests Only

```bash
mvn test
```
## Steps
1. Read data from file and create a sorted (DESC) list of Tasks. 
2. calculate conference days. 
3. calculate all morning talks.
4. calculate all evening talks.
5. render track for each day and complete the remaning time with network event.

## Main Domain Concepts

#### TrackManager
* The `TrackManager` provide an track for each conference day based on avaliable talks.

#### Talk
* `Talk` Represent a Single talk in the conference

#### TrackProcessor and Tracktypes 
* Those are the core Classes and Interfaces of the solution providing an easy way for calculate and extend.

### Core Frameworks and tools

* Spring Boot
* Spring Core
* Lombook Project

### Testing Frameworks 

* Junit
* Mockito
* Hamcrest Matchers
* Javafaker
