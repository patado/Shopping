/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;


import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


/**
 *
 * @author phamon
 */
public class DBConnect {
    
    
    
    
    public void dbconnecttoSQLite(String sqlQuery) {
    
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
      
      
      
      ResultSet queryResultSet = statement.executeQuery(sqlQuery);
      
      
      
      
      
//      
//      while(rs.next())
//      {
//        // read the result set
//        System.out.println("Keyname = " + rs.getString("Keyname"));
//        System.out.println("id = " + rs.getInt("id"));
//      }
      
      
      while(queryResultSet.next())
      {
        // read the result set
        System.out.println(queryResultSet.getString("RecItem"));
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
    
     public ArrayList dbconnecttoSQLite2(String SQLQuery) {
    
    // load the sqlite-JDBC driver using the current class loader
         
         ArrayList <String> QueryResultsNameRecipe = new ArrayList();
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
      
      ResultSet queryResultSet = statement.executeQuery(SQLQuery);
      

      while(queryResultSet.next())
      {
        // read the result set
          QueryResultsNameRecipe.add(queryResultSet.getString("RecItem"));
          //System.out.println(rs2.getString("RecItem"));

      }
      
      statement.close();
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
    
    return QueryResultsNameRecipe;
    
}
    
     
     public String dbconnecttoSQLite3(String SQLQuery) {
    
    // load the sqlite-JDBC driver using the current class loader
         
         String result = null;
    try {
        
        Class.forName("org.sqlite.JDBC");

    }
    catch (ClassNotFoundException e) {
        System.err.println(e);
    }
    Connection connection = null;
    // System.err.println("Here");
    try
    {
      // create a database connection
      connection = DriverManager.getConnection("jdbc:sqlite:recipe.db");
      Statement statement2 = connection.createStatement();
      statement2.setQueryTimeout(30);  // set timeout to 30 sec.

      ResultSet queryResultSet = statement2.executeQuery(SQLQuery);
      
      

      result = queryResultSet.getString("RecItem");
      

      
    }
    catch(SQLException e)
    {
      // if the error message is "out of memory", 
      // it probably means no database file is found
      // 
        // System.err.println(e.getMessage());///////// Multiple querries are causing a resultset closed error
        //System.err.println(e.toString());
        
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
     
     
        public void dbconnecttoSQLiteGetAndDisplayRecipe(String RecipeName) {
    
    // load the sqlite-JDBC driver using the current class loader
         
         ArrayList <String> aLresult = new ArrayList();
    try {
        
        Class.forName("org.sqlite.JDBC");

    }
    catch (ClassNotFoundException e) {
        System.err.println(e);
    }
    Connection connection = null;
    // System.err.println("Here");
    try
    {
      // create a database connection
      connection = DriverManager.getConnection("jdbc:sqlite:recipe.db");
      Statement statement2 = connection.createStatement();
      statement2.setQueryTimeout(30);  // set timeout to 30 sec.

      String SQLQuery = "SELECT Description FROM Procedure WHERE RecItem LIKE '" + RecipeName + "' ORDER BY RecItem";
      ResultSet queryResultSet = statement2.executeQuery(SQLQuery);
      
      
      while(queryResultSet.next())
      {
        // read the result set
          aLresult.add(queryResultSet.getString("Description"));

      }
      
      Statement statement3 = connection.createStatement();
      statement3.setQueryTimeout(30);  // set timeout to 30 sec.

      String SQLQuery3 = "SELECT PicData FROM Pics where RecItem LIKE '" + RecipeName + "'";
      ResultSet queryResultSet3 = statement3.executeQuery(SQLQuery3);
      
      Blob imageBlob = queryResultSet3.getBlob("PicData");
      InputStream binaryStream = imageBlob.getBinaryStream(0, imageBlob.length());
      Image image = null;
      try {
          image = ImageIO.read(binaryStream);
          
      }
      catch (IOException e) {
          
      }
      ImageIcon icon = new ImageIcon(image);
      
      
      new OneRecipeDisplayJFrame(RecipeName, aLresult, icon).CreateJFrame(RecipeName, aLresult, icon);

      
    }
    catch(SQLException e)
    {
      // if the error message is "out of memory", 
      // it probably means no database file is found
      // 
        // System.err.println(e.getMessage());///////// Multiple querries are causing a resultset closed error
        System.err.println(e.toString());
        
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
    
    //return result;
    
}

    
    
    
}