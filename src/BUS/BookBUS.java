/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.util.List;
import DAO.BookDAO;
import DTO.Book;
import java.sql.*;

/**
 *
 * @author User
 */
public class BookBUS {
    private BookDAO BookDAO;
    
    public BookBUS() {
        BookDAO = new BookDAO();
    }
    
    
    public List<Book> getAllBooks() {
        return BookDAO.getAllBooks();
    }
    public List<Book> getBooksAvailable() {
        return BookDAO.getBooksAvailable();
    }
    public void addBook(Book bo) {
        BookDAO.addBook(bo);
    }
    public boolean checkBookIdExists(String id) {
        List<Book> books = getAllBooks(); 
        for (Book book : books) {
            if (book.getMaSach().equals(id)) {
                return true;
            }
        }
        return false; 
}

    public void deleteBook(String id) throws SQLException {
        BookDAO.deleteBook(id);
    }
    public void updateBook(Book bk) throws SQLException {
        BookDAO.updateBook(bk);
    }
    public List<Book> searchBookByID(String query) {
        return BookDAO.searchBookByID(query);
    }
    public List<Book> searchBookByName(String query) {
        return BookDAO.searchBookByName(query);
    }
    public List<Book> searchBookByAuthor(String query) {
        return BookDAO.searchBookByAuthor(query);
    }
    public List<Book> searchBookByCategory(String query) {
        return BookDAO.searchBookByCategory(query);
    }
    public String getMaTheLoaiByTen(String tenTheLoai) {
        return BookDAO.getMaTheLoaiByTen(tenTheLoai);
    }
    public String getMaNXBByTen(String tenNXB) {
        return BookDAO.getMaNXBByTen(tenNXB);
    }
    public Book getBookByMaSach(String maSach) {
        return BookDAO.getBookByMaSach(maSach);
    }
}

