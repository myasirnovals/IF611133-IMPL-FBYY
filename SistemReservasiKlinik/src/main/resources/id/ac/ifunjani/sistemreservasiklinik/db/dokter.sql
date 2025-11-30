CREATE TABLE dokter
(
    id_dokter   CHAR(10)     NOT NULL,
    nama_dokter VARCHAR(100) NOT NULL,
    spesialis   VARCHAR(50)  NOT NULL,
    no_telp     VARCHAR(13)  NOT NULL,
    PRIMARY KEY (id_dokter),
) ENGINE = InnoDB;