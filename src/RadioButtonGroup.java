import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class RadioButtonGroup {
    public static void main(String[] args, Display display, Shell shell) {
        myGroup(display, shell);
    }

    static void myGroup(Display display, Shell shell) {
        Group group3 = new Group(shell, SWT.NONE);
        group3.setText("Group №3");;
        group3.setLayout(new FillLayout(SWT.VERTICAL));

        Text text3 = new Text(group3, SWT.SINGLE | SWT.BORDER);
        text3.setTextLimit(8);

        Button button3 = new Button (group3, SWT.PUSH);
        button3.setText("OK");

        Button button31 = new Button (group3, SWT.RADIO);
        button31.setText("One");

        Button button32 = new Button (group3, SWT.RADIO);
        button32.setText("Two");

        Button button33 = new Button (group3, SWT.RADIO);
        button33.setText("Three");

        button3.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {

                if(!text3.getText().isEmpty()) {

                    if(text3.getText().contentEquals(button31.getText())) {
                        button31.setSelection(true);
                        button32.setSelection(false);
                        button33.setSelection(false);
                    }
                    else if(text3.getText().contentEquals(button32.getText())) {
                        button31.setSelection(false);
                        button32.setSelection(true);
                        button33.setSelection(false);
                    }
                    else if(text3.getText().contentEquals(button33.getText())) {
                        button31.setSelection(false);
                        button32.setSelection(false);
                        button33.setSelection(true);
                    }
                    else{
                        MessageBox msg3 = new MessageBox(shell, SWT.ICON_ERROR);
                        msg3.setMessage("No button with a specified name!");
                        msg3.open();
                    }
                }
            }
        });

    }

}