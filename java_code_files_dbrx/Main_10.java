import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Rectangle2D rect = new Rectangle2D.Double(50, 50, 100, 50); // Your rectangle
        Line2D line = new Line2D.Double(0, 75, 200, 75); // Your line

        if (!rect.intersectsLine(line)) {
            line.setLine(0, 0, 0, 0); // Or however you want to handle it when the rectangle and line do not intersect
        } else {
            ArrayList<Point2D> intersections = getLineRectangleIntersections(line, rect); // Get intersection points

            if (intersections.size() >= 2) {
                Point2D p1 = intersections.get(0);
                Point2D p2 = intersections.get(1);
                line = new Line2D.Double(p1, p2);
            } else if (intersections.size() == 1) {
                // Line passes through one corner or edge
                Point2D p1 = intersections.get(0);
                // Decide what to do: possibly set line from one of line's endpoints to p1
                // For example, assume we keep the part of the line inside the rectangle
                Point2D.Double lineStart = new Point2D.Double(line.getX1(), line.getY1());
                if (rect.contains(lineStart)) {
                    line = new Line2D.Double(lineStart, p1);
                } else {
                    Point2D.Double lineEnd = new Point2D.Double(line.getX2(), line.getY2());
                    line = new Line2D.Double(p1, lineEnd);
                }
            } else {
                // No intersection points found
                Point2D.Double p1 = new Point2D.Double(line.getX1(), line.getY1());
                Point2D.Double p2 = new Point2D.Double(line.getX2(), line.getY2());
                if (!rect.contains(p1) && !rect.contains(p2)) {
                    line.setLine(0, 0, 0, 0);
                } else if (!rect.contains(p1)) {
                    // p1 is outside, p2 is inside
                    ArrayList<Point2D> newIntersections = getLineRectangleIntersections(line, rect);
                    if (newIntersections.size() > 0) {
                        Point2D closestPoint = newIntersections.get(0);
                        double minDist = closestPoint.distance(p2);
                        for (Point2D point : newIntersections) {
                            double dist = point.distance(p2);
                            if (dist < minDist) {
                                minDist = dist;
                                closestPoint = point;
                            }
                        }
                        line = new Line2D.Double(closestPoint, p2);
                    }
                } else if (!rect.contains(p2)) {
                    // p1 is inside, p2 is outside
                    ArrayList<Point2D> newIntersections = getLineRectangleIntersections(line, rect);
                    if (newIntersections.size() > 0) {
                        Point2D closestPoint = newIntersections.get(0);
                        double minDist = closestPoint.distance(p1);
                        for (Point2D point : newIntersections) {
                            double dist = point.distance(p1);
                            if (dist < minDist) {
                                minDist = dist;
                                closestPoint = point;
                            }
                        }
                        line = new Line2D.Double(p1, closestPoint);
                    }
                }
            }
        }
        // Optional: Output the final line coordinates
        System.out.println("Line coordinates: (" + line.getX1() + ", " + line.getY1() + ") to (" + line.getX2() + ", " + line.getY2() + ")");
    }

    public static ArrayList<Point2D> getLineRectangleIntersections(Line2D line, Rectangle2D rect) {
        ArrayList<Point2D> intersections = new ArrayList<>();

        // Get the four edges of the rectangle
        Line2D left = new Line2D.Double(rect.getX(), rect.getY(), rect.getX(), rect.getY() + rect.getHeight());
        Line2D top = new Line2D.Double(rect.getX(), rect.getY(), rect.getX() + rect.getWidth(), rect.getY());
        Line2D right = new Line2D.Double(rect.getX() + rect.getWidth(), rect.getY(), rect.getX() + rect.getWidth(), rect.getY() + rect.getHeight());
        Line2D bottom = new Line2D.Double(rect.getX(), rect.getY() + rect.getHeight(), rect.getX() + rect.getWidth(), rect.getY() + rect.getHeight());

        Line2D[] edges = {left, top, right, bottom};

        for (Line2D edge : edges) {
            Point2D intersection = getLineLineIntersection(line, edge);
            if (intersection != null) {
                // Avoid duplicate points
                boolean alreadyAdded = false;
                for (Point2D p : intersections) {
                    if (p.distance(intersection) < 1e-6) {
                        alreadyAdded = true;
                        break;
                    }
                }
                if (!alreadyAdded) {
                    intersections.add(intersection);
                }
            }
        }
        return intersections;
    }

    // Helper method to compute intersection point between two lines
    public static Point2D getLineLineIntersection(Line2D line1, Line2D line2) {
        double x1 = line1.getX1();
        double y1 = line1.getY1();
        double x2 = line1.getX2();
        double y2 = line1.getY2();

        double x3 = line2.getX1();
        double y3 = line2.getY1();
        double x4 = line2.getX2();
        double y4 = line2.getY2();

        double denom = (y4 - y3)*(x2 - x1) - (x4 - x3)*(y2 - y1);
        if (denom == 0.0) {
            // Lines are parallel
            return null;
        }

        double ua = ((x4 - x3)*(y1 - y3) - (y4 - y3)*(x1 - x3))/denom;
        double ub = ((x2 - x1)*(y1 - y3) - (y2 - y1)*(x1 - x3))/denom;

        if (ua >= 0 && ua <= 1 && ub >= 0 && ub <=1) {
            // Intersection point
            double x = x1 + ua*(x2 - x1);
            double y = y1 + ua*(y2 - y1);
            return new Point2D.Double(x, y);
        }
        // No intersection
        return null;
    }
}

