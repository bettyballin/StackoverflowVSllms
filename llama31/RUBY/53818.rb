# app/models/event.rb\nclass Event < ApplicationRecord\n  attr_accessor :start, :end, :title\n\n  def as_json(options = {})\n    {\n      id: id,\n      title: title,\n      start: start,\n      end: end\n    }\n  end\nend