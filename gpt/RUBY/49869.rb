class CustomersController < ApplicationController\n     ...\n     private\n     \n     def customer_params\n       params.require(:customer).permit(:name, :email, :phone)\n     end\n   end