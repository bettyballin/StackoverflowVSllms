class FmfilesController < ApplicationController\n  def progress_monitor\n    # Logic to get the progress of the server-side process\n    progress = ... # your logic to fetch progress\n\n    render :json => { progress: progress }\n  end\n\n  def create\n    # Your create action logic\n    # Ensure to handle file upload here\n  end\nend