CREATE TABLE laReservasi
(
    id_reservasi VARCHAR  (5) NOT NULL,
    id_pasien VARCHAR () NOT NULL,
    id_rekam_medis CHAR (15) NOT NULL,
    id_staff VARCHAR (5) NOT NULL,
    id_jadwal VARCHAR (5) NOT NULL,

    PRIMARY KEY (id_reservasi),
    CONSTRAINT fk_reservasi FOREIGN KEY (id_pasien) REFERENCES pasien (id_pasien) ON DELETE RESTRICT,
    CONSTRAINT fk_reservasi FOREIGN KEY (id_rekam_medis) REFERENCES rekam_medis (id_rekam_medis) ON DELETE RESTRICT,
    CONSTRAINT fk_reservasi FOREIGN KEY (id_staff) REFERENCES staff (id_staff) ON DELETE RESTRICT,
    CONSTRAINT fk_reservasi FOREIGN KEY (id_jadwal) REFERENCES jadwal (id_jadwal) ON DELETE RESTRICT,
);