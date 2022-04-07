package org.mizar.vocabularies;

import java.util.*;
import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@Getter

public class Vocabulary extends LinkedList<Symbol> {

    private String name;

    @Override
    public String toString() {
        String result = "#" + name + "\n";
        for (Symbol symbol: this) {
            result += symbol + "\n";
        }
        return result;
    }

    public Symbol findSymbol(String representation) {
        int i = indexOf(new Symbol(null,representation));
        return i < 0 ? null : get(i);
    }
}
