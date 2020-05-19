package es.uv.eu.mvc.view.paint_window;

import es.uv.eu.mvc.model.PaintModel;

public class PaintView {
    
    private PaintModel model;
    
    public PaintView(PaintModel model) {
        this.model = model;
    }

    public PaintModel getModel() {
        return model;
    }
}
