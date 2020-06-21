INSERT INTO `kunde` VALUES (1,'Kirchgasse 4 9876 Berlin','Müller Karl','157123456');
INSERT INTO `kunde` VALUES (2,'Hauptstr. 3 87654 München','Test Birgit','789456123');
INSERT INTO `kunde` VALUES (3,'Radweg 123 11223 Rostock','Muster Peter','153333');

INSERT INTO `bestellung` (id, bezahlt, datum, endsumme, rabatt, versandkosten, versendet, waehrung, kunden_ID) VALUES (1,0,'2020-06-09',26,1,2,0,0,1);
INSERT INTO `bestellung` VALUES (2,1,'2020-06-22',18,0,3,0,0,2);
INSERT INTO `bestellung` VALUES (3,1,'2020-06-01',5000,200,1500,1,1,3);

INSERT INTO `artikel` (name, id, anmerkung, groesse, bestellung_ID, DTYPE) VALUES ('Hose kurz',1,'rot','D',1,'HoseKurz');
INSERT INTO `artikel` (name, id, anmerkung, groesse, bestellung_ID, DTYPE) VALUES ('Schal',2,'autos blau','23 cm',1,'Schal');
INSERT INTO `artikel` (name, id, anmerkung, groesse, bestellung_ID, DTYPE) VALUES ('Schal',3,'grün','38 cm',2,'Schal');
INSERT INTO `artikel` (name, id, anmerkung, groesse, bestellung_ID, DTYPE) VALUES ('Hose kurz',4,'lila','G',3,'HoseKurz');



