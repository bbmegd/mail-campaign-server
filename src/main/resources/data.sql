CREATE TABLE IF NOT EXISTS contact (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(256) NOT NULL,
  surname VARCHAR(256) NOT NULL,
  email VARCHAR(256) NOT NULL
);

CREATE TABLE IF NOT EXISTS campaign (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name varchar(256) NOT NULL,
  active BOOLEAN DEFAULT true
);

CREATE TABLE IF NOT EXISTS mail (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  isLinkClicked BOOLEAN,
  startTime timestamp ,
  endTime timestamp ,
  contact_id int,
  campaign_id int,
  uuid varchar(64),
  foreign key (contact_id) references contact(id),
  foreign key (campaign_id) references campaign(id)
);

