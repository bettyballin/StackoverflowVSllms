match 'auth/:provider/callback', to: 'user_sessions#create_from_oauth'\nmatch 'auth/failure',           to: 'user_sessions#oauth_auth_failure'