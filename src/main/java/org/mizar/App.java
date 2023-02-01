package org.mizar;

import org.mizar.vocabularies.Vocabularies;

public class App
{
    public static void main( String[] args )
    {
        if (args.length == 0) {
            System.out.println("\nEnter path to mml.vct file!");
            return;
        }
        Vocabularies vocabularies = new Vocabularies(args[0]);
        vocabularies.loadMmlVct();
        System.out.println(vocabularies);
        System.out.println(vocabularies.findVocabulary("abian"));
        System.out.println(vocabularies.findVocabularyWithSymbol("."));
        System.out.println(vocabularies.findSymbol("."));
    }
}
