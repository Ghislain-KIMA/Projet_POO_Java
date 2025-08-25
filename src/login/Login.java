
package login ;

import javafx.scene.layout.HBox ;
import javafx.scene.layout.Priority ;
import javafx.scene.layout.VBox ;

import java.nio.file.Paths;

import database.ConfigDatabase;
import filegestion.FileGestion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene ;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Login extends HBox
{
    private Scene scene ;
    int currentIndex = 0 ;
    private VBox imageVbox ;
    private VBox loginVbox ;
    private VBox personalVbox ;

    public Login()
    {
        super() ;

        ImageView imageView = new ImageView(new Image("file:" + Paths.get(System.getProperty("user.dir"), "ressource/image/image_.jpg").toString())) ;
        // imageView.setPreserveRatio(true) ;

        // imageView.setSmooth(true) ;
        // // VBox.setVgrow(imageView, Priority.ALWAYS);
        imageVbox = new VBox(imageView) ;
        imageVbox.setId("imagevbox") ;
        imageVbox.setAlignment(Pos.CENTER) ;
        imageVbox.setPadding(new Insets(10)) ;

        if ((new FileGestion(Paths.get(System.getProperty("user.dir"), "storage/budget.db"))).isExistsFile())
        { loginVbox = new SignIn() ; }
        else
        {
            loginVbox = new FirstLaunching() ;
            personalVbox = new ConfigLauncher() ;
            try
            {
                ConfigDatabase defaultDatabase = new ConfigDatabase(Paths.get(System.getProperty("user.dir"), "storage/budget.db")) ;
                defaultDatabase.newConfigDatabaseFile() ;
                defaultDatabase.createDefaultTablesOfConfigDatabase() ;
            }
            catch(Exception ERROR)
            { System.out.println("ERROR : " + ERROR.getMessage()); }

            ((Button) ((HBox) this.loginVbox.getChildren().get(2)).getChildren().get(0)).setOnAction(event ->
            {
                this.getChildren().remove(1) ;
                this.getChildren().add(personalVbox) ;
            }) ;
        }
        
        HBox.setHgrow(imageVbox, Priority.ALWAYS);
        HBox.setHgrow(loginVbox, Priority.ALWAYS);

        this.getChildren().addAll(imageVbox, loginVbox) ;
        scene = new Scene(this) ;

        scene.widthProperty().addListener((obs, oldVal, newVal) ->
        {
            double w = newVal.doubleValue();
            
            if (this.getChildren().contains(imageVbox))
            {
                imageVbox.setPrefWidth(w * 0.4);
                imageVbox.setMinWidth(w*0.4) ;
                imageVbox.setMaxWidth(w*0.4) ;
            }
            if (!(loginVbox instanceof SignIn))
            { personalVbox.setPrefWidth(w * 0.6); }
            loginVbox.setPrefWidth(w * 0.6) ;
        });
        
        
        
        scene.widthProperty().addListener((obs, oldVal, newVal)  ->
        {
            // Supprimer le label si la fenêtre est trop petite
            if (newVal.doubleValue() < 600)
            {
                this.getChildren().remove(imageVbox);
            }
            else if (!this.getChildren().contains(imageVbox))
            {
                this.getChildren().addFirst(imageVbox);
            }
        });

        scene.getStylesheets().add("file:ressource/style/mainlogin.css") ;
    }

    public Scene getLoginScene()
    { return this.scene ; }
}
