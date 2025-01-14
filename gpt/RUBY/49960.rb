class Person < ActiveRecord::Base\n     before_validation :load_validation_rules\n     validate :dynamic_validations\n\n     def load_validation_rules\n       @validation_rules = YAML.load_file(Rails.root.join('config', 'validation_rules.yml'))['validation_rules']\n     end\n\n     def dynamic_validations\n       country_rules = @validation_rules[country]\n       return unless country_rules\n\n       company_rules = country_rules[company_name]\n       return unless company_rules\n\n       company_rules.each do |field, rules|\n         value = send(field)\n         if rules['required'] && value.blank?\n           errors.add(field, "can't be blank")\n         end\n\n         if rules['minimum_length'] && value.size < rules['minimum_length']\n           errors.add(field, "is too short (minimum is #{rules['minimum_length']} characters)")\n         end\n\n         if rules['maximum_length'] && value.size > rules['maximum_length']\n           errors.add(field, "is too long (maximum is #{rules['maximum_length']} characters)")\n         end\n\n         if rules['format'] && value !~ Regexp.new(rules['format'])\n           errors.add(field, 'is invalid')\n         end\n       end\n     end\n   end