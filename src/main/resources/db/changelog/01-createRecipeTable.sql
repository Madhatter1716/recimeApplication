
-- liquibase formatted sql
-- changeset Tarro:01

CREATE TABLE recipe (
    id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    position BIGINT(20),
    likes BIGINT(20),
    difficulty ENUM('easy', 'medium', 'hard'),
    imageUrl VARCHAR(2000)
);

INSERT INTO recipe (name, position, likes, difficulty, imageUrl)
VALUES ("Chicken Burger", 1, 1000, 'easy', 'https://ddg0cip9uom1w.cloudfront.net/code-challenge/burger.jpg'),
 ("Vegan Burger", 2, 4000, 'easy', 'https://ddg0cip9uom1w.cloudfront.net/code-challenge/burger.jpg'),
  ("Beef Burger", 3, 89000, 'medium', 'https://ddg0cip9uom1w.cloudfront.net/code-challenge/burger.jpg'),
   ("Breakfast Burger", 4, 500, 'easy', 'https://ddg0cip9uom1w.cloudfront.net/code-challenge/burger.jpg'),
    ("Quarter Pound Burger", 5, 700000, 'hard', 'https://ddg0cip9uom1w.cloudfront.net/code-challenge/burger.jpg');
    
    
-- rollback DROP TABLE `recipe`;