class Entry < ActiveRecord::Base\n  has_many :entry_tags\n  has_many :tags, through: :entry_tags\n\n  after_save :update_tags\n  attr_writer :tag_names\n\n  def tag_names\n    tags.map(&:name).join(", ")\n  end\n\n  validate :validate_tag_names\n\n  def update_tags\n    if @tag_names\n      self.tags = @tag_names.split(",").map do |name|\n        Tag.find_or_create_by_name(name.strip)\n      end\n    end\n  end\n  private :update_tags\n\n  # Custom validation method for tag names\n  def validate_tag_names\n    return unless @tag_names.present?\n\n    @tag_names.split(",").each do |name|\n      name = name.strip\n      tag = Tag.new(name: name)\n\n      if !tag.valid?\n        tag.errors.full_messages.each do |message|\n          errors.add(:base, "Tag #{name}: #{message}")\n        end\n      end\n    end\n  end\nend