package org.TriangleEval;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTypeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getTypeTriangleIsLine() {
        Triangle isLine = new Triangle(5,5,10);
        assertEquals("Not a triangle", isLine.getType());
        isLine = new Triangle(5,4,10);
        assertEquals("Not a triangle", isLine.getType());

    }

    @Test
    void EquilateralTriangle(){
        Triangle triangle = new Triangle(5,5,5);
        assertEquals("Equilateral", triangle.getType());
    }
    @Test
    void Isosceles(){
        Triangle triangle = new Triangle(8,5,8);
        assertEquals("Isosceles",triangle.getType());
    }
    @Test
    void Scalene(){
        Triangle triangle = new Triangle(5,3,7);
        assertEquals("Scalene", triangle.getType());
    }
}