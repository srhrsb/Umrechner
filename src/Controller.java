import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {


    /**
     * Verweis/Speicherung des Objects von View zur Darstellung der Nutzeroberfläche
     */
    View view;

    /**
     * Konstruktor von Controller
     */
    public Controller() {
        view = new View( 500, 170);
        //hiermit wird der Button zur Berechnung angewiesen die Methode convertUnit aufzurufen,
        //wenn er gedrückt wird, dies wird in "addActionButtonHandler durchführt
        view.addActionButtonHandler(this::convertUnit);
    }

    /**
     * Hauptmethode (Programmeinstieg) - erzeugt ein Object der Klasse Controller
     * @param args
     */
    public static void main(String[] args) {
        new Controller();
    }

    /**
     * Methode zur Umrechnung von gegebener Maßeinheit in gewünschte Maßeinheit
     * @param event
     */
    public void convertUnit( ActionEvent event ){

       // Logik für Berechnung

        //ToDo: string mit Aufgabe holen
        String task = view.getTaskText();

        //Parsen des strings
        var taskData = parseTaskInput( task );
        System.out.println(Arrays.toString(taskData));

        //Berechnung/Umrechnung
        //String result = getResult( taskData );
        String result = getResultV2( taskData );

        //Ergebnis ausgeben
        view.showResult(result);





    }

    private String getResult( String[] taskData ){
        float result = 0;

        boolean cmToM = taskData[1].toLowerCase().equals("cm") &&
                        taskData[2].toLowerCase().equals("m");

        boolean mmToM = taskData[1].toLowerCase().equals("mm") &&
                        taskData[2].toLowerCase().equals("m");

        boolean mToCm = taskData[1].toLowerCase().equals("m") &&
                        taskData[2].toLowerCase().equals("cm");

        boolean mToMm = taskData[1].toLowerCase().equals("m") &&
                        taskData[2].toLowerCase().equals("mm");

        if( cmToM==true ){
            result = Float.valueOf(taskData[0])/100;
        }
        else if (mmToM==true){
            result = Float.valueOf(taskData[0])/1000;
        }
        else if (mToCm==true){
            result = Float.valueOf(taskData[0])*100;
        }
        else if (mToMm==true){
            result = Float.valueOf(taskData[0])*1000;
        }
        else{
            return "Diese Umrechnung wird nicht unterstützt";
        };

        return result+" "+taskData[2];
    }

    private String getResultV2( String[] taskData)
    {
         float from = getValue(taskData[1]);
         float to = getValue(taskData[2]);

         //Zahl die umgerechnet werden soll
         float value = Float.valueOf(taskData[0]);

         //Fall: wenn to und from gleich sind
         float result = value;

         //Falls berechnet werden muss:
         if(to != from) {
             float valueInMeter = value / from;
             result = valueInMeter * to;
         }

         return result +" "+taskData[2];
    }

    private float getValue(String unit){
        String[] units = {"mm","cm","dm","m","km"};
        Float[] values = {1000f,100f, 10f, 1f, 1/1000f};

        for (int i = 0; i < units.length; i++) {
            if(units[i].equals(unit)){
                return values[i];
            }
        }
        return 1f;
    }




    /**
     * Parsen der Nutzereingabe für die Berechnung
     * @param task Nutzereingabe
     * @return Daten
     */
    public String[] parseTaskInput( String task){

        //wandelt den String task in ein Array um, des Separator (Trenner)
        //ist hier ein Leerzeichen
        var tempTaskData = task.split(" ");

        String[] taskData = {tempTaskData[0], tempTaskData[1], tempTaskData[3] };
        return taskData;
    }






}