import java.util.ArrayList;

public class Book implements  IPublishingArtifact{
    private int ID;
    private String name;
    private String subtitle;
    public String ISBN;
    private long pageCount;
    private ArrayList<String> keywords;
    Language language;
    private String createdOn;
    private final ArrayList<Author> authors;

    public Book(){
        authors = new ArrayList<>();
        keywords = new ArrayList<>();
        language = new Language();
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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    public Language getLanguage() {
        return language;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public String Publish()
    {
        StringBuilder str;
        str = new StringBuilder("<xml>\n");
        str.append("\t<title>").append(getName()).append("</title>\n");
        str.append("\t<subtitle>").append(getSubtitle()).append("</subtitle>\n");
        str.append("\t<isbn>").append(ISBN).append("</isbn>\n");
        str.append("\t<pageCount>").append(getPageCount()).append("</pageCount>\n");
        str.append("\t<keywords>");
        int i = 0, j = 0;
        for(String ignored : this.keywords)
        {
            i++;
        }
        for(String contor: this.keywords)
        {
            j++;
            if(j < i)
            {
                str.append(contor).append("; ");
            }
            else
            {
                str.append(contor);
            }
        }
        str.append("</keywords>\n");
        str.append("\t<languageID>").append(getLanguage().ID).append("</languageID>\n");
        str.append("\t<createdOn>").append(getCreatedOn()).append("</createdOn>\n");
        str.append("\t<authors>");
        i = 0;
        j = 0;
        for(Author ignored : this.authors)
        {
            i++;
        }
        for(Author contor_2: this.authors)
        {
            j++;
            if(j < i)
            {
                str.append(contor_2.getFirstName()).append(" ").append(contor_2.getLastName()).append("; ");
            }
            else
            {
                str.append(contor_2.getFirstName()).append(" ").append(contor_2.getLastName());
            }
        }
        str.append("</authors>\n");
        str.append("</xml>");
        return str.toString();
    }
}
