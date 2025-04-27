BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "ActivityLog" (
	"logId"	INTEGER NOT NULL,
	"userId"	INTEGER NOT NULL,
	"action"	TEXT NOT NULL,
	"timestamp"	TEXT NOT NULL,
	"details"	TEXT,
	PRIMARY KEY("logId" AUTOINCREMENT),
	FOREIGN KEY("userId") REFERENCES "User"("userId")
);
CREATE TABLE IF NOT EXISTS "Category" (
	"categoryId"	INTEGER NOT NULL,
	"userId"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	"icon"	TEXT NOT NULL,
	"colour"	TEXT NOT NULL,
	PRIMARY KEY("categoryId" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "Reward" (
	"rewardId"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	"description"	TEXT NOT NULL,
	"amount"	REAL NOT NULL,
	"type"	TEXT NOT NULL,
	"code"	INTEGER NOT NULL,
	PRIMARY KEY("rewardId" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "RewardHistory" (
	"historyId"	INTEGER NOT NULL,
	"userId"	INTEGER NOT NULL,
	"rewardId"	INTEGER NOT NULL,
	"dateRedeemed"	TEXT NOT NULL,
	"amount"	REAL NOT NULL,
	PRIMARY KEY("historyId" AUTOINCREMENT),
	FOREIGN KEY("rewardId") REFERENCES "Reward"("rewardId"),
	FOREIGN KEY("userId") REFERENCES "User"("userId")
);
CREATE TABLE IF NOT EXISTS "SubCategory" (
	"subCategoryId"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	"transactionId"	INTEGER,
	"userId"	INTEGER NOT NULL,
	PRIMARY KEY("subCategoryId" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "Transaction" (
	"transactionId"	INTEGER NOT NULL,
	"userId"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	"amount"	REAL NOT NULL,
	"transactionMethod"	TEXT NOT NULL,
	"location"	TEXT,
	"dateTime"	TEXT NOT NULL,
	"description"	TEXT NOT NULL,
	"photo"	TEXT NOT NULL,
	"categoryId"	INTEGER NOT NULL,
	"subCategoryId"	INTEGER NOT NULL,
	"expense"	INTEGER NOT NULL,
	"recurring"	INTEGER NOT NULL,
	PRIMARY KEY("transactionId" AUTOINCREMENT),
	FOREIGN KEY("categoryId") REFERENCES "Category"("categoryId"),
	FOREIGN KEY("subCategoryId") REFERENCES "SubCategory"("subCategoryId"),
	FOREIGN KEY("userId") REFERENCES "User"("userId") ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS "User" (
	"userId"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	"surname"	TEXT NOT NULL,
	"email"	TEXT NOT NULL,
	"password"	TEXT NOT NULL,
	"cashoos"	REAL NOT NULL,
	"isActive"	INTEGER NOT NULL,
	PRIMARY KEY("userId" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "UserSettings" (
	"userSettingsId"	INTEGER NOT NULL,
	"userId"	INTEGER NOT NULL,
	"payday"	TEXT NOT NULL,
	"salary"	REAL NOT NULL,
	"minGoal"	REAL NOT NULL,
	"maxGoal"	REAL NOT NULL,
	"color"	TEXT NOT NULL,
	"chinchilla"	TEXT NOT NULL,
	PRIMARY KEY("userSettingsId" AUTOINCREMENT),
	FOREIGN KEY("userId") REFERENCES "User"("userId") ON DELETE CASCADE
);
INSERT INTO "ActivityLog" VALUES (1,1,'Transaction Added','2024-04-26 13:00','Added transaction: McDonalds');
INSERT INTO "ActivityLog" VALUES (2,1,'Transaction Added','2024-04-26 15:00','Added transaction: Uber Ride');
INSERT INTO "Category" VALUES (1,1,'Food','food_icon','#FFA500');
INSERT INTO "Category" VALUES (2,1,'Transport','transport_icon','#0000FF');
INSERT INTO "Category" VALUES (3,2,'Entertainment','entertainment_icon','#800080');
INSERT INTO "Category" VALUES (4,2,'Shopping','shopping_icon','#FFC0CB');
INSERT INTO "Category" VALUES (5,1,'Food','food_icon','#FFA500');
INSERT INTO "Category" VALUES (6,1,'Transport','transport_icon','#0000FF');
INSERT INTO "Category" VALUES (7,2,'Entertainment','entertainment_icon','#800080');
INSERT INTO "Category" VALUES (8,2,'Shopping','shopping_icon','#FFC0CB');
INSERT INTO "Reward" VALUES (1,'Free Coffee','Get a free coffee on your next purchase',5.0,'Discount',1001);
INSERT INTO "Reward" VALUES (2,'Movie Ticket','Free movie ticket',10.0,'Free',1002);
INSERT INTO "Reward" VALUES (3,'Cash Back','Get 10% cash back',10.0,'Cash Back',1003);
INSERT INTO "Reward" VALUES (4,'Free Coffee','Get a free coffee on your next purchase',5.0,'Discount',1001);
INSERT INTO "Reward" VALUES (5,'Movie Ticket','Free movie ticket',10.0,'Free',1002);
INSERT INTO "Reward" VALUES (6,'Cash Back','Get 10% cash back',10.0,'Cash Back',1003);
INSERT INTO "RewardHistory" VALUES (1,1,1,'2024-04-27',5.0);
INSERT INTO "RewardHistory" VALUES (2,2,2,'2024-04-28',10.0);
INSERT INTO "RewardHistory" VALUES (3,1,1,'2024-04-27',5.0);
INSERT INTO "RewardHistory" VALUES (4,2,2,'2024-04-28',10.0);
INSERT INTO "SubCategory" VALUES (1,'Groceries',NULL,1);
INSERT INTO "SubCategory" VALUES (2,'Dining Out',NULL,1);
INSERT INTO "SubCategory" VALUES (3,'Bus',NULL,1);
INSERT INTO "SubCategory" VALUES (4,'Movies',NULL,2);
INSERT INTO "SubCategory" VALUES (5,'Clothes',NULL,2);
INSERT INTO "SubCategory" VALUES (6,'Groceries',NULL,1);
INSERT INTO "SubCategory" VALUES (7,'Dining Out',NULL,1);
INSERT INTO "SubCategory" VALUES (8,'Bus',NULL,1);
INSERT INTO "SubCategory" VALUES (9,'Movies',NULL,2);
INSERT INTO "SubCategory" VALUES (10,'Clothes',NULL,2);
INSERT INTO "Transaction" VALUES (1,1,'McDonalds',120.0,'Card','Mall','2024-04-26 13:00','Lunch','',1,2,1,0);
INSERT INTO "Transaction" VALUES (2,1,'Uber Ride',80.0,'Cash','City Center','2024-04-26 15:00','Taxi to work','',2,3,1,0);
INSERT INTO "Transaction" VALUES (3,2,'Cinema',200.0,'Card','Cinema Complex','2024-04-27 18:00','Movie night','',3,4,1,0);
INSERT INTO "Transaction" VALUES (4,2,'Zara',500.0,'Card','Shopping Mall','2024-04-28 14:00','New shirt','',4,5,1,0);
INSERT INTO "Transaction" VALUES (5,1,'McDonalds',120.0,'Card','Mall','2024-04-26 13:00','Lunch','',1,2,1,0);
INSERT INTO "Transaction" VALUES (6,1,'Uber Ride',80.0,'Cash','City Center','2024-04-26 15:00','Taxi to work','',2,3,1,0);
INSERT INTO "Transaction" VALUES (7,2,'Cinema',200.0,'Card','Cinema Complex','2024-04-27 18:00','Movie night','',3,4,1,0);
INSERT INTO "Transaction" VALUES (8,2,'Zara',500.0,'Card','Shopping Mall','2024-04-28 14:00','New shirt','',4,5,1,0);
INSERT INTO "User" VALUES (1,'John','Doe','john.doe@example.com','password123',1000.0,1);
INSERT INTO "User" VALUES (2,'Jane','Smith','jane.smith@example.com','securepass',1500.0,1);
INSERT INTO "UserSettings" VALUES (1,1,'25th',3000.0,500.0,1000.0,'#FF0000','Fluffy');
INSERT INTO "UserSettings" VALUES (2,2,'15th',4000.0,700.0,1200.0,'#00FF00','Snowball');
INSERT INTO "UserSettings" VALUES (3,1,'25th',3000.0,500.0,1000.0,'#FF0000','Fluffy');
INSERT INTO "UserSettings" VALUES (4,2,'15th',4000.0,700.0,1200.0,'#00FF00','Snowball');
COMMIT;
