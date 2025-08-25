import login.Login;

import javafx.application.Application ;
import javafx.stage.Stage ;

public class App extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args) ;
    }

    public void start(Stage primaryStage)
    {
        Login root = new Login() ;
        primaryStage.setScene(root.getLoginScene()) ;
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(300);
        primaryStage.setMaximized(true) ;
        primaryStage.show() ;
    }
}
