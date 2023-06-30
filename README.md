# Book-Library-API
XML REST API Spring Boot Application that provides different API endpoints to manage books in a H2 database

Technologies used:

[x]XML
[x]REST API
[x]Spring Boot
[x]Spring Data JPA
[x]Tomcat
[x]Lombok
[x] H2 in-memory db

API endpoints:

//get a book by id: http://localhost:8080/api/book/1
//add a book: http://localhost:8080/api/book/add
//update a book: http://localhost:8080/api/book/update
//delete book by id: http://localhost:8080/api/book/delete/1
//get all books: http://localhost:8080/api/book/all
//get books by author: http://localhost:8080/api/book?author={author}
//get books by genre: http://localhost:8080/api/book?genre={genre}


Sample Data:
(Note: id field is required when using the update api else no need)
    <book>
        <id>1</id>
        <name>The Case Book of Sherlock Holmes</name>
        <price>100.0</price>
        <genre>Mystery</genre>
        <author>Sir Arthur Conan Doyle</author>
    </book>
