class FileUploader < CarrierWave::Uploader::Base\n      include CarrierWave::MiniMagick\n\n      version :thumb do\n        process :generate_thumb\n\n        def full_filename(for_file)\n          "#{File.basename(for_file, '.*')}_thumb.jpg"\n        end\n      end\n\n      def generate_thumb\n        manipulate! do |frame, index|\n          frame.format('jpg', 0)\n          frame.resize('200x200')\n          frame\n        end\n      end\n    end