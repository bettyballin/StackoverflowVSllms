cd /home/deploy/your_app/current; script/runner -e production ./script/my_cron_job.rb >> /home/deploy/your_app/current/log/my_file.log 2>&1