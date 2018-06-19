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
CREATE TABLE public."User"
(
  id bigint NOT NULL DEFAULT nextval('"userIdSeq"'::regclass),
  login character varying(20) NOT NULL,
  psw character varying(20),
  name character varying(20),
  UNIQUE(login),
  CONSTRAINT "User_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);



-- ----------------------------
-- View structure for RatingView
-- ----------------------------
CREATE OR REPLACE VIEW "RatingView" AS
 SELECT "User".name AS "User",
    round(avg("History".result), 3) AS "Result"
   FROM "History",
    "User"
  WHERE "History".id_user = "User".id
  GROUP BY "User"
  ORDER BY "Result" ASC;

