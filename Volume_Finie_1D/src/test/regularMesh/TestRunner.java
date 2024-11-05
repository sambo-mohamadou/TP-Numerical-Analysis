package test.regularMesh;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestFonctionnement1.class);
        Result result2 = JUnitCore.runClasses(TestFonctionnement2.class);
        Result result3 = JUnitCore.runClasses(TestFonctionnement3.class);

        System.out.println("__________TestFonctionnement1__________");
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());

        System.out.println("__________TestFonctionnement2__________");
        for (Failure failure : result2.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result2.wasSuccessful());

        System.out.println("__________TestFonctionnement3__________");
        for (Failure failure : result3.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result3.wasSuccessful());

        System.out.println("\n__________TestConvergence1__________");
        Result resultC1 = JUnitCore.runClasses(TestConvergence1.class);

        System.out.println("\n__________TestConvergence2__________");
        Result resultC2 = JUnitCore.runClasses(TestConvergence2.class);


    }

}