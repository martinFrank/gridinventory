package com.github.martinfrank.gridinventory;

import com.github.martinfrank.geolib.GeoPoint;

import java.util.Collection;

public interface GridShape {

    public boolean fitsInside(GridContainer container, GeoPoint pointer);

    public Collection<GeoPoint> getShape();

    public GeoPoint getPointer();

    public Collection<GeoPoint> getRelativeShape(GeoPoint point);

}
