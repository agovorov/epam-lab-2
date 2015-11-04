package com.epam.lab.display;

/**
 * Display strategy factory class
 *
 * @author Govorov Andrey
 */
public class DisplayStrategyFactory {
    public static DisplayStrategy getWriter(String param) {
        switch (param) {
            case "console":
                return new DisplayConsole();
            default:
                throw new IllegalArgumentException("Unknown display strategy : param='" + param + "'");
        }
    }
}
