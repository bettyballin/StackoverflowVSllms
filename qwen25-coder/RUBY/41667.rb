require 'fileutils'\n\ndef force_copy(source, dest)\n  FileUtils.rm_rf(dest) if File.exist?(dest)\n  FileUtils.cp_r(source, dest)\nend\n\n# Usage:\nforce_copy('source_directory', 'destination_directory')