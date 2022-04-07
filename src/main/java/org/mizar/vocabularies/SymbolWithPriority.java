package org.mizar.vocabularies;

import lombok.*;

@Getter

public class SymbolWithPriority extends Symbol {

    private Integer priority;

    public SymbolWithPriority(SymbolKind kind, String representation, Integer priority) {
        super(kind, representation);
        this.priority = priority;
    }

    @Override
    public String toString() {
        return super.toString() + " " + priority;
    }
}
