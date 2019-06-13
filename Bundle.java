import java.util.*;

/**
   Composite Pattern
   A bundle of items that is again an item.
*/
public class Bundle implements LineItem
{
   private ArrayList<LineItem> items;
   /**
      Constructs a bundle with no items.
   */
   public Bundle() { items = new ArrayList<LineItem>(); }

   /**
      Adds an item to the bundle.
      @param item the item to add
   */
   public void add(LineItem item) { items.add(item); }

   public double getPrice() 
   {
      double price = 0;
      for (int i = 0; i < items.size(); i++)
      {
         LineItem item = (LineItem) items.get(i);
         price += item.getPrice();
      }
      return price; 
   }

   public String toString()
   {
      String description = "Pacote: ";
      for (int i = 0; i < items.size(); i++)
      {
         if (i > 0) description += ", ";
         LineItem item = (LineItem) items.get(i);
         description += item.toString();
      }
      return description;
   } 
}
