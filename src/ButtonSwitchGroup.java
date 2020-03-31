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
        MyGroup(display, shell);
    }

    static void MyGroup(Display display, Shell shell) {

        Group group2 = new Group(shell, SWT.NONE);
        group2.setText("Group №2");;
        group2.setLayout(new FillLayout(SWT.VERTICAL));

        Text text2 = new Text(group2, SWT.SINGLE | SWT.BORDER);
        text2.setTextLimit(8);

        Button button21 = new Button (group2, SWT.PUSH);
        button21.setText("Click me!");

        Button button22 = new Button (group2, SWT.PUSH);
        button22.setText("Click me!");

        button21.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                if(!text2.getText().isEmpty()) {
                    button22.setText(text2.getText());
                }
            }
        });

        button22.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                String temp = new String(button22.getText());
                button22.setText(button21.getText());
                button21.setText(temp);
            }
        });

    }
}