package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBoot implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initDate();
    }

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBoot(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initDate() {

        Author almat = new Author("Almat", "Zhagyparov");
        Book book1 = new Book("Java", "23903");
        Publisher publisher1=new Publisher("Astana","Zhandosova 125");


        Author arman = new Author("Arman","Gainullin");
        Book book2 = new Book("PHP","1255");
        Publisher publisher2=new Publisher("Atamura","Tole bi 27");

        almat.getBooks().add(book1);
        book1.getAuthors().add(almat);
        book1.setPublisher(publisher1);

        arman.getBooks().add(book2);
        book2.getAuthors().add(arman);
        book2.setPublisher(publisher2);

        authorRepository.save(almat);
        bookRepository.save(book1);

        authorRepository.save(arman);
        bookRepository.save(book2);

    }



}
