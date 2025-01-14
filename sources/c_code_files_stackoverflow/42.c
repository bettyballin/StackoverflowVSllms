pp
template <typename T>
struct foo
{
  explicit foo(T const *)
  {
  }
};


template <typename T>
struct bar
{
  bar(T const *)
  {
  }
};


int main(int argc, char **argv)
{
  int a;
  foo<int> f(&a); // works
  bar<int> b(&a); // works
  return 0;
}