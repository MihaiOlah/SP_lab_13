import Spring.models.*;
import Spring.models.ImageProxy;
//import org.json.JSONObject;
import org.json.JSONObject;
import services.BookStatistics;
import services.FileExporter;
import services.JsonVisitor;
import services.RenderContentVisitor;

public class Lab6 {

    public static void main(String[] args) throws Exception {
        Book book = new Book("Titanic");
        Section cap1 = new Section("Capitolul 1");
        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.add(p1);
        Paragraph p2 = new Paragraph("Paragraph 2");
        cap1.add(p2);
        Paragraph p3 = new Paragraph("Paragraph 3");
        cap1.add(p3);
        Paragraph p4 = new Paragraph("Paragraph 4");
        cap1.add(p4);
        cap1.add(new ImageProxy("ImageOne"));
        cap1.add(new Image("ImageTwo"));
        cap1.add(new Paragraph("Some text"));
        cap1.add(new Table("Table 1"));

        cap1.accept(new RenderContentVisitor());
        book.add(cap1);
        BookStatistics stats = new BookStatistics();
        cap1.accept(stats);
        stats.printStatistics();

        book.addAuthor(new Author("Bnea", "Dorin"));
        book.addAuthor(new Author("FFF", "OP"));

        JSONObject a = book.accept(new JsonVisitor());
        (new FileExporter()).export(book, "fisier.json", new JsonVisitor());
    }


}
