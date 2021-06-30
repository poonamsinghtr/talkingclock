# Talking Clock

Talking clock is an application which displays time in "Human Friendly" way.

It will generate the Human friendly time as

| Input | Output            |  
| ----- |:-----------------:|
| 1:00  | One o'clock       | 
| 2:00  | Two o'clock       |
| 13:00 | One o'clock       | 
| 13:05 | Five past One     |
| 13:55 | Five to Two       |    



# You can run the application in three ways 

### 1. Console app without giving any input

You can run the app as console application. 

#### How to run
To run the application we need to build it using command in the root folder

`./gradlew clean build`

Run the application by running the jar

`java -jar -Dspring.main.web-application-type=NONE TalkingClock-0.0.1-SNAPSHOT.jar`

### 2. Console App with time as input in format HH:MM

It will allow the command to take an arbitrary Numeric Time parameter as input and return the "Human Friendly Text" equivalent.

#### How to run

Run the application by running the jar

`java -jar -Dspring.main.web-application-type=NONE TalkingClock-0.0.1-SNAPSHOT.jar 13:00`

### 3. REST Service

REST service which expose the clock and allow an optional parameter to pass the arbitrary Numeric Time, and will return the "Human Friendly Text" as JSON.

#### How to run

Run the application by running the jar

`java -jar TalkingClock-0.0.1-SNAPSHOT.jar`

* **Endpoint**
  
  /clock


* **Method**
  
  `GET`


*  **URL Params**

   **Optional:** 
    `time=[numeric]`
    `format: HH:MM`


* **Success Response:**

    * **Code:** 200
    * **Content:**  `{ "time": "Twenty nine to One" }`


* **Error Response:**

    * **Code:** 400 Bad Request 
    * **Content:** `Input Time should be in number format`
    
    OR
  
    * **Code:** 400 Bad Request
    * **Content:** `Time should be in range from hr(0 - 24) and min(0 -59)`

* **Sample Request:**
  
  `http://localhost:8080/clock?time=13:00`
  
  Response:

   `{
    "time": "One o' clock"
    }`

#### Note:
Application is written in Java 8, you need to use the Runtime environment which is java 8 or above

### Testing
The tests are written in Junit and can be run using this command
`./gradlew clean test`
