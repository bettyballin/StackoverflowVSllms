require 'sys/proctable'\ninclude Sys\n\ndef process_running?(pid)\n  ProcTable.ps(pid) != nil\nend