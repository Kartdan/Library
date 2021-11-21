import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Author> authors_list = new ArrayList<>();
        List<Book> books_list = new ArrayList<>();
        List<EditorialGroup> editorial_group_list = new ArrayList<>();
        List<PublishingBrand> publishing_brand_list = new ArrayList<>();
        List<PublishingRetailer> publishing_retailers_list = new ArrayList<>();
        List<Countries> countries_list = new ArrayList<>();

        File file;
        Scanner scan;
        int j;

        //autorii
        try {
            file = new File("/Users/Dani Cartale/Desktop/Facultate/Anul 2/Sem 1/POO/Tema_1/src/init/Authors.in");
            scan = new Scanner(file);
            scan.nextLine();
            while (scan.hasNextLine()) {
                String[] arr = scan.nextLine().split("###");
                Author contor = new Author();
                contor.setID(Integer.parseInt(arr[0]));
                contor.setFirstName(arr[1]);
                contor.setLastName(arr[2]);
                authors_list.add(contor);
            }
        } catch (Exception e) {
            System.out.println("Eroare");
        }

        try {
            //cartile
            file = new File("/Users/Dani Cartale/Desktop/Facultate/Anul 2/Sem 1/POO/Tema_1/src/init/books.in");
            scan = new Scanner(file);
            scan.nextLine();
            while (scan.hasNextLine()) {
                String[] arr = scan.nextLine().split("###");
                Book contor = new Book();
                contor.setID(Integer.parseInt(arr[0]));
                contor.setName(arr[1]);
                contor.setSubtitle(arr[2]);
                contor.ISBN = arr[3];
                contor.setPageCount(Integer.parseInt(arr[4]));
                ArrayList<String> keywords_list = new ArrayList<>();
                String[] key_words = arr[5].split("; ");
                Collections.addAll(keywords_list, key_words);
                contor.setKeywords(keywords_list);
                contor.getLanguage().setID(Integer.parseInt(arr[6]));
                contor.setCreatedOn(arr[7]);
                books_list.add(contor);
            }
        } catch (Exception e) {
            System.out.println("Eroare");
        }

        //limbile
        try {
            file = new File("/Users/Dani Cartale/Desktop/Facultate/Anul 2/Sem 1/POO/Tema_1/src/init/languages.in");
            scan = new Scanner(file);
            scan.nextLine();
            while (scan.hasNextLine()) {
                String[] arr = scan.nextLine().split("###");
                int language_ID = Integer.parseInt(arr[0]);
                String language_code = arr[1];
                String language_name = arr[2];
                for (Book contor : books_list) {
                    if (contor.getLanguage().getID() == language_ID) {
                        contor.getLanguage().setCode(language_code);
                        contor.getLanguage().setName(language_name);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Eroare");
        }

        //legatura autori-carte
        try {
            file = new File("/Users/Dani Cartale/Desktop/Facultate/Anul 2/Sem 1/POO/Tema_1/src/init/books-authors.in");
            scan = new Scanner(file);
            scan.nextLine();
            int i = 0;
            while (scan.hasNextLine()) {
                String[] arr = scan.nextLine().split("###");
                int book_id = Integer.parseInt(arr[0]);
                int author_id = Integer.parseInt(arr[1]);
                for (Book contor_book : books_list) {
                    if (book_id == contor_book.getID()) {
                        for (Author contor_author : authors_list) {
                            if (author_id == contor_author.getID()) {
                                books_list.get(i).getAuthors().add(contor_author);
                            }
                        }
                    }
                }
                i++;
            }
        } catch (Exception e) {
            System.out.println("Eroare");
        }

        try {
            //grupurile editoriale
            file = new File("/Users/Dani Cartale/Desktop/Facultate/Anul 2/Sem 1/POO/Tema_1/src/init/editorial-groups.in");
            scan = new Scanner(file);
            scan.nextLine();
            while (scan.hasNextLine()) {
                String[] arr = scan.nextLine().split("###");
                EditorialGroup contor = new EditorialGroup();
                contor.setID(Integer.parseInt(arr[0]));
                contor.setName(arr[1]);
                editorial_group_list.add(contor);
            }
        } catch (Exception e) {
            System.out.println("Eroare");
        }

        //publishing brands
        try {
            file = new File("/Users/Dani Cartale/Desktop/Facultate/Anul 2/Sem 1/POO/Tema_1/src/init/publishing-brands.in");
            scan = new Scanner(file);
            scan.nextLine();
            while (scan.hasNextLine()) {
                String[] arr = scan.nextLine().split("###");
                PublishingBrand contor = new PublishingBrand();
                contor.ID = Integer.parseInt(arr[0]);
                contor.name = arr[1];
                publishing_brand_list.add(contor);
            }
        } catch (Exception e) {
            System.out.println("Eroare");
        }

        //editorial-groups-books
        try {
            file = new File("/Users/Dani Cartale/Desktop/Facultate/Anul 2/Sem 1/POO/Tema_1/src/init/editorial-groups-books.in");
            scan = new Scanner(file);
            scan.nextLine();
            j = 0;
            while (scan.hasNextLine()) {
                String[] arr = scan.nextLine().split("###");
                int group_id = Integer.parseInt(arr[0]);
                int book_id = Integer.parseInt(arr[1]);
                for (Book contor_book : books_list) {
                    if (book_id == contor_book.getID()) {
                        for (EditorialGroup contor_EG : editorial_group_list) {
                            if (group_id == contor_EG.getID()) {
                                editorial_group_list.get(j).getBooks().add(contor_book);
                            }
                        }
                    }
                }
                j++;
            }
        } catch (Exception e) {
            System.out.println("Eroare");
        }

        //publishing-brands-books
        try {
            file = new File("/Users/Dani Cartale/Desktop/Facultate/Anul 2/Sem 1/POO/Tema_1/src/init/publishing-brands-books.in");
            scan = new Scanner(file);
            scan.nextLine();
            j = 0;
            while (scan.hasNextLine()) {
                String[] arr = scan.nextLine().split("###");
                int group_id = Integer.parseInt(arr[0]);
                int book_id = Integer.parseInt(arr[1]);
                for (Book contor_book : books_list) {
                    if (book_id == contor_book.getID()) {
                        for (PublishingBrand contor_EG : publishing_brand_list) {
                            if (group_id == contor_EG.ID) {
                                publishing_brand_list.get(j).books.add(contor_book);
                            }
                        }
                    }
                }
                j++;
            }
        } catch (Exception e) {
            System.out.println("Eroare");
        }

        //publishing-retailers
        try {
            file = new File("/Users/Dani Cartale/Desktop/Facultate/Anul 2/Sem 1/POO/Tema_1/src/init/publishing-retailers.in");
            scan = new Scanner(file);
            scan.nextLine();
            while (scan.hasNextLine()) {
                String[] arr = scan.nextLine().split("###");
                PublishingRetailer contor = new PublishingRetailer();
                contor.setID(Integer.parseInt(arr[0]));
                contor.setName(arr[1]);
                publishing_retailers_list.add(contor);
            }
        } catch (Exception e) {
            System.out.println("Eroare");
        }

        //Countries
        try {
            file = new File("/Users/Dani Cartale/Desktop/Facultate/Anul 2/Sem 1/POO/Tema_1/src/init/countries.in");
            scan = new Scanner(file);
            scan.nextLine();
            while (scan.hasNextLine()) {
                String[] arr = scan.nextLine().split("###");
                Countries contor = new Countries();
                contor.ID = Integer.parseInt(arr[0]);
                contor.countryCode = arr[1];
                countries_list.add(contor);
            }
        } catch (Exception e) {
            System.out.println("Eroare");
        }

        //publishing-retailers-countries
        try {
            file = new File("/Users/Dani Cartale/Desktop/Facultate/Anul 2/Sem 1/POO/Tema_1/src/init/publishing-retailers-countries.in");
            scan = new Scanner(file);
            scan.nextLine();
            j = 0;
            while (scan.hasNextLine()) {
                String[] arr = scan.nextLine().split("###");
                int retailer = Integer.parseInt(arr[0]);
                int contry_id = Integer.parseInt(arr[1]);
                for (PublishingRetailer contor : publishing_retailers_list) {
                    if (contor.getID() == retailer) {
                        for (Countries contor_countries : countries_list) {
                            if (contor_countries.ID == contry_id) {
                                publishing_retailers_list.get(j).getCountries().add(contor_countries);
                            }
                        }
                    }
                }
                j++;
            }
        } catch (Exception e) {
            System.out.println("Eroare");
        }

        //publishing-retailers-books
        try {
            file = new File("/Users/Dani Cartale/Desktop/Facultate/Anul 2/Sem 1/POO/Tema_1/src/init/publishing-retailers-books.in");
            scan = new Scanner(file);
            scan.nextLine();
            //j = 0;
            while (scan.hasNextLine()) {
                String[] arr = scan.nextLine().split("###");
                int retailer_id = Integer.parseInt(arr[0]);
                int book_id = Integer.parseInt(arr[1]);
                j = 0;
                for (PublishingRetailer contor : publishing_retailers_list) {
                    if (contor.getID() == retailer_id) {
                        for (Book contor_book : books_list) {
                            if (contor_book.getID() == book_id) {
                                publishing_retailers_list.get(j).getPublishingArtifacts().add(contor_book);
                            }
                        }
                    }
                    j++;
                }
            }
        } catch (Exception e) {
            System.out.println("Eroare");
        }

        //publishing-retailers-editorial-groups
        try {
            file = new File("/Users/Dani Cartale/Desktop/Facultate/Anul 2/Sem 1/POO/Tema_1/src/init/publishing-retailers-editorial-groups.in");
            scan = new Scanner(file);
            scan.nextLine();
            while (scan.hasNextLine()) {
                String[] arr = scan.nextLine().split("###");
                int retailer_id = Integer.parseInt(arr[0]);
                int group_id = Integer.parseInt(arr[1]);
                j = 0;
                for (PublishingRetailer contor : publishing_retailers_list) {
                    if (contor.getID() == retailer_id) {
                        for (EditorialGroup contor_EG : editorial_group_list) {
                            if (contor_EG.getID() == group_id) {
                                publishing_retailers_list.get(j).getPublishingArtifacts().add(contor_EG);
                            }
                        }
                    }
                    j++;
                }
            }
        } catch (Exception e) {
            System.out.println("Eroare");
        }

        //publishing-retailers-publishing-brands
        try {
            file = new File("/Users/Dani Cartale/Desktop/Facultate/Anul 2/Sem 1/POO/Tema_1/src/init/publishing-retailers-publishing-brands.in");
            scan = new Scanner(file);
            scan.nextLine();
            while (scan.hasNextLine()) {
                String[] arr = scan.nextLine().split("###");
                int retailer_id = Integer.parseInt(arr[0]);
                int publisher_id = Integer.parseInt(arr[1]);
                j = 0;
                for (PublishingRetailer contor : publishing_retailers_list) {
                    if (contor.getID() == retailer_id) {
                        for (PublishingBrand contor_PG : publishing_brand_list) {
                            if (contor_PG.ID == publisher_id) {
                                publishing_retailers_list.get(j).getPublishingArtifacts().add(contor_PG);
                            }
                        }
                    }
                    j++;
                }
            }
        } catch (Exception e) {
            System.out.println("Eroare");
        }

        //Java - data structures
        Administration test_1 = new Administration(publishing_retailers_list);

        //getBooksForPublishingRetailerID()
        int t1_1 = 16;
        int t1_2 = 2;
        int t1_3 = 6;
        int t1_4 = 10;
        int t1_5 = 12;
        List<Book> books_method_1;
        books_method_1 = test_1.getBooksForPublishingRetailerID(t1_1);
        test_1.print_book(books_method_1);
        books_method_1 = test_1.getBooksForPublishingRetailerID(t1_2);
        test_1.print_book(books_method_1);
        books_method_1 = test_1.getBooksForPublishingRetailerID(t1_3);
        test_1.print_book(books_method_1);
        books_method_1 = test_1.getBooksForPublishingRetailerID(t1_4);
        test_1.print_book(books_method_1);
        books_method_1 = test_1.getBooksForPublishingRetailerID(t1_5);
        test_1.print_book(books_method_1);

        //getLanguagesForPublishingRetailerID
        int t2_1 = 7;
        int t2_2 = 8;
        int t2_3 = 11;
        int t2_4 = 2;
        int t2_5 = 13;
        List<String> language_method_2 = test_1.getLanguagesForPublishingRetailerID(t2_1);
        test_1.print_language(language_method_2);
        language_method_2 = test_1.getLanguagesForPublishingRetailerID(t2_2);
        test_1.print_language(language_method_2);
        language_method_2 = test_1.getLanguagesForPublishingRetailerID(t2_3);
        test_1.print_language(language_method_2);
        language_method_2 = test_1.getLanguagesForPublishingRetailerID(t2_4);
        test_1.print_language(language_method_2);
        language_method_2 = test_1.getLanguagesForPublishingRetailerID(t2_5);
        test_1.print_language(language_method_2);

        //getCountriesForBookID(int bookID)
        int t3_1 = 204;
        int t3_2 = 1581;
        int t3_3 = 2648;
        int t3_4 = 5583;
        int t3_5 = 8517;
        List<ArrayList<Countries>> countries_method_3 = test_1.getCountriesForBookID(t3_1);
        test_1.print_countries(countries_method_3, t3_1);
        countries_method_3 = test_1.getCountriesForBookID(t3_2);
        test_1.print_countries(countries_method_3, t3_2);
        countries_method_3 = test_1.getCountriesForBookID(t3_3);
        test_1.print_countries(countries_method_3, t3_3);
        countries_method_3 = test_1.getCountriesForBookID(t3_4);
        test_1.print_countries(countries_method_3, t3_4);
        countries_method_3 = test_1.getCountriesForBookID(t3_5);
        test_1.print_countries(countries_method_3, t3_5);

        //getCommonBooksForRetailerIDs
        int t4_11 = 12;
        int t4_12 = 17;

        int t4_21 = 3;
        int t4_22 = 7;

        int t4_31 = 4;
        int t4_32 = 5;

        int t4_41 = 7;
        int t4_42 = 9;

        int t4_51 = 17;
        int t4_52 = 8;
        List<Book> books_m4 = test_1.getCommonBooksForRetailerIDs(t4_11, t4_12);
        test_1.print_book(books_m4);
        books_m4 = test_1.getCommonBooksForRetailerIDs(t4_21, t4_22);
        test_1.print_book(books_m4);
        books_m4 = test_1.getCommonBooksForRetailerIDs(t4_31, t4_32);
        test_1.print_book(books_m4);
        books_m4 = test_1.getCommonBooksForRetailerIDs(t4_41, t4_42);
        test_1.print_book(books_m4);
        books_m4 = test_1.getCommonBooksForRetailerIDs(t4_51, t4_52);
        test_1.print_book(books_m4);

        //getAllBooksForRetailerIDs
        List<Book> books_m5_1 = test_1.getAllBooksForRetailerIDs(t4_11, t4_12);
        test_1.print_book(books_m5_1);
        List<Book> books_m5_2 = test_1.getAllBooksForRetailerIDs(t4_21, t4_22);
        test_1.print_book(books_m5_2);
        List<Book> books_m5_3 = test_1.getAllBooksForRetailerIDs(t4_31, t4_32);
        test_1.print_book(books_m5_3);
        List<Book> books_m5_4 = test_1.getAllBooksForRetailerIDs(t4_41, t4_42);
        test_1.print_book(books_m5_4);
        List<Book> books_m5_5 = test_1.getAllBooksForRetailerIDs(t4_51, t4_52);
        test_1.print_book(books_m5_5);
    }
}
