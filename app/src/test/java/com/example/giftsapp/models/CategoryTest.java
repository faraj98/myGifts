package com.example.giftsapp.models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CategoryTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void setId() {

    }


    @Test
    public void getId() {
        Category category=new Category();
        int id=category.getId();
        assertNotNull(id);
    }


    @Test
    public void getImg() {
    }

    @Test
    public void setImg() {
    }

    @Test
    public void getTitle() {
    }

    @Test
    public void setTitle() {
    }

    @Test
    public void getAllGategory() {
    }
}