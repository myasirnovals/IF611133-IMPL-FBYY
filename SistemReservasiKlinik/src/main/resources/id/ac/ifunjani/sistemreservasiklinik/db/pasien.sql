CREATE TABLE pasien
(
    id_pasien CHAR(16) NOT NULL,
    nama_lengkap VARCHAR(100) NOT NULL,
    alamat TEXT,
    tanggal_lahir DATE,
    no_telepon VARCHAR(13) NOT NULL,
    password VARCHAR(255) NOT NULL,

    PRIMARY KEY (id_pasien)
);