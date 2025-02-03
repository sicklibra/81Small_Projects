package org.TriangleEval;
import java.util.Arrays;

/*Triangle evaluator By Josh Hodges
* Purpose, this evaluator accepts 3 integers and determines what type of
* triangle the legs can make and returns a print statement letting the user
* know. this is an exercise for testing and utilization of enumeration.
*/
public class TriangleType {
    int[] sides;
    //Set up enum with baked in print statements for return.
    enum Tri{
        SCALENE() {
            @Override
            public String printType() {
                return "Scalene";
            }
        },
        EQUILATERAL(){
            @Override
            public String printType() {
                return "Equilateral";
            }
        },
        ISOSCELES(){
            @Override
            public String printType() {
                return "Isosceles";
                }
            },
        NOTTRI(){
            @Override
            public String printType() {
                return "Not a triangle";
            }
        };
        public abstract String printType();

    }
    //Constructor making a sorted list of legs for eval.
    public TriangleType(int a, int b, int c){
       sides = new int[]{a,b,c};
       Arrays.sort(sides);
    }
    //Public call to get the triangle type
    public String getType(){
        //creates a triangle enum.
        Tri triangle;
        //gets triangle type
        triangle=evlauate();
        //returns the baked in print statement for triangle type
        return triangle.printType();
    }
    //returns triangle enum after evaluation.
    public Tri evlauate(){
        //most likely scenario is a line or broken triangle
        if(sides[0]<=0 || sides[0]+sides[1]<= sides[2]){
            return Tri.NOTTRI;
        }
        //if the first two (shortest)legs are the same could be either.
        else if(sides[0]==sides[1]){
            //evaluates third leg
            if (sides[0]==sides[2]){
                return Tri.EQUILATERAL;
            }
            //if only the two are equal
            else{
                return Tri.ISOSCELES;
            }
        }
        //only option left.
        else{
            return Tri.SCALENE;
        }
    }
}
