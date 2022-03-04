package se.bth.pa2552_project.system.utils;

public class HeadlessHelper {
    public static void setupForHeadlessTesting() {
        String isRunningOnCi = System.getenv("CI");
        if ("true".equalsIgnoreCase(isRunningOnCi)) {
            System.out.println("Running test headless");
            System.setProperty("monocle.platform", "Headless");
            System.setProperty("testfx.robot", "glass");
            System.setProperty("glass.platform", "Monocle");
            System.setProperty("embedded", "monocle");
            System.setProperty("testfx.headless", "true");
            System.setProperty("prism.order", "sw");
            System.setProperty("prism.verbose", "true");

            System.setProperty("prism.text", "t2k");
            // System.setProperty("prism.text", "native");

            // System.setProperty("java.awt.headless", "true");
        }
    }
}