package login ;

import java.util.List ;

import javafx.animation.TranslateTransition ;
import javafx.geometry.Insets ;
import javafx.geometry.Pos ;
import javafx.scene.control.Button ;
import javafx.scene.control.CheckBox ;
import javafx.scene.control.Label ;
import javafx.scene.layout.HBox ;
import javafx.scene.layout.Priority ;
import javafx.scene.layout.Region ;
import javafx.scene.layout.VBox ;
import javafx.util.Duration ;

public class FirstLaunching extends VBox
{
    int currentIndex = 0 ;
    List<String> listMessages = List.of
    (
        "Prenez le contrôle de votre argent, chaque centime compte.",
        "Votre budget, vos règles. Planifiez, suivez, maîtrisez.",
        "Fini les fins de mois difficiles. Commencez à piloter vos finances."
    ) ;

    public FirstLaunching()
    {
        super() ;

        int rightMarge = 30 ;
        
        Button messageLeftButton = new Button("<") ;
        Label messageLabel = new Label(listMessages.get(currentIndex)) ;
        Button messageRightButton = new Button(">") ;
        messageLeftButton.getStyleClass().add("navbutton") ;
        messageRightButton.getStyleClass().add("navbutton") ;
        messageLabel.setId("message");

        VBox topVbox = new VBox() ;
        HBox languages = new HBox(new CheckBox()) ;
        languages.setAlignment(Pos.TOP_RIGHT) ;
        VBox.setMargin(topVbox, new Insets(rightMarge)) ;
        HBox welcome = new HBox(new Label("Bienvenu sur Budget")) ;
        welcome.setAlignment(Pos.CENTER) ;
        VBox.setVgrow(welcome, Priority.ALWAYS) ;
        topVbox.getChildren().addAll(languages, welcome) ;
        welcome.getChildren().get(0).setId("welcome") ;
        
        HBox messages = new HBox() ;
        Region leftSpacer = new Region() ;
        Region rightSpacer = new Region() ;
        HBox.setHgrow(leftSpacer, Priority.ALWAYS) ;
        HBox.setHgrow(rightSpacer, Priority.ALWAYS) ;
        messages.getChildren().addAll(messageLeftButton, leftSpacer, messageLabel, rightSpacer, messageRightButton) ;
        messages.setAlignment(Pos.CENTER);
        messages.setPadding(new Insets(10));

        Button nextButton = new Button("Next") ;
        nextButton.setId("nextbutton") ;
        HBox nextBottomVbox = new HBox(nextButton) ;
        nextBottomVbox.setAlignment(Pos.BOTTOM_RIGHT);
        nextBottomVbox.setPadding(new Insets(rightMarge));
        
        VBox.setVgrow(topVbox, Priority.ALWAYS);
        VBox.setVgrow(messages, Priority.ALWAYS);
        VBox.setVgrow(nextBottomVbox, Priority.ALWAYS);

        this.getChildren().addAll(topVbox, messages, nextBottomVbox) ;
        
        nextBottomVbox.getChildren().get(0).setVisible(false);
        messageLeftButton.setVisible(false) ;
        messageLeftButton.setOnAction(event -> leftButtonAction()) ;
        messageRightButton.setOnAction(event -> rigthButtonAction()) ;
        

        this.setAlignment(Pos.CENTER) ;
        this.getStylesheets().add("file:ressource/style/firstlaunching.css") ;
    }

    private void leftButtonAction()
    {
        if (currentIndex > 0)
        {
            currentIndex-- ;
            slideLabelMessage((Label) ((HBox) this.getChildren().get(1)).getChildren().get(2) , listMessages.get(currentIndex), false) ;

            if (currentIndex > 0 )
                { ((Button) ((HBox) this.getChildren().get(1)).getChildren().get(4)).setVisible(true); }
            else
                { ((Button) ((HBox) this.getChildren().get(1)).getChildren().get(0)).setVisible(false); }
            if (currentIndex != (listMessages.size() - 1))
                { ((Button) ((HBox) this.getChildren().get(2)).getChildren().get(0)).setVisible(false); }
        }
    }

    private void rigthButtonAction()
    {
        if (currentIndex < listMessages.size() - 1)
        {
            currentIndex++ ;
            slideLabelMessage((Label) ((HBox) this.getChildren().get(1)).getChildren().get(2) , listMessages.get(currentIndex), false) ;

            if (currentIndex >= (listMessages.size() - 1))
                { ((Button) ((HBox) this.getChildren().get(1)).getChildren().get(4)).setVisible(false); }
            else
                { ((Button) ((HBox) this.getChildren().get(1)).getChildren().get(0)).setVisible(true); }
            if (currentIndex == (listMessages.size() - 1))
                { ((Button) ((HBox) this.getChildren().get(2)).getChildren().get(0)).setVisible(true); }
        }
    }

     public void slideLabelMessage(Label centerLabel ,String newText, boolean toLeft)
    {
        TranslateTransition slideOut = new TranslateTransition(Duration.millis(200), centerLabel);
        slideOut.setByX(toLeft ? -150 : 150) ;
        slideOut.setOnFinished(event ->
        {
            centerLabel.setTranslateX(toLeft ? 150 : -150); // positionne hors écran
            centerLabel.setText(newText) ;
            TranslateTransition slideIn = new TranslateTransition(Duration.millis(200), centerLabel) ;
            slideIn.setToX(0) ;
            slideIn.play() ;
        }) ;
        slideOut.play() ;
    }
}
