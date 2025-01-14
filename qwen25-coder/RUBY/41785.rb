module Greeting\n  def hello\n    "Hello!"\n  end\n\n  def self.hi_there\n    "Hi there!"\n  end\nend\n\nclass Person\n  include Greeting # Mixin behavior from Greeting module\nend\n\nperson = Person.new\nputs person.hello      # Output: Hello!\nputs Greeting.hi_there # Output: Hi there!