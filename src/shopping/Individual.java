/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author phamon
 */
public class Individual {
    
    Scanner sc = new Scanner (System.in);
    static ArrayList <Individual> family = new ArrayList();
    
    String name;
    ArrayList <Ingredient> allergies;
    boolean vegetarian;
    
    Individual(){
        initGuest();
    }
    
    Individual(String name){
        this.name = name;
        this.allergies = null;
    }

    public Individual(String name, ArrayList<Ingredient> allergies) {
        this.name = name;
        this.allergies = allergies;
    }

    public Individual(String name, ArrayList<Ingredient> allergies, boolean vegetarian) {
        this.name = name;
        this.allergies = allergies;
        this.vegetarian = vegetarian;
    }
    
    public Individual(String name, boolean vegetarian) {
        this.name = name;
        this.allergies = null;
        this.vegetarian = vegetarian;
    }

    @Override
    public String toString() {
        return "Individual{" + "name=" + name + ", allergies=" + allergies + ", vegetarian=" + vegetarian + '}';
    }
    
    public String toString(int i) {
        
        if (vegetarian)
            return name + " (Vegetarian)"; 
        else
            return name;
        
        
    }

    public void initGuest (){
        System.out.print("\nAt present ");
        for (int i=0 ; i<family.size() ; i++)
            System.out.print((family.get(i).name)+", ");
        if (family.size()>1)
            System.out.print("are");
        else if (family.isEmpty())
            System.out.print("nobody is");
        else
            System.out.print("is");
            
        System.out.println(" living at home. ");
        
        if (family.size()>0)
        {
            System.out.println("\nDo you want to remove / add people?");
            System.out.println("type 1 to add");
            System.out.println("type 2 to remove");
            System.out.println("type 0 to exit");
        }
        else
        {
            System.out.println("Do you want to add people?");
            System.out.println("type 1 to add");
            System.out.println("type 0 to exit");
        }
        
        int optionAddPeople = sc.nextInt();
        
        switch (optionAddPeople){
            case 0: Admin.menuStart();
            case 1: addPeople();
                break;
            case 2: removePeople();
        }
        
            
    }
    
    public void addPeople(){
        System.out.println("How many additional people are there at home?");
        int numberPeople = sc.nextInt();
        for (int i=0 ; i<numberPeople ; i++)
        {
            System.out.println("\nName of the individual?");
            String name = sc.next();
            System.out.println("If "+name+" is subject to allergies, please enter all relevant numbers");
            System.out.println("1. Peanuts");
            System.out.println("2. Other nuts");
            System.out.println("3. Eggs");
            System.out.println("4. Milk");
            System.out.println("5. Fish");
            System.out.println("6. Shellfish");
            System.out.println("7. Soy");
            System.out.println("8. Wheat");
            System.out.println("0. No allergy");
            String allergy = sc.next();
            
            ArrayList <Ingredient> allergyArrayList = new ArrayList ();
            for (int j=0 ; j<allergy.length() ; j++)
            {
               switch (allergy.charAt(j))
               {
                   case '1':allergyArrayList.add(new Ingredient ("Peanut"));
                       break;
                   case '2':allergyArrayList.add(new Ingredient ("Nut"));
                       break;
                   case '3':allergyArrayList.add(new Ingredient ("Egg"));
                       break;
                   case '4':allergyArrayList.add(new Ingredient ("Milk"));
                       break;
                   case '5':allergyArrayList.add(new Ingredient ("Fish"));
                       break;
                   case '6':allergyArrayList.add(new Ingredient ("Shellfish"));
                       break;
                   case '7':allergyArrayList.add(new Ingredient ("Soy"));
                       break;
                   case '8':allergyArrayList.add(new Ingredient ("Wheat"));
                       break;
                       
               }
            }
            
            System.out.println("Is "+name+" a vegetarian? (yes/no)");
            String vegString = sc.next();
            
            boolean veg=false;
            if (vegString.equals("Yes") | vegString.equals("yes") | vegString.equals("y") | vegString.equals("Y"))
                veg=true;
            
            Individual person = new Individual(name, allergyArrayList, veg);
            family.add(person);
        }
        
        System.out.print("\n");
        for (int i=0 ; i<family.size() ; i++)
            System.out.println(family.get(i).toString());
        
        Admin.menuStart();
    
    }
    
    public void removePeople(){
        System.out.println("\nPlease select relevant number for the family member you want to remove:");
        for (int i=0 ; i<family.size() ; i++)
            System.out.println((i)+". "+(family.get(i).toString()));
        
        int removePeople = sc.nextInt();
        
        family.remove(removePeople);
                  
            
        
        
        
        
        
        Admin.menuStart();
    
    }
    
}