package filegestion;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileGestion
{
    private Path filePath ;

    public FileGestion(Path filePath)
    { this.filePath = filePath ; }

    public boolean isExistsFile()
    { return (Files.exists(this.filePath) && Files.isRegularFile(this.filePath)) ; }

    public void newFile()
    {
        try
        { Files.createFile(this.filePath) ; }
        catch(Exception ERROR)
        {
            if (!(ERROR instanceof FileAlreadyExistsException))
            { System.out.println("ERROR : " + ERROR.getMessage()) ; }
        }
    }

    /* public static void newFile(Path filePath)
    {
        try
        { Files.createFile(filePath) ; }
        catch(Exception ERROR)
        {
            if (!(ERROR instanceof FileAlreadyExistsException))
            { System.out.println("ERROR : " + ERROR.getMessage()) ; }
        }
    } */

    public Path getDirPathOfFile()
    {
        String[] words = this.filePath.toString().split("/") ;
        if (words.length > 1)
        { return Paths.get(String.join("/", java.util.Arrays.copyOf(words, words.length - 1))) ; }
        return this.filePath ;
        //  A prendre en compte si l'utilisateur entre une chemin relatif.
    }

    /* public static Path getPathOfFile(Path filePath)
    {
        String[] words = filePath.toString().split("/") ;
        if (words.length > 1)
        { return Paths.get(String.join("/", java.util.Arrays.copyOf(words, words.length - 1))) ; }
        return filePath ;
        //  A prendre en compte si l'utilisateur entre une chemin relatif.
    } */
}
