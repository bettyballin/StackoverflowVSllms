perl -anE 'say $F[2] unless $h{$F[2]}++' in.txt > out.txt