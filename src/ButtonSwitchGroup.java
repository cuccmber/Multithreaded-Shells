import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ButtonSwitchGroup {

    public static void main(String[] args, Display display, Shell shell) {
        myGroup(display, shell);
    }

    static void myGroup(Display display, Shell shell) {

        Group group = new Group(shell, SWT.NONE);
        group.setText("Group №2");;
        group.setLayout(new FillLayout(SWT.VERTICAL));

        Text input = new Text(group, SWT.SINGLE | SWT.BORDER);
        input.setTextLimit(8);

        Button renameButton = new Button (group, SWT.PUSH);
        renameButton.setText("Click me!");

        Button switchButton = new Button (group, SWT.PUSH);
        switchButton.setText("Click me!");

        renameButton.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                if(!input.getText().isEmpty()) {
                    switchButton.setText(input.getText());
                }
            }
        });

        switchButton.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                String temp = new String(switchButton.getText());
                switchButton.setText(renameButton.getText());
                renameButton.setText(temp);
            }
        });

    }
}