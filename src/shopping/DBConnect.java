/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;


import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author phamon
 */
public class DBConnect {
    
    
    
    
    public void dbconnecttoSQLite(String s) {
    
    // load the sqlite-JDBC driver using the current class loader
    try {
        
        Class.forName("org.sqlite.JDBC");

    }
    catch (ClassNotFoundException e) {
        System.err.println(e);
    }
    Connection connection = null;
    try
    {
      // create a database connection
      connection = DriverManager.getConnection("jdbc:sqlite:recipe.db");
      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      
//      ResultSet rs = statement.executeQuery("select * from Keywords");
      
      
      
      ResultSet rs2 = statement.executeQuery(s);
      
      
      
      
      
//      
//      while(rs.next())
//      {
//        // read the result set
//        System.out.println("Keyname = " + rs.getString("Keyname"));
//        System.out.println("id = " + rs.getInt("id"));
//      }
      
      
      while(rs2.next())
      {
        // read the result set
        System.out.println(rs2.getString("RecItem"));
//        System.out.println("id = " + rs.getInt("id"));
      }
    }
    catch(SQLException e)
    {
      // if the error message is "out of memory", 
      // it probably means no database file is found
      System.err.println(e.getMessage());
    }
    finally
    {
      try
      {
        if(connection != null)
          connection.close();
      }
      catch(SQLException e)
      {
        // connection close failed.
        System.err.println(e);
      }
    }
    
}
    
     public ArrayList dbconnecttoSQLite2(String s) {
    
    // load the sqlite-JDBC driver using the current class loader
         
         ArrayList <String> aL = new ArrayList();
    try {
        
        Class.forName("org.sqlite.JDBC");

    }
    catch (ClassNotFoundException e) {
        System.err.println(e);
    }
    Connection connection = null;
    try
    {
      // create a database connection
      connection = DriverManager.getConnection("jdbc:sqlite:recipe.db");
      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      ResultSet rs2 = statement.executeQuery(s);

      while(rs2.next())
      {
        // read the result set
          aL.add(rs2.getString("RecItem"));
          //System.out.println(rs2.getString("RecItem"));

      }
      connection.close();
    }
    catch(SQLException e)
    {
      // if the error message is "out of memory", 
      // it probably means no database file is found
      System.err.println(e.getMessage());
    }
    finally
    {
      try
      {
        if(connection != null)
          connection.close();
      }
      catch(SQLException e)
      {
        // connection close failed.
        System.err.println(e);
      }
    }
    
    return aL;
    
}
    
     
     public String dbconnecttoSQLite3(String s) {
    
    // load the sqlite-JDBC driver using the current class loader
         
         //ArrayList <String> aL = new ArrayList();
         String result = null;
    try {
        
        Class.forName("org.sqlite.JDBC");

    }
    catch (ClassNotFoundException e) {
        System.err.println(e);
    }
    Connection connection = null;
    try
    {
      // create a database connection
      connection = DriverManager.getConnection("jdbc:sqlite:recipe.db");
      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      ResultSet rs2 = statement.executeQuery(s);

      result = rs2.getString("RecItem");
      
    }
    catch(SQLException e)
    {
      // if the error message is "out of memory", 
      // it probably means no database file is found
      // System.err.println(e.getMessage());
    }
    finally
    {
      try
      {
        if(connection != null)
          connection.close();
      }
      catch(SQLException e)
      {
        // connection close failed.
        System.err.println(e);
      }
    }
    
    return result;
    
}
    
    
    
    
}