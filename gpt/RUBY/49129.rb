class FruitsController < ApplicationController\n  def display\n    @fruit = Fruit.find(params[:id])\n    # Your custom logic here\n  end\nend