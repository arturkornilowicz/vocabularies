package org.mizar;

import org.mizar.vocabularies.*;

public class VocabulariesApp
{

    static Vocabularies vocabularies;

    static void findDoubleRepresentations() {
        for (Vocabulary vocabulary: vocabularies) {
            for (Symbol symbol: vocabulary) {
                if (symbol.getRepresentation2() != null) {
                    System.out.println(symbol);
                }
            }
        }
    }

    public static void main( String[] args )
    {
        if (args.length == 0) {
            System.out.println("\nEnter path to mml.vct file!");
            return;
        }
        vocabularies = new Vocabularies(args[0]);
        vocabularies.loadMmlVct();
//        System.out.println(vocabularies);
//        System.out.println(vocabularies.findVocabulary("abian"));
//        System.out.println(vocabularies.findVocabularyWithSymbol("."));
//        System.out.println(vocabularies.findSymbol("."));

        findDoubleRepresentations();

    }
}
