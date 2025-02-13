FROM public.ecr.aws/j6b7p9b9/drpjava:latest

RUN   mkdir -p /etc/drp/aec-cp-ims-jobs

WORKDIR /etc/drp/aec-cp-ims-jobs

ADD build/libs/*.jar .

CMD java $JAVA_OPTS -Dserver.port=8080 -Dlog4j2.formatMsgNoLookups=true -jar *.jar

EXPOSE 8080