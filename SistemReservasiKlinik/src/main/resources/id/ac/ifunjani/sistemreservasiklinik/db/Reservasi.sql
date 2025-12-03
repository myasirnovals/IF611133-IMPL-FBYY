CREATE TABLE reservasi
(
    id_reservasi VARCHAR  (5) NOT NULL,
    id_pasien VARCHAR (255) NOT NULL,
    id_rekam_medis CHAR (15) NOT NULL,
    id_staff VARCHAR (5) NOT NULL,
    id_jadwal VARCHAR (5) NOT NULL,

    PRIMARY KEY (id_reservasi),
    CONSTRAINT fk_reservasi_pasien FOREIGN KEY (id_pasien) REFERENCES pasien (id_pasien) ON DELETE RESTRICT,
    CONSTRAINT fk_reservasi_rekam_medis FOREIGN KEY (id_rekam_medis) REFERENCES rekam_medis (id_rekam_medis) ON DELETE RESTRICT,
    CONSTRAINT fk_reservasi_staff FOREIGN KEY (id_staff) REFERENCES staff (id_staff) ON DELETE RESTRICT,
    CONSTRAINT fk_reservasi_jadwal FOREIGN KEY (id_jadwal) REFERENCES jadwal (id_jadwal) ON DELETE RESTRICT
);