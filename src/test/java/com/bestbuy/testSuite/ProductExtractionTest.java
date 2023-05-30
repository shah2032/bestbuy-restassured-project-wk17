package com.bestbuy.testSuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductExtractionTest {
    static ValidatableResponse response;
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);

    }
//    21. Extract the limit
@Test
public void test021() {
    int limit = response.extract().path("limit");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of limit is : " + limit);
    System.out.println("------------------End of Test---------------------------");

}


//22. Extract the total
@Test
public void test022() {
    List<Integer> listOfIds =response.extract().path("data.id");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("List of Ids are : " + listOfIds);
    System.out.println("------------------End of Test---------------------------");

}



//23. Extract the name of 5th product
@Test
public void test023() {
    String nameOf5thProduct = response.extract().path("data[4].name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The name of the 5th product is : " + nameOf5thProduct);
    System.out.println("------------------End of Test---------------------------");

}
//24. Extract the names of all the products
@Test
public void test024() {
   List<String>  nameOfAllProducts = response.extract().path("data.name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The name of products are : " + nameOfAllProducts);
    System.out.println("------------------End of Test---------------------------");

}


//25. Extract the productId of all the products
@Test
public void test025() {
    List<Integer>  idOfAllProducts = response.extract().path("data.id");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The productId of all the products are : " + idOfAllProducts);
    System.out.println("------------------End of Test---------------------------");

}



//26. Print the size of the data list
@Test
public void test026() {
    List<String>  dataSize =   response.extract().path("data");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The size of the data is : " +dataSize.size());
    System.out.println("------------------End of Test---------------------------");
}


//27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
@Test
public void test027() {
    List<String> value = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("  product value is : " + value);
    System.out.println("------------------End of Test---------------------------");
}
//28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
@Test
public void test028() {
    String model = response.extract().path("data[8].model");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The model of product is : " + model);
    System.out.println("------------------End of Test---------------------------");

}


//29. Get all the categories of 8th products
@Test
public void test029() {
    List<String> categories = response.extract().path("data[7].categories");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The categories of 8th products are : " + categories);
    System.out.println("------------------End of Test---------------------------");

}



//30. Get categories of the store where product id = 150115
@Test
public void test030() {
    List<String> storeCategories = response.extract().path("data[3].categories");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The categories of the store where product id = 150115 is  : " + storeCategories);
    System.out.println("------------------End of Test---------------------------");

}



//31. Get all the descriptions of all the products
@Test
public void test031() {
    List<String>  descriptions = response.extract().path("data.description");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The descriptions of all the products : " + descriptions);
    System.out.println("------------------End of Test---------------------------");

}



//32. Get id of all the all categories of all the products
@Test
public void test032() {
    List<Integer>  categoriesId = response.extract().path("data.categories.id");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The Id of all  categories of all the products are : " + categoriesId);
    System.out.println("------------------End of Test---------------------------");

}
//33. Find the product names Where type = HardGood
@Test
public void test033() {
    List<String> productNames =  response.extract().path("data.findAll{it.type}.name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The names of products that Where type = HardGood are: " + productNames);
    System.out.println("------------------End of Test---------------------------");
}


//Find the Total number of categories for the product where product name = Duracell - AA
//1.5V CopperTop Batteries (4-Pack)
    @Test
    public void test034() {
        List<Integer> categoriesTotal =  response.extract().path("data.findAll{it.name == 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Total number of categories  are: " + categoriesTotal);
        System.out.println("------------------End of Test---------------------------");
    }

//35. Find the createdAt for all products whose price < 5.49
@Test
public void test035() {
  List<Integer>   createdAt =  response.extract().path("data.findAll{it.price < 5.49}.createdAt");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The createdAt that price is less than 5.49 are: " + createdAt);
    System.out.println("------------------End of Test---------------------------");
}

//36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)"
@Test
public void test036() {
    List<String> categories =  response.extract().path("data.findAll{it.name == 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The Total number of categories  are: " + categories);
    System.out.println("------------------End of Test---------------------------");
}


// 37. Find the manufacturer of all the products

    @Test
    public void test037() {
        List<String>  manufacturer = response.extract().path("data.manufacturer");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The manufacturer of all the products : " + manufacturer);
        System.out.println("------------------End of Test---------------------------");

    }



//38. Find the imge of products whose manufacturer is = Energizer
@Test
public void test038() {
    List<String> image =  response.extract().path("data.findAll{it.manufacturer == 'Energizer'}.image");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The image of products whose manufacturer is = Energizer is: " + image);
    System.out.println("------------------End of Test---------------------------");
}


//39. Find the createdAt for all categories products whose price > 5.99
@Test
public void test039() {
    List<Integer>   createdAt =  response.extract().path("data.findAll{it.price > 5.49}.createdAt");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The createdAt that price is grater than 5.49 are: " + createdAt);
    System.out.println("------------------End of Test---------------------------");
}



//40. Find the uri of all the products
@Test
public void test040() {
    List<String>  url = response.extract().path("data.url");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The manufacturer of all the products : " + url);
    System.out.println("------------------End of Test---------------------------");

}




}
