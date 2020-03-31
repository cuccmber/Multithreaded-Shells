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
    int numberOfShells = 5;
    boolean choice;
    ArrayList<Shell> movingShells;

    public Window() {
        movingShells = new ArrayList<Shell>();
    }

    public int getNumberOfShells(){
        return numberOfShells;
    }

    public void incrementCount(){
        if(count > numberOfShells - 1){
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

    public Point getLocation(int borderX, int borderY, int radius, int numberOfShells, int currentShell){

        Point center = new Point(borderX/2, borderY/2);
        float angle = 90 - (360 / numberOfShells*currentShell);

        int x = (int) (radius * cos(Math.toRadians(angle))) + center.X;
        int y = (int) (radius * sin(Math.toRadians(angle))) + center.Y;

        Point point = new Point(x, y);
        return point;
    }

    public void setChoice(boolean move){
        choice = move;
    }

    public boolean getChoice(){
        return choice;
    }

    public static void main(String[] args) {
        Window window = new Window();
        Display display = new Display();
        Shell mainShell = new Shell(display);
        mainShell.setLayout(new FillLayout());

        ComboGroup.myGroup(display, mainShell);
        ButtonSwitchGroup.myGroup(display, mainShell);
        RadioButtonGroup.myGroup(display, mainShell);
        CheckButtonGroup.myGroup(display, mainShell);
        TableGroup.myGroup(display, mainShell);

        for(int i = 0; i < window.getNumberOfShells(); i++) {
            window.addShellToList(new Shell());
        }

        ComboGroup.myGroup(display, window.getShell().get(0));
        ButtonSwitchGroup.myGroup(display, window.getShell().get(1));
        RadioButtonGroup.myGroup(display, window.getShell().get(2));
        CheckButtonGroup.myGroup(display, window.getShell().get(3));
        TableGroup.myGroup(display, window.getShell().get(4));

        mainShell.setText("Option 19");
        mainShell.setLocation(500, 300);
        mainShell.pack();
        mainShell.open();

        display.addFilter(SWT.KeyDown, new Listener() {
            public void handleEvent(Event e) {
                if (e.character == 0x01) {
                    window.setChoice(true);
                    mainShell.setVisible(false);
                    new ShellThread(window).start();
                }else if (e.character == 0x02){
                    window.setChoice(false);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e2) {
                        System.out.println("Interrupt");
                    }

                    mainShell.open();
                    }
            }

        });

        while(!mainShell.isDisposed()) {
            if(display.readAndDispatch()) {
                display.sleep();
            }
        }
    }
}