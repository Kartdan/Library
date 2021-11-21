import java.util.ArrayList;

public class EditorialGroup implements  IPublishingArtifact{
    private int ID;
    private String name;
    private ArrayList<Book> books;
    public EditorialGroup()
    {
        books = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public String Publish()
    {
        StringBuilder str = new StringBuilder("<xml>");
        str.append("\n\t<editorialGroup>\n");
        str.append("\t\t<ID>").append(ID).append("</ID>\n");
        str.append("\t\t <Name>").append(name).append("</Name>\n");
        str.append("\t</editorialGroup>\n");
        str.append("\t<books>\n");
        for(Book contor: getBooks())
        {
            str.append("\t\t<book>\n");
            str.append("\t\t\t<title>").append(contor.getName()).append("</title>\n");
            str.append("\t\t\t<subtitle>").append(contor.getSubtitle()).append("</tsubtitle>\n");
            str.append("\t\t\t<isbn>").append(contor.ISBN).append("</isbn>\n");
            str.append("\t\t\t<pageCount>").append(contor.getPageCount()).append("</pageCount>\n");
            str.append("\t\t\t<keywords>");
            int i = 0, j = 0;
            for(String ignored : contor.getKeywords())
            {
                i++;
            }
            for(String contor_2: contor.getKeywords())
            {
                j++;
                if(j < i)
                {
                    str.append(contor_2).append("; ");
                }
                else
                {
                    str.append(contor_2);
                }
            }
            str.append("</keywords>\n");
            str.append("\t\t\t<languageID>").append(contor.getLanguage().getName()).append("</languageID>\n");
            str.append("\t\t\t<createdOn>").append(contor.getCreatedOn()).append("</createdON>\n");
            str.append("\t\t\t<authors>");
            i = 0;
            j = 0;
            for(Author ignored : contor.getAuthors())
            {
                i++;
            }
            for(Author contor_2: contor.getAuthors())
            {
                j++;
                if(j < i)
                {
                    str.append(contor_2.getLastName()).append(" ").append(contor_2.getLastName()).append("; ");
                }
                else
                {
                    str.append(contor_2.getLastName()).append(" ").append(contor_2.getFirstName());
                }
            }
            str.append("</authors>\n");
            str.append("\t\t</book>\n");
        }


        str.append("\t</books>\n");
        str.append("</xml>");

        return str.toString();
    }
}
