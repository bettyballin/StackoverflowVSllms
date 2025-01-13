class Foo\n  def self.private_bar\n    # Complex logic goes here\n    puts "hi"\n  end\n  private_class_method :private_bar\n  class <<self\n    private\n    def another_private_bar\n      puts "bar"\n    end\n  end\n  public\n  def instance_bar\n    self.class.private_bar\n  end\n  def instance_bar2\n    self.class.another_private_bar\n  end\nend\n\nf=Foo.new\nf=instance_bar # NoMethodError: private method `private_bar' called for Foo:Class\nf=instance_bar2 # NoMethodError: private method `another_private_bar' called for Foo:Class