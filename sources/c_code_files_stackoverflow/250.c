#include <list>
#include <cmath>

struct Point {
    float x, y;
};

void erase_closest_point(std::list<Point>& pointList, const Point& point)
{
    if (!pointList.empty())
    {
        std::list<Point>::iterator closestPoint = pointList.begin();
        float closestDistance = std::sqrt(std::pow(point.x - closestPoint->x, 2) +
                                          std::pow(point.y - closestPoint->y, 2));

        // for each point in the list
        for (std::list<Point>::iterator it = ++closestPoint;
             it != pointList.end(); ++it)
        {
            const float distance = std::sqrt(std::pow(point.x - it->x, 2) +
                                             std::pow(point.y - it->y, 2));

            // is the point closer than the previous best?
            if (distance < closestDistance)
            {
                // replace it as the new best
                closestPoint = it;
                closestDistance = distance;
            }
        }

        pointList.erase(closestPoint);
    }
}