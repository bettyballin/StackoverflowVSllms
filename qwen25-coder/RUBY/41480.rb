class Demo\n  # The stuff we'll look up.\n  DEFAULT = "Hello"\n  def initialize\n    @message = DEFAULT\n  end\n  def say() @message end\n\n  # Use symbols to look up identifiers.\n  def look_up_with_symbols\n    [Demo.const_get(:DEFAULT),\n     method(:say),\n     instance_variable_get(:@message)]\n  end\nend\n\ndem = Demo.new\nputs dem.look_up_with_symbols