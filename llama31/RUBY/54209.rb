class ConditionalValidator < ActiveModel::Validator\n  def validate(record)\n    country = record.country\n    company_name = record.company_name\n\n    # Load the validation rules for the current country and company\n    validation_rules = validation_config[country][company_name]\n\n    # Iterate through the validation rules and apply them to the record\n    validation_rules.each do |field, rules|\n      # Get the value of the field from the record\n      value = record.send(field)\n\n      # Apply the validation rules\n      rules.each do |rule, options|\n        case rule\n        when :minimum_length\n          record.errors.add(field, "must be at least #{options} characters long") if value.length < options\n        when :maximum_length\n          record.errors.add(field, "must be no more than #{options} characters long") if value.length > options\n        when :required\n          record.errors.add(field, "is required") if value.blank?\n        when :format\n          record.errors.add(field, "must match the format #{options}") unless value =~ options\n        end\n      end\n    end\n  end\nend