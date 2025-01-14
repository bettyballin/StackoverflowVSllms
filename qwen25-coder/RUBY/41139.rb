class Order < ActiveRecord::Base\n  has_many :previous_addresses\n  has_one  :applicant\n  has_one  :current_address\n\n  accepts_nested_attributes_for :applicant, :current_address, allow_destroy: true\nend\n\nclass Applicant < ActiveRecord::Base\n  belongs_to :order\n\n  # Example of conditional validation based on the associated order's company attribute\n  validate :company_specific_validations\n\n  private\n\n  def company_specific_validations\n    case order&.company\n    when 'Company200'\n      validates_length_of :middle_name, maximum: 20, allow_nil: true\n    when 'Company201'\n      validates_length_of :middle_name, maximum: 1, allow_nil: true\n    end\n  end\nend\n\nclass CurrentAddress < ActiveRecord::Base\n  belongs_to :order\n\n  # Example of conditional validation based on the associated order's company attribute\n  validates_with CompanySpecificValidator\nend\n\n# Custom validator that uses conditionals\nclass CompanySpecificValidator < ActiveModel::EachValidator\n  def validate_each(record, attribute, value)\n    case record.order&.company\n    when 'Company200'\n      # Add validation logic specific to Company200\n      if value.length > 100 # Example\n        record.errors.add(attribute, "is too long for Company200")\n      end\n    when 'Company201'\n      # Add validation logic specific to Company201\n      if value.length > 50 # Example\n        record.errors.add(attribute, "is too long for Company201")\n      end\n    end\n  end\nend