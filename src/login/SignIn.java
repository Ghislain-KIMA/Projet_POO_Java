package login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class SignIn extends VBox
{
    public SignIn()
    {
        super(15) ;

        StackPane stackPane = new StackPane() ;
        VBox passwordVbox = new VBox(5, new Label("Entrez votre mot de passe"), new PasswordField()) ;
        Region spacer = new Region() ;
        HBox.setHgrow(spacer, Priority.ALWAYS) ;
        HBox connectionHbox = new HBox(new Label("Mot de passe oublié."), spacer, new Button("Connextion")) ;
        VBox vbox = new VBox() ;
        vbox.getStyleClass().add(("ombre")) ;
        VBox champ = new VBox(20, passwordVbox, connectionHbox) ;
        champ.setPadding(new Insets(10)) ;
        champ.setAlignment(Pos.CENTER) ;
        stackPane.getChildren().addAll(vbox, champ) ;
        stackPane.setMaxSize(300, 200) ;
        stackPane.setMinSize(300, 200) ;

        this.setAlignment(Pos.CENTER) ;
        this.getChildren().addAll(stackPane) ;
        this.getStylesheets().add("file:ressource/style/signin.css") ;
    }

    /* À implémenter */
    public HBox personalInterface()
    { return null ; }

    /* À implémenter */
    public HBox familyInterface()
    { return null ; }

    /* À implémenter */
    public HBox associationInterface()
    { return null ; }
}
