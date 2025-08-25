package login ;

import javafx.geometry.Insets ;
import javafx.geometry.Pos ;
import javafx.scene.Parent ;
import javafx.scene.layout.HBox ;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox ;
import javafx.scene.control.Button;
import javafx.scene.control.Label ;
import javafx.scene.control.TextField;

public class ConfigLauncher extends VBox
{
    private HBox config ;
    private HBox personalConfig ;
    private HBox familyConfig ;
    private HBox associationConfig ;
    private int configurationWidth = 300 ;
    private int configurationHeigth = 400 ;

    public ConfigLauncher()
    {
        HBox gestionType = (HBox) buildGestionType() ;
        personalConfig = (HBox) buildPersonalGestionConfiguration() ;
        familyConfig = (HBox) buildFamilyGestionConfiguration() ;
        associationConfig = (HBox) buildAssociationGestionConfiguration() ;
        Region spacer1 = new Region() ;
        Region spacer2 = new Region() ;
        VBox.setVgrow(spacer2, Priority.ALWAYS) ;
        VBox.setVgrow(spacer1, Priority.ALWAYS) ;
        
        this.config = personalConfig ;
        ((Label) gestionType.getChildren().get(1)).setOnMouseClicked(event ->
        {
            if (!this.getChildren().contains(personalConfig))
            {
                this.getChildren().removeLast() ;
                this.getChildren().removeLast() ;
                this.getChildren().addAll(personalConfig, spacer2) ;
            }
        }) ;
        ((Label) gestionType.getChildren().get(3)).setOnMouseClicked(event ->
        {
            if (!this.getChildren().contains(familyConfig))
            {
                this.getChildren().removeLast() ;
                this.getChildren().removeLast() ;
                this.getChildren().addAll(familyConfig, spacer2) ;
            }
        }) ;
        ((Label) gestionType.getChildren().get(5)).setOnMouseClicked(event ->
        {
            if (!this.getChildren().contains(associationConfig))
            {
                this.getChildren().removeLast() ;
                this.getChildren().removeLast() ;
                this.getChildren().addAll(associationConfig, spacer2) ;
            }
        }) ;

        this.getChildren().addAll(gestionType, spacer1, config, spacer2) ;
        this.setAlignment(Pos.CENTER) ;
    }

    private Parent buildGestionType()
    {
        HBox types = new HBox() ;

        Label personal = new Label("Personal".toUpperCase()) ;
        Label family = new Label("Family".toUpperCase()) ;
        Label association = new Label("Association".toUpperCase()) ;

        Region leftSpacer = new Region() ;
        Region centreSpacer1 = new Region() ;
        Region centreSpacer2 = new Region() ;
        Region rightSpacer = new Region() ;
        HBox.setHgrow(leftSpacer, Priority.ALWAYS) ;
        HBox.setHgrow(centreSpacer1, Priority.ALWAYS) ;
        HBox.setHgrow(centreSpacer2, Priority.ALWAYS) ;
        HBox.setHgrow(rightSpacer, Priority.ALWAYS) ;

        types.getChildren().addAll(leftSpacer, personal, centreSpacer1, family, centreSpacer2, association, rightSpacer) ;
        types.setPadding(new Insets(20, 0, 10, 0)) ;
        return types ;
    }

    private Parent buildPersonalGestionConfiguration()
    {
        int labelTextFieldSpacer = 5 ;
        HBox hbox = new HBox() ;
        
        StackPane stackPane = new StackPane() ;
        VBox configuration = new VBox(15) ;
        VBox lastName = new VBox(labelTextFieldSpacer, new Label("Nom"), new TextField()) ;
        VBox firstName = new VBox(labelTextFieldSpacer, new Label("Prénom"), new TextField()) ;
        VBox email = new VBox(labelTextFieldSpacer, new Label("Email"), new TextField()) ;
        VBox statutRevenu = new VBox(labelTextFieldSpacer, new Label("Statut de votre revenu"), new TextField()) ;
        VBox revenuMoyenneMois = new VBox(labelTextFieldSpacer, new Label("Combien pensez-vous avoir par mois ?"), new TextField()) ;
        Region spacer = new Region() ;
        HBox.setHgrow(spacer, Priority.ALWAYS) ;
        HBox actionButtons = new HBox(new Button("Effacer"), spacer, new Button("Enregistrer")) ;
        configuration.getChildren().addAll(lastName, firstName, email, statutRevenu, revenuMoyenneMois, actionButtons) ;
        StackPane.setMargin(configuration, new Insets(15));
        configuration.setMaxSize(configurationWidth, configurationHeigth) ;
        VBox ombreVbox = new VBox() ;
        VBox.setVgrow(ombreVbox, Priority.ALWAYS);
        ombreVbox.setMinSize(configurationWidth, configurationHeigth) ;
        stackPane.getChildren().addAll(ombreVbox, configuration) ;

        Region leftSpacer = new Region() ;
        Region rightSpacer = new Region() ;
        HBox.setHgrow(leftSpacer, Priority.ALWAYS) ;
        HBox.setHgrow(rightSpacer, Priority.ALWAYS) ;

        hbox.getChildren().addAll(leftSpacer, stackPane, rightSpacer) ;

        return hbox ;
    }

