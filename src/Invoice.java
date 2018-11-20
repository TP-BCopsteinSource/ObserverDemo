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
      for (int i = 0; i < listeners.size(); i++)
      {
         ChangeListener listener = listeners.get(i);
         listener.stateChanged(event);
      }
   }

   /**
      Adds a change listener to the invoice.
      @param listener the change listener to add
   */
   public void addChangeListener(ChangeListener listener) 
   { 
      listeners.add(listener); 
   }

   /**
      Gets an iterator that iterates through the items.
      @return an iterator for the items
   */
   public Iterator<LineItem> getItems()
   {
      return new
         Iterator<LineItem>()
         {
            public boolean hasNext() 
            { 
               return current < items.size(); 
            }
            public LineItem next() 
            { 
               LineItem r = items.get(current);
               current++; 
               return r;
            }
            public void remove()
            {
               throw new UnsupportedOperationException();
            }
            private int current = 0;
         };
   }

   public String format(InvoiceFormatter formatter)
   {
      String r = formatter.formatHeader();
      Iterator<LineItem> iter = getItems(); 
      while (iter.hasNext())
      {
         LineItem item = iter.next();
         r += formatter.formatLineItem(item);
      }
      return r + formatter.formatFooter();
   }
}
