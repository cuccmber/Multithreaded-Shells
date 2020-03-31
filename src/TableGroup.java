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

public class TableGroup {
    public static void main(String[] args, Display display, Shell shell) {
        myGroup(display, shell);
    }

    static void myGroup(Display display, Shell shell) {
        Group group = new Group(shell, SWT.NONE);
        group.setText("Group №5");
        group.setLayout(new FillLayout(SWT.VERTICAL));

        Text input = new Text(group, SWT.SINGLE | SWT.BORDER);
        input.setTextLimit(5);

        Button addButton = new Button (group, SWT.PUSH);
        addButton.setText("Add item");

        Button moveTo2ndButton = new Button (group, SWT.PUSH);
        moveTo2ndButton.setText("Move to column 2");

        Button moveTo1stButton = new Button (group, SWT.PUSH);
        moveTo1stButton.setText("Move to column 1");

        Table table = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
        table.setLinesVisible(true);
        table.setSize(200, 200);

        TableColumn column1 = new TableColumn(table, SWT.NONE);
        TableColumn column2 = new TableColumn(table, SWT.NONE);
        column1.setWidth(63);
        column2.setWidth(63);

        addButton.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                if(!input.getText().isEmpty()) {
                    TableItem item = new TableItem(table, SWT.NONE);
                    item.setText(0, input.getText());
                }
            }
        });

        moveTo2ndButton.addSelectionListener(new SelectionAdapter() {

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

        moveTo1stButton.addSelectionListener(new SelectionAdapter() {

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