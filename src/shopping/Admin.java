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
public class Admin {
    

    public static void menuStart(){
        Scanner sc = new Scanner (System.in);
        
        int menuInit = 0;
        boolean flag = false;
        
        do
        {
            flag=false;
            System.out.println("\t\t** Initialisation menu **");
            System.out.print("\n");
            System.out.println("Please select one of the options below.");
            System.out.print("\n");
            System.out.println("1  - I have an ingredient, just need a list of recipes that use it");
            System.out.println("2  - I have a number of ingredients, just need a list of recipes that use them all");
            System.out.println("3  - Show me the list of recipes where I already have all the ingredients (no shopping)");
            System.out.println("4  - I want to prepare menus for the week and generate the relevant shopping list");
            System.out.println("5  - Return All Recipes");//("5  - I want to add another recipe to the database");
            System.out.println("6  - Show me the list of items that will hit the 'use by date' this week");
            System.out.println("7  - Update the list of items showing in my cupboard");
            System.out.println("8  - In this menu you may specify how many people live at home (default 1)");
            System.out.println("\t If any have food allergies (default none)");
            System.out.println("\t If any is a vegetarian (default none)");
            System.out.println("9  - In this menu you may list the equipment at your disposal for cooking (default none)");
            System.out.println("10 - In this menu you may specify the general requirements for your menus (default none)");
            System.out.println("11 - Reports section");
            System.out.println("12 - Let me select a recipe in the database");
            System.out.println("0 - Exit");

            try{

                menuInit = sc.nextInt();}
            catch(Exception e)
                {System.out.println("Please select a number");flag=true;};

            if (menuInit>12 | menuInit<0)
                flag=true;

            sc.nextLine();
        }while (flag);
        
        ArrayList <Ingredient> arrL = new ArrayList();
        arrL.add(new Ingredient("Nuts"));
        arrL.add(new Ingredient("Chicken"));
        
        switch (menuInit)
        {
            case 1: System.out.println("menu 1");
                Menu.requestRecipe();
                break;
            case 2: System.out.println("menu 2");
                Menu.requestRecipe2();
                break;
            case 3: Individual a = new Individual("Bob");
                System.out.print(a.toString());
                break;
            case 4: Individual b = new Individual("Jim", arrL );
                System.out.print(b.toString());
                break;
           case 5: System.out.println("menu 5");
                Menu.returnAllRecipes();
                break;
           case 6: System.out.println("menu 6");
                break;
           case 7: System.out.println("menu 7");
                new Ingredient();
                break;
           case 8: System.out.println("menu 8");
                   new Individual();
                break;
           case 9: System.out.println("menu 9");
                break;
           case 10: System.out.println("menu 10");
                break;
           case 11: System.out.println("menu 11");
                break;
           case 12: FrontJFrame.CreateFrontJFrame();
                break;
        }
        
        
        
}
    
    public static void displayIndividual(Individual in) {
        
        // System.out.println(in.toString());
        
        
    }
    
}