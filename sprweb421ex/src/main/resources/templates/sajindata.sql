USE test;

CREATE TABLE sajindata (
	id INT PRIMARY KEY AUTO_INCREMENT,
	sangcode INT NOT NULL, 
	about TEXT,
	filepath VARCHAR(255), 
	uploadat TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
	CONSTRAINT fk_sangdata_sajindata_sangcode 
		FOREIGN KEY (sangcode) REFERENCES sangdata(code)
);