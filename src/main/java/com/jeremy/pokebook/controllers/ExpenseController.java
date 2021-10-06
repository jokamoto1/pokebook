package com.jeremy.pokebook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jeremy.pokebook.models.Expense;
import com.jeremy.pokebook.services.ExpenseService;
@Controller
public class ExpenseController {
	
	@Autowired
	ExpenseService  expenseService;
//    @RequestMapping("/books/{id}")
//    public String showExpense(Model model, @PathVariable("id") Long id  ) {
//    	Expense expense = expenseService.findExpense(id);
//    	model.addAttribute("expenses" , expense);
//    	return "index.jsp";	
//    }
    @RequestMapping("/")
    public String showExpenses(Model model, @ModelAttribute("expense") Expense expense ) {
    	List<Expense> expenses = expenseService.allExpenses();
    	model.addAttribute("expenses" , expenses);
//    	model.addAttribute("expense");
    	return "dashboard.jsp";	
    }
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model
//    		@RequestParam(value="name") String name,
//    		@RequestParam(value="vendor") String vendor,
//    		@RequestParam(value="amount") Double amount,
//    		@RequestParam(value="description") String description
    		) {
    		if (result.hasErrors()) {
    			List<Expense> expenses = expenseService.allExpenses();
    	    	model.addAttribute("expenses" , expenses);
    	    	model.addAttribute("expense");
    			return "dashboard.jsp";
    		}
//    		Expense newExpense =  new Expense(name, vendor, amount, description);
    		expenseService.create(expense);
    		return "redirect:/";
    }
}
