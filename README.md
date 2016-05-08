# UrlExpander

Instructions to use the jar:

1. Set proxy int the terminal (if proxy) by:
	a. export http_proxy=http://username:password@proxyhost:port/
	b. export https_proxy=https://username:password@proxyhost:port/

2. Keep the media domains file in the same directory as the jar.

3. Use command: java -jar UrlExpander.jar "NUM_THREADS" "PathOfTweetsFile" "PathOfOutputFile"

NUM_THREADS: Keep it so as to obtain CPU usage around 100%, for 4 cores and 8 GB RAM, 500 is suitable
PathOfTweetsFile: Path of the file to be processed
PathOfOutputFile: Path of the output file, an empty file need not be created

Enjoy!
