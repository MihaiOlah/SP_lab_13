package services;

import Spring.models.Visitee;
import Spring.models.Visitor;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class FileExporter {
    public FileExporter()
    {

    }

    public void export(Visitee element, String fileName, Visitor<JSONObject> visitor) throws IOException
    {
        JSONObject content = element.accept(visitor);

        try {
            FileWriter file = new FileWriter(fileName);
            file.write(content.toString());
            file.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
