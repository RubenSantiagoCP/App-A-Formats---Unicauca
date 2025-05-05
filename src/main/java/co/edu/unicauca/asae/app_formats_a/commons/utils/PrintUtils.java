package co.edu.unicauca.asae.app_formats_a.commons.utils;

public class PrintUtils {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public  static  void writeHeader(String text){
        System.out.println(ANSI_YELLOW + "==================================================="+ANSI_RESET);
        System.out.println(ANSI_YELLOW+text+ANSI_RESET);
        System.out.println(ANSI_YELLOW + "==================================================="+ANSI_RESET);
    }

    public  static  void writeSubHeader(String text){
        System.out.println(ANSI_BLUE + "================================================================================"+ANSI_RESET);
        System.out.println(ANSI_BLUE+text+ANSI_RESET);
        System.out.println(ANSI_BLUE + "================================================================================"+ANSI_RESET);
    }
}
