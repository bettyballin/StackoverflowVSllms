class QueriesController < ApplicationController\n  before_action :validate_form, only: [:results]\n\n  def results\n    # Process the form data\n    @name = query_form.name\n    # Additional processing...\n  end\n\n  private\n\n  def query_form\n    @query_form ||= QueryForm.new(params.permit(:name, image: [:font_size], :analysis_type, :results_to_generate, :graph_type, :graph_width, :theme))\n  end\n\n  def validate_form\n    unless query_form.valid?\n      flash[:error] = query_form.errors.full_messages.join(", ")\n      redirect_to action: 'index'\n    end\n  end\nend