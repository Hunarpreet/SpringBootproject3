package com.example.demo;

import com.example.demo.entities.myUser;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RestClient {
//consumed the endpoints
    private  static final String get_all_user="http://localhost:8080/getAllUsers";
    private  static final String get_all_userbyid="http://localhost:8080/find/{id}";
    private  static final String create_user="http://localhost:8080/saveUser";

    private  static final String find_by_id="http://localhost:8080/find/{id}";

    private  static final String edit_user="http://localhost:8080/edituser";

    private  static  final String delete_user="http://localhost:8080/user/{id}";
    static RestTemplate restTemplate=new RestTemplate();
    public static  void main(String[]args){
        /*from here we can call
        get,put,post and delete apis
         */
        callGetAllUsersApi();
        callGetUserbyId();
        callcreateuser();
        updateuser();
        callGetAllUsersApi();
        Delete_user();
        callGetAllUsersApi();



    }
    private static  void callGetAllUsersApi(){
        HttpHeaders  headers= new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity=new HttpEntity<>("parameters",headers);

       ResponseEntity<String>result= restTemplate.exchange(get_all_user, HttpMethod.GET,entity, String.class);
       System.out.println(result);
    }
    private static void callGetUserbyId(){
        Map<String,Integer>m1=new HashMap<>();

        m1.put("id",22);
       String user=restTemplate.getForObject(get_all_userbyid, String.class,m1);
        System.out.println(user);
    }
    public static void callcreateuser(){

       myUser user = new myUser();
       user.setCity("delhi");
       user.setId(1);
       user.setStatus("active");
       user.setName("Yash");

        ResponseEntity<myUser> user2=restTemplate.postForEntity(create_user,user, myUser.class);
           //System.out.println("body is"+user2.getBody());
    }

    private static  void updateuser(){
        myUser updateduser = new myUser();
        updateduser.setId(1);
        updateduser.setCity("delhii");
        updateduser.setStatus("inactive");
        updateduser.setName("Yash Kwatra");
        restTemplate.put(edit_user,updateduser);
    }

    private static void Delete_user(){
        System.out.println("Enter the Id for which you want to delete user");
        Scanner sc=new Scanner(System.in);
        int user=sc.nextInt();
        Map<String,Integer>m1=new HashMap<>();
        m1.put("id",user);
        restTemplate.delete(delete_user,m1);
        System.out.println("User with id  "+user+"  deleted sucesfully");

    }


}
