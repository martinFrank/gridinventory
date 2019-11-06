package com.github.martinfrank.gridinventory;

public class RectangleItem<I> extends BasicGridItem<I> {

    public RectangleItem(int width, int height){
        super(RectangleUtility.createShape(width, height));
    }

}
