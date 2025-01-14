# Model\nclass YourModel < ApplicationRecord\n  has_one_attached :binary_file\nend\n\n# Migration\nclass CreateActiveStorageTables < ActiveRecord::Migration[6.0]\n  def change\n    create_table :your_models do |t|\n      t.timestamps\n    end\n  end\nend\n\n# Controller\nclass YourModelsController < ApplicationController\n  def create\n    @your_model = YourModel.new(your_model_params)\n    if @your_model.save\n      # Handle success\n    else\n      # Handle failure\n    end\n  end\n\n  private\n\n  def your_model_params\n    params.require(:your_model).permit(:binary_file)\n  end\nend