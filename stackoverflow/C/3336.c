#include <iostream>\nusing namespace std;\n\nstruct Pair { int a; int b; Pair(int x, int y) : a(x),b(y) {}};\nstruct F {\n  static const float blah = 200.0;\n  static const Pair corners[4];\n};\n\n// square boards are so ordinary\nconst Pair F::corners[4] = { Pair(0,0), Pair(0,1), Pair(2,0), Pair(2,2) };\n\nconst float F::blah ;\n\nint main(int, char **) {\n  cout << F::corners[0].a << endl ;\n  cout << F::blah << endl;\n  return 0;\n}