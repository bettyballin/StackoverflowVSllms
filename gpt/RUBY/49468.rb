# app/controllers/widgets_controller.rb\n    class WidgetsController < ApplicationController\n      def index\n        @widgets = Widget.all\n      end\n\n      def show\n        @widget = Widget.find(params[:id])\n      end\n\n      def new\n        @widget = Widget.new\n      end\n\n      def create\n        @widget = Widget.new(widget_params)\n        if @widget.save\n          redirect_to @widget\n        else\n          render 'new'\n        end\n      end\n\n      private\n\n      def widget_params\n        params.require(:widget).permit(:name, :description, :author, :code)\n      end\n    end