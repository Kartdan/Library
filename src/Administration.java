import java.util.*;

public class Administration
{
    List<PublishingRetailer> publishing_retailers_list;
    public Administration(List<PublishingRetailer> publishing_retailers_list)
    {
        this.publishing_retailers_list = publishing_retailers_list;
    }
    List<Book> books_list_return = new ArrayList<>();
    List<Book> final_book_return_list = new ArrayList<>();
    public List<Book> getBooksForPublishingRetailerID(int publishingRetailerID)
    {
        for (PublishingRetailer contor: publishing_retailers_list)
        {
            if(contor.getID() == publishingRetailerID)
            {
                for (IPublishingArtifact aux : contor.getPublishingArtifacts())
                {
                    if (aux instanceof Book aux2) {
                        books_list_return.add(aux2);
                    }
                    if (aux instanceof PublishingBrand publishingBrand) {
                        books_list_return.addAll(publishingBrand.books);
                    }
                    if (aux instanceof EditorialGroup editorialGroup) {
                        books_list_return.addAll(editorialGroup.getBooks());
                    }
                }
            }
        }
        for(Book contor: books_list_return)
        {
            if(!final_book_return_list.contains(contor))
            {
                final_book_return_list.add(contor);
            }
        }
        return final_book_return_list;
    }

    List<Language> language_return_list = new ArrayList<>();
    List<String> final_language_return_list = new ArrayList<>();
    public List<String> getLanguagesForPublishingRetailerID(int publishingRetailerID)
    {
        for (PublishingRetailer contor_2: publishing_retailers_list)
        {
            if(contor_2.getID() == publishingRetailerID)
            {
                for (IPublishingArtifact aux : contor_2.getPublishingArtifacts()) {
                    if (aux instanceof Book) {
                        language_return_list.add(((Book) aux).language);
                    }
                    if (aux instanceof PublishingBrand publishingBrand) {
                        for (Book contor : publishingBrand.books) {
                            language_return_list.add(contor.language);
                        }
                    }
                    if (aux instanceof EditorialGroup editorialGroup) {
                        for (Book contor : editorialGroup.getBooks()) {
                            language_return_list.add(contor.language);
                        }
                        //language_list_return.addAll(editorialGroup.books);
                    }
                }
            }
        }
        for(Language contor: language_return_list)
        {
            if(!final_language_return_list.contains(contor.name))
            {
                final_language_return_list.add(contor.name);
            }
        }
        return final_language_return_list;
    }

    List<ArrayList<Countries>> countries_return_list = new ArrayList<>();
    public List<ArrayList<Countries>> getCountriesForBookID(int bookID)
    {
        for(PublishingRetailer i: publishing_retailers_list)
        {
            for(IPublishingArtifact j: i.getPublishingArtifacts())
            {
                if(j instanceof Book)
                {
                    if(((Book) j).getID() == bookID)
                    {
                        countries_return_list.add(i.getCountries());
                    }
                }
                if(j instanceof PublishingBrand publishingBrand)
                {
                    for(Book contor: publishingBrand.getBooks())
                    {
                        if(contor.getID() == bookID)
                        {
                            countries_return_list.add(i.getCountries());
                        }
                    }
                }
                if(j instanceof EditorialGroup editorialGroup)
                {
                    for(Book contor: editorialGroup.getBooks())
                    {
                        if(contor.getID() == bookID)
                        {
                            countries_return_list.add(i.getCountries());
                        }
                    }
                }
            }
        }
        return countries_return_list;
    }

    List<Book> common_books_list_return = new ArrayList<>();
    List<Book> getCommonBooksForRetailerIDs(int retailerID1, int retailerID2)
    {
        List<Book> list_1 = new ArrayList<>();
        List<Book> list_2 = new ArrayList<>();

        for (PublishingRetailer contor: publishing_retailers_list)
        {
            if(contor.getID() == retailerID1)
            {
                for (IPublishingArtifact aux : contor.getPublishingArtifacts())
                {
                    if (aux instanceof Book aux2) {
                        list_1.add(aux2);
                    }
                    if (aux instanceof PublishingBrand publishingBrand) {
                        list_1.addAll(publishingBrand.books);
                    }
                    if (aux instanceof EditorialGroup editorialGroup) {
                        list_1.addAll(editorialGroup.getBooks());
                    }
                }
            }
        }
        for (PublishingRetailer contor: publishing_retailers_list)
        {
            if(contor.getID() == retailerID2)
            {
                for (IPublishingArtifact aux : contor.getPublishingArtifacts())
                {
                    if (aux instanceof Book aux2) {
                        list_2.add(aux2);
                    }
                    if (aux instanceof PublishingBrand publishingBrand) {
                        list_2.addAll(publishingBrand.books);
                    }
                    if (aux instanceof EditorialGroup editorialGroup) {
                        list_2.addAll(editorialGroup.getBooks());
                    }
                }
            }
        }
        for(Book book_1: list_1)
        {
            for(Book book_2: list_2)
            {
                if(Objects.equals(book_1.getName(), book_2.getName()))
                {
                    common_books_list_return.add(book_1);
                }
            }
        }
        return common_books_list_return;
    }

    public List<Book> getAllBooksForRetailerIDs(int retailerID1, int retailerID2)
    {
        List<Book> list_1 = new ArrayList<>();
        List<Book> list_2 = new ArrayList<>();

        for (PublishingRetailer contor: publishing_retailers_list)
        {
            if(contor.getID() == retailerID1)
            {
                for (IPublishingArtifact aux : contor.getPublishingArtifacts())
                {
                    if (aux instanceof Book aux2) {
                        list_1.add(aux2);
                    }
                    if (aux instanceof PublishingBrand publishingBrand) {
                        list_1.addAll(publishingBrand.books);
                    }
                    if (aux instanceof EditorialGroup editorialGroup) {
                        list_1.addAll(editorialGroup.getBooks());
                    }
                }
            }
        }
        for (PublishingRetailer contor: publishing_retailers_list)
        {
            if(contor.getID() == retailerID2)
            {
                for (IPublishingArtifact aux : contor.getPublishingArtifacts())
                {
                    if (aux instanceof Book aux2) {
                        list_2.add(aux2);
                    }
                    if (aux instanceof PublishingBrand publishingBrand) {
                        list_2.addAll(publishingBrand.books);
                    }
                    if (aux instanceof EditorialGroup editorialGroup) {
                        list_2.addAll(editorialGroup.getBooks());
                    }
                }
            }
        }
        List<Book> buffer_list = new ArrayList<>(list_1);
        buffer_list.addAll(list_2);
        List<Book> final_list = new ArrayList<>();
        for(Book contor: buffer_list)
        {
            if(!final_list.contains(contor))
            {
                final_list.add(contor);
            }
        }
        return final_list;
    }

    public void print_book(List<Book> Book_list)
    {
        for(Book contor: Book_list)
        {
            System.out.println(contor.getName() + " " + contor.getID());
        }
    }
    public void print_language(List<String> Languages_list)
    {
        for(String contor: Languages_list)
        {
            System.out.println("Language name: " + contor);
        }
    }
    public void print_countries(List<ArrayList<Countries>> Countries_list, int BookId)
    {
        for(ArrayList<Countries> contor: Countries_list)
        {
            for(Countries contor_2: contor)
            {
                System.out.println("Country code for bookID " + BookId + ": " + contor_2.countryCode + " " + contor_2.ID);
            }
        }
    }
}
