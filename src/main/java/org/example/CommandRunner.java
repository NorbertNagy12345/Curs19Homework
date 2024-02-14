package org.example;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.Transaction;
import org.example.service.TransactionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.UUID.randomUUID;
import static org.example.model.TransactionType.BUY;
import static org.example.model.TransactionType.SELL;

@Component
@RequiredArgsConstructor
@Slf4j
public class CommandRunner implements CommandLineRunner {
    private final TransactionService service;

    @Override
    public void run(String... args) {
        log.info("Runner is populating with data");
        service.getAll(null).addAll(List.of(
                Transaction.builder()
                        .id(randomUUID().toString())
                        .product("TV")
                        .type(BUY)
                        .amount(3000D)
                        .build(),
                Transaction.builder()
                        .id(randomUUID().toString())
                        .product("laptop")
                        .type(SELL)
                        .amount(8000D)
                        .build(),
                Transaction.builder()
                        .id(randomUUID().toString())
                        .product("Quest")
                        .type(BUY)
                        .amount(1500D)
                        .build()
        ));
    }
}