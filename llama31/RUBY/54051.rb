class AnalyticsFilter\n  include ActiveModel::Model\n\n  attr_accessor :start_date, :end_date\n\n  validates :start_date, presence: true\n  validates :end_date, presence: true\n\n  def initialize(attributes = {})\n    attributes.each do |name, value|\n      send("#{name}=", value)\n    end\n  end\nend