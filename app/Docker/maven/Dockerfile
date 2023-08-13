# ベースイメージを指定
FROM maven:latest

# 作業ディレクトリを設定
WORKDIR /app

# ホストのプロジェクトファイルをコンテナにコピー
COPY ../ .

# Mavenの依存関係を解決してビルド
RUN mvn clean install

# ビルドした成果物などを利用するためにポートをエクスポート
#EXPOSE 8080

# コンテナ起動時に実行するコマンドを指定
#CMD ["java", "-jar", "app-0.0.1-SNAPSHOT.jar"]
