import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class VisualizadorTextoNormal extends JTextArea implements ChangeListener {
	private Invoice invoice;
	private InvoiceFormatter invForm;
	
    public VisualizadorTextoNormal(Invoice i){
    	super(20,40);
    	invoice = i;
    	invForm = new SimpleFormatter();
    }
	@Override
	public void stateChanged(ChangeEvent e) {
        this.setText(invoice.format(invForm));
	}
}
