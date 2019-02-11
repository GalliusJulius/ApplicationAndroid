package com.example.premiereversion;

import android.app.AlertDialog;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Adapteur pour les datas dans notre recycler view
 */
public class AdpaterRecycler extends RecyclerView.Adapter<AdpaterRecycler.VuePerso> {
    /**
     * Liste des données au sein du recycler view
     */
    private List<ToDoItem> listeData;

    /**
     * Classe interne responsable de donner chaque vues
     */
    public static class VuePerso extends RecyclerView.ViewHolder{

        private ImageView couleur;
        private TextView label;
        private ToDoItem item = null;
        private Switch boutton;

        public VuePerso(@NonNull View item) {
            super(item);
            label = ((TextView) itemView.findViewById(R.id.label));
            couleur = ((ImageView) itemView.findViewById(R.id.couleur));
            boutton = ((Switch) itemView.findViewById(R.id.swi));

            /**
            boutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle("cc".first)
                            .setMessage("c".second)
                            .show();
                }
            });*/
        }

        public void afficher(ToDoItem todo){
            item = todo;
            label.setText(todo.getLabel());
            switch (todo.getTag()){
                case Tags.FAIBLE:
                    //vert
                    couleur.setBackgroundColor(Color.rgb(90,204,86));
                    break;
                case Tags.IMPORTANT:
                    //rouge
                    couleur.setBackgroundColor(Color.rgb(192,29,29));
                    break;
                case Tags.NORMAL:
                    couleur.setBackgroundColor(Color.rgb(249,151,28));
                    break;
                 default:

            }
            if(item.isRealise()){
                boutton.setChecked(true);
            }
            else{
                boutton.setChecked(false);
            }
        }

        public void activer(){
            System.out.println("cc");
            boutton.setChecked(true);
        }
    }

    /**
     * Constructeur de l'adapteur
     * @param contenu les objets au sein de l'adaptateur
     */
    public AdpaterRecycler(List<ToDoItem> contenu){
        super();
        listeData = contenu;
    }

    /**
     * Methode appélé automatiquement par le layoutManager (créé une nouvelle vue)
     *
     */
    @NonNull
    @Override
    public AdpaterRecycler.VuePerso onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view, parent, false);
        VuePerso vh = new VuePerso(v);
        return vh;
    }

    /**
     * Remplace une valeur d'une vue (appel automatique avec le layoutManager)
     */

    @Override
    public void onBindViewHolder(@NonNull VuePerso vuePerso, int i) {
        ToDoItem item = listeData.get(i);
        vuePerso.afficher(item);
    }

    @Override
    public int getItemCount() {
        return listeData.size();
    }
}
