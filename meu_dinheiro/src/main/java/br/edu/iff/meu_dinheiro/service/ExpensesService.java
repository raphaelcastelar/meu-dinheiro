package br.edu.iff.meu_dinheiro.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import br.edu.iff.meu_dinheiro.entities.expenses;

@Service
public class ExpensesService {

    private List<expenses> expensesList = new ArrayList<>();
    
    public List<expenses> findAll() {
        return new ArrayList<>(expensesList);

    }

    public expenses FindExpensesById(Long id) {
        expenses expenses = new expenses();
        if ( id == null) {
            return null; 
        }
            expenses.setId(id);
            expenses.setDescription("aaa"); 
            expenses.setValue(null);
            return expenses;
        
    }

    public expenses save(expenses expense) {
        if (expense.getId() == null) {
            Long newId = expensesList.stream()
                    .mapToLong(e -> e.getId() != null ? e.getId() : 0)
                    .max()
                    .orElse(0L) + 1;
            expense.setId(newId);
        }
        expensesList.removeIf(e -> e.getId() != null && e.getId().equals(expense.getId()));
        expensesList.add(expense);
        return expense;
    }

    public void deleteById(Long id) {
        expensesList.removeIf(expense -> expense.getId() != null && expense.getId().equals(id));
    }
}