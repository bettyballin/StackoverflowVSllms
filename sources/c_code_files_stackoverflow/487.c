pp
#include <iostream>
using namespace std;

struct Pair { int a; int b; Pair(int x, int y) : a(x),b(y) {}};
struct F {
  static const float blah;
  static const Pair corners[4];
};

// square boards are so ordinary
const Pair F::corners[4] = { Pair(0,0), Pair(0,1), Pair(2,0), Pair(2,2) };

const float F::blah = 200.0;

int main(int, char **) {
  cout << F::corners[0].a << endl ;
  cout << F::blah << endl;
  return 0;
}