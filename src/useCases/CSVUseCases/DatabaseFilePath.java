package useCases.CSVUseCases;

import java.io.File;


/**
 * Class to get the absolute file path of a file.
 * <p>
 * Usage Example:
 * DatabaseFilePath c = new DatabaseFilePath("EXAMPLE.csv");
 * System.out.println(c.getFilePath());     // prints the absolute path of EXAMPLE.csv in the database folder
 * <p>
 * // below will create EXAMPLE.csv under the database folder
 * FileWriter fw = new FileWriter(new File(DatabaseFilePath.getDatabasePath(), c.getFileName()));
 * BufferedWriter output = new BufferedWriter(fw);
 * output.close();
 * <p>
 * // below will add a line "This line will be added" to the "EXAMPLE.csv" file
 * FileWriter fw2 = new FileWriter(c.getFilePath(), true);
 * BufferedWriter output2 = new BufferedWriter(fw2);
 * output2.append("\n").append("This line will be added");
 * output2.close();
 */

public class DatabaseFilePath {

    private final String filePath;

    /**
     * Create a DatabaseFilePath class for a file
     *
     * @param filename name of the file
     */
    public DatabaseFilePath(String filename) {
        this.filePath = System.getProperty("user.dir") + File.separator +
                "src" + File.separator + "database" + File.separator + filename;
    }

    /**
     * Getter for filePath
     *
     * @return The path of the file
     */
    public String getFilePath() {
        return filePath;
    }

}
