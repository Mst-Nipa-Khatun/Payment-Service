//package com.PaymentService.controller;
//
//import java.util.regex.Pattern;
//import java.net.InetAddress;
///*
//  @INFO I am proficient in Java, so I solved the problem using Java. But I know Python Basic.
//*/
//public class IPAdressValidation {
//
//    private static boolean isIPv4(final String ip) {
//        /**
//         * @INFO i got this pattern from stackoverflow for try to solve this problem but not finished yet.
//         */
//        Pattern IPV4_PATTERN = Pattern.compile(
//                "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
//        return IPV4_PATTERN.matcher(ip).matches();
//    }
//
//    private static boolean isPrivateIPAddress(String ipAddress) {
//        InetAddress ia = null;
//        try {
//            InetAddress ad = InetAddress.getByName(ipAddress);
//            byte[] ip = ad.getAddress();
//            ia = InetAddress.getByAddress(ip);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//
//        return ia.isSiteLocalAddress();
//    }
//
//    public void validate(String ipAddress) {
//        try {
//            if (isIPv4(ipAddress) || !isPrivateIPAddress(ipAddress)) {
//                System.out.println("Valid IP");
//            }else {
//                System.out.println("Invalid IP");
//            }
//        }catch (Exception e) {
//            System.out.println("Invalid IP");
//        }
//    }
//
//}
