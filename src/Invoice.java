import java.util.*;
import javax.swing.event.*;

/**
   An invoice for a sale, consisting of line items.
*/
public class Invoice{
   private ArrayList<LineItem> items;
   private ArrayList<ChangeListener> listeners;

   /**
      Constructs a blank invoice.
   */
   public Invoice()
   {
      items = new ArrayList<LineItem>();
      listeners = new ArrayList<ChangeListener>();
   }

  /**
      Adds an item to the invoice.
      @param item the item to add
   */
   public void addItem(LineItem item) 
   { 
      items.add(item); 
      // notify all observers of the change to the invoice
      ChangeEvent event = new ChangeEvent(this);
      listeners.forEach(l->l.stateChanged(event));
   }

   /**
      Adds a change listener to the invoice.
      @param listener the change listener to add
   */
   public void addChangeListener(ChangeListener listener) 
   { 
      listeners.add(listener); 
   }

   public String format(InvoiceFormatter formatter){
      String r = formatter.formatHeader();
      for(LineItem item:items) {
          r += formatter.formatLineItem(item);    	  
      }
      return r + formatter.formatFooter();
   }
}