// Class definitions for Point2D, Line2D, and Rectangle2D

class Point2D {
    public double x;
    public double y;

    public Point2D() { }

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point2D p) {
        double dx = this.x - p.x;
        double dy = this.y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static class Double extends Point2D {
        public Double(double x, double y) {
            super(x, y);
        }
    }
}

class Line2D {
    protected double x1, y1, x2, y2;

    public Line2D() { }

    public Line2D(double x1, double y1, double x2, double y2) {
        setLine(x1, y1, x2, y2);
    }

    public void setLine(double x1, double y1, double x2, double y2) {
        this.x1 = x1; this.y1 = y1;
        this.x2 = x2; this.y2 = y2;
    }

    public double getX1() { return x1; }
    public double getY1() { return y1; }
    public double getX2() { return x2; }
    public double getY2() { return y2; }

    public static class Double extends Line2D {
        public Double(double x1, double y1, double x2, double y2) {
            super(x1, y1, x2, y2);
        }

        public Double(Point2D p1, Point2D p2) {
            super(p1.x, p1.y, p2.x, p2.y);
        }
    }

    public boolean intersectsLine(Line2D line) {
        return linesIntersect(this.getX1(), this.getY1(), this.getX2(), this.getY2(), 
                              line.getX1(), line.getY1(), line.getX2(), line.getY2());
    }

    public boolean intersectsLine(double x3, double y3, double x4, double y4) {
        return linesIntersect(this.getX1(), this.getY1(), this.getX2(), this.getY2(), x3, y3, x4, y4);
    }

    public static boolean linesIntersect(double x1, double y1, double x2, double y2,
                                         double x3, double y3, double x4, double y4) {
        // Implement standard algorithm for checking if two line segments intersect
        double denom = (y4 - y3)*(x2 - x1) - (x4 - x3)*(y2 - y1);
        if (denom == 0.0) {
            // Lines are parallel or coincident
            return false;
        }
        double ua = ((x4 - x3)*(y1 - y3) - (y4 - y3)*(x1 - x3))/denom;
        double ub = ((x2 - x1)*(y1 - y3) - (y2 - y1)*(x1 - x3))/denom;
        return (ua >= 0.0 && ua <= 1.0 && ub >= 0.0 && ub <= 1.0);
    }
}

class Rectangle2D {
    protected double x, y, width, height;

    public Rectangle2D() { }

    public Rectangle2D(double x, double y, double width, double height) {
        setRect(x, y, width, height);
    }

    public void setRect(double x, double y, double width, double height) {
        this.x = x; this.y = y;
        this.width = width; this.height = height;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }

    public boolean contains(Point2D p) {
        return (p.x >= x && p.x <= x + width && p.y >= y && p.y <= y + height);
    }

    public boolean intersectsLine(Line2D line) {
        // Check if the line intersects any of the rectangle's edges
        Line2D[] edges = {
            new Line2D.Double(x, y, x + width, y), // top
            new Line2D.Double(x + width, y, x + width, y + height), // right
            new Line2D.Double(x + width, y + height, x, y + height), // bottom
            new Line2D.Double(x, y + height, x, y)  // left
        };
        for (Line2D edge : edges) {
            if (line.intersectsLine(edge)) {
                return true;
            }
        }
        // Also check if one of the endpoints is inside the rectangle
        if (contains(new Point2D(line.getX1(), line.getY1())) || contains(new Point2D(line.getX2(), line.getY2()))) {
            return true;
        }
        return false;
    }

    public static class Double extends Rectangle2D {
        public Double(double x, double y, double width, double height) {
            super(x, y, width, height);
        }
    }
}