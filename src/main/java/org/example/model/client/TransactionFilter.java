package org.example.model.client;

import lombok.Builder;
import org.example.model.TransactionType;

@Builder
public record TransactionFilter(
        String product,
        TransactionType type,
        Double minAmount,
        Double maxAmount
) {
}