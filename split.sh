# keep only those files in the dir that you want to split
# splits file in a directory to files with lines 1500000
# run in directory where files are to be split
#BASEDIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
BASEDIR='pwd -P'
SEPARATOR="/"
SUFFIX="_s"
EXT=".txt"
i=1
for file in *.txt
do
	FILENAME="${file%.*}"
	split -l 1500000 $file
	# rename files as required
	j=1
	for x in 'ls x* | sort'
	do
		mv $x $BASEDIR$SEPARATOR$FILENAME$SUFFIX$j$EXT
		j=$(($j+1))
	done
	i=$((i+1))
	#TODO delete file splitted to save disk space
done
