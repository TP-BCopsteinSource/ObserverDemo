import java.util.Observer;
import java.util.Observable;


import javax.swing.JTextArea;

public class VisualizadorTextoNormal extends JTextArea implements Observer {
	private InvoiceFormatter invForm;
	
    public VisualizadorTextoNormal(Invoice invoice){
    	super(20,40);
    	invoice.addObserver(this);
    	invForm = new SimpleFormatter();
	}
	
	@Override
	public void update(Observable e,Object arg) {
		Invoice inv = (Invoice)e;
        this.setText(inv.format(invForm));
	}
}
