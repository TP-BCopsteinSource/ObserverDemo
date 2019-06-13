import java.util.Observer;
import java.util.Observable;

import javax.swing.JEditorPane;
import javax.swing.event.ChangeEvent;


public class VisualizadorTextoHtml extends JEditorPane implements Observer {
	private InvoiceFormatter invForm;
	
    public VisualizadorTextoHtml(Invoice invoice){
        this.setEditable(false);
        this.setContentType("text/html");
        invoice.addObserver(this);
    	invForm = new HTMLFormatter();
    }

	@Override
	public void update(Observable e,Object arg) {
        Invoice inv = (Invoice)e;
        this.setText(inv.format(invForm));
	}
}
