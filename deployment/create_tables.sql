CREATE TABLE employers (
    id INT(6) AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    lastName VARCHAR(30) NOT NULL,
    department VARCHAR(50)
);

    CREATE TABLE products (
        id INT(6) AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(30) NOT NULL,
        category VARCHAR(30) NOT NULL,
        gender VARCHAR(30) NOT NULL,
        stock INT(6) NOT NULL,
        price INT(6) NOT NULL,
        codeScan VARCHAR(30) NOT NULL,
        image VARCHAR(30) NOT NULL
    );
