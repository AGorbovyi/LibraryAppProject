package libraryapp;

/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author: Anton Gorbovyi
 * @version: 22.04.2024
 **/

import libraryapp.repository.BookCatalogRepository;
import libraryapp.repository.UserCardRepository;
import libraryapp.service.BookCatalogService;
import libraryapp.service.LibraryService;
import libraryapp.service.UserCardService;
import libraryapp.ui.AdminMenu;

public class LibraryApp {

    public static void main(String[] args) {
        BookCatalogRepository bookCatalog = new BookCatalogRepository();
        bookCatalog.init();
        UserCardRepository userCardRepository = new UserCardRepository();
        userCardRepository.init();

        BookCatalogService bookCatalogService = new BookCatalogService(bookCatalog);
        UserCardService userCardService = new UserCardService(userCardRepository);
        List<Service> services = new ArrayList();
        services.add(bookCatalogService);
        services.add(userCardService);
        LibraryService libraryService = new LibraryService(services);

        AdminMenu adminMenu = new AdminMenu(services);

        while (true){
            adminMenu.startMenu();
        }

    }

}
