class Parent\n  def my_method\n    puts "This is my method"\n  end\nend\n\nclass Child < Parent\n  undef :my_method\nend\n\nParent.new.my_method # => This is my method\nChild.new.my_method  # => NoMethodError: undefined method `my_method' for #<Child:0x00007f9a2c1b3a88>