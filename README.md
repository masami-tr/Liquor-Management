# お酒のデータベース制作

## 概要

お酒の情報を管理するアプリ

・お酒の名前、原産国、種類、アルコール度数をまとめたアプリになります。

・お酒の情報の検索、登録、更新、削除が可能です。

・お酒の情報をストックすればするほど、オリジナルのライブラリーが構築されます。

## 作成背景

お酒を嗜むのが私の趣味なのですが、お気に入りを見つけてもつい飲みすぎて酔っ払ってしまって何を飲んだか忘れてしまいます・・・。

なので種類や名前を備忘録として気軽に記録できるアプリがほしいなと思い自分で制作してみました。

## 使用技術

＜バックエンド＞
* Java 20.0.1
* SpringBoot 3.1.5
* MyBatis

＜その他＞
* MySQL 8.0.34
* Docker 23.0.5
* 自動テスト
* CI (Checkstyle, Codecov, Discordへの通知, 自動テストを実行)

## アプリケーション概略図
![Untitled](https://github.com/masami-tr/Liquor-Management/assets/133315049/e569c577-643d-4bd9-87e6-a5137abdb809)

## アプリケーション機能一覧

|機能|詳細|URL|
|----|----|----|
|検索|IDを指定して検索する|/liquors/{id}|
|新規登録|ID及び付随するお酒を新規登録する|/liquors|
|更新|指定したIDのお酒を更新する|/liquors/{id}|
|削除|指定したお酒を削除する|/liquors/{id}|

## DB定義
テーブル名：liquor

|カラム名|データ型|キー|NOT NULL|備考|
|----|----|----|----|----|
|id|int|PRIMARY|KEY|ID,自動生成|
|liquorType|VARCHAR(20)| |NOT NUL|お酒の種類|
|producingCountry|VARCHAR(20)| |NOT NULL|原産国|
|liquorName| VARCHAR(20)| |NOT NULL| お酒の名前|
|alcoholContent| INT| |NOT NULL| アルコール度数|

## テストコードの実装
下記テストコードを実装しました。

* 単体テスト
  * LiquorServiceImplTest
  * LiquorMapperTest

* 結合テスト
  * 適宜更新中

# 振り返り

今回、初めての個人でWEBアプリケーション開発を通して、Java言語の知識だけではなく、フレームワークやデータベース、テストなど様々な知識を学ぶことができました。

また、これまでエラーコードに悩んだり、うまく実装できずかなりの時間を費やしてしまった事がありました。
その場合、私は本やネット検索・ChatGPT、他の方のコード等を参考に解決の糸口を探すことを心がけました。
今後、現場に入った場合もたくさんの既存コードや技術に積極的に触れて、技術力を高めていきたいと思います。

# 今後の展望
* テーブルに「味」、「☆5段階評価」、「店名」（どこで飲んだか）を追加

* 情報をカラム別に検索できるように実装して、柔軟に情報確認できるように実装

* フロント領域を実装
  * React (JavaScript)
  * Chakra UI

* AWSへのデプロイ

