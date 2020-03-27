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

public class FourthGroup extends Window{
    public static void main(String[] args, Display display, Shell shell) {
        MyGroup(display, shell);
    }

    static void MyGroup(Display display, Shell shell) {
        Group group4 = new Group(shell, SWT.NONE);
        group4.setText("Group №4");;
        group4.setLayout(new FillLayout(SWT.VERTICAL));

        Text text4 = new Text(group4, SWT.SINGLE | SWT.BORDER);
        text4.setTextLimit(8);

        Button button4 = new Button (group4, SWT.PUSH);
        button4.setText("OK");

        Button button41 = new Button (group4, SWT.CHECK);
        button41.setText("One");

        Button button42 = new Button (group4, SWT.CHECK);
        button42.setText("Two");

        Button button43 = new Button (group4, SWT.CHECK);
        button43.setText("Three");

        button4.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {

                if(!text4.getText().isEmpty()) {

                    if(text4.getText().contentEquals(button41.getText())) {
                        if(button41.getSelection() == true) {
                            button41.setSelection(false);
                        }
                        else {
                            button41.setSelection(true);
                        }
                    }
                    else if(text4.getText().contentEquals(button42.getText())) {
                        if(button42.getSelection() == true) {
                            button42.setSelection(false);
                        }
                        else {
                            button42.setSelection(true);
                        }
                    }
                    else if(text4.getText().contentEquals(button43.getText())) {
                        if(button43.getSelection() == true) {
                            button43.setSelection(false);
                        }
                        else {
                            button43.setSelection(true);
                        }
                    }
                    else{
                        MessageBox msg4 = new MessageBox(shell, SWT.ICON_ERROR);
                        msg4.setMessage("No button with a specified name!");
                        msg4.open();
                    }
                }
            }
        });
    }
}