package com.example.premiereversion;

/**
 * Classe représentant un objet à faire dans la liste
 */
public class ToDoItem {

    /**
     * Label de l'objet (nom)
     */
    private String label;

    /**
     * Niveau de priorité de l'objet
     */
    private String tag;

    /**
     * Tache réalisé ou non (par défault = false)
     */
    private boolean realise =false;

    /**
     * Constructeur qui initialise un objet non réalisé avec un label et un tag définit
     * @param lab Label de l'objet
     * @param t tag de l'objet
     */
    public ToDoItem(String t,String lab){
        this.label=lab;
        this.tag=t;
    }

    public String getLabel() {
        return label;
    }

    public String getTag() {
        return tag;
    }

    public boolean isRealise() {
        return realise;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setRealise(boolean realise) {
        this.realise = realise;
    }
}
