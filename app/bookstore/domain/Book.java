/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:15:12
 */

package app.bookstore.domain;

import java.time.LocalDate;

public class Book {
    private String id;

    private String author;

    private String title;

    private String description;

    private String isbn;

    private double price;

    private LocalDate publishDate;

    public Book(String id, String author, String title, String description, String isbn, double price, LocalDate publishDate) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.price = price;
        this.publishDate = publishDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
}
