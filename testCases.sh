#!/usr/bin/sh

for i in `seq 30 50`
do
	for j in `seq 5 10`
	do

		for k in `seq 5 10`
		do
			echo -e "$i $j $k"
			java WorkDistributor $i $j $k
			echo -e "\n"
		done
	done
done
