# Survey API

For more detail information on how to connect it with frontend UI, cloud hosting and running the docker container on K8s, please [click here](https://github.com/aniket414/swe645-software-development/tree/master/Assignment-3)!

Tech Stack: Spring Boot, Java

This Project consists of three APIs described as below:

1. GET | api/v1.0/surveys/{id} -> Get a particular survey record based on its Id.
2. GET | api/v1.0/surveys -> Get all the surveys done till date.
3. POST | api/v1.0/surveys -> Save a new survey.

Survey Contract:
```json
        {
            "firstName": "John",
            "lastName": "Doe",
            "email": "john.doe@mail.com",
            "address": "9155 Walnut St",
            "city": "New York",
            "state": "NY",
            "zip": "22031",
            "telephone": "8888888888",
            "dateOfSurvey": "04-28-2022",
            "recommendation": "Very Likely",
            "interest": "Friends",
            "likings": "Students"
        }
