class Foo {\n  // Be a little smarter about deriving the vertex type, to save the user some typing.\n  template<typename Vertex> inline void drawVertices(\n    Elements vCount, RenPrim primitiveType, PixMaterial *mtl, Vertex const *vertices)\n  {\n    this->Foo::drawVertices(vCount, primitiveType, mtl, vertices, Vertex::VertexType);\n  }\n\n  virtual void drawVertices(\n    Elements vCount,\n    RenPrim primitiveType,\n    PixMaterial *mtl,\n    void const *vertices,\n    uint vertexType) = 0;\n};