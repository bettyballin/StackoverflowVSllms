groupadd svn\nuseradd -g svn svnuser\nchown -R svnuser:svn /home/brianly/svn/test\nchmod -R 755 /home/brianly/svn/test\nusermod -aG svn www-data