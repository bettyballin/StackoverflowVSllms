const express = require('express');\nconst app = express();\nconst passport = require('passport');\nconst OAuth2Strategy = require('passport-oauth2');\n\n// Initialize OAuth2 strategy\npassport.use(new OAuth2Strategy({\n  authorizationURL: 'https://example.com/oauth/authorize',\n  tokenURL: 'https://example.com/oauth/token',\n  clientID: 'your_client_id',\n  clientSecret: 'your_client_secret',\n  callbackURL: 'http://localhost:3000/auth/callback'\n}, (accessToken, refreshToken, profile, cb) => {\n  // Use the access token to access protected resources\n  // ...\n}));