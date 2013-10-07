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
        
        new DBConnect().dbconnecttoSQLite("select DISTINCT RecItem from RecipeIngredients where InItem LIKE '%"+ s + "%'");
        
    }
    
    public static void requestRecipe2() {
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter ingredient name - ");
        String s = sc.next();
        ArrayList <String> aL = new ArrayList();
        ArrayList <String> aL2 = new ArrayList();
        
        aL = new DBConnect().dbconnecttoSQLite2("select DISTINCT RecItem from RecipeIngredients where InItem LIKE '%"+ s + "%'");
        
        //.dbconnecttoSQLite("select DISTINCT RecItem from RecipeIngredients where InItem LIKE '%"+ s + "%'");
        
        System.out.println(aL.toString());
        
        System.out.print("Enter next ingredient name - ");
        String s2 = sc.next();
        
        for (int x= 0; x<aL.size(); x++) {
            
            String s3 = new DBConnect().dbconnecttoSQLite3("select RecItem from RecipeIngredients where RecItem LIKE '" + aL.get(x) + "' AND InItem LIKE '%" + s2 + "%'");
            if (s3 != null) {
                
                aL2.add(s3);
                
            }
            
        }
        
        System.out.println(aL2.toString());
        
    }
    
            
            
    
    
    
    public static void returnRecipeName (int i) {
        
        new DBConnect().dbconnecttoSQLite("select RecItem from RecipeIngredients where InItem LIKE 'Milk'");
        
    }
    
}