# SOA Project: Arithmetic Operations using MockMvc Unit Testing

## Objective
Build a Spring Boot REST API that performs addition, subtraction, multiplication and division, and test its controller using MockMvc, JUnit 5 and Mockito.

## Requirements
- JDK 17 or later
- Maven 3.6+
- Spring Tool Suite (STS)

## Import into STS
1. Extract `soa-arithmetic-mockmvc-project.zip`.
2. Open STS → File → Import.
3. Select Maven → Existing Maven Projects.
4. Browse to the extracted project folder and select `pom.xml`.
5. Click Finish and wait for Maven dependencies to download.

## Run tests
Right-click the project → Run As → Maven test.
Or run `mvn test` in the project folder.

## API endpoints
- `GET http://localhost:8080/api/add?a=10&b=5` → 15.0
- `GET http://localhost:8080/api/subtract?a=10&b=5` → 5.0
- `GET http://localhost:8080/api/multiply?a=10&b=5` → 50.0
- `GET http://localhost:8080/api/divide?a=10&b=5` → 2.0
- Division by zero returns HTTP 400 Bad Request.

## Test cases
1. Addition returns the sum.
2. Subtraction returns the difference.
3. Multiplication returns the product.
4. Division returns the quotient.
5. Division by zero returns 400 Bad Request.
6. Missing request parameter returns 400 Bad Request.

## Concepts
MockMvc performs simulated HTTP requests to controller endpoints without starting a real server. Mockito mocks the ArithmeticService so the controller can be tested independently. JUnit 5 runs the test methods and checks HTTP status codes and response bodies.
