
-- ----------------------------
-- Sequence structure for gameIdSeq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gameIdSeq";
CREATE SEQUENCE "gameIdSeq"
 INCREMENT 1
 MINVALUE 0
 MAXVALUE 2147483647
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for userIdSeq
-- ----------------------------
DROP SEQUENCE IF EXISTS "userIdSeq";
CREATE SEQUENCE "userIdSeq"
 INCREMENT 1
 MINVALUE 0
 MAXVALUE 2147483647
 START 1
 CACHE 1;
SELECT setval('"public"."userIdSeq"', 6, true);

-- ----------------------------
-- Table structure for History
-- ----------------------------
DROP TABLE IF EXISTS "History";
CREATE TABLE "History" (
"id" int8 DEFAULT nextval('"gameIdSeq"'::regclass) NOT NULL,
"id_user" int8 NOT NULL,
"result" int8 NOT NULL
)
WITH (OIDS=FALSE);



-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS "User";
CREATE TABLE "User" (
"id" int8 DEFAULT nextval('"userIdSeq"'::regclass) NOT NULL,
"login" varchar(20) COLLATE "default" NOT NULL,
"psw" varchar(20) COLLATE "default",
"name" varchar(20) COLLATE "default"
)
WITH (OIDS=FALSE);


-- ----------------------------
-- View structure for RatingView
-- ----------------------------
CREATE OR REPLACE VIEW "RatingView" AS 
 SELECT "User".name AS "User",
    round(avg("History".result), 3) AS "Result"
   FROM "History",
    "User"
  WHERE ("History"."id_user" = "User".id)
  GROUP BY "User".name
  ORDER BY "User".name DESC;


-- ----------------------------
-- Primary Key structure for table History
-- ----------------------------
ALTER TABLE "History" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table User
-- ----------------------------
ALTER TABLE "User" ADD PRIMARY KEY ("id");
