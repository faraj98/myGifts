package com.example.giftsapp.models;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
@RunWith(JUnit4.class)
public class UserTest {

    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void passwordValidator() {
        assertTrue(User.isValidPassword(null));
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void emailValidator() {
        assertTrue(User.isValidEmail("MahmoudKhairAllah.gmail.com"));
    }
    @Test
    public void getId() {
    }

    @Test
    public void setId() {
    }

    @Test
    public void getName() {
    }

    @Test
    public void setName() {
    }

    @Test
    public void getEmail() {
    }

    @Test
    public void setEmail() {
    }

    @Test
    public void getPhoneNumber() {
    }

    @Test
    public void setPhoneNumber() {
    }
}