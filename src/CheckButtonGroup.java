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

public class CheckButtonGroup {
    public static void main(String[] args, Display display, Shell shell) {
        myGroup(display, shell);
    }

    static void myGroup(Display display, Shell shell) {
        Group group = new Group(shell, SWT.NONE);
        group.setText("Group №4");;
        group.setLayout(new FillLayout(SWT.VERTICAL));

        Text input = new Text(group, SWT.SINGLE | SWT.BORDER);
        input.setTextLimit(8);

        Button OK = new Button (group, SWT.PUSH);
        OK.setText("OK");

        Button pushButtonOne= new Button (group, SWT.CHECK);
        pushButtonOne.setText("One");

        Button pushButtonTwo = new Button (group, SWT.CHECK);
        pushButtonTwo.setText("Two");

        Button pushButtonThree = new Button (group, SWT.CHECK);
        pushButtonThree.setText("Three");

        OK.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {

                if(!input.getText().isEmpty()) {

                    if(input.getText().contentEquals(pushButtonOne.getText())) {
                        if(pushButtonOne.getSelection() == true) {
                            pushButtonOne.setSelection(false);
                        }
                        else {
                            pushButtonOne.setSelection(true);
                        }
                    }
                    else if(input.getText().contentEquals(pushButtonTwo.getText())) {
                        if(pushButtonTwo.getSelection() == true) {
                            pushButtonTwo.setSelection(false);
                        }
                        else {
                            pushButtonTwo.setSelection(true);
                        }
                    }
                    else if(input.getText().contentEquals(pushButtonThree.getText())) {
                        if(pushButtonThree.getSelection() == true) {
                            pushButtonThree.setSelection(false);
                        }
                        else {
                            pushButtonThree.setSelection(true);
                        }
                    }
                    else{
                        MessageBox noButton = new MessageBox(shell, SWT.ICON_ERROR);
                        noButton.setMessage("No button with a specified name!");
                        noButton.open();
                    }
                }
            }
        });
    }
}