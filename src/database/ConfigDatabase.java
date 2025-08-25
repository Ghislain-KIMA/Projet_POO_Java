package database ;

import java.lang.Exception  ;
import java.nio.file.Path ;
import java.sql.Connection ;
import java.sql.DriverManager ;
// import java.sql.ResultSet ;
import java.sql.SQLException ;
import java.sql.Statement ;

import filegestion.DirectoryGestion ;
import filegestion.FileGestion ;

public class ConfigDatabase
{
    private Path databasePath ;
    
    public ConfigDatabase(Path databasePath) throws Exception
    {
        if (!databasePath.toString().endsWith(".db") || databasePath.toString().equals(".db") )
        { throw new Exception("L’âge indiqué est incorrecte."); }
        this.databasePath = databasePath ;
    }

    public void newConfigDatabaseFile()
    {
        FileGestion dbConfigFile = new FileGestion(this.databasePath) ;
        DirectoryGestion.newDirectory(dbConfigFile.getDirPathOfFile()) ;
        dbConfigFile.newFile() ;
    }

    public void createDefaultTablesOfConfigDatabase()
    {
        String tableGestionsCreationRequete =
            "CREATE TABLE IF NOT EXISTS `gestions` (\n" +
                "   `id_gestion` SMALLINT PRIMARY KEY,\n" +
                "   `gestion_type` VARCHAR(25) NOT NULL UNIQUE,\n" +
                "   `first_launch` BOOLEAN NOT NULL,\n" +
                "   `max_launches` SMALLINT NOT NULL\n" +
                ");" ;
        String tableLaunchersCreationRequete =
            "CREATE TABLE IF NOT EXISTS `launchers` (\n" +
                "   `id_launcher` SMALLINT PRIMARY KEY,\n" + 
                "   `launcher_email` VARCHAR(256) NOT NULL,\n" +
                "   `launcher_db_name` VARCHAR(120) NOT NULL UNIQUE,\n" +
                "   `launcher_password` VARCHAR(120) NOT NULL,\n" +
                "   `launcher_gestion_type` VARCHAR(65) NOT NULL\n" +
                ");" ;
        this.executeUpdateRequete(tableLaunchersCreationRequete);
        this.executeUpdateRequete(tableGestionsCreationRequete);
    }

    /* private ResultSet executeQueryRequete(String requete)
    {
        ResultSet resultat = null ;
        try
        {
            Connection connecter = DriverManager.getConnection("jdbc:sqlite:".concat(this.databasePath.toString())) ;
            Statement mediator = connecter.createStatement() ;
            resultat = mediator.executeQuery(requete) ;
            connecter.close() ;
        }
        catch (SQLException ERROR)
        { System.err.println("ERROR : " + ERROR.getMessage()) ; }
        return resultat ;
    } */

    private void executeUpdateRequete(String requete)
    {
        Connection connecter = null ;
        try
        {
            connecter = DriverManager.getConnection("jdbc:sqlite:".concat(this.databasePath.toString())) ;
            Statement mediator = connecter.createStatement() ;
            connecter.setAutoCommit(false) ;
            mediator.executeUpdate(requete) ;
            connecter.commit() ;
            connecter.close() ;
        }
        catch (SQLException ERROR)
        {
            try
            {
                if (connecter != null)
                { connecter.rollback() ; }
                else
                { System.err.println("ERROR : " + ERROR.getMessage()) ; }
            }
            catch (SQLException ERR)
            { System.out.println("ERROR : " + ERR.getMessage()) ; }
        }
    }
}
