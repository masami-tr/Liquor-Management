DROP TABLE IF EXISTS liquor;

CREATE TABLE liquor (
  id INT UNSIGNED AUTO_INCREMENT NOT NULL,
  liquor_type VARCHAR(20) NOT NULL,
  producing_country VARCHAR(20) NOT NULL,
  liquor_name VARCHAR(20) NOT NULL,
  alcohol_content INT NOT NULL,;
  PRIMARY KEY (id)
);

INSERT INTO liquor (id, liquor_type, producing_country, liquor_name, alcohol_content) VALUES (1, "ウイスキー", "スコットランド", "マッカラン", 40);
INSERT INTO liquor (id, liquor_type, producing_country, liquor_name, alcohol_content) VALUES (2, "焼酎", "日本", "黒霧島", 25);
