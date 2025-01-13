public delegate double GetCoordinateDelegate(MyGeometry^ geometry);\n\npublic ref class MyGeometry\n{\npublic:\n    property double X;\n    property double Y;\n};\n\npublic ref class GeometryAlgorithms\n{\npublic:\n    static double GetMaxBound(MyGeometry^ geometry, GetCoordinateDelegate^ getCoordinate)\n    {\n        // implement algorithm using getCoordinate delegate\n    }\n};\n\n// usage\nMyGeometry^ geometry = gcnew MyGeometry();\ngeometry->X = 10.0;\ngeometry->Y = 20.0;\n\nGetCoordinateDelegate^ getX = gcnew GetCoordinateDelegate(&MyGeometry::get_X);\nGetCoordinateDelegate^ getY = gcnew GetCoordinateDelegate(&MyGeometry::get_Y);\n\ndouble maxX = GeometryAlgorithms::GetMaxBound(geometry, getX);\ndouble maxY = GeometryAlgorithms::GetMaxBound(geometry, getY);