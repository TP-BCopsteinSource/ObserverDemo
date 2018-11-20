import javax.swing.JEditorPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class VisualizadorTextoHtml extends JEditorPane implements ChangeListener {
	private Invoice invoice;
	private InvoiceFormatter invForm;
	
    public VisualizadorTextoHtml(Invoice i){
        this.setEditable(false);
        this.setContentType("text/html");
        invoice = i;
    	invForm = new HTMLFormatter();
    }
	@Override
	public void stateChanged(ChangeEvent e) {
        this.setText(invoice.format(invForm));
	}
}
