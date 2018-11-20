/**
   A simple invoice formatter.
*/
public class SimpleFormatter implements InvoiceFormatter
{
   public String formatHeader()
   {
      total = 0;
      return "     N O T A   F I S C A L\n\n\n";
   }

   public String formatLineItem(LineItem item)
   {
      total += item.getPrice();
      return item.toString() + ": R$" 
         + item.getPrice() + "\n";
   }

   public String formatFooter()
   {
      return "\n\nTOTAL: R$" + total + "\n";
   }
   
   private double total;
}

