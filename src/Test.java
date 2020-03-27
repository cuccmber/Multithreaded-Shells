import org.eclipse.swt.widgets.Display;

public class Test extends Thread {
    @Override
    public void run() {
        Display.getDefault().asyncExec(new Runnable(){
            @Override
            public void run() {
                if(Window.GetChoice() == true) {
                    System.out.println("Show");
                }else{
                    System.out.println("Hide");
                }
            }
        });
    }
}
