class GamesController < ApplicationController\n  def show\n    @game = Game.find(params[:id])\n\n    case params[:view]\n    when 'full'\n      render xml: @game.to_xml(include: { players: {}, current_turn: {} })\n    when 'history'\n      render xml: @game.to_xml(include: { turns: {} })\n    else\n      # Default view includes only game attributes\n      render xml: @game\n    end\n  end\nend