CREATE table jadwal
(
    id_jadwal   VARCHAR(5) NOT NULL,
    tanggal     DATE DEFAULT CURRENT_DATE,
    hari        ENUM('SENIN', 'SELASA', 'RABU', 'KAMIS', 'JUMAT', 'SABTU') NOT NULL,
    jam_mulai   TIME       NOT NULL,
    jam_selesai TIME       NOT NULL,
    id_dokter   CHAR(10)   NOT NULL,
    PRIMARY KEY (id_jadwal),
    CONSTRAINT fk_jadwal_dokter FOREIGN KEY (id_dokter) REFERENCES dokter (id_dokter) ON DELETE RESTRICT
) ENGINE = InnoDB;