# main.rb\nrequire './my_module'  # loads the my_module.rb file\n\nclass MyClass\n  include MyModule  # includes the MyModule constants and methods into MyClass\nend\n\nobj = MyClass.new\nobj.hello  # outputs "Hello!"