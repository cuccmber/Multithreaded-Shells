import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ShellThread extends Thread {
    private int count = 0;

    @Override
    public void run() {

        Display display = Display.getDefault();

        //Shell first_shell = new Shell(display);


        Shell second_shell = new Shell(display);
        SecondGroup.MyGroup(display, second_shell);
        second_shell.setLayout(new FillLayout());

        Shell third_shell = new Shell(display);
        ThirdGroup.MyGroup(display, third_shell);
        third_shell.setLayout(new FillLayout());

        Shell fourth_shell = new Shell(display);
        FourthGroup.MyGroup(display, fourth_shell);
        fourth_shell.setLayout(new FillLayout());

        Shell fifth_shell = new Shell(display);
        FifthGroup.MyGroup(display, fifth_shell);
        fifth_shell.setLayout(new FillLayout());


        Display.getDefault().asyncExec(new Runnable() {

            @Override
            public void run() {
                if(count > 4){
                    count = 0;
                }
                if(Window.GetChoice() == true){
                    MoveShell(Window.GetFirstShell(), Window.GetSecondShell(), Window.GetThirdShell(), Window.GetFourthShell(), Window.GetFifthShell(), count);

                    count++;
                }else{
                    HideShell(Window.GetFirstShell(), Window.GetSecondShell(), Window.GetThirdShell(), Window.GetFourthShell(), Window.GetFifthShell());

                }
           }
        });
    }

    public static void MoveShell(Shell shell1, Shell shell2, Shell shell3, Shell shell4, Shell shell5, int count) {
        shell1.setBounds(Window.x_coords[count], Window.y_coords[count], 250, 250);
        shell1.open();

        shell2.setBounds(Window.x_coords[count+1], Window.y_coords[count+1], 250, 250);
        shell2.open();

        shell3.setBounds(Window.x_coords[count+2], Window.y_coords[count+2], 250, 250);
        shell3.open();

        shell4.setBounds(Window.x_coords[count+3], Window.y_coords[count+3], 250, 250);
        shell4.open();

        shell5.setBounds(Window.x_coords[count+4], Window.y_coords[count+4], 250, 250);
        shell5.open();
/*
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            System.out.println("Interrupt");
        }
        */

    }

    public static void HideShell(Shell shell1, Shell shell2, Shell shell3, Shell shell4, Shell shell5){
        shell1.setVisible(false);
        shell2.setVisible(false);
        shell3.setVisible(false);
        shell4.setVisible(false);
        shell5.setVisible(false);
    }
}
