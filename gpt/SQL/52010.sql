WITH AreaPoints AS (\n    SELECT\n        Area,\n        geography::UnionAggregate(Location) AS CombinedGeography\n    FROM Points\n    GROUP BY Area\n)\nSELECT\n    Area,\n    CombinedGeography.STConvexHull() AS BoundingPolygon\nFROM AreaPoints;