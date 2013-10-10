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
    
    public Ingredient() {
        updateCupboard();
    }

    public Ingredient(String Ingredientname) {
        this.Ingredientname = Ingredientname;
    }
    
    public Ingredient(String Ingredientname, String measurement, float quantity) {
        this.Ingredientname = Ingredientname;
        this.measurement = measurement;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Ingredients{" + "Ingredientname=" + Ingredientname + '}';
    }
    
    
    public void updateCupboard() {
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
            System.out.println("type 3 to amend details for an ingredient");
            System.out.println("type 0 to exit");
        }
        else
        {
            System.out.println("Do you want to add ingredients?");
            System.out.println("type 1 to add");
            System.out.println("type 0 to exit");
        }
        
        int optionAddIngredient = sc.nextInt();
        
        switch (optionAddIngredient){
            case 0: return;
            case 1: addIngredient();
                break;
          //  case 2: removeIngredient();
          //  case 3: amendIngredientQuantity();
          //  case 4: amendIngredientName();
            }
    }
    
    
    public void addIngredient(){
        System.out.println("How many ingredients do you want to add?");
        int numberIngredients = sc.nextInt();
        for (int i=0 ; i<numberIngredients ; i++)
        {
            System.out.println("\nName of the ingredient?");
            String nameIngredient = sc.next();
            System.out.println("What is the basis for measuring "+nameIngredient+"?" );
            System.out.println("1. Gram");
            System.out.println("2. Litre");
            System.out.println("3. Item");
            System.out.println("4. Slice");
            System.out.println("5. Tablespoon");
            System.out.println("6. Teaspoon");
            int measurementOption = sc.nextInt();
            String measurement = "";
            switch (measurementOption) {
                case 1: measurement = "Gram";
                case 2: measurement = "Litre";
                case 3: measurement = "Item";
                case 4: measurement = "Slice";
                case 5: measurement = "Tablespoon";
                case 6: measurement = "Teaspoon";
            }
            System.out.println("\nQuantity of "+nameIngredient+"?");
            float QuantityIngredient = sc.nextFloat();
            
            Ingredient newIngredient = new Ingredient (nameIngredient,measurement,QuantityIngredient);
            cupboard.add(newIngredient);
            
            
        }
        Admin.menuStart();
    }
    
}