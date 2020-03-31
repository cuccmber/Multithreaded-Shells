import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import static java.lang.Math.sin;
import static java.lang.Math.cos;

public class Window{

    public static int[] x_coords = new int[]{700, 940, 850, 550, 460, 700, 940, 850, 550, 460};
    public static int[] y_coords = new int[]{160, 400, 650, 650, 400, 160, 400, 650, 650, 400};
    private static boolean choice;

    private final Shell firstShell;
    private final Shell secondShell;
    private final Shell thirdShell;
    private final Shell fourthShell;
    private final Shell fifthShell;

    public Window() {
        firstShell = new Shell();
        secondShell = new Shell();
        thirdShell = new Shell();
        fourthShell = new Shell();
        fifthShell = new Shell();
    }
    //

    public Point GetLocation(float displayHeight, float displayWidth, int radius, float angle){
        Point center = new Point(displayHeight/2, displayWidth/2);
        double height = 0;
        double width = 0;
        height = cos(angle)*radius;
        width = sin(angle)*radius;

        Point point = new Point(height, width);
        return point;
    }

    private void setFirstShell(){
        firstShell.setLayout(new FillLayout());
        FirstGroup.MyGroup(Display.getDefault(), firstShell);
    }

    private void setSecondShell(){
        secondShell.setLayout(new FillLayout());
        SecondGroup.MyGroup(Display.getDefault(), secondShell);
    }

    private void setThirdShell(){
        thirdShell.setLayout(new FillLayout());
        ThirdGroup.MyGroup(Display.getDefault(), thirdShell);
    }

    private void setFourthShell(){
        fourthShell.setLayout(new FillLayout());
        FourthGroup.MyGroup(Display.getDefault(), fourthShell);
    }

    private void setFifthShell(){
        fifthShell.setLayout(new FillLayout());
        FifthGroup.MyGroup(Display.getDefault(), fifthShell);
    }

    public Shell getFirstShell(){
        return firstShell;
    }

    public Shell getSecondShell(){
        return secondShell;
    }

    public Shell getThirdShell(){
        return thirdShell;
    }

    public Shell getFourthShell(){
        return fourthShell;
    }

    public Shell getFifthShell(){
        return fifthShell;
    }

    public static void main(String[] args) {
        Display display = new Display();
        Window window = new Window();
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());

        FirstGroup.MyGroup(display, shell);
        SecondGroup.MyGroup(display, shell);
        ThirdGroup.MyGroup(display, shell);
        FourthGroup.MyGroup(display, shell);
        FifthGroup.MyGroup(display, shell);

        window.setFirstShell();
        window.setSecondShell();
        window.setThirdShell();
        window.setFourthShell();
        window.setFifthShell();

        shell.setText("Option 19");
        shell.setSize(900, 600);
        shell.setBounds(500, 300, 0, 0);
        shell.pack();
        shell.open();

        System.out.println(window.GetLocation(1080, 1920, 250, 10).X);
        System.out.println(" ");
        System.out.println(window.GetLocation(1080, 1920, 250, 10).Y);

        final boolean move[] = {false};

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