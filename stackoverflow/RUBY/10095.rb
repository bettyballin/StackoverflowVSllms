# Re-raise errors caught by the controller. \nclass SiteController; def rescue_action(e) raise e end; end \n\nclass SiteControllerTest < Test::Unit::TestCase \n  def setup \n    @controller = SiteController.new \n    @request     = ActionController::TestRequest.new \n    @response   = ActionController::TestResponse.new \n  end