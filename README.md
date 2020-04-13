[![CircleCI](
https://circleci.com/gh/JakuBB96/pet-clinic-implementation/tree/master.svg?style=svg)](https://circleci.com/gh/JakuBB96/pet-clinic-implementation/tree/master)

# Pet-clinic-implementation


Repository contains an opinionated version of the classic reference application - [Spring Pet Clinic](https://github.com/spring-projects/spring-petclinic)

It's a sample web application that I've created, based on one of my Spring Framework courses

Unlike the original implementation, app was split into two separate modules, first one: pet-clinic-data contains differently implemented entities, and both Map and Spring Data JPA implementations of service layer.

Second module: pet-clinic-web is the main module of the application, it contains all the controllers and ThymeLeaf templates as well as classes responsible for loading sample data on bootstrap.


# Run app on your local machine

```
git clone https://github.com/JakuBB96/pet-clinic-implementation.git
cd pet-clinic-implementation/pet-clinic-web
./mvnw package
java -jar target/*.jar
```

# License

The Spring PetClinic sample application is released under version 2.0 of the [Apache License](http://www.apache.org/licenses/LICENSE-2.0).
