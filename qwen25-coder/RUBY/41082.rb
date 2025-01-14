class Project\n  include DataMapper::Resource\n\n  property :id,     Serial\n  property :title,  String, :nullable => false\n\n  has n, :tasks\n\n  validate :ensure_minimum_tasks\n\n  private\n\n  def ensure_minimum_tasks\n    # Validate nested Task objects\n    tasks.each_with_index do |task, index|\n      task.valid?("project[#{index}]")\n      unless task.valid?\n        task.errors.full_messages.each { |msg| errors.add(:tasks, msg) }\n      end\n    end\n\n    # Check if the number of valid tasks meets the minimum requirement\n    min_tasks = 2\n    if tasks.select(&:valid?).size < min_tasks\n      errors.add(:tasks, "must have at least #{min_tasks} valid tasks")\n    end\n  end\nend