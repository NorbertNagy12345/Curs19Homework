package org.example.model;

import lombok.Builder;

@Builder
public record Transaction(
        String id,
        String product,
        TransactionType type,
        Double amount
) {
}