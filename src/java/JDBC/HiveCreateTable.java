/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiveCreateTable {
   private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
   
   public static void main(String[] args) throws SQLException {
   try {
          
           Class.forName(driverName);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(HiveCreateTable.class.getName()).log(Level.SEVERE, null, ex);
       }
      
      // get connection
      Connection con = DriverManager.getConnection("jdbc:hive://demo.gethue.com/ad", "demo", "demo");
      
      // create statement
      Statement stmt = con.createStatement();
      
      // execute statement
      stmt.executeQuery("CREATE TABLE IF NOT EXISTS "
         +" ejemploA ( eid int, name String, "
         +" salary String, destignation String)"
         +" COMMENT ‘Employee details’"
         +" ROW FORMAT DELIMITED"
         +" FIELDS TERMINATED BY ‘\t’"
         +" LINES TERMINATED BY ‘\n’"
         +" STORED AS TEXTFILE;");
         
      System.out.println("Table employee created.");
      con.close();
   }
}