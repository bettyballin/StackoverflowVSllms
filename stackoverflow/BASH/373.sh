for i in *.*; do mkdir -p ${i:0:1}/${i:1:1}/${i:2:1}/; mv $i ${i:0:1}/${i:1:1}/${i:2:1}/; done;