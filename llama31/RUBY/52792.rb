module Foo\n  module Bar\n    def self.new(*args)\n      SimpleBarImplementation.new(*args)\n    end\n\n    private\n\n    def baz\n      raise NotImplementedError.new('Implementing Classes MUST redefine #baz')\n    end\n  end\n\n  class SimpleBarImplementation\n    include Bar\n    def baz\n      # implementation details\n    end\n  end\nend