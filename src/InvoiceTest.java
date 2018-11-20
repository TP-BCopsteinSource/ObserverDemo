import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
   A program that tests the invoice classes.
*/
public class InvoiceTest
{
   public static void main(String[] args)
   {
      final Invoice invoice = new Invoice();
      final VisualizadorTextoNormal vtn = new VisualizadorTextoNormal(invoice);
      final VisualizadorTextoHtml vhtm = new VisualizadorTextoHtml(invoice);
      
      invoice.addChangeListener(vtn);      
      invoice.addChangeListener(vhtm);
      
    
      // add line items to a combo box
      final JComboBox combo = new JComboBox();   
      Product martelo = new Product("Martelo", 19.95);
      combo.addItem(martelo);
      Product pregos = new Product("Pregos variados", 9.95);
      combo.addItem(pregos);
      Product tinta = new Product("Tinta vinil", 35.60);
      combo.addItem(tinta);
      Bundle pacoteMartelo = new Bundle();
      pacoteMartelo.add(martelo);
      pacoteMartelo.add(pregos);
      combo.addItem(new DiscountedItem(pacoteMartelo, 10));

      // make a button for adding the currently selected
      // item to the invoice
      JButton addButton = new JButton("Add");
      addButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               LineItem item = (LineItem) combo.getSelectedItem();
               invoice.addItem(item);
            }
         });

      // put the combo box and the add button into a panel
      JPanel panel = new JPanel();
      panel.add(combo);
      panel.add(addButton);

      JFrame frame = new JFrame();
      Container contentPane = frame.getContentPane();
      contentPane.add(panel, BorderLayout.SOUTH);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
      
      JFrame frameView1 = new JFrame();
      frameView1.getContentPane().add(new JScrollPane(vtn),BorderLayout.CENTER);
      //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frameView1.pack();
      frameView1.setVisible(true);        

      JFrame frameView2 = new JFrame();
      JScrollPane jp = new JScrollPane(vhtm);
      jp.setPreferredSize(new Dimension(500, 300));
      frameView2.getContentPane().add(jp,BorderLayout.CENTER);
      //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frameView2.pack();
      frameView2.setVisible(true);          
   }
}
