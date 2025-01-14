pp
#include <boost/function.hpp>
#include <boost/bind.hpp>

typedef boost::function<void(void)> Action;

class Data {
public:
  Data() {}
  ~Data() {}
  void Register(Action action) { _a = action; }

private:
  Action _a;
};

class Display {
public:
  Display(Data d) { d.Register( boost::bind(&Display::SomeTask, this) ); }
  ~Display() {}
  void SomeTask() {}
};

int main() {
  Data d;
  Display disp(d);
  return 0;
}