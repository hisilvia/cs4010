// CartItemBean.java
// Class that maintains a book and its quantity.
package edu.umsl.java.servlets.bookstore;

import java.io.*;

public class CartItemBean implements Serializable {
   private static final long serialVersionUID = 1L;
   private BookBean book;
   private int quantity;
   private String subtotal;
   
   // initialize a CartItemBean
   public CartItemBean( BookBean bookToAdd, int number )
   {
      book = bookToAdd;
      quantity = number;
   }
   
   // get the book (this is a read-only property)
   public BookBean getBook()
   {
      return book;
   }

   // set the quantity
   public void setQuantity( int number )
   {
      quantity = number;
   }

   // get the quantity
   public int getQuantity()
   {
      return quantity;
   }
   
// set the quantity
   public void setSubtotal( String st )
   {
      subtotal = st;
   }

   // get the quantity
   public String getSubtotal()
   {
      return subtotal;
   }
   
}
