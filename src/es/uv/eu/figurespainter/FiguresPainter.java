package es.uv.eu.figurespainter;

import es.uv.eu.mvc.model.FiguresPainterModel;
import es.uv.eu.mvc.controller.FiguresPainterController;
import es.uv.eu.mvc.view.default_values_window.DVWView;
import es.uv.eu.mvc.view.figures_painter_window.FiguresPainterView;

public class FiguresPainter {

    public static void main(String[] args) {
        FiguresPainterModel model = new FiguresPainterModel();
        FiguresPainterView figuresPainterView = new FiguresPainterView(model);
        DVWView defValWindView = new DVWView(model, figuresPainterView);
        new FiguresPainterController(model, defValWindView, figuresPainterView);
    }
    
}
