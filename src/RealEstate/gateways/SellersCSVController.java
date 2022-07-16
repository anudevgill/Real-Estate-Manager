package RealEstate.gateways;

import RealEstate.useCases.CreateSeller;
import RealEstate.useCases.DatabaseFilePath;

import java.io.*;

public class SellersCSVController implements CsvInterface{
    private final CreateSeller createSeller;

    private final static DatabaseFilePath filepath = new DatabaseFilePath("Sellers.csv");

    final private static BufferedReader reader;

    static {
        try {
            reader = new BufferedReader(new FileReader(filepath.getFilePath()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    final private static BufferedWriter writer;

    static {
        try {
            writer = new BufferedWriter(new FileWriter(filepath.getFilePath(), true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    final private static BufferedWriter overWriter;

    static {
        try {
            overWriter = new BufferedWriter(new FileWriter(filepath.getFilePath(), false));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SellersCSVController(CreateSeller createSeller){
        this.createSeller = createSeller;
    }

    public CreateSeller getCreateSeller() {
        return createSeller;
    }



    @Override
    public void read() throws IOException {

    }

    @Override
    public void write() throws IOException {

    }
}