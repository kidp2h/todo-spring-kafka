FROM postgres:15.12

# Install Japanese locale
RUN apt-get update && \
    apt-get install -y locales && \
    sed -i '/ja_JP.UTF-8/s/^# //g' /etc/locale.gen && \
    locale-gen

ENV LANG=ja_JP.UTF-8 \
    LANGUAGE=ja_JP:ja \
    LC_ALL=ja_JP.UTF-8