// foo.h\nclass Foo {\npublic:\n    template <typename F>\n    void func(F f);\n\nprivate:\n    int member_;\n};\n\nextern template void Foo::func(boost::function<void(int)>);\n\n// foo.cc\ntemplate <typename F>\nvoid Foo::func(F f) {\n    f(member_);\n}\n\ntemplate void Foo::func(boost::function<void(int)>);