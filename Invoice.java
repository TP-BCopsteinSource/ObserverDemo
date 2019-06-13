import java.util.List;
import java.util.ArrayList;
import java.util.Observable;

/**
   An invoice for a sale, consisting of line items.
*/
public class Invoice extends Observable{
   private List<LineItem> items;

   public Invoice()
   {
      items = new ArrayList<LineItem>();
   }

   public void addItem(LineItem item) 
   { 
      items.add(item); 
      // notify all observers of the change to the invoice
      setChanged();
      notifyObservers();
   }

   public String format(InvoiceFormatter formatter){
      String r = formatter.formatHeader();
      for(LineItem item:items) {
          r += formatter.formatLineItem(item);    	  
      }
      return r + formatter.formatFooter();
   }
}
