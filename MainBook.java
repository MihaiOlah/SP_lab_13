import services.*;

public class MainBook {

    public static void main(String[] args) throws Exception {
        Command cmd1 = new OpenCommand("fisier.json");
        cmd1.execute();

        Command cmd2 = new StatisticsCommand(DocumentManager.getBook());
        cmd2.execute();

        //DocumentManager.getBook().accept(new RenderContentVisitor());
    }

}
