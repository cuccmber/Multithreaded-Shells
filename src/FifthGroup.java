import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class FifthGroup{
    public static void main(String[] args, Display display, Shell shell) {
        MyGroup(display, shell);
    }

    static void MyGroup(Display display, Shell shell) {
        Group group5 = new Group(shell, SWT.NONE);
        group5.setText("Group №5");
        group5.setLayout(new FillLayout(SWT.VERTICAL));

        Text text5 = new Text(group5, SWT.SINGLE | SWT.BORDER);
        text5.setTextLimit(5);

        Button button51 = new Button (group5, SWT.PUSH);
        button51.setText("Add item");

        Button button52 = new Button (group5, SWT.PUSH);
        button52.setText("Move to column 2");

        Button button53 = new Button (group5, SWT.PUSH);
        button53.setText("Move to column 1");

        Table table = new Table(group5, SWT.BORDER | SWT.FULL_SELECTION);
        table.setLinesVisible(true);
        table.setSize(200, 200);

        TableColumn column1 = new TableColumn(table, SWT.NONE);
        TableColumn column2 = new TableColumn(table, SWT.NONE);
        column1.setWidth(63);
        column2.setWidth(63);

        button51.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                if(!text5.getText().isEmpty()) {
                    TableItem item = new TableItem(table, SWT.NONE);
                    item.setText(0, text5.getText());
                }
            }
        });

        button52.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {

                TableItem[] selection = table.getSelection();
                if(selection.length == 0) {
                    MessageBox msg1 = new MessageBox(shell, SWT.ICON_ERROR);
                    msg1.setMessage("No items selected!");
                    msg1.open();

                }
                else {
                    int index = table.getSelectionIndex();
                    TableItem item = table.getItem(index);
                    if(!item.getText(0).equals("") && item.getText(1).equals("")) {
                        item.setText(1, item.getText(0));
                        item.setText(0, "");
                    }

                }
            }
        });

        button53.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {

                TableItem[] selection = table.getSelection();
                if(selection.length == 0) {
                    MessageBox msg1 = new MessageBox(shell, SWT.ICON_ERROR);
                    msg1.setMessage("No items selected!");
                    msg1.open();

                }
                else {
                    int index = table.getSelectionIndex();
                    TableItem item = table.getItem(index);
                    if(item.getText(0).equals("") && item.getText(1) != "") {
                        item.setText(0, item.getText(1));
                        item.setText(1, "");
                    }

                }
            }
        });

    }
}