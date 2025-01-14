pp
struct foo { };

struct bar {
  bar(foo f) {}
};

int main() {
  // does *not* create a bar object initialized by a default constructed 
  // foo object.
  bar b(foo());
  return 0;
}