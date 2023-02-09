package org.mizar.vocabularies;

import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode(of={"representation"})
@Getter

public class Symbol {

    public static final Integer defaultPriority = 64;

    private SymbolKind kind;
    private String representation;
    private String representation2;
    private Integer priority = defaultPriority;

    public Symbol(SymbolKind kind, String representation, Integer priority) {
        this(kind,representation,null,priority);
    }

    public Symbol(SymbolKind kind, String representation, String representation2) {
        this(kind,representation,representation2,defaultPriority);
    }

    public Symbol(SymbolKind kind, String representation ) {
        this(kind,representation,null,defaultPriority);
    }

    @Override
    public String toString() {
        return kind + representation + (representation2 == null ? "" : " " + representation2) + (kind == SymbolKind.O ? " " + priority : "");
    }
}
