# Primary App Controller\nclass ApiController < ApplicationController\n  before_action :check_token\n\n  private\n\n  def check_token\n    return head(:unauthorized) unless params[:token] == ENV['SHARED_SECRET_TOKEN']\n  end\nend