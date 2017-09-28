
Project title
Homework Assignments
For all assignments, the source code for the solution should be provided directly as a zip file, or as a link to an online source repository such as Github. In addition to the code, a set of instructions for building and running the application should be provided, along with any notes the developer would like to include which explain the design decisions made.
Problem 1: Reverse Geocoding Assignment
Design and implement a RESTful web service (HTTP) which is capable of looking up a physical street address given a set of geographic coordinates (longitude and latitude values). For example, given the latitude '33.969601' and longitude '-84.100033', the service should return the address of the NCR office in Duluth, GA (2651 Satellite Blvd, Duluth, GA 30096). The implementation should delegate to an online geocoding API (i.e., Google Maps or similar) to perform the lookup; the implementation will serve as a basic abstraction to simplify usage of one or more external services that handle the geo-location aspects.
Non-Functional Requirements:
The service should cache (locally) the last 10 lookups and provide an additional RESTful API for retrieving this stored data. The data
returned from this API should be a collection of the lookups performed, including the longitude and latitude values, the address found, and the date/time of the lookup. The service should handle any error conditions (such as invalid input or internal errors) with suitable HTTP error responses. The developer is responsible for designing the API signatures, including the input/output data structures, and any exceptions deemed necessary. Although Java is preferred, the choice of language and frameworks is at the discretion of the developer. Ideally, the application will run as a simple process/executable, and not require an external container or web server to run.

Getting Started

Usage:

http://localhost:8080/addresses/search?latitude=51.5&longitude=-1.1166667
http://localhost:8080/addresses




