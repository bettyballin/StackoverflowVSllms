require 'twitter'\n\nclient = Twitter::REST::Client.new do |config|\n  config.consumer_key        = ENV['TWITTER_API_KEY']\n  config.consumer_secret     = ENV['TWITTER_API_SECRET']\n  config.access_token        = ENV['TWITTER_ACCESS_TOKEN']\n  config.access_token_secret = ENV['TWITTER_ACCESS_SECRET']\nend