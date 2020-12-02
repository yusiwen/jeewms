FROM tomcat:8-jdk8
RUN rm -rvf /usr/local/tomcat/webapps/ROOT
ADD target/jeewms.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
ENV MYSQL_HOST=127.0.0.1
ENV MYSQL_PORT=3306
ENV MYSQL_DB=wms
ENV MYSQL_USER=wms_user
ENV MYSQL_PASSWORD=123456
ENV REDIS_HOST=127.0.0.1
ENV REDIS_PORT=6379
CMD ["catalina.sh", "run"]

