class SlideshowsController < ApplicationController\n      def index\n        @images = ['image1.jpg', 'image2.jpg', 'image3.jpg'] # Add your image paths here\n      end\n    end