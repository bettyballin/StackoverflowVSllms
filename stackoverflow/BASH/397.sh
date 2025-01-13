AC_INIT(Makefile.in)\n\nFOP=fop.sh\nHHC=hhc\nXSLTPROC=xsltproc\n\nAC_ARG_WITH(fop, [  --with-fop  Where to find Apache FOP],\n[\n    if test "x$withval" != "xno"; then\n        FOP="$withval"\n    fi\n]\n)\nAC_PATH_PROG(FOP,  $FOP)\n\nAC_ARG_WITH(hhc, [  --with-hhc  Where to find Microsoft Help Compiler],\n[\n    if test "x$withval" != "xno"; then\n        HHC="$withval"\n    fi\n]\n)\nAC_PATH_PROG(HHC,  $HHC)\n\nAC_ARG_WITH(xsltproc, [  --with-xsltproc  Where to find xsltproc],\n[\n    if test "x$withval" != "xno"; then\n        XSLTPROC="$withval"\n    fi\n]\n)\nAC_PATH_PROG(XSLTPROC,  $XSLTPROC)\n\nAC_SUBST(FOP)\nAC_SUBST(HHC)\nAC_SUBST(XSLTPROC)\n\nHERE=`pwd`\nAC_SUBST(HERE)\nAC_OUTPUT(Makefile)\n\ncat > config.nice <<EOT\n#!/bin/sh\n./configure \\n    --with-fop='$FOP' \\n    --with-hhc='$HHC' \\n    --with-xsltproc='$XSLTPROC' \\n\nEOT\nchmod +x config.nice