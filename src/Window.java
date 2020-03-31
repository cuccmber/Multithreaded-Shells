import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import java.util.ArrayList;

import static java.lang.Math.sin;
import static java.lang.Math.cos;

public class Window{

    int count;
    static boolean choice;

    ArrayList<Shell> movingShells;

    public Window() {
        movingShells = new ArrayList<Shell>();
    }

    public void incrementCount(){
        if(count > 4){
            count = 0;
        }
        count++;
    }

    public int getCount(){
        return count;
    }

    public void addShellToList(Shell adding){
        adding.setLayout(new FillLayout());
        movingShells.add(adding);
    }

    public ArrayList<Shell> getShell(){
        return movingShells;
    }

    public Point GetLocation(int radius, int numberOfShells, int currentShell){
        Point center = new Point(500, 500);
        float angle = 360 / numberOfShells;
        currentShell++;

        System.out.println(angle);

        int height = (int) (radius * sin(angle*currentShell)) + center.X;
        int width = (int) (radius * (1 - cos(angle*currentShell))) + center.Y;

        Point point = new Point(height, width);
        return point;
    }

    public static void main(String[] args) {
        Display display = new Display();
        Window window = new Window();
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());

        ComboGroub.MyGroup(display, shell);
        ButtonSwitchGroup.MyGroup(display, shell);
        RadioButtonGroup.MyGroup(display, shell);
        CheckButtonGroup.MyGroup(display, shell);
        TableGroup.MyGroup(display, shell);

        int numberOfShells = 5;
        for(int i = 0; i < numberOfShells; i++) {
            window.addShellToList(new Shell());
        }

        ComboGroub.MyGroup(display, window.getShell().get(0));
        ButtonSwitchGroup.MyGroup(display, window.getShell().get(1));
        RadioButtonGroup.MyGroup(display, window.getShell().get(2));
        CheckButtonGroup.MyGroup(display, window.getShell().get(3));
        TableGroup.MyGroup(display, window.getShell().get(4));

        shell.setText("Option 19");
        shell.setSize(900, 600);
        shell.setBounds(500, 300, 0, 0);
        shell.pack();
        shell.open();

        final boolean move = false;

        display.addFilter(SWT.KeyDown, new Listener() {
            public void handleEvent(Event e) {
                if (e.character == 0x01) {
                    setChoice(true);
                    shell.setVisible(false);
                    new ShellThread(window).start();
                }else if (e.character == 0x02){
                    setChoice(false);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e2) {
                        System.out.println("Interrupt");
                    }

                    shell.open();
                    }
            }

        });

        while(!shell.isDisposed()) {
            if(display.readAndDispatch()) {
                display.sleep();
            }
        }
    }
    public static void setChoice(boolean move){
        choice = move;
    }

    public static boolean getChoice(){
        return choice;
    }

}