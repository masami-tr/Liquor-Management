DROP TABLE IF EXISTS liquor;

CREATE TABLE liquor (
  id INT UNSIGNED AUTO_INCREMENT,
  liquorType VARCHAR(20) NOT NULL,
  producingCountry VARCHAR(20) NOT NULL,
  liquorName VARCHAR(20) NOT NULL,
  alcoholContent INT NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO liquor (id, liquorType, producingCountry, liquorName, alcoholContent) VALUES (1, "ウイスキー", "スコットランド", "マッカラン", 40);
INSERT INTO liquor (id, liquorType, producingCountry, liquorName, alcoholContent) VALUES (2, "焼酎", "日本", "黒霧島", 25);
