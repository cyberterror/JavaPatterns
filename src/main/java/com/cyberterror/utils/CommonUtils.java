package com.cyberterror.utils;

public interface CommonUtils {

    static void print_good(String message) {
        System.out.println("\u001b[01;32m[+]\u001b[0m " + message);
    }
    static void print_info(String message) {
        System.out.println("\u001b[01;34m[*]\u001b[0m " + message);
    }
    static void print_error(String message) {
        System.out.println("\u001b[01;31m[-]\u001b[0m " + message);
    }
    static void print_warn(String message) {
        System.out.println("\u001b[01;33m[!]\u001b[0m " + message);
    }
    static void print_stat(String message) {
        System.out.println("\u001b[01;35m[*]\u001b[0m " + message);
    }
}
