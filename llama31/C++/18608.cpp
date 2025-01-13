#include <assimp/Importer.hpp>\n#include <assimp/scene.h>\n#include <assimp/postprocess.h>\n\n// Load a 3D model using Assimp\nAssimp::Importer importer;\nconst aiScene* scene = importer.ReadFile("model.dae", aiProcess_Triangulate);