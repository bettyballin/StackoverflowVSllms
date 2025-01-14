# app/services/action_logger_service.rb\nclass ActionLoggerService\n  def initialize(actor, action, subject)\n    @actor = actor\n    @action = action\n    @subject = subject\n  end\n\n  def call\n    Logging.create!(\n      user: @actor,\n      action: @action,\n      details: @subject.attributes.to_json # or any other relevant data\n    )\n  end\nend\n\n# app/controllers/some_controller.rb\nclass SomeController < ApplicationController\n  def some_action\n    subject = Subject.find(params[:id])\n    if subject.update(subject_params)\n      ActionLoggerService.new(current_user, "updated", subject).call\n      # Proceed with any other logic or render views\n    else\n      # Handle errors\n    end\n  end\nend