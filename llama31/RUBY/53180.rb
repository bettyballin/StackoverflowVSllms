class Foo\n  private\n  def self.bar\n    puts 'bar'\n  end\n\n  def call_bar\n    self.class.instance_eval { bar }\n  end\nend\n\nFoo.new.call_bar  # prints "bar"