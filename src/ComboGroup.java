import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ComboGroup {


    public static void main(String[] args, Display display, Shell shell) {

        myGroup(display, shell);

    }

    static void myGroup(Display display, Shell shell) {

        Group group = new Group(shell, SWT.NONE);
        group.setText("Group №1");
        group.setLayout(new FillLayout(SWT.VERTICAL));

        Text input = new Text(group, SWT.SINGLE | SWT.BORDER);
        input.setTextLimit(8);

        Button OK = new Button (group, SWT.PUSH);
        OK.setText("OK");

        Combo combo = new Combo(group, SWT.DROP_DOWN);

        OK.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                if(combo.getItemCount()>=1) {
                    MessageBox msg1 = new MessageBox(shell, SWT.ICON_ERROR);
                    msg1.setMessage("Can't add new text!");
                    msg1.open();
                }
                else {
                    if(!input.getText().isEmpty()) {
                        combo.add(input.getText());
                    }
                }
            }
        });

    }

}