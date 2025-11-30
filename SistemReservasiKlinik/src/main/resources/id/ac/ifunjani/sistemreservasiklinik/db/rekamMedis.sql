create table rekam_medis
(
    id_rekam_medis char(16),
    id_dokter char(10),
    keluhan text,
    diagnosa text,
    catatan_dokter text,
    tanggal_periksa date,

    primary key (id_rekam_medis),
    constraint fk_rekam_medis_dokter foreign key (id_dokter) references dokter(id_dokter) on delete restrict
);