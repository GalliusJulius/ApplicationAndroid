package com.example.premiereversion;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ToDoItem> listeTaches = new ArrayList<ToDoItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * Set up
         */
        super.onCreate(savedInstanceState);
        //on set le layout
        setContentView(R.layout.activity_main);
        listeTaches = getListe();

        /**
         * Recupération des objets
         */
        //on récupère la barre en haut
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Boutton en bas (message)
        FloatingActionButton fab = findViewById(R.id.fab);

        /**
         * Gestion du recycler view
         */
        //on le récupère
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //améliore les perfs de l'appli
        recyclerView.setHasFixedSize(true);
        //initialisation du layout manager + le mettre sur le recycler
        LinearLayoutManager layoutRecycler = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutRecycler);
        //gestion de l'adapteur
        AdpaterRecycler adpateur = new AdpaterRecycler(listeTaches);
        recyclerView.setAdapter(adpateur);
        //listener de recyler
        /** TODO
        SwipeController swipe = new SwipeController();
        ItemTouchHelper item = new ItemTouchHelper(swipe);
        item.attachToRecyclerView(recyclerView);
    */
        /**
         * Ajout des listeners
         */
        //Ajout de listeners sur le boutton de message
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public  List<ToDoItem> getListe(){
        ArrayList<ToDoItem> items = new ArrayList<ToDoItem>();
        items.add(new ToDoItem(Tags.IMPORTANT, "Réviser ses cours"));
        items.add(new ToDoItem(Tags.NORMAL, "Acheter du pain"));
        items.add(new ToDoItem(Tags.NORMAL, "Marcher 30 mn par jour"));
        items.add(new ToDoItem(Tags.FAIBLE, "Manger 5 fruits et légumes"));
        items.add(new ToDoItem(Tags.NORMAL, "Prendre des nouvelles des parents"));
        items.add(new ToDoItem(Tags.FAIBLE, "Préparer la prochaine soirée poker"));
        items.add(new ToDoItem(Tags.NORMAL, "Révoir les premières saisons de Game of thrones"));
        items.add(new ToDoItem(Tags.FAIBLE, "Finir la vaisselle"));
        items.add(new ToDoItem(Tags.IMPORTANT, "Acheter un nouveau disque dur"));
        items.add(new ToDoItem(Tags.IMPORTANT, "Revoir les raccourcis clavier"));
        items.add(new ToDoItem(Tags.NORMAL, "Tester une nouvelle techno"));
        items.add(new ToDoItem(Tags.FAIBLE, "Tester l'application en cours"));

        return items;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
