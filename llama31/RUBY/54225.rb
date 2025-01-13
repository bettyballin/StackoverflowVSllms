# spec/controllers/my_controller_spec.rb\nrequire 'spec_helper'\n\ndescribe MyController do\n  before(:each) do\n    @user = Factory(:user) # assuming you have a user factory\n  end\n\n  describe "GET index" do\n    it "should be successful when logged in" do\n      controller.stub!(:current_user).and_return(@user)\n      get :index\n      response.should be_success\n    end\n\n    it "should redirect when not logged in" do\n      get :index\n      response.should redirect_to(login_path)\n    end\n  end\nend