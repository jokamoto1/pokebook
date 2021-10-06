package com.jeremy.pokebook.services;

// ...
import org.springframework.stereotype.Service;
import java.util.*;
import com.jeremy.pokebook.models.Expense;
import com.jeremy.pokebook.repositories.ExpenseRepository;
@Service
public class ExpenseService {
    // adding the book repository as a dependency
	private final ExpenseRepository expenseRepository;
    
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    // returns all the books
    public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
    // creates a book
    public Expense create(Expense e) {
        return expenseRepository.save(e);
    }
    public void deleteExpense(Long id) {
    	 expenseRepository.deleteById(id);
    }
//    public Expense updateExpense(Long id, String title, String desc,String lang,Integer numOfPages) {
//    	Expense oldBook =  findBook(id);
//    	oldBook.setTitle(title);
//    	oldBook.setDescription(desc);
//    	oldBook.setLanguage(lang);
//    	oldBook.setNumberOfPages(numOfPages);
//    	return bookRepository.save(oldBook);
//    }
    // retrieves a book
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
}
