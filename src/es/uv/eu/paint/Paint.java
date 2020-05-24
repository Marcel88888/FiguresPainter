package es.uv.eu.paint;

import es.uv.eu.mvc.model.PaintModel;
import es.uv.eu.mvc.controller.PaintController;
import es.uv.eu.mvc.view.default_values_window.DVWView;
import es.uv.eu.mvc.view.paint_window.PaintView;

public class Paint {

    public static void main(String[] args) {
        PaintModel model = new PaintModel();
        PaintView paintView = new PaintView(model);
        DVWView defValWindView = new DVWView(model, paintView);
        new PaintController(model, defValWindView, paintView);
    }
    
}
