module Greetable\n  def greet(name)\n    "Hello, #{name}!"\n  end\nend\n\nclass Person\n  include Greetable\nend\n\nperson = Person.new\nputs person.greet("Alice") # Outputs: Hello, Alice!