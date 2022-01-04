package services;

import Spring.models.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class OpenCommand implements Command{
    private final String file_;

    public OpenCommand(String file)
    {
        file_ = file;
    }

    @Override
    public void execute() {
        try {
            String jsonFileData = new String(Files.readAllBytes(Paths.get(file_)));
            JSONObject book = new JSONObject(jsonFileData);
            JSONArray bookElements = book.getJSONArray("content").getJSONObject(0).getJSONArray("elements");
            JSONArray bookAuthors = book.getJSONArray("authors");
            Book concreteBook = new Book(book.getString("title"));

            for (int i = 0; i < bookAuthors.length(); i++)
            {
                JSONObject e = bookAuthors.getJSONObject(i);

                concreteBook.addAuthor(new Author(e.getString("surname"), e.getString("name")));
            }

            for (int i = 0; i < bookElements.length(); i++)
            {
                JSONObject e = bookElements.getJSONObject(i);

                Iterator keys = e.keys();

                while (keys.hasNext())
                {
                    String currentKey = (String)keys.next();

                    JSONObject currentObj = e.getJSONObject(currentKey);

                    if (currentKey.equals("paragraph"))
                    {
                        concreteBook.add(new Paragraph(currentObj.getString("text")));
                    }
                    else if (currentKey.equals("imageProxy"))
                    {
                        concreteBook.add(new ImageProxy(currentObj.getString("url")));
                    }
                    else if (currentKey.equals("image"))
                    {
                        concreteBook.add(new Image(currentObj.getString("url")));
                    }
                    else if (currentKey.equals("table"))
                    {
                        concreteBook.add(new Table(currentObj.getString("title")));
                    }
                }
            }

            DocumentManager.setBook(concreteBook);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
