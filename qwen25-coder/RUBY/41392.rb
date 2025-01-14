module ReusableModule\n  def module_method\n    puts "Module Method: Hi there!"\n  end\nend\n\nclass ClassThatIncludes\n  include ReusableModule\nend\n\nclass ClassThatExtends\n  extend ReusableModule\nend\n\nputs "Include"\nClassThatIncludes.new.module_method       # "Module Method: Hi there!"\n\nputs "Extend"\n# ClassThatExtends.new.module_method      # This line would raise a NoMethodError\nClassThatExtends.module_method            # "Module Method: Hi there!"