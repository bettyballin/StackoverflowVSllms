module MyModule\n  def method_a(param)\n    @var ||= 0\n    # other logic goes here\n  end\nend\n\nclass MyClass\n  include MyModule\n\n  def initialize\n    init_my_module_vars\n  end\n\n  private\n\n  def init_my_module_vars\n    @var = 0\n  end\nend\n\n# Usage\nobj = MyClass.new\nobj.method_a(10)