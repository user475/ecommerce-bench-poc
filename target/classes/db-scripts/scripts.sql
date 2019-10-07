/* creating schema */
CREATE SCHEMA `ecommerce-assigement` ;


/*  TABLE `addresses` */
	CREATE TABLE `addresses` (  
	`addressId` int(11) NOT NULL, 
	`location` varchar(255) NOT NULL, 
	`state` varchar(45) DEFAULT NULL, 
	`pincode` int(11) NOT NULL, 
	PRIMARY KEY (`addressId`)
	)

	INSERT INTO `addresses` (`addressId`, `location`, `state`, `pincode`) VALUES ('1', 'NLR', 'AP', '524002');

	
/*  TABLE `catalog` */
	
	CREATE TABLE `catalog` (  
	`cid` int(11) NOT NULL,  
	`catalogName` varchar(255) DEFAULT NULL,
	PRIMARY KEY (`cid`)
	)

	INSERT INTO `catalog` (`cid`, `catalogName`) VALUES ('1', 'Books');

	
/*  TABLE `catalog_product` */
	CREATE TABLE `catalog_product` ( 
	`Catalog_cid` int(11) NOT NULL,  
	`setProducts_pid` int(11) NOT NULL, 
	PRIMARY KEY (`Catalog_cid`,`setProducts_pid`), 
	UNIQUE KEY `UK_ql0firw7ostoeb7jpvyb69jiy` (`setProducts_pid`), 
	CONSTRAINT `FKgnylqq5i71c32g943n8hplgbk` FOREIGN KEY (`setProducts_pid`) REFERENCES `product` (`pid`)
	)
	
	INSERT INTO `catalog_product` (`Catalog_cid`, `setProducts_pid`) VALUES ('1', '1');


/*  TABLE `customers` */
	CREATE TABLE `customers` ( 
	`userId` int(11) NOT NULL,  
	`emailId` varchar(255) DEFAULT NULL,  
	`firstName` varchar(255) DEFAULT NULL, 
	`lastName` varchar(255) DEFAULT NULL, 
	`mobileNo` varchar(10) DEFAULT NULL, 
	`password` varchar(255) DEFAULT NULL, 
	PRIMARY KEY (`userId`),  UNIQUE KEY `UK_avdv9vtadi3ouqthbm596d2f4` (`emailId`)
	) 
	
	INSERT INTO `customers` (`userId`, `emailId`, `firstName`, `lastName`, `mobileNo`, `password`)
	VALUES ('1', 'test@virtusa.com', 'test', 'test', '9879879879', '$2a$12$meMzYJ6fImpZKdt2sgmw/eqvGAbWo4qHVVj5gYYsNdTgGNjLyG9wO');

	
	
/*  TABLE `customers_addresses` */
	CREATE TABLE `customers_addresses` ( 
	`Customer_userId` int(11) NOT NULL, 
	`userAddress_addressId` int(11) NOT NULL,
	PRIMARY KEY (`Customer_userId`,`userAddress_addressId`),
	UNIQUE KEY `userAddress_addressId_UNIQUE` (`userAddress_addressId`)
	)
	
	INSERT INTO `customers_addresses` (`Customer_userId`, `userAddress_addressId`) VALUES ('1', '1');

	
/*  TABLE `orders` */
	CREATE TABLE `orders` (  
	`orderId` int(11) NOT NULL, 
	`date` datetime DEFAULT NULL, 
	`feedback` varchar(255) DEFAULT NULL,
	`orderPrice` double DEFAULT NULL, 
	`orderStatus` varchar(255) DEFAULT NULL,
	`productDescrption` varchar(255) DEFAULT NULL,
	`productId` int(11) DEFAULT NULL, 
	`productName` varchar(255) DEFAULT NULL,  
	`rating` float DEFAULT NULL, 
	`userId` int(11) DEFAULT NULL, 
	`addressId` int(11) DEFAULT NULL,  PRIMARY KEY (`orderId`)
	) 
	
	INSERT INTO `orders` (`orderId`, `date`, `feedback`, `orderPrice`, `orderStatus`, `productDescrption`, `productId`, `productName`, `rating`, `userId`, `addressId`) 
		VALUES ('1', '2019-10-01 00:00:00', 'good product', '4500', 'S', ' book', '1', 'java book', '5', '1', '1');

	
	/*  TABLE `product` */
	CREATE TABLE `product` (  
	`pid` int(11) NOT NULL, 
	`catId` int(11) DEFAULT NULL, 
	`price` double DEFAULT NULL,  
	`productDescrption` varchar(255) DEFAULT NULL, 
	`productName` varchar(255) DEFAULT NULL,  PRIMARY KEY (`pid`)
	)
	
	INSERT INTO `product` (`pid`, `catId`, `price`, `productDescrption`, `productName`)
	VALUES ('1', '1', '4500', 'Book ', 'Java book');

