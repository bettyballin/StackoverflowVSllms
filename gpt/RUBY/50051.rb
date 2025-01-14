require 'yaml'\n\n# Example class with a lock\nclass MyClass\n  attr_accessor :name, :lock\n\n  def initialize(name)\n    @name = name\n    @lock = Mutex.new\n  end\n\n  # Custom to_yaml method to exclude the lock from serialization\n  def to_yaml(opts = {})\n    # Create a hash representation of the object without the lock\n    data = {\n      'name' => @name\n    }\n    # Use YAML to dump the hash instead of the full object\n    YAML.quick_emit(self, opts) do |out|\n      out.map(taguri, to_yaml_style) do |map|\n        data.each do |k, v|\n          map.add(k, v)\n        end\n      end\n    end\n  end\nend\n\nobj = MyClass.new("example")\n\n# Serializing the object\nyaml_data = YAML.dump(obj)\nputs yaml_data\n\n# Output will not include the lock