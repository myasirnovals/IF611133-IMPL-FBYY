CREATE TABLE rekam_medis
(
    id_rekam_medis CHAR(16) NOT NULL ,
    id_dokter CHAR(10) NOT NULL ,
    keluhan TEXT NOT NULL ,
    diagnosa TEXT NOT NULL ,
    catatan_dokter TEXT,
    tanggal_periksa DATE DEFAULT CURRENT_DATE,

    PRIMARY KEY (id_rekam_medis),
    CONSTRAINT fk_rekam_medis_dokter FOREIGN KEY (id_dokter) REFERENCES dokter(id_dokter) ON DELETE RESTRICT 
);