    private Parent buildFamilyGestionConfiguration()
    {
        int labelTextFieldSpacer = 5 ;
        HBox hbox = new HBox() ;
        
        StackPane stackPane = new StackPane() ;
        VBox configuration = new VBox(15) ;
        VBox familyName = new VBox(labelTextFieldSpacer, new Label("Nom de votre famille"), new TextField()) ;
        VBox familyEmail = new VBox(labelTextFieldSpacer, new Label("Email"), new TextField()) ;
        VBox periodicite = new VBox(labelTextFieldSpacer, new Label("Quelle est la périodicité de cotisation"), new TextField()) ;
        Region spacer = new Region() ;
        HBox.setHgrow(spacer, Priority.ALWAYS) ;
        HBox actionButtons = new HBox(new Button("Effacer"), spacer, new Button("Enregistrer")) ;
        configuration.getChildren().addAll(familyName, familyEmail, periodicite, actionButtons) ;
        StackPane.setMargin(configuration, new Insets(15));
        configuration.setMaxSize(configurationWidth, configurationHeigth) ;
        VBox ombreVbox = new VBox() ;
        VBox.setVgrow(ombreVbox, Priority.ALWAYS);
        ombreVbox.setMinSize(configurationWidth, configurationHeigth) ;
        stackPane.getChildren().addAll(ombreVbox, configuration) ;

        Region leftSpacer = new Region() ;
        Region rightSpacer = new Region() ;
        HBox.setHgrow(leftSpacer, Priority.ALWAYS) ;
        HBox.setHgrow(rightSpacer, Priority.ALWAYS) ;

        hbox.getChildren().addAll(leftSpacer, stackPane, rightSpacer) ;

        return hbox ;
    }

    private Parent buildAssociationGestionConfiguration()
    {
        int labelTextFieldSpacer = 5 ;
        HBox hbox = new HBox() ;
        
        StackPane stackPane = new StackPane() ;
        VBox configuration = new VBox(15) ;
        VBox associationName = new VBox(labelTextFieldSpacer, new Label("Nom de votre association"), new TextField()) ;
        VBox associationEmail = new VBox(labelTextFieldSpacer, new Label("Email"), new TextField()) ;
        VBox montantCotisation = new VBox(labelTextFieldSpacer, new Label("Quel est le montant de participation"), new TextField()) ;
        VBox periodicite = new VBox(labelTextFieldSpacer, new Label("Quelle est la périodicité de cotisation"), new TextField()) ;
        Region spacer = new Region() ;
        HBox.setHgrow(spacer, Priority.ALWAYS) ;
        HBox actionButtons = new HBox(new Button("Effacer"), spacer, new Button("Enregistrer")) ;
        configuration.getChildren().addAll(associationName, associationEmail, montantCotisation, periodicite, actionButtons) ;
        StackPane.setMargin(configuration, new Insets(15));
        configuration.setMaxSize(configurationWidth, configurationHeigth) ;
        VBox ombreVbox = new VBox() ;
        VBox.setVgrow(ombreVbox, Priority.ALWAYS);
        ombreVbox.setMinSize(configurationWidth, configurationHeigth) ;
        stackPane.getChildren().addAll(ombreVbox, configuration) ;

        Region leftSpacer = new Region() ;
        Region rightSpacer = new Region() ;
        HBox.setHgrow(leftSpacer, Priority.ALWAYS) ;
        HBox.setHgrow(rightSpacer, Priority.ALWAYS) ;

        hbox.getChildren().addAll(leftSpacer, stackPane, rightSpacer) ;

        return hbox ;
    }
}
