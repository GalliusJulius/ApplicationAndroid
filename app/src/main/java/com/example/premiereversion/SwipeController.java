package com.example.premiereversion;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import static android.support.v7.widget.helper.ItemTouchHelper.*;


class SwipeController extends Callback {


    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        this.onSwiped(viewHolder, makeMovementFlags(0, LEFT | RIGHT));
        System.out.println("cc1");
        return 0;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        System.out.println(direction);
        ((AdpaterRecycler.VuePerso)viewHolder).activer();
    }
}