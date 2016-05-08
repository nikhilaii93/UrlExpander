# keep only those files in the dir that you want to split
# splits file in a directory to files with lines 1500000
# run in directory where files are to be split
#BASEDIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
BASEDIR=$(pwd)
SEPARATOR="/"
SUFFIX="_s"
EXT=".txt"
i=1
CURRENT_TXT=$(ls *.txt)
for file in $CURRENT_TXT
do
	FILENAME="${file%.*}"
	split -l 1500000 $file
	# rename files as required
	j=1
	XFILES=$('ls x* | sort')
	for x in $XFILES
	do
		TARGET=$BASEDIR$SEPARATOR$FILENAME$SUFFIX$j$EXT
		# spaces in the target removed pathname removed
		mv "$x" "${TARGET// /}"
		j=$(($j+1))
	done
	i=$((i+1))
	#TODO delete file splitted to save disk space
done
