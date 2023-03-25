package twisk.vues;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;

public class EcouteurQuit implements EventHandler {
    @Override
    public void handle(Event event) {
        Platform.exit();
    }
}
