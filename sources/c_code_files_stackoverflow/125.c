++
namespace VW {
  struct Foo {
      friend Foo operator+(const Foo&, const Foo&);
  };
}
VW::Foo VW::operator+(const Foo& lhs, const Foo& rhs) { return lhs; }