package conagua;

public class Main {

    public static void main(String[] args) {
        
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {
                Login lg = new Login();
                lg.setVisible(true);
            }
        });
        
    }
    
}
