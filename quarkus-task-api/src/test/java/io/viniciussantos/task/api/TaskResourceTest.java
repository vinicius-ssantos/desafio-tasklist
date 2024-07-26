//package io.viniciussantos.task.api;
//
//import io.quarkus.test.junit.QuarkusTest;
//import io.restassured.http.ContentType;
//import io.viniciussantos.task.model.TaskRequest;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.BeforeEach;
//import io.restassured.RestAssured;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.*;
//
//@QuarkusTest
//public class TaskResourceTest {
//
//    @BeforeEach
//    public void setup() {
//        RestAssured.baseURI = "http://localhost";
//        RestAssured.port = 8081;
//    }
//
//    @Test
//    public void testGetAllTasks() {
//        given()
//                .when().get("/task")
//                .then()
//                .statusCode(200)
//                .contentType(ContentType.JSON)
//                .body("$.size()", is(greaterThanOrEqualTo(0)));
//    }
//
//    @Test
//    public void testCreateTask() {
//        TaskRequest request = new TaskRequest();
//        request.setTitle("New Task");
//        request.setDescription("New Description");
//
//        given()
//                .contentType(ContentType.JSON)
//                .body(request)
//                .when().post("/task")
//                .then()
//                .statusCode(200)
//                .contentType(ContentType.JSON)
//                .body("title", is("New Task"))
//                .body("description", is("New Description"));
//    }
//
//    @Test
//    public void testUpdateTask() {
//        TaskRequest request = new TaskRequest();
//        request.setTitle("Updated Task");
//        request.setDescription("Updated Description");
//
//        given()
//                .contentType(ContentType.JSON)
//                .body(request)
//                .when().put("/task/1")
//                .then()
//                .statusCode(200)
//                .contentType(ContentType.JSON)
//                .body("title", is("Updated Task"))
//                .body("description", is("Updated Description"));
//    }
//
//    @Test
//    public void testDeleteTask() {
//        given()
//                .when().delete("/task/1")
//                .then()
//                .statusCode(204);
//    }
//}
