0 4 * * * RAILS_ENV=production PATH=/usr/local/bin:$PATH /usr/local/bin/ruby /data/myapp/current/script/runner -e production /data/myapp/current/script/myscript.rb >> /data/myapp/current/log/cron.log 2>&1