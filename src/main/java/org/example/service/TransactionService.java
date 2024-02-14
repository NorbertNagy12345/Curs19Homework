package org.example.service;

import org.example.model.Transaction;
import org.example.model.TransactionType;
import org.example.model.client.TransactionFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
@Service
public class TransactionService {private final List<Transaction> transactions;

    public TransactionService() {
        this.transactions = new ArrayList<>();
    }

    public List<Transaction> getAll(TransactionFilter filter) {
        if (filter == null) {
            return transactions;
        }

        return transactions.stream()
                .filter(transaction -> filter.product() == null || filter.product().equals(transaction.product()))
                .filter(transaction -> filter.type() == null || filter.type().equals(transaction.type()))
                .filter(transaction -> filter.minAmount() == null || filter.minAmount() < transaction.amount())
                .filter(transaction -> filter.maxAmount() == null || filter.maxAmount() > transaction.amount())
                .toList();
    }

    public Map<TransactionType, List<Transaction>> getGroupedByType() {
        return transactions.stream().collect(groupingBy(Transaction::type));
    }
}