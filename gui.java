import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;

public class gui extends Frame {
    gui() {
        Button sub = new Button("Submit");

        sub.setBounds(30, 100, 80, 30);
        add(sub);
        setSize(500, 500);
        setTitle("Task Manager");
        setLayout(null);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

    }

    public static void main(String[] args) {
        gui m_gui = new gui();
    }

}
