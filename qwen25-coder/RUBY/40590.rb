# app/controllers/tweets_controller.rb\n   class TweetsController < ApplicationController\n     def search\n       @results = TwitterSearchService.run(params[:q], params[:since_id])\n     end\n   end