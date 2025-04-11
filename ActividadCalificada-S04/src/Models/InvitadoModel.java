package Models;

import Core.Model;
import Core.View;
import java.util.ArrayList;
import java.util.List;

public class InvitadoModel implements Model {
    private List<View> views = new ArrayList<>();

    @Override
    public void attach(View view) {
        views.add(view);
    }

    @Override
    public void notifyViews() {
        for (View view : views) {
            view.update(this, null);
        }
    }
}