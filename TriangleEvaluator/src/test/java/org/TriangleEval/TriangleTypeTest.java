package org.TriangleEval;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTypeTest {

    @BeforeEach
    void setUp() {
    Triangle not = new Triangle(3,9,5);
    Triangle equi = new Triangle(6,9,6);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getTypeTriangleIsLine() {
        Triangle line = new Triangle(5,5,10);
        String out =line.getType();
        assertEquals("Not a triangle", out);
        line = new Triangle(5,4,10);
        out=line.getType();
        assertEquals("Not a triangle", out);

    }
    @Test
    void ImproperParameters(){
        Triangle triangle = new Triangle(5.6,5.7,10);
        assertThrows(IllegalArgumentException.class, ()->triangle.getType());
        Triangle triangle2 = new Triangle(5,5,10, 6);
        assertThrows(IllegalArgumentException.class, ()->triangle2.getType());
        Triangle triangle3 = new Triangle(2,5);
        assertThrows(IllegalArgumentException.class, ()->triangle3.getType());
    }
    @Test
    void EquilateralTriangle(){
        Triangle triangle = new Triangle(5,5,5);
        String out = triangle.getType();
        assertEquals("Equilateral", out);
    }
    @Test
    void Isosceles(){
        Triangle triangle = new Triangle(8,5,8);
        String out = triangle.getType();
        assertEquals("Isosceles", out);
    }
    @Test
    void Scalene(){
        Triangle triangle = new Triangle(5,3,7);
        assertEquals("Scalene", triangle.getType());
    }
}