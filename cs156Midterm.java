/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Don
 */

/**
 * DateFormat dateFormat = new SimpleDateFormat( "MM/dd/yyyy hh:mm:ss");
 * Date date = new Date();
 * JOptionPane.showMessageDialog(null," Date & Time");
 * JOptionPane.showMessageDialog(null,dateFormat.format(date));
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner; // ALL IMPORT DECLARATIONS MUST BE ENTERED B4 CLASS!
import javax.swing.*;
import java.applet.*;
// !

public class CS156Midterm {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        
        String user_input = "";
        
        // USES A DIALOG BOX TO Get """"Input"" MESSAGE!!!!!!!!!!!!!!!!!!
        String name = JOptionPane.showInputDialog(null,"Hello, What is your name?");


        //STORES INPUT FROM DIALOG BOX INTO NEW STRING VARIABLE!!!!!!!
        String message1 = String.format("Hello %s. This program will calculate "
                + "the average score\nfor every student grade. Lets begin!", name);
        
        // USES A DIALOG BOX TO PRINT MESSAGE!!!!!!!!!!!!!!!!!!
        JOptionPane.showMessageDialog(null,message1);

        String stamt = JOptionPane.showInputDialog(null,"How many students will we be calculating today?");
        stamt = ParseString(stamt);
        int studamt = Integer.parseInt(stamt);
        
        String StudentName[] = new String[studamt];
        
        int scoreamt[] = new int[studamt];
        
        //int scores [];
        int [][]gotscores = new int[studamt][100];
        double average[] = new double[studamt];
        
        for(int i=0; i<studamt; i++)
        {
            //Gets each students name!!!!
            StudentName[i] = GetStudentName(i+1);
            
            //Gets amount of scores per student!!!!
            scoreamt[i] = GetScoresAmt(StudentName, i);
               
            for(int j=i; j==i; j++){
            gotscores[j] = GetScores(scoreamt[j]);
            
            }
            
            average[i] = GetAverage(gotscores[i], scoreamt[i]);
        }
        
        for(int i = 0; i < StudentName.length; i++){
        JOptionPane.showMessageDialog(null,"The average of " + StudentName[i] + "'s grades is: " + average[i]);
        }


        //DISPLAYING INFO IN FRAME!!!!

        //Sets Font!!!!
        Font font1 = new Font("Courier", Font.BOLD,14);

        //1. Create the frame.
        JFrame myFrame = new JFrame("HERE ARE THE RESULTS!");
        myFrame.getContentPane().setFont(font1);


        //Random Colors!!!!!!!!!
        Random randomColorsgen = new Random();
        int color = 0; // stores each random color generated
        String colors = "";

        color = 1 + randomColorsgen.nextInt(7);


        //SETS RANDOM BACKGROUND COLOR!!!!!!!!!!

            switch (color) {
                case 1:
                    myFrame.getContentPane().setBackground(Color.YELLOW);
                    break;
                case 2:
                    myFrame.getContentPane().setBackground(Color.RED);
                    break;
                case 3:
                    myFrame.getContentPane().setBackground(Color.GREEN);
                    break;
                case 4:
                    myFrame.getContentPane().setBackground(Color.BLUE);
                    break;
                case 5:
                    myFrame.getContentPane().setBackground(Color.MAGENTA);
                    break;
                case 6:
                    myFrame.getContentPane().setBackground(Color.WHITE);
                    break;
                case 7:
                    myFrame.getContentPane().setBackground(Color.ORANGE);
                    break;
                default:
                    myFrame.getContentPane().setBackground(Color.PINK);
                    break;
            }

            // PUTS DATE ON JFRAME
            String date = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss").format(new Date());
            JLabel labeldate = new JLabel(date);

            //
            String studentnames = "Here are the student names: ";
            JLabel label1 = new JLabel(studentnames);


            //Structures The JFrame
            myFrame.getContentPane().setLayout(new FlowLayout ());
            myFrame.getContentPane().add(new JButton("Student Names"));
            myFrame.getContentPane().add(new JButton("Student Scores"));
            myFrame.getContentPane().add(new JButton("Student Averages"));
            myFrame.getContentPane().add(new JButton("Four"));
            myFrame.getContentPane().add(new JButton("Five"));
            myFrame.getContentPane().add(new JButton("Six"));

            //Set font for JLabels
            label1.setFont(font1);
            labeldate.setFont(font1);

            //myFrame.getContentPane().setFont(font1);
            myFrame.setSize(800, 600);

            myFrame.setLocationRelativeTo(null);
            myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            myFrame.setVisible(true);

        }


    //}
    
    public static String GetStudentName(int counter)
    {
        
        return JOptionPane.showInputDialog(null,"What is the name of student number " + counter);

    }
    
    public static int GetScoresAmt(String StudentName[], int pos)
    {
        String samt;
        samt = JOptionPane.showInputDialog(null,"How many scores will we be calculating "
                + "for " + StudentName[pos] + " today?");
        
        samt = ParseString(samt);
        int amt = Integer.parseInt(samt);
        return amt;

    }
    
    public static int [] GetScores(int size)
    {
        String sarr[];
        sarr = new String[size];
        
        int counter = 1;
        
        int arr[];
        arr = new int [size];
        
        for(int i=0; i<size; i++){
            sarr[i] = JOptionPane.showInputDialog(null,"Please enter score number " + counter);
            counter++;
            sarr[i] = ParseString(sarr[i]);
            arr[i] = Integer.parseInt(sarr[i]);
        }
        return arr;
    }
    
    public static int GetAverage( int scorearr[], int numofgrades)
    {
        int total = 0;
        
        for(int i=0; i <numofgrades; i++){
            total += scorearr[i];
        }
        return total / numofgrades;

    }
    
    public static String ParseString(String str)
    { 
       String newstr = "";
        
       for (char ch : str.toCharArray()){
       
           if (Character.isDigit(ch)){
           newstr += ch;
           }
        }
       
       //System.out.println(" THIS IS THE PARSE STRING: " +newstr);
       return newstr;
       }      
    }




