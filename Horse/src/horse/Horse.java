/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horse;

import java.util.Calendar;
/**
 *
 * @author bill
 */
public class Horse {
    
    private String name;
    private int weight;
    private int birthYear;
    private char gender;
    private String sire;
    private String dam;
    
    public Horse(){
        name = " ";
        weight = 0;
        birthYear = 0;
        gender = ' ';
        sire = " ";
        dam = " ";        
    }
    
    public Horse(String horseName, int horseWeight, int horseBirthYear,
                        char horseGender, String horseSire, String horseDam){
        name = horseName;
        weight = horseWeight;
        birthYear = horseBirthYear;
        gender = horseGender;
        sire = horseSire;
        dam = horseDam;
    }
    
    public String getName(){
        return name;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public int getBirthYear(){
        return birthYear;
    }
    
    public char getGender(){
        return gender;
    }
    
    public String getSire(){
        return sire;       
    }
    
    public String getDam(){
        return dam;
    }
    
    
    //  MUTATOR SECTION
    
    public void setName(String horseName){
        name = horseName;        
    }
    
    public void setWeight(int horseWeight){
        weight = horseWeight;
    }
    
    public void setBirthYear(int horseBirthYear){
        birthYear = horseBirthYear;        
    }
    
    public void setGender(char horseGender){
        gender = horseGender;
    }
    
    public void setSire(String horseSire){
        sire = horseSire;
    }
    
    public void setDam(String horseDam){
        dam = horseDam;
    }
    
    public int getAge(){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentAge = (currentYear - birthYear);
        
        return currentAge;
    }
    
    public String toString(){
        String genderString;
        
        if (gender == 'M'){
            genderString = "male";
        }
        else {
            genderString = "female";
        }
        String output = name + " is a " + weight + " lb. " + genderString + " born in " + birthYear + 
                            " to the sire " + sire + " and the dam " + dam + ".";
        
        return output;
    }
    
}
