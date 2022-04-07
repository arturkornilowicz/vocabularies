package org.mizar.vocabularies;

import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode(of={"representation"})
@Getter

public class Symbol {

    private SymbolKind kind;
    private String representation;
    private String representation2;

    public Symbol(SymbolKind kind, String representation) {
        this(kind,representation,null);
    }

    @Override
    public String toString() {
        return kind + representation + (representation2 == null ? "" : " " + representation2);
    }
}
