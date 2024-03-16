package com.example.attendanceapplication;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessing {
    //instance fields
    private String fileName;
    private String fileType;
    private String netID;
    private int employID;
    private String firstName;
    private String middleName;
    private String lastName;
    private String utdEmail;
    private String course;
    private String career;
    private int units;


    void processFile(){
        try {
            Scanner reader = new Scanner(fileName);
            if(fileType.equals("Elearning")){
                parseElearning(fileName);
            }
            else if(fileType.equals("Coursebook")){
                parseCoursebook(fileName);
            }
            else{
                System.out.println("is not of any types");
            }
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();

        } catch(FileNotFoundException e){
            System.out.println("Error occurred: File cannot be found");
            e.printStackTrace();
        }
        return;
    }
    void setFileName(String name){
        fileName = name;
    }
    void setFileType(String type){
        fileType = type;
    }

    void parseElearning(String fileName){

    }
    void parseCoursebook(String fileName){

    }
}
