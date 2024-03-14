import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MathObjectTest {

    void triangleType(int a, int b, int c){
        if (a==b && a==c && b==c){
            System.out.println("Equilateral Triangle");
        } else if (a==b || a==c || b==c) {
            System.out.println("Isosceles Triangle");
        }else {
            System.out.println("Scalene Triangle");
        }

    }

    void inputChecking(int a, int b, int c, String exceptFail) {
        Throwable exceptionA = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("a input out of range");
        });
        Throwable exceptionB = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("b input out of range");
        });
        Throwable exceptionC = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("c input out of range");
        });
        Throwable exceptionAExpectError = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("wrong expect error parametr. A input actually is ok");
        });
        Throwable exceptionBExpectError = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("wrong expect error parametr. A input actually is ok");
        });
        Throwable exceptionCExpectError = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("wrong expect error parametr. A input actually is ok");
        });
        if (exceptFail.equals("")){
            assertTrue(1<= a && a<=200, exceptionA.getMessage());
            assertTrue(1<= b && b<=200, exceptionB.getMessage());
            assertTrue(1<= c && c<=200, exceptionC.getMessage());
        }else if (exceptFail.equals("a")) {
            assertFalse(1<= a && a<=200, exceptionAExpectError.getMessage());
        }else if (exceptFail.equals("b")) {
            assertFalse(1<= b && b<=200, exceptionBExpectError.getMessage());
        }else if (exceptFail.equals("c")) {
            assertFalse(1<= c && c<=200, exceptionCExpectError.getMessage());
        }else{
            assertFalse(1<= a && a<=200, exceptionAExpectError.getMessage());
            assertFalse(1<= b && b<=200, exceptionBExpectError.getMessage());
            assertFalse(1<= c && c<=200, exceptionCExpectError.getMessage());
        }

    }

    void sidesChecking(int a, int b, int c, String exceptError) {
        Throwable exceptionA = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("A is Bigger than sum of B+C. The given figure is not a triangle");
        });
        Throwable exceptionB = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("B is Bigger than sum of A+C. The given figure is not a triangle");
        });
        Throwable exceptionC = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("C is Bigger than sum of A+B. The given figure is not a triangle");
        });
        Throwable exceptionABigger = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("wrong except error parametr. A is ok");
        });
        Throwable exceptionBBigger = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("wrong except error parametr b is ok");
        });
        Throwable exceptionCBigger = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("wrong except error parametr c is ok");
        });
        if (exceptError.equals("")){
            assertTrue(a <b+ c, exceptionA.getMessage());
            assertTrue(b <a+ c, exceptionB.getMessage());
            assertTrue(c <a+ b, exceptionC.getMessage());
            triangleType(a, b, c);
        } else if (exceptError.equals("a")) {
            assertFalse(a <b+ c, exceptionABigger.getMessage());
        } else if (exceptError.equals("b")) {
            assertFalse(b <a+ c, exceptionBBigger.getMessage());
        } else if (exceptError.equals("c")) {
            assertFalse(c <a+ b, exceptionCBigger.getMessage());
        }

    }

    MathObject EquilateralTriangle = new MathObject(30,30,30);
    MathObject IsoscelesTriangle = new MathObject(30,20,20);
    MathObject ScaleneTriangle = new MathObject(10,20,26);
    MathObject InputError = new MathObject(250,250,250);
    MathObject SideABiggerError = new MathObject(190,10,20);
    MathObject SideBBiggerError = new MathObject(10,190,20);
    MathObject SideCBiggerError = new MathObject(10,10,190);

    @Nested
    class EquilateralTriangle {
        @Test
        void userInputChecking(){
            inputChecking(EquilateralTriangle.getA(), EquilateralTriangle.getB(), EquilateralTriangle.getC(), "");
        }

        @Nested
        class SidesChecking {
            @Test
            void userSidesChecking(){
                sidesChecking(EquilateralTriangle.getA(), EquilateralTriangle.getB(), EquilateralTriangle.getC(), "");
            }
        }


    }

    @Nested
    class IsoscelesTriangle {
        @Test
        void userInputChecking(){
            inputChecking(IsoscelesTriangle.getA(), IsoscelesTriangle.getB(), IsoscelesTriangle.getC(), "");
        }

        @Nested
        class SidesChecking {
            @Test
            void userSidesChecking(){
                sidesChecking(IsoscelesTriangle.getA(), IsoscelesTriangle.getB(), IsoscelesTriangle.getC(), "");
            }
        }


    }

    @Nested
    class ScaleneTriangle {
        @Test
        void userInputChecking(){
            inputChecking(ScaleneTriangle.getA(), ScaleneTriangle.getB(), ScaleneTriangle.getC(), "");
        }

        @Nested
        class SidesChecking {
            @Test
            void userSidesChecking(){
                sidesChecking(ScaleneTriangle.getA(), ScaleneTriangle.getB(), ScaleneTriangle.getC(), "");
            }
        }


    }

    @Nested
    class InputAError {

        @Test
        void userInputChecking(){
            inputChecking(InputError.getA(), InputError.getB(), InputError.getC(), "a");
        }
    }

    @Nested
    class InputBError {

        @Test
        void userInputChecking(){
            inputChecking(InputError.getA(), InputError.getB(), InputError.getC(), "b");
        }
    }

    @Nested
    class InputCError {

        @Test
        void userInputChecking(){
            inputChecking(InputError.getA(), InputError.getB(), InputError.getC(), "c");
        }
    }

    @Nested
    class InputAllError {

        @Test
        void userInputChecking(){
            inputChecking(InputError.getA(), InputError.getB(), InputError.getC(), "all");
        }
    }

    @Nested
    class SideAIsBigger {
        @Test
        void userInputChecking(){
            inputChecking(SideABiggerError.getA(), SideABiggerError.getB(), SideABiggerError.getC(), "");
        }

        @Nested
        class SidesChecking {
            @Test
            void userSidesChecking(){
                sidesChecking(SideABiggerError.getA(), SideABiggerError.getB(), SideABiggerError.getC(), "a");
            }
        }

    }

    @Nested
    class SideBIsBigger {
        @Test
        void userInputChecking(){
            inputChecking(SideBBiggerError.getA(), SideBBiggerError.getB(), SideBBiggerError.getC(), "");
        }

        @Nested
        class SidesChecking {
            @Test
            void userSidesChecking(){
                sidesChecking(SideBBiggerError.getA(), SideBBiggerError.getB(), SideBBiggerError.getC(), "b");
            }
        }

    }

    @Nested
    class SideCIsBigger {
        @Test
        void userInputChecking(){
            inputChecking(SideCBiggerError.getA(), SideCBiggerError.getB(), SideCBiggerError.getC(), "");
        }

        @Nested
        class SidesChecking {
            @Test
            void userSidesChecking(){
                sidesChecking(SideCBiggerError.getA(), SideCBiggerError.getB(), SideCBiggerError.getC(), "c");
            }
        }

    }

}