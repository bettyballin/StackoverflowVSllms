class AdminController < ApplicationController\n  before_action :authenticate_user!\n  load_and_authorize_resource\n\n  def index\n    # admin actions here\n  end\nend