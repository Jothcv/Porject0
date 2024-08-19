package com.example.library_managementt.Modelo;



import com.example.library_managementt.model.document.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {

    @Test
    void testUserCreation() {
        User user = new User();


        user.setId("12345");
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setMembershipNumber("M1234");


        assertEquals("12345", user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("M1234", user.getMembershipNumber());
    }

    @Test
    void testUserGetters() {

        User user = new User();
        user.setId("67890");
        user.setName("Jane Doe");
        user.setEmail("jane.doe@example.com");
        user.setMembershipNumber("M5678");


        assertEquals("67890", user.getId());
        assertEquals("Jane Doe", user.getName());
        assertEquals("jane.doe@example.com", user.getEmail());
        assertEquals("M5678", user.getMembershipNumber());
    }

    @Test
    void testUserSetters() {

        User user = new User();


        user.setId("54321");
        user.setName("Alice Smith");
        user.setEmail("alice.smith@example.com");
        user.setMembershipNumber("M9876");

        // Verify the setters work as expected
        assertEquals("54321", user.getId());
        assertEquals("Alice Smith", user.getName());
        assertEquals("alice.smith@example.com", user.getEmail());
        assertEquals("M9876", user.getMembershipNumber());
    }

    @Test
    void testUserToString() {
        User user = new User();
        user.setId("99999");
        user.setName("Bob Brown");
        user.setEmail("bob.brown@example.com");
        user.setMembershipNumber("M1111");


        String expectedToString = "User(id=99999, name=Bob Brown, email=bob.brown@example.com, membershipNumber=M1111)";
        assertEquals(expectedToString, user.toString());
    }
}
