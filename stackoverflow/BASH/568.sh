while [ "${forcedexit}" != "true" ]\ndo\n    read squidinput\n    if [ -n squidinput ]\n       then\n        phpout=`"${phpexecpath}" "${phpredirectorpath}" "${squidinput}"`\n        echo "${phpout}"\n    fi\ndone