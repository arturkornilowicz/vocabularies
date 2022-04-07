package org.mizar.vocabularies;

import java.io.*;
import java.util.*;
import lombok.*;

@AllArgsConstructor

public class Vocabularies extends LinkedList<Vocabulary> {

    private String fileName;

    public void loadMmlVct() {
        Scanner scanner;
        String line;
        String[] tab;
        Vocabulary vocabulary = null;
        SymbolKind kind;
        try {
            System.out.println("Loading " + fileName);
            scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                line = scanner.nextLine().trim();
                if (line.charAt(0) == '#') {
                    if (vocabulary != null) {
                        add(vocabulary);
                    }
                    vocabulary = new Vocabulary(line.substring(1));
                    scanner.nextLine(); // numbers
                } else {
                    tab = line.split(" ");
                    kind = SymbolKind.valueOf(tab[0].substring(0,1));
                    if (tab.length == 1) {
                        vocabulary.add(new Symbol(kind, tab[0].substring(1)));
                    } else {
                        switch (kind) {
                            case O:
                                vocabulary.add(new SymbolWithPriority(kind, tab[0].substring(1), Integer.parseInt(tab[1])));
                                break;
                            case R:
                                vocabulary.add(new Symbol(kind, tab[0].substring(1), tab[1]));
                                break;
                            default:
                                System.out.println("Wrong line " + line);
                        }
                    }
                }
            }
            add(vocabulary);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (Vocabulary vocabulary: this) {
            result += vocabulary;
        }
        return result;
    }

    public Vocabulary findVocabulary(String vocName) {
        int i = indexOf(new Vocabulary(vocName.toUpperCase()));
        return i < 0 ? null : get(i);
    }

    public Vocabulary findVocabularyWithSymbol(String representation) {
        for (Vocabulary vocabulary: this) {
            if (vocabulary.findSymbol(representation) != null) {
                return vocabulary;
            }
        }
        return null;
    }

    public Symbol findSymbol(String representation) {
        Symbol result;
        for (Vocabulary vocabulary: this) {
            result = vocabulary.findSymbol(representation);
            if (result != null) {
                return result;
            }
        }
        return null;
    }
}
