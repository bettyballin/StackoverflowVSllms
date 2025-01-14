class YourResourcesController < ApplicationController\n  def revert_to_version\n    @resource = YourResource.find(params[:id])\n    version_number = params[:version].to_i\n\n    if @resource.versions.exists?(version_number)\n      @resource.revert_to(version_number)\n      if @resource.save\n        redirect_to @resource, notice: "Resource was successfully reverted to version #{version_number}."\n      else\n        redirect_to @resource, alert: 'Could not revert resource.'\n      end\n    else\n      redirect_to @resource, alert: 'Invalid version number.'\n    end\n  end\nend