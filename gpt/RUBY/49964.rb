def update\n  @album = Album.find(params[:id])\n  if @album.update(params.require(:album).permit(:attribute1, :attribute2, :attribute3))\n    redirect_to action: 'list'\n  else\n    render action: 'edit'\n  end\nend