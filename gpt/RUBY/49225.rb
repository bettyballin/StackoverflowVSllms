class Parent\n  def greet\n    puts "Hello from Parent"\n  end\nend\n\nclass Child < Parent\n  undef :greet\nend\n\nparent = Parent.new\nchild = Child.new\n\nparent.greet  # Outputs: Hello from Parent\nchild.greet   # Raises NoMethodError