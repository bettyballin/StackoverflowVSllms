RSpec.describe UsersController, type: :controller do\n       it "responds successfully" do\n         get :index\n         expect(response).to be_successful\n       end\n     end