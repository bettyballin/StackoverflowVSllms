module TestOne\n  module Foo\n    def foo\n      42\n    end\n  end\n\n  module Bar\n    include Foo\n  end\n\n  class Quux\n    include Bar\n  end\nend\n\nTestOne::Bar.ancestors # => [TestOne::Bar, TestOne::Foo]\nTestOne::Quux.ancestors # => [TestOne::Quux, TestOne::Bar, TestOne::Foo, Object, Kernel]\nTestOne::Quux.new.foo # => 42