# Avoid overly complex metaprogramming\nclass MyClass\n  def self.create_method(name)\n    define_method(name) do\n      puts "Hello, #{name}!"\n    end\n  end\nend