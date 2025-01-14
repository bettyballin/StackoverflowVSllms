class YourModel < ApplicationRecord\n  before_save :some_method\n\n  private\n\n  def some_method\n    YourModel.transaction do\n      # Your logic here\n      # Raising an error here will roll back the entire transaction\n    end\n  rescue => e\n    errors.add(:base, "Transaction failed: #{e.message}")\n    throw(:abort)  # This will prevent the save from completing\n  end\nend