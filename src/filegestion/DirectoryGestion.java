package filegestion;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirectoryGestion
{
    private Path dirPath ;

    public DirectoryGestion(Path dirPath)
    { this.dirPath = dirPath ; }

    public boolean isExistsDirectory()
    { return (Files.exists(this.dirPath) && Files.isDirectory(this.dirPath)) ; }

    /* public static boolean isExistsDirectory(Path dirPath)
    { return (Files.exists(dirPath) && Files.isDirectory(dirPath)) ; } */

    public static void newDirectory(Path dirPath)
    {
        try
        { Files.createDirectory(dirPath) ; }
        catch(Exception ERROR)
        {
            if (!(ERROR instanceof FileAlreadyExistsException))
            {   System.out.println("ERROR : " + ERROR.getMessage()) ; }
        }
    }
}
