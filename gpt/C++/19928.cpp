template<typename Vertex> \ninline void drawVertices(Elements vCount, RenPrim primitiveType, PixMaterial *mtl, Vertex const *vertices) {\n    this->drawVertices(vCount, primitiveType, mtl, vertices, Vertex::VertexType);\n}\n\nvirtual void drawVertices(Elements vCount, RenPrim primitiveType, PixMaterial *mtl, void const *vertices, uint vertexType) = 0;