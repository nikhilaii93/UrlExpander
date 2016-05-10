# runs the jar for all files in a dir
# keep the mediaDomains & jar in the same dir as the script
# BASEDIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
BASEDIR=$(pwd)
SUFFIX="_processed"
EXT=".txt"
SEPARATOR="/"
JARPATH="UrlExpander.jar"
# store current .txt files so that extra created files are not processed
CURRENT_FILES=$(ls *.txt)
for file in $CURRENT_FILES
do
	FILENAME="${file%.*}"
	TARGET=$BASEDIR$SUFFIX$SEPARATOR$FILENAME$SUFFIX$EXT
	java -jar $JARPATH 2000 $file $TARGET
done
