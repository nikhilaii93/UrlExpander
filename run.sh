# runs the jar for all files in a dir
# keep the mediaDomains & jar in the same dir as the script
# BASEDIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
BASEDIR='pwd -P'
SUFFIX="_processed"
EXT=".txt"
SEPARATOR="/"
JARPATH="UrlExpander.jar"
for file in *.txt;
do
	FILENAME="${file%.*}"
	TARGET=$BASEDIR$SUFFIX$SEPARATOR$FILENAME$SUFFIX$EXT
	java -jar $JARPATH 50 $file $TARGET
done
