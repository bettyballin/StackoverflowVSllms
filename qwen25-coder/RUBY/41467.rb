class ClientRegionsController < ApplicationController\n  make_resourceful do\n    actions :all\n    belongs_to :client\n\n    response_for(:create) do |format|\n      format.html { redirect_to client_client_regions_path(@client) }\n    end\n\n    response_for(:update) do |format|\n      format.html { redirect_to client_client_regions_path(@client) }\n    end\n  end\n\n  private\n\n  def current_objects\n    @current_objects ||= Client.find(params[:client_id]).client_regions.paginate(page: params[:page], order: "name")\n  end\nend