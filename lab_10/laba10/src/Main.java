import java.awt.print.Printable;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        Method method = list.getClass().getMethod("remove", Object.class);
        Type returnType = method.getGenericReturnType();
        System.out.println("Тип методу, що повернувся: " + returnType.getTypeName());

        System.out.println("\n");
        Example example = new Example();
        Class<?> testClass = example.getClass();
        if (testClass.isMemberClass()) {
            System.out.println(testClass.getName() + " Належить до класу");
        }

        else {
            System.out.println(testClass.getName() + " НЕ належить до класу");
        }

        System.out.println("\n");

        Class<?> myClass = MyClass.class;
        Method myMethod = myClass.getMethod("myMethod", Object[].class);
        Object[] arguments = new Object[] {"Hello", 5, true};
        myMethod.invoke(null, new Object[] {arguments});
    }

    public static class Example {
        public void Print() {
            System.out.println("Hello Everyone!");
        }
    }

    public static class MyClass {
        public static void myMethod(Object... arguments) {
            for (Object arg : arguments) {
                System.out.println(arg);
            }
        }
    }
}


