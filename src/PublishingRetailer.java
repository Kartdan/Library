import java.util.ArrayList;

public class PublishingRetailer{
    private int ID;
    private String name;
    private final ArrayList<IPublishingArtifact> publishingArtifacts;
    private final ArrayList<Countries> countries;
    public PublishingRetailer()
    {
        publishingArtifacts = new ArrayList<>();
        countries = new ArrayList<>();
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

    public ArrayList<IPublishingArtifact> getPublishingArtifacts() {
        return publishingArtifacts;
    }

    public ArrayList<Countries> getCountries() {
        return countries;
    }
}
