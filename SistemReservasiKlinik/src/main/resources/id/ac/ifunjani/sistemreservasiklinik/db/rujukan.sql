CREATE TABLE rujukan
{
    id_rujukan CHAR(10) NOT NULL,
    deskripsi_rujukan TEXT,
    rumah_sakit_tujuan VARCHAR(50) NOT NULL,
    id_rekam_medis CHAR (16) NOT NULL,

    PRIMARY KEY (id_rujukan),
    CONSTRAINT fk_rujukan_rekam_medis FOREIGN KEY (id_rekam_medis) REFERENCES rekam_medis(id_rekam_medis) ON DELETE RESTRICT
}