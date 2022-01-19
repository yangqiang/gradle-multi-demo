FROM openjdk:8-jre-alpine3.9

RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories
RUN apk add --no-cache \
 tzdata \
 openssh-client
# 设置时区
RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

ARG DEPENDENCY=build/dependency

WORKDIR /tianrang/app
COPY ${DEPENDENCY}/BOOT-INF/lib ./lib
COPY ${DEPENDENCY}/META-INF ./META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes ./

ENTRYPOINT ["java","-cp",".:lib/*","demo.app.admin.AdminAppMain"]
