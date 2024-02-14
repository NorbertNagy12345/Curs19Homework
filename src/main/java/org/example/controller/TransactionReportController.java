package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Transaction;
import org.example.model.TransactionType;
import org.example.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("transactions/reports")
@RequiredArgsConstructor
public class TransactionReportController {
    private final TransactionService service;

    @GetMapping("type")
    public Map<TransactionType, List<Transaction>> getGroupedByType() {
        return service.getGroupedByType();
    }
}