import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ShellThread extends Thread {
    int count = 0;
    Window window;




    ShellThread(Window tWindow){
        window = tWindow;
    }

    @Override
    public void run() {


        while (Window.getChoice()) {
            if (count > 4) {
                count = 0;
            }



            Display.getDefault().asyncExec(() -> {


                window.getFirstShell().setBounds(Window.x_coords[count], Window.y_coords[count], 250, 250);
                window.getFirstShell().open();


                window.getSecondShell().setBounds(Window.x_coords[count + 1], Window.y_coords[count + 1], 250, 250);
                window.getSecondShell().open();

                window.getThirdShell().setBounds(Window.x_coords[count + 2], Window.y_coords[count + 2], 250, 250);
                window.getThirdShell().open();

                window.getFourthShell().setBounds(Window.x_coords[count + 3], Window.y_coords[count + 3], 250, 250);
                window.getFourthShell().open();

                window.getFifthShell().setBounds(Window.x_coords[count + 4], Window.y_coords[count + 4], 250, 250);
                window.getFifthShell().open();

                count++;
            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupt");
            }
        }
        Display.getDefault().asyncExec(() -> {
            HideShell(window.getFirstShell(), window.getSecondShell(), window.getThirdShell(),
                    window.getFourthShell(), window.getFifthShell());
        });

    }

    public static void MoveShell(Shell shell1, Shell shell2, Shell shell3, Shell shell4, Shell shell5, int count) {

        if (count > 4) {
            count = 0;
        }

        shell1.setBounds(Window.x_coords[count], Window.y_coords[count], 250, 250);
        shell1.open();

        shell2.setBounds(Window.x_coords[count + 1], Window.y_coords[count + 1], 250, 250);
        shell2.open();

        shell3.setBounds(Window.x_coords[count + 2], Window.y_coords[count + 2], 250, 250);
        shell3.open();

        shell4.setBounds(Window.x_coords[count + 3], Window.y_coords[count + 3], 250, 250);
        shell4.open();

        shell5.setBounds(Window.x_coords[count + 4], Window.y_coords[count + 4], 250, 250);
        shell5.open();

        count++;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupt");
        }

        if (Window.getChoice()) {
            MoveShell(shell1, shell2, shell3, shell4, shell5, count);
        }


    }

    public static void HideShell(Shell shell1, Shell shell2, Shell shell3, Shell shell4, Shell shell5) {

        shell1.setVisible(false);
        shell2.setVisible(false);
        shell3.setVisible(false);
        shell4.setVisible(false);
        shell5.setVisible(false);
    }
}
