package org.mizar.vocabularies;

import lombok.*;

@AllArgsConstructor
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

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Symbol symbol = (Symbol) obj;
        return
                this.getRepresentation().equals(symbol.getRepresentation()) ||
                        (symbol.getRepresentation2() != null && this.getRepresentation().equals(symbol.getRepresentation2())) ||
                        (this.getRepresentation2() != null && this.getRepresentation2().equals(symbol.getRepresentation())) ||
                        (this.getRepresentation2() != null && symbol.getRepresentation2() != null && this.getRepresentation2().equals(symbol.getRepresentation2()))
                ;
    }
}
