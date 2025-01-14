class ApplicationController < ActionController::Base\n  force_ssl if: :production?\n\n  private\n\n  def production?\n    Rails.env.production?\n  end\nend