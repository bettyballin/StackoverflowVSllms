sudo dtrace -p <PID> -n 'syscall::read:entry, syscall::write:entry { @files[ustack()] = bytes; }'