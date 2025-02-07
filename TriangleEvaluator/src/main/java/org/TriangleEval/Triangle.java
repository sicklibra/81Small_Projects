package org.TriangleEval;

import java.util.Arrays;

/*Triangle evaluator By Josh Hodges
 * Purpose, this evaluator accepts 3 integers and determines what type of
 * triangle the legs can make and returns a print statement letting the user
 * know. this is an exercise for testing and utilization of enumeration.
 */
public class Triangle {
    int[] sides;
    TirangleTypeEnum type;

    //Set up enum with baked in print statements for return.
    enum TirangleTypeEnum {
        SCALENE("Scalene"),
        EQUILATERAL("Equilateral"),
        ISOSCELES("Isosceles"),
        NOTTRI("Not a triangle")

        String prettyPrint;

        TirangleTypeEnum(String prettyPrint) {
            this.prettyPrint = prettyPrint;
        }
        }

    public Triangle(int a, int b, int c) {
        //call another function to sort sides and evaluate enumeration.
        sides = new int[]{a, b, c};
        type = evaluate();
    }

    //Public call to get the triangle type
    public String getType() {
        return type.toString();
    }

    //returns triangle enum after evaluation.
    private TirangleTypeEnum evaluate() {
        Arrays.sort(sides);
        //most likely scenario is a line or broken triangle
        if (sides[0] <= 0 || sides[0] + sides[1] <= sides[2]) {
            return TirangleTypeEnum.NOTTRI;
        }
        //if the first two (shortest)legs are the same could be either.
        else if (sides[0] == sides[1]) {
            //evaluates third leg
            if (sides[0] == sides[2]) {
                return TirangleTypeEnum.EQUILATERAL;
            }
            //if only the two are equal
            else {
                return TirangleTypeEnum.ISOSCELES;
            }
        }
        //only option left.
        else {
            return TirangleTypeEnum.SCALENE;
        }
    }
}
