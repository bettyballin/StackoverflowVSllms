module InitializableAttributes\n  def self.included(base)\n    base.extend(ClassMethods)\n  end\n\n  module ClassMethods\n    attr_accessor :defined_attributes\n\n    def attributes(*attrs)\n      @defined_attributes ||= []\n      @defined_attributes.concat(attrs)\n\n      attrs.each do |attr|\n        attr_accessor attr\n      end\n\n      define_method(:initialize) do |*args|\n        options = args.extract_options!\n        self.class.defined_attributes.each_with_index do |property, index|\n          send("#{property}=", options[property] || args[index])\n        end\n        post_initialize if respond_to?(:post_initialize)\n      end\n    end\n  end\n\n  private\n\n  def post_initialize\n    # This method can be overridden by subclasses to add custom initialization logic.\n  end\nend\n\nclass MyClass\n  include InitializableAttributes\n  attributes :foo, :bar\n\n  def post_initialize\n    # Additional initialization logic here\n  end\nend\n\n# Usage\ninstance = MyClass.new(foo: 'value1', bar: 'value2')