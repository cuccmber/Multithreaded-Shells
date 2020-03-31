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

public class ComboGroub {


    public static void main(String[] args, Display display, Shell shell) {

        MyGroup(display, shell);

    }

    static void MyGroup(Display display, Shell shell) {

        Group group1 = new Group(shell, SWT.NONE);
        group1.setText("Group №1");
        group1.setLayout(new FillLayout(SWT.VERTICAL));

        Text text1 = new Text(group1, SWT.SINGLE | SWT.BORDER);
        text1.setTextLimit(8);

        Button button1 = new Button (group1, SWT.PUSH);
        button1.setText("OK");

        Combo combo1 = new Combo(group1, SWT.DROP_DOWN);

        button1.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                if(combo1.getItemCount()>=1) {
                    MessageBox msg1 = new MessageBox(shell, SWT.ICON_ERROR);
                    msg1.setMessage("Can't add new text!");
                    msg1.open();
                }
                else {
                    if(!text1.getText().isEmpty()) {
                        combo1.add(text1.getText());
                    }
                }
            }
        });

    }

}