package persistence;

import model.Animals;
import model.MoleculeList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

// Represents a writer that writes JSON representation of molecule list to file
//cited from the JsonSerializationDemo
public class JsonWriter {

    private static final int TAB = 3;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of MoleculeList to file
    public void write(MoleculeList ml) {
        JSONObject json = ml.toJson();
        saveToFile(json.toString(TAB));
    }


    // MODIFIES: this
    // EFFECTS: writes JSON representation of a List of Animals to file
    public void write(List<Animals> animals) {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        JSONObject dog = animals.get(0).toJson();
        JSONObject cat = animals.get(1).toJson();
        JSONObject quokka = animals.get(2).toJson();
        jsonArray.put(dog);
        jsonArray.put(cat);
        jsonArray.put(quokka);
        jsonObject.put("Animals", jsonArray);
        saveToFile(jsonObject.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }


}
