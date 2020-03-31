import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.util.ArrayList;

public class ShellThread extends Thread {
    Window window;


    ShellThread(Window thisWindow){
        window = thisWindow;
    }

    public static void hideShell(ArrayList<Shell> hidingShells) {
        for(int i = 0; i < hidingShells.size(); i++){
            hidingShells.get(i).setVisible(false);
        }
    }

    @Override
    public void run() {

        while (window.getChoice()) {
            Display.getDefault().asyncExec(() -> {

                for(int i = 0; i < window.getShell().size(); i++){
                    Point myPoint = window.getLocation(1500, 800, 250, window.getNumberOfShells(), i - window.getCount());

                    window.getShell().get(i).setBounds(myPoint.X, myPoint.Y, 250, 250);
                    window.getShell().get(i).open();
                }
                window.incrementCount();
            });


            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }

        Display.getDefault().asyncExec(() -> {
            hideShell(window.getShell());
        });

    }
}
