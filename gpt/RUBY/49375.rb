User.validators.each do |validator|\n  validator.attributes.each do |attribute|\n    validator.options.each do |option, value|\n      puts "Attribute: #{attribute}, Validator: #{validator.class.name}, Option: #{option}, Value: #{value}"\n    end\n  end\nend