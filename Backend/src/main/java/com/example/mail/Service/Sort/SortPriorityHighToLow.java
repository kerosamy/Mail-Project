package com.example.mail.Service.Sort;

import com.example.mail.model.Email;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class SortPriorityHighToLow implements Sort<Email> {
    @Override
    public List<Email> applySort(List<Email> emails) {
        emails.sort(Comparator.comparing(SortPriorityHighToLow::getPriorityValue));
        return emails;
    }
    private static int getPriorityValue(Email email) {
        return switch (email.getPriority().toUpperCase()) {
            case "HIGH" -> 1;
            case "MEDIUM" -> 2;
            case "LOW" -> 3;
            default -> Integer.MAX_VALUE;
        };
    }
}
