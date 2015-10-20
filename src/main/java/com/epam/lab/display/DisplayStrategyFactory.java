package com.epam.lab.display;

public class DisplayStrategyFactory {

	public static DisplayStrategy getWriter(String param) {
        switch (param) {
            case "console":
                return new DisplayConsole();
            case "console2":
                return new DisplayConsole2();
            default:
                throw new IllegalArgumentException("Unknown strategy : param='" + param + "'");
        }
    }
}
