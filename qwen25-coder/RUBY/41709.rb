# app/controllers/albums_controller.rb\n    class AlbumsController < ApplicationController\n      def show\n        @feature = Feature.find(params[:id]) # or however you are finding the feature\n        @albums_feature = Album.find_albums_with_feature(@feature.id)\n      end\n    end