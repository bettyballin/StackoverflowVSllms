class User < ApplicationRecord\n  after_create :populate_checklist_items\n\n  private\n\n  def populate_checklist_items\n    checklist_items = YAML.load_file(Rails.root.join('config', 'checklist_items.yml'))\n    checklist_items.each do |item|\n      self.checklist_items.create!(name: item['name'])\n    end\n  end\nend