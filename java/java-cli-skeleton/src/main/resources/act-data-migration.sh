#!/usr/bin/env bash

JARPATH=target/dependency
for file in `ls -1 ${JARPATH}/*.jar`
do
CLASSPATH=${CLASSPATH}:${file}
done

CLASSPATH="$CLASSPATH:target/act-data-migration-1.0-SNAPSHOT.jar"
OPTS="-cp $CLASSPATH $OPTS"

exec /home/y/bin/java ${OPTS} com.yahoo.udbconfig.tools.act.ActDataMigrationTool "$@"