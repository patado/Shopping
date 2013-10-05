/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author phamon
 */
public class Menu {
    
    Date startDate;
    String recipeName;
    ArrayList <Individual> guest = new ArrayList();
    Scanner sc = new Scanner (System.in);
    
    
    public static void requestRecipe() {
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter ingredient name - ");
        String s = sc.next();
        
        new DBConnect().dbconnecttoSQLite("select RecItem from RecipeIngredients where InItem LIKE '%"+ s + "%'");
        
    }
    
    
    public static void returnRecipeName (int i) {
        
        new DBConnect().dbconnecttoSQLite("select RecItem from RecipeIngredients where InItem LIKE 'Milk'");
        
    }
    
}