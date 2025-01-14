class DocumentsController < ApplicationController\n     before_action :set_document, only: [:show]\n\n     def show\n       respond_to do |format|\n         format.odf { send_odf }\n         format.odp { send_odp }\n       end\n     end\n\n     private\n\n     def send_odf\n       render_odocument('odf')\n     end\n\n     def send_odp\n       render_odocument('odp')\n     end\n\n     def render_odocument(format)\n       template_xml = File.read(File.join(Rails.root, 'app', 'views', 'documents', "show.#{format}.erb"))\n       dynamic_content = ERB.new(template_xml).result(binding)\n\n       Dir.mktmpdir do |temp_dir|\n         FileUtils.cp_r File.join(Rails.root, 'lib', 'templates', "#{format}"), temp_dir\n\n         content_path = File.join(temp_dir, format, 'content.xml')\n         File.write(content_path, dynamic_content)\n\n         zip_file_path = File.join(Dir.tmpdir, "document.#{format}")\n         Zip::File.open(zip_file_path, Zip::File::CREATE) do |zip|\n           Dir[File.join(temp_dir, '**', '*')].each do |file|\n             zip.add(File.basename(file), file) unless File.directory?(file)\n           end\n         end\n\n         send_file zip_file_path, type: "application/vnd.oasis.opendocument.#{format}", disposition: 'inline'\n       end\n     end\n\n     def set_document\n       @document = Document.find(params[:id])\n     end\n   end