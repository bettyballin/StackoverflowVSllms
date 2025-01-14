require "shrine"\n   require "shrine/storage/file_system" # stores files locally\n\n   Shrine.storages = {\n     cache: Shrine::Storage::FileSystem.new("public", prefix: "uploads/cache"), # temporary\n     store: Shrine::Storage::FileSystem.new("public", prefix: "uploads/store"), # permanent\n   }\n\n   Shrine.plugin :activerecord # or :mongoid\n   Shrine.plugin :cached_attachment_data # for retaining the cached file across form redisplays