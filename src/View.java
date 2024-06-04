import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private JButton actionBtn;
    private JTextField taskTf;
    private JLabel resultLabel;


    public View( int width, int height ){
         setSize( width, height);
         setTitle("Umrechner");
         setDefaultCloseOperation( DISPOSE_ON_CLOSE );
         addUIComponents();
         setVisible(true);
    }

    /**
     * Fügt UI Elemente dem Fenster hinzu
     */
    private void addUIComponents(){
        //Layout setzen
        setLayout(new BorderLayout());

        //Panel erstellen
        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        centerPanel.setLayout(new GridLayout( 2, 1));
        centerPanel.setBorder(new EmptyBorder(5,5,5,5));

        add( topPanel, BorderLayout.NORTH);
        add( centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        actionBtn = new JButton("Umrechnen");

        JLabel headline = new JLabel("" +
                "Bitten geben Sie die Aufgabe nach folgendem Muster ein:" +
                "zb: 2 cm in m");

        taskTf = new JTextField();

        resultLabel = new JLabel("<Hier ist später die Lösung>");

        topPanel.add(headline);
        centerPanel.add(taskTf);
        centerPanel.add(resultLabel);
        bottomPanel.add(actionBtn);
    }

    public void addActionButtonHandler( ActionListener listener){

        actionBtn.addActionListener( listener );
    }

    public String getTaskText(){
       return taskTf.getText();
    }

    public void showResult( String result){
        resultLabel.setText(result);
    }

}
