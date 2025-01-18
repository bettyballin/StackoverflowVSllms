package com.example;

import java.lang.String;
import java.lang.Integer;
import java.awt.Point;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="point-wrapper") // specify the xml element name if needed
public class PointWrapper {
    @Attribute(name = "x", required = false)
    private Integer xCoordinate;

    @Attribute(name = "y", required = false)
    private Integer yCoordinate;

    // Constructors
    public PointWrapper() {
        // No-arg constructor
    }

    public PointWrapper(Integer x, Integer y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    // Getters and setters
    public Integer getX() {
        return xCoordinate;
    }

    public void setX(Integer xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Integer getY() {
        return yCoordinate;
    }

    public void setY(Integer yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public static Point toPoint(PointWrapper wrapper){
        if (wrapper == null || wrapper.getX() == null || wrapper.getY() == null) {
            return new java.awt.Point();
        }
        return new java.awt.Point(wrapper.xCoordinate, wrapper.yCoordinate);
    }

    public static PointWrapper toPointWrapper(java.awt.Point point){
        if (point == null) {
            return null;
        }
        return new PointWrapper(point.x, point.y);
    }

    public static void main(String[] args) {
    }
}