# app/models/employee.rb\nclass Employee < ApplicationRecord\n  belongs_to :employer\n\n  def uri\n    Rails.application.routes.url_helpers.employer_employee_url(employer, self, host: Rails.application.config.default_url_options[:host])\n  end\nend\n\n# app/models/employer.rb\nclass Employer < ApplicationRecord\n  has_many :employees\n\n  def uri\n    Rails.application.routes.url_helpers.employer_url(self, host: Rails.application.config.default_url_options[:host])\n  end\nend