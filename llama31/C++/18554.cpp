// foo.cc\nvoid instantiate() {\n    Foo foo;\n    foo.func(boost::function<void(int)>());\n}