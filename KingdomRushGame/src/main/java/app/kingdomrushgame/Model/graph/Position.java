package app.kingdomrushgame.Model.graph;

public interface Position<E> {
    E getElement() throws IllegalStateException;
}
