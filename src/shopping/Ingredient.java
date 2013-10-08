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
public class Ingredient extends Home {
    Scanner sc = new Scanner (System.in);
    static ArrayList <Ingredient> cupboard = new ArrayList();
    
    String Ingredientname;
    float quantity;
    String measurement;

    public Ingredient(String Ingredientname) {
        this.Ingredientname = Ingredientname;
    }

    @Override
    public String toString() {
        return "Ingredients{" + "Ingredientname=" + Ingredientname + '}';
    }
    
    
    public static void updateCupboard() {
        System.out.print("\nAt present you have ");
        for (int i=0 ; i<cupboard.size() ; i++)
            System.out.print((cupboard.get(i).Ingredientname)+", ");
        if (cupboard.isEmpty())
            System.out.print("nothing");
            
        System.out.println(" in the cupboard. ");
        
        if (cupboard.size()>1)
        {
            System.out.println("\nDo you want to remove / add ingredients?");
            System.out.println("type 1 to add");
            System.out.println("type 2 to remove");
            System.out.println("type 0 to exit");
        }
        else
        {
            System.out.println("Do you want to add ingredients?");
            System.out.println("type 1 to add");
            System.out.println("type 0 to exit");
        }
        
//        int optionAddPeople = sc.nextInt();
//        
//        switch (optionAddPeople){
//            case 0: return;
//            case 1: addPeople();
//                break;
//            case 2: removePeople();
//        }
    }
    
}