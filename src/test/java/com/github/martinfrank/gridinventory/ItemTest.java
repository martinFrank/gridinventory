package com.github.martinfrank.gridinventory;

import com.github.martinfrank.geolib.GeoPoint;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

public class ItemTest<I> {

    @Test
    @SuppressWarnings("unchecked")
    public void rectangleTranslationTest(){
        RectangleItem<I> item = new RectangleItem(2, 4);
        GeoPoint location = new GeoPoint(2,2);

        Collection<GeoPoint> relativeShape = item.getRelativeShape(location);
        for (GeoPoint p: (Collection<GeoPoint>)item.getShape()){
            GeoPoint translated = new GeoPoint(p.getX()+location.getX(), p.getY() + location.getY());
            Assert.assertTrue(relativeShape.contains(translated));
        }
    }

    @Test
    public void fitInsideTest() {
        RectangleContainer<I> container = new RectangleContainer<>(10, 5);
        RectangleItem<I> item = new RectangleItem<>(2, 2);
        GeoPoint location = new GeoPoint(0, 0);
        Assert.assertEquals(container.fitsInside(item, location), item.fitsInside(container, location));
    }

}