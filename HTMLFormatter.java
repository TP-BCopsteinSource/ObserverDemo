/**
   An HTML invoice formatter.
*/
public class HTMLFormatter implements InvoiceFormatter
{
   public String formatHeader()
   {
      total = 0;
      String s = "<HTML>\n"

               + "<HEAD>\n"
               + "<TITLE>NOTA FISCAL</TITLE>\n"
               + "</HEAD>\n"

               + "<BODY>\n"

               + "<H1>NOTA FISCAL</H1>\n"

               + "<TABLE BORDER=2>\n"

               + "<TR>\n"
               + "<TD>ITEM</TD>\n"
               + "<TD>VALOR</TD>\n"
               + "</TR>\n";

      return s;
   }

   public String formatLineItem(LineItem item)
   {
      total += item.getPrice();

      String s = "<TR>\n"
               + "<TD>" + item.toString() + "</TD>\n"
               + "<TD>" + "R$" + item.getPrice() + "</TD>\n"
               + "</TR>\n";

      return s;
   }

   public String formatFooter()
   {
      String s = "<TR>\n"
               + "<TD>" + "TOTAL"  + "</TD>\n"
               + "<TD>" + "R$" + total + "</TD>\n"
               + "</TR>\n"
               + "</TABLE>\n"
               + "</BODY>\n"
               + "</HTML>\n";

      return s;
   }
   
   private double total;
}
