package com.github.martinfrank.gridinventory;

import com.github.martinfrank.geolib.GeoPoint;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

public class ItemTest {

    @Test
    @SuppressWarnings("unchecked")
    public void rectangleTranslationTest(){
        RectangleItem item = new RectangleItem(2,4);
        GeoPoint location = new GeoPoint(2,2);

        Collection<GeoPoint> relativeShape = item.getRelativeShape(location);
        for (GeoPoint p: (Collection<GeoPoint>)item.getShape()){
            GeoPoint translated = new GeoPoint(p.getX()+location.getX(), p.getY() + location.getY());
            Assert.assertTrue(relativeShape.contains(translated));
        }
    }

}