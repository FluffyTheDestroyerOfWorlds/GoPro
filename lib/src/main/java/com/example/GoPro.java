package com.example;

import java.util.Arrays;
import java.util.Scanner;

public class GoPro {
    public static void main(String[] args){

        String[] sInput = new String[7];
        Integer ans;
        // define goPro
        GoProCamera[] hero = new GoProCamera[3];
       // GoProCamera hero5session;
       // GoProCamera heroSession;
        port[] tempPort = new port[2];

        tempPort[0] = port.usbC;
        tempPort[1] = port.microHDMI;
        hero[0] = setupCamera("Hero5 Black",8,true,true,true,true,true,true,"professional",tempPort, 399.99);

        tempPort[0] = port.usbC;
        tempPort[1] = null;
        hero[1] = setupCamera("Hero5 Session",8,true,true,false,true,false,false,"consumer",tempPort, 299.99);

        tempPort[0] = port.microUSB;
        tempPort[1] = null;
        hero[2] = setupCamera("Hero Session",8,false,false,false,false,false,false,"consumer",tempPort, 199.99);


        // ask questions and figure out which goPro you need
        Scanner in = new Scanner(System.in);

        System.out.println("Thanks for your interest in GoPro.  We will ask you a series of questions inorder to help choose the right one.");
        System.out.println("Is this for work? (y/n)");
        sInput[0] = in.nextLine();
        // hero5 black
        System.out.println("Do you need to show people your location at all? (y/n)");
        sInput[1] = in.nextLine();
        System.out.println("Do you need access to RAW footage? (y/n)");
        sInput[2] = in.nextLine();
        System.out.println("Do you want touch display? (y/n)");
        sInput[3] = in.nextLine();
        // hero5 session
        System.out.println("Do you need voice control for action sequences? (y/n)");
        sInput[4] = in.nextLine();
        System.out.println("Do you want to upload this to a cloud service? (y/n)");
        sInput[5] = in.nextLine();

        System.out.println("Is price a determining factor? (y/n)");
        sInput[6] = in.nextLine();



     ans = FindProduct(sInput);



      System.out.println("We recommend the: " + hero[ans].toString());


    }


    public static Integer FindProduct(String[] sAry){
       Integer answer = 2;
        Boolean hero5black, hero5session, herosession;
        hero5session = herosession =  hero5black = false;
        //hero5 black
        if (sAry[1].compareToIgnoreCase("Y") == 0 || sAry[2].compareToIgnoreCase("Y") == 0 || sAry[3].compareToIgnoreCase("Y") == 0){
            hero5black = true;
            answer = 0;
            System.out.println("1");
            return answer;
        }
        //hero5 session
        if (sAry[4].compareToIgnoreCase("Y") == 0 || sAry[5].compareToIgnoreCase("Y") == 0){
            hero5session = true;
            hero5black = true;
            answer = 1;
            System.out.println("2");
        }
        //work?
        if (sAry[0].compareToIgnoreCase("Y") == 0){
            herosession = false;
            if (hero5black && hero5session) {
                answer = 0;
               // hero5session = false;
                System.out.println("3");
            }
        }
        //price?
        if (hero5black && hero5session && sAry[6].compareToIgnoreCase("Y") == 0){
            answer = 1;
            System.out.println("4");
        }


        return answer;
    }

    public enum port {
        usbC,microHDMI,microUSB
    }

    public static GoProCamera setupCamera(String iName, Integer iMP,Boolean iVoiceCmd,
            Boolean iVideoStable,
            Boolean iTouchDisplay,
            Boolean iUpload2Cloud,
            Boolean iLocationCapture,
            Boolean iRawPhotoAcess,
            String iLowLightPerformance,
            port[] iPorts,
            double iPrice){

        GoProCamera inputCamera = new GoProCamera();

        inputCamera.Name = iName;

        inputCamera.MP = iMP;
        inputCamera.VideoStable = iVideoStable;
        inputCamera.VoiceCmd = iVoiceCmd;
        inputCamera.TouchDisplay = iTouchDisplay;
        inputCamera.Upload2Cloud = iUpload2Cloud;
        inputCamera.LocationCapture = iLocationCapture;
        inputCamera.RawPhotoAcess = iRawPhotoAcess;
        inputCamera.LowLightPerformance = iLowLightPerformance;
        inputCamera.Ports = iPorts;
        inputCamera.Price = iPrice;




        return inputCamera;
    }


    public static class GoProCamera {
        String Name;
        Integer MP;
        Boolean VoiceCmd;
        Boolean VideoStable;
        Boolean TouchDisplay;
        Boolean Upload2Cloud;
        Boolean LocationCapture;
        Boolean RawPhotoAcess;
        String LowLightPerformance;
        Double Price;
        port Ports[];

        @Override
        public String toString() {
            return "Name='" + Name + '\'' +
                    ", MP=" + MP +
                    ", VoiceCmd=" + VoiceCmd +
                    ", VideoStable=" + VideoStable +
                    ", TouchDisplay=" + TouchDisplay +
                    ", Upload2Cloud=" + Upload2Cloud +
                    ", LocationCapture=" + LocationCapture +
                    ", RawPhotoAcess=" + RawPhotoAcess +
                    ", LowLightPerformance='" + LowLightPerformance + '\'' +
                    ", Price=" + Price +
                    ", Ports=" + Arrays.toString(Ports);
        }


    }




}

