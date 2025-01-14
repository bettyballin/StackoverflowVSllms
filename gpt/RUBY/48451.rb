class Employee < ActiveResource::Base\n  self.site = "http://example.com"\n\n  def self.create(attributes = {})\n    company_id = attributes.delete(:company_id)\n    self.site = "http://example.com/companies/#{company_id}"\n    employee = super(attributes)\n  ensure\n    self.site = "http://example.com"  # Reset site after creation\n  end\nend