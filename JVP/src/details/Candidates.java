/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package details;

import java.util.Scanner;

/**
 *
 * @author denan
 */
public class Candidates {
    private String nama, qualification, status;
    private int age;
    
    public void getCandidatesDetails () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Name :");
        nama = sc.next(); 
        System.out.println("Enter Your Qualification :");
        qualification = sc.next();
        System.out.println("Enter Your Age :");
        age = sc.nextInt();
        AgeValidation obj= new AgeValidation ();
        obj.validateAge ();
    }
    private class AgeValidation {
      public void validateAge (){
          if (age>=21 && age<=25){
              status="selected";
          }
          else {
              status="rejected";
          }
      }   
    }
    public void printCandidatesDetails(){
        System.out.println("Name: "+nama);
        System.out.println("Qualification: "+qualification);
        System.out.println("Age: "+age);
        System.out.println("Selection Status: "+status);
    }
    public static void main(String args []){
        Candidates candidates=new Candidates();
        candidates.getCandidatesDetails();
        candidates.printCandidatesDetails();
    }
        
        
   
}
