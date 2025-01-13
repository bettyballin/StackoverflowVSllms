def self.generate_validating_setters(*fields)\n  fields.each do |field|\n    define_method("#{field}=") do |value|\n      begin\n        Date.parse(value)\n      rescue\n        @dates_bad = true\n      end\n      self.write_attribute(field, value)\n    end\n  end\nend