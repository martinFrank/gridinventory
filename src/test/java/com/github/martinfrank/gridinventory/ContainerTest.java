package com.github.martinfrank.gridinventory;

import com.github.martinfrank.geolib.GeoPoint;
import org.junit.Assert;
import org.junit.Test;

public class ContainerTest <I> {

    @Test
    public void itemOutsideContainerTest(){
        RectangleContainer container = new RectangleContainer(10,5);
        RectangleItem <I> item = new RectangleItem<>(1,2);

        Assert.assertFalse(container.fitsInside(item, new GeoPoint(-1,0)));
        Assert.assertFalse(container.fitsInside(item, new GeoPoint(10,0)));
        Assert.assertFalse(container.fitsInside(item, new GeoPoint(0,4)));
        Assert.assertFalse(container.fitsInside(item, new GeoPoint(9,-1)));

        Assert.assertTrue(container.fitsInside(item, new GeoPoint(0,0)));
        Assert.assertTrue(container.fitsInside(item, new GeoPoint(9,3)));
    }

    @Test
    public void intersectionTest(){
        RectangleContainer container = new RectangleContainer(10,5);
        RectangleItem <I> itemInside = new RectangleItem<>(2,2);
        RectangleItem <I> itemToAdd = new RectangleItem<>(2,2);
        container.add(itemInside, new GeoPoint(0,0));

        Assert.assertFalse(container.fitsInside(itemToAdd, new GeoPoint(0,0)));
        Assert.assertFalse(container.fitsInside(itemToAdd, new GeoPoint(1,0)));
        Assert.assertFalse(container.fitsInside(itemToAdd, new GeoPoint(0,1)));
        Assert.assertFalse(container.fitsInside(itemToAdd, new GeoPoint(1,1)));

        Assert.assertTrue(container.fitsInside(itemToAdd, new GeoPoint(2,0)));
        Assert.assertTrue(container.fitsInside(itemToAdd, new GeoPoint(0,2)));
    }

    @Test
    public void contentTest(){
        RectangleContainer container = new RectangleContainer(10,5);
        RectangleItem <I> first = new RectangleItem<>(2,2);
        container.add(first, new GeoPoint(0,0));
        Assert.assertTrue(container.getContent().contains(first));

        RectangleItem <I> second = new RectangleItem<>(2,2);
        Assert.assertFalse(container.fitsInside(second, new GeoPoint(0,0)));

        container.remove(new GeoPoint(0,0));
        Assert.assertFalse(container.getContent().contains(first));
        Assert.assertTrue(container.fitsInside(second, new GeoPoint(0,0)));
    }
}
