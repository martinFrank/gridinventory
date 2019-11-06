package com.github.martinfrank.gridinventory;

public class RectangleContainer<I> extends BasicGridContainer<I> {

    public RectangleContainer(int width, int height){
        super(RectangleUtility.createShape(width, height));
    }

}
