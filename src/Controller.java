import java.awt.event.ActionEvent;
import java.util.Arrays;

public class Controller {

    View view;

    public Controller() {
        view = new View( 500, 170);
        view.addActionButtonHandler(this::calculate);
    }

    public static void main(String[] args) {
        new Controller();
    }

    public void calculate( ActionEvent event ){

       // Logik für Berechnung

        //ToDo: string mit Aufgabe holen
        String task = view.getTaskText();

        //ToDo: Parsen des strings
        var taskData = parseTaskInput( task );
        System.out.println(Arrays.toString(taskData));

        //ToDo: Berechnung/Umrechnung

        //ToDo: Ergebnis ausgeben

    }

    /**
     * Parsen der Nutzereingabe für die Berechnung
     * @param task Nutzereingabe
     * @return Daten
     */
    public String[] parseTaskInput( String task){
        var tempTaskData = task.split(" ");
        String[] taskData = {tempTaskData[0], tempTaskData[1], tempTaskData[3] };
        return taskData;
    }






}