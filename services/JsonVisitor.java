package services;

import Spring.models.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonVisitor implements Visitor<JSONObject> {

    @Override
    public JSONObject visitBook(Book book) {
        JSONArray json_arr = new JSONArray();
        JSONObject json_book= new JSONObject();

        try {
            json_book.put("title", book.getTitle());

            for (Author author : book.getAuthors())
            {
                JSONObject json_author = new JSONObject();

                json_author.put("surname", author.getName());
                json_author.put("name", author.getSurname());

                json_arr.put(json_author);
            }

            json_book.put("authors", json_arr);

            json_arr = new JSONArray();

            for (Element element : book.getContent())
            {
                JSONObject json_element= new JSONObject();
                json_arr.put(((Visitee)element).accept(this));
            }

            json_book.put("content", json_arr);

            return json_book;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JSONObject visitSection(Section section) {
        JSONArray json_arr = new JSONArray();
        JSONObject json_elem= new JSONObject();

        try {
            for (Element element : section.getContent())
            {
                json_arr.put(((Visitee)element).accept(this));
            }

            json_elem.put("elements", json_arr);

            return json_elem;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JSONObject visitTableOfContents(TableOfContents tableOfContents) {
        JSONObject json = new JSONObject();

        try {
            json.put("title", tableOfContents.getTitle());

            return (new JSONObject()).put("tableOfContents", json);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JSONObject visitParagraph(Paragraph paragraph) {
        JSONObject json = new JSONObject();

        try {
            json.put("text", paragraph.getText());

            return (new JSONObject()).put("paragraph", json);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JSONObject visitImageProxy(ImageProxy imageProxy) {
        JSONObject json = new JSONObject();

        try {
            json.put("url", imageProxy.getUrl());

            return (new JSONObject()).put("imageProxy", json);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JSONObject visitImage(Image image) {
        JSONObject json = new JSONObject();

        try {
            json.put("url", image.getUrl());

            return (new JSONObject()).put("image", json);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JSONObject visitTable(Table table) {
        JSONObject json = new JSONObject();

        try {
            json.put("title", table.getTitle());

            return (new JSONObject()).put("table", json);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
