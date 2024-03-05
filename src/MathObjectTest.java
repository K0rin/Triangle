import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MathObjectTest {

    MathObject triangle = new MathObject(10,30,30);
    @Test
    void inputChecking() {
        Throwable exceptionA = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("a input out of range");
        });
        Throwable exceptionB = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("b input out of range");
        });
        Throwable exceptionC = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("c input out of range");
        });
        assertTrue(1<= triangle.getA() && triangle.getA()<=200, exceptionA.getMessage());
        assertTrue(1<= triangle.getB() && triangle.getB()<=200, exceptionB.getMessage());
        assertTrue(1<= triangle.getC() && triangle.getC()<=200, exceptionC.getMessage());
    }

    @Nested
    class SidesTriangleChecking {
        @Test
        void sidesChecking() {
            Throwable exceptionA = assertThrows(IllegalArgumentException.class, () -> {
                throw new IllegalArgumentException("A is Bigger than summ of B+C. The given figure is not a triangle");
            });
            Throwable exceptionB = assertThrows(IllegalArgumentException.class, () -> {
                throw new IllegalArgumentException("B is Bigger than summ of A+C. The given figure is not a triangle");
            });
            Throwable exceptionC = assertThrows(IllegalArgumentException.class, () -> {
                throw new IllegalArgumentException("C is Bigger than summ of B+C. The given figure is not a triangle");
            });
            assertTrue(triangle.getA() <triangle.getB()+ triangle.getC(), exceptionA.getMessage());
            assertTrue(triangle.getB() <triangle.getA()+ triangle.getC(), exceptionB.getMessage());
            assertTrue(triangle.getC() <triangle.getA()+ triangle.getB(), exceptionC.getMessage());
        }

        @Nested
        class TriangleType {
            @Test
            void triangleType(){
                if (triangle.getA()==triangle.getB() && triangle.getA() == triangle.getC() && triangle.getB() == triangle.getC()){
                    System.out.println("Equilateral Triangle");
                } else if (triangle.getA()==triangle.getB() || triangle.getA() == triangle.getC() || triangle.getB() == triangle.getC()) {
                    System.out.println("Isosceles Triangle");
                }else {
                    System.out.println("Scalene Triangle");
                }

            }
        }
    }

}