import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.util.ArrayList;

public class ShellThread extends Thread {
    Window window;




    ShellThread(Window thisWindow){
        window = thisWindow;
    }

    @Override
    public void run() {

        while (Window.getChoice()) {
            Display.getDefault().asyncExec(() -> {

                for(int i = 0; i < window.getShell().size(); i++){
                    int X = window.GetLocation(200, 5, i).X;
                    int Y = window.GetLocation(200, 5, i).Y;
                    window.getShell().get(i).setBounds(X, Y, 250, 250);
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
            HideShell(window.getShell());
        });

    }

    public static void HideShell(ArrayList<Shell> hidingShells) {
        for(int i = 0; i < hidingShells.size(); i++){
            hidingShells.get(i).setVisible(false);
        }
    }
}
