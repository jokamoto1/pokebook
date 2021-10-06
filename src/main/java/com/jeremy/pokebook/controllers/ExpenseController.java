package com.jeremy.pokebook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestMapping("/edit/{id}")
    public String edit(Model model,@PathVariable("id") Long id , @Valid @ModelAttribute("expense") Expense expense, BindingResult result ) {
    	if (result.hasErrors()) {
	    	model.addAttribute("expense");
			return "edit.jsp";
		}
    	expenseService.create(expense);
    	
    	return "redirect:/";	
    }
    @RequestMapping("/show/edit/{id}")
    public String showEdit(Model model,@PathVariable("id") Long id , @ModelAttribute("expense") Expense expense) {
    	Expense oneExpense = expenseService.findExpense(id);
    	model.addAttribute("oneExpense" , oneExpense);
   
    	return "edit.jsp";	
    }
    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/";
    }
    @RequestMapping(value="/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
    	Expense expense =expenseService.findExpense(id);
    	model.addAttribute("expense", expense);
    	return "view.jsp";
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
