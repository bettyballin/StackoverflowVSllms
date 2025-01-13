# set up the mirror\ngit svn clone -s $SVN\ngit remote add origin git@$MACHINE:svnmirror.git\ngit push\n# + cron job to do git svn rebase && git push every N hours/minutes\n\n# set up the local working copy for development\ngit clone git://$MACHINE/svnmirror.git\n# that's an anonymous, read only clone \n# no push to the svn mirror for developers - only cronjob user can push there\ngit remote add newproject git@$MACHINE:myproject.git\ngit push newproject\n# now do the real deal\ngit clone git://$MACHINE/myproject.git\n# hack hack hack\ngit push # origin master not needed\ngit remote add svnmirror git://$MACHINE/svnmirror.git\ngit merge svnmirror/master\ngit push