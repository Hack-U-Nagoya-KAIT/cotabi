# こたび

ひつじさんのメモ
  
## よく使うコマンド

git branch ：今いるブランチを見る

git switch ブランチ名 ：指定したブランチに飛ぶ

git switch -c ブランチ名 ：今いるブランチから新しくブランチをきる

git pull　：developブランチに移動し作業前に使用し最新の情報を取り込む

git rebase　ブランチ名　：作業ブランチに移動し基本developを指定して取り込む
  git

## ブランチの命名規則
  
developブランチから切り、「feature/#(イシュー番号)_わかりやすい名前」のブランチを作る。

例：feature/#1_header
  
※絶対日本語使わない

これが見えればできている

環境構築の仕方

スマホに表示したい場合:ngrokを起動する
  ngrok http 8080
  https//ほにゃらら.appをコピー
  app.jsに貼り付け
  npm start

スマホに表示しなくていい方はここから
docker-compose up -dを実行する



