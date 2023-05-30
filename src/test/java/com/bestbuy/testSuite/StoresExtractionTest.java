package com.bestbuy.testSuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {
    static ValidatableResponse response;
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);

    }
    //1. Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }
    //2. Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + total);
        System.out.println("------------------End of Test---------------------------");

    }
//    3. Extract the name of 5th store
@Test
public void test003() {
 String name = response.extract().path("data[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th store is : " + name);
        System.out.println("------------------End of Test---------------------------");

}

//4. Extract the names of all the store
@Test
public void test004() {
    List<Integer> listOfStoreName =response.extract().path("data.name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("List of Store are : " + listOfStoreName);
    System.out.println("------------------End of Test---------------------------");

}
//5. Extract the storeId of all the store
@Test
public void test005() {
    List<Integer> listOfStoreId =response.extract().path("data.id");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("List of Store are : " + listOfStoreId);
    System.out.println("------------------End of Test---------------------------");

}
//6. Print the size of the data list
@Test
public void test006() {
    List<String>  dataSize =   response.extract().path("data");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The size of the data is : " +dataSize.size());
    System.out.println("------------------End of Test---------------------------");
}
//7. Get all the value of the store where store name = St Cloud
@Test
public void test007() {
    List<HashMap<String , ?>> values =  response.extract().path("data.findAll{it.name == 'St Cloud'}");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The values for store name 'St Cloud' are: " + values );
    System.out.println("------------------End of Test---------------------------");
}
//8. Get the address of the store where store name = Rochester
@Test
public void test008() {
    List<String> address =  response.extract().path("data.findAll{it.name == 'Rochester'}.address");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The address of store name ' Rochester' is : " + address);
    System.out.println("------------------End of Test---------------------------");
}


//9. Get all the services of 8th store
@Test
public void test009() {
    List<HashMap<String, ?>> listOfServices = response.extract().path("data[7].services");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The services of '8th store' are: " + listOfServices);
    System.out.println("------------------End of Test---------------------------");
}

//10. Get storeservices of the store where service name = Windows Store
@Test
public void test010() {
    List<HashMap<String, ?>> serviceName = response.extract().path("data.find{it.services}.services.findAll{it.name ='Windows Store'}.storeservices");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println(" Storeservices of the store where service name = Windows Store : "+serviceName);
    System.out.println("------------------End of Test---------------------------");

}
//11. Get all the storeId of all the store
@Test
public void test011() {
    List<Integer> storeIds =   response.extract().path("data.services.storeservices.storeId");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("List Of store Id is: "+storeIds);
    System.out.println("------------------End of Test---------------------------");

}

//12. Get id of all the store
@Test
public void test012() {
    List<Integer>   allStoreId = response.extract().path("data.id");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The id of all the store are : " + allStoreId);
    System.out.println("------------------End of Test---------------------------");

}

//13. Find the store names Where state = ND
//13. Find the store names Where state = ND
@Test
public void test013() {
    String stateND =   response.extract().path("data[7].state");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The store names Where state  : "+ stateND);
    System.out.println("------------------End of Test---------------------------");

}

//14. Find the Total number of services for the store where store name = Rochester
@Test
public void test014() {
    List<HashMap<String , ?>> values =  response.extract().path("data.findAll{it.name == 'Rochester'}.services");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The Total number of services for  the store name 'Rochester' are: " + values );
    System.out.println("------------------End of Test---------------------------");
}

//15. Find the createdAt for all services whose name = “Windows Store”
@Test
public void test15() {

        List<String> createAtList = response.extract().path("data.services*.findAll{it.name == 'Windows Store'}.createdAt");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The createdAt of services name are: " + createAtList );
    System.out.println("------------------End of Test---------------------------");
    }


// 16. Find the name of all services Where store name = “Fargo”
@Test
public void test016() {
    List<HashMap<String , ?>> values =  response.extract().path("data.findAll{it.name == 'Fargo'}.services");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The Total number of services for  the store name 'Fargo' are: " + values );
    System.out.println("------------------End of Test---------------------------");
}



// 17. Find the zip of all the store
@Test
public void test017() {
    List<Integer>   allZipOfStore = response.extract().path("data.zip");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The zip of all the store are : " + allZipOfStore);
    System.out.println("------------------End of Test---------------------------");

}



//18. Find the zip of store name = Roseville
@Test
public void test018() {
    List<HashMap<String , ?>> zip =  response.extract().path("data.findAll{it.name == 'Roseville'}.zip");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The zip of  the store name 'Roseville' are: " + zip);
    System.out.println("------------------End of Test---------------------------");
}




//19. Find the storeservices details of the service name = Magnolia Home Theater
@Test
public void test019() {
        //data[*].services[*].name

        List<String> image =  response.extract().path("data.findAll{it.name == 'Energizer'}.image");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The image of products whose manufacturer is = Energizer is: " + image);
        System.out.println("------------------End of Test---------------------------");
    }



//20. Find the lat of all the stores
@Test
public void test020() {
    List<Integer>   allLatOfStore = response.extract().path("data.lat");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The lat of all the store are : " + allLatOfStore);
    System.out.println("------------------End of Test---------------------------");

}

}
