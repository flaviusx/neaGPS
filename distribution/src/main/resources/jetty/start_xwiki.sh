#!/bin/sh

export LANG=fr_FR.ISO8859-1
JETTY_HOME=.
JAVA_OPTS=-Xmx300m

# The port on which to start Jetty can be passed to this script as the first argument
if [ -n "$1" ]; then
  JETTY_PORT=$1
else
  JETTY_PORT=8080
fi

echo Starting Jetty on port $JETTY_PORT ...
echo Logs are in the logs/ directory

mkdir -p logs 2>/dev/null
nohup java $JAVA_OPTS -Dfile.encoding=iso-8859-1 -Djetty.port=$JETTY_PORT -Djetty.home=$JETTY_HOME -jar $JETTY_HOME/start.jar > logs/xwiki_output.log 2> logs/xwiki_errors.log &
