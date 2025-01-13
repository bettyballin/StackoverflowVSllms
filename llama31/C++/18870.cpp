public ref class MyGeometry\n{\npublic:\n    property double X;\n    property double Y;\n};\n\npublic ref class GeometryAlgorithms\n{\npublic:\n    static double GetMaxBound(MyGeometry^ geometry, Func<MyGeometry^, double>^ getCoordinate)\n    {\n        // implement algorithm using getCoordinate delegate\n    }\n};\n\n// usage\nMyGeometry^ geometry = gcnew MyGeometry();\ngeometry->X = 10.0;\ngeometry->Y = 20.0;\n\nauto getX = [](MyGeometry^ g) { return g->X; };\nauto getY = [](MyGeometry^ g) { return g->Y; };\n\ndouble maxX = GeometryAlgorithms::GetMaxBound(geometry, getX);\ndouble maxY = GeometryAlgorithms::GetMaxBound(geometry, getY);