class CountriesController < ApplicationController\n  def index\n    if params[:search]\n      @countries = Country.search(params[:search])\n    else\n      @countries = Country.all\n    end\n  end\nend