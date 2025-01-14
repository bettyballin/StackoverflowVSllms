class ApplicationController < ActionController::Base\n  before_action :set_company_param\n\n  private\n\n  def set_company_param\n    @company = params[:company]\n  end\n\n  def default_url_options(options={})\n    { company: @company }.merge(options)\n  end\nend