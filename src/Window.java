import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class Window{

    public static int[] x_coords = new int[]{700, 940, 850, 550, 460, 700, 940, 850, 550, 460};
    public static int[] y_coords = new int[]{160, 400, 650, 650, 400, 160, 400, 650, 650, 400};
    private static boolean choice;

    static Shell first_shell;
    static Shell second_shell;
    static Shell third_shell;
    static Shell fourth_shell;
    static Shell fifth_shell;

    private static void SetFirstShell(){
        first_shell = new Shell();
        first_shell.setLayout(new FillLayout());
        FirstGroup.MyGroup(Display.getDefault(), first_shell);
    }

    private static void SetSecondShell(){
        second_shell = new Shell();
        second_shell.setLayout(new FillLayout());
        SecondGroup.MyGroup(Display.getDefault(), second_shell);
    }

    private static void SetThirdShell(){
        third_shell = new Shell();
        third_shell.setLayout(new FillLayout());
        ThirdGroup.MyGroup(Display.getDefault(), third_shell);
    }

    private static void SetFourthShell(){
        fourth_shell = new Shell();
        fourth_shell.setLayout(new FillLayout());
        FourthGroup.MyGroup(Display.getDefault(), fourth_shell);
    }

    private static void SetFifthShell(){
        fifth_shell = new Shell();
        fifth_shell.setLayout(new FillLayout());
        FifthGroup.MyGroup(Display.getDefault(), fifth_shell);
    }

    public static Shell GetFirstShell(){
        return first_shell;
    }

    public static Shell GetSecondShell(){
        return second_shell;
    }

    public static Shell GetThirdShell(){
        return third_shell;
    }

    public static Shell GetFourthShell(){
        return fourth_shell;
    }

    public static Shell GetFifthShell(){
        return fifth_shell;
    }
    public static void main(String[] args) {

        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());

        FirstGroup.MyGroup(display, shell);
        SecondGroup.MyGroup(display, shell);
        ThirdGroup.MyGroup(display, shell);
        FourthGroup.MyGroup(display, shell);
        FifthGroup.MyGroup(display, shell);

        SetFirstShell();
        SetSecondShell();
        SetThirdShell();
        SetFourthShell();
        SetFifthShell();

        shell.setText("Task 19");
        shell.setSize(900, 600);
        shell.setBounds(500, 300, 0, 0);
        shell.pack();
        shell.open();

        ShellThread shellThread = new ShellThread();

        final boolean move[] = {false};
        display.addFilter(SWT.KeyDown, new Listener() {
            public void handleEvent(Event e) {

                if (e.character == 0x01) {
                    SetChoice(true);
                    shell.setVisible(false);
                    shellThread.run();
                }else if (e.character == 0x02){
                    SetChoice(false);
                    shell.open();
                    shellThread.run();                }
            }

        });

        while(!shell.isDisposed()) {
            if(display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    public static void SetChoice(boolean move){
        if(move == true){
            choice = true;
        }
        else{
            choice = false;
        }
    }

    public static boolean GetChoice(){
        return choice;
    }

}