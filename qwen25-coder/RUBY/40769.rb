require 'dry-validation'\n\nclass Post < BasicModel::Base\n  include Dry::Validation\n\n  def self.schema\n    Dry::Schema.JSON do\n      required(:name).value(:string)\n      required(:title).value(:string).min_size?(5)\n    end\n  end\n\n  def validate!\n    result = self.class.schema.call(name: name, title: title)\n    if result.success?\n      true\n    else\n      raise ArgumentError, result.errors.to_h\n    end\n  end\nend