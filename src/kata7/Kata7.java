package kata7;

import javax.swing.JFrame;

public class Kata7 extends JFrame{
    
    public static void main(String[] args) {
        new Kata7().execute();
    }

    public Kata7() {
        Watch watch = new Watch();
        WatchDisplay watchDisplay = new WatchDisplay();
        new WatchPresenter(watch, watchDisplay);
        this.setTitle("Watch");
        this.setSize(400,424);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(watchDisplay);
    }

    private void execute() {
        this.setVisible(true);
    }
    
}

