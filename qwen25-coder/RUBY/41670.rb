# features/support/account_steps.rb\n   def create_account_and_store_id(world)\n     account = Account.create(attributes_for(:account))\n     world.account_id = account.id\n   end\n\n   Given 'an account is created' do\n     create_account_and_store_id(self)  # `self` refers to the World object\n   end\n\n   When 'the next step in the workflow is taken' do\n     # Use @account_id\n   end