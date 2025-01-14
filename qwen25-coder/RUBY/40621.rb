class Widget\n  def initialize(public_attr, private_attr)\n    @x = public_attr\n    @y = private_attr\n  end\n\n  def x\n    @x\n  end\n\n  protected :x\n\n  def utility_method\n    @y\n  end\n\n  private :utility_method\n\n  def display_private_data\n    # Controlled access to a private method using send inside class\n    "Private Data: #{send(:utility_method)}"\n  end\nend\n\nw = Widget.new('public data', 'secret data')\nputs w.display_private_data # This is allowed and intended use of send within the class