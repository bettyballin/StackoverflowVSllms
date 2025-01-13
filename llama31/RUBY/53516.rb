# Java-like interface behavior is achieved using Ruby's abstract classes\nclass AbstractClass\n  def self.included(klass)\n    raise NotImplementedError unless klass.instance_methods.include?(:required_method)\n  end\nend\n\n# Ruby module\nmodule MyModule\n  def optional_method\n    # implementation\n  end\nend\n\n# Class that includes the module\nclass MyClass\n  include MyModule\n  def required_method\n    # implementation\n  end\nend