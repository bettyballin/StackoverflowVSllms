select regexp_replace(encode('héllo there','hex'),'(..)',E'%\\1','g');