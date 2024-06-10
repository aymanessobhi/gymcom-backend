CREATE database fmsardb;
CREATE USER 'fmsardb'@'localhost' IDENTIFIED  BY 'fmsardb!';

GRANT ALL PRIVILEGES ON fmsardb.* TO 'fmsardb'@'localhost';

FLUSH PRIVILEGES;


-- fmsardb.fmsar_coef_abat_ev definition

CREATE TABLE `fmsar_coef_abat_ev` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `entret_reg` enum('CONCESSIONNAIRE','AUTRE') DEFAULT NULL,
  `ice` varchar(255) DEFAULT NULL,
  `ident_fiscale` varchar(255) DEFAULT NULL,
  `percent_from_year3` double DEFAULT NULL,
  `percent_year1` double DEFAULT NULL,
  `percent_year2` double DEFAULT NULL,
  `prestataire` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


-- fmsardb.fmsar_coef_abat_ev_seq definition

CREATE TABLE `fmsar_coef_abat_ev_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- fmsardb.fmsar_coef_abat_km definition

CREATE TABLE `fmsar_coef_abat_km` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `km_moyen_annuel_di` int DEFAULT NULL,
  `km_moyen_annuel_es` int DEFAULT NULL,
  `km_moyen_annuel_hy` int DEFAULT NULL,
  `per_km_en_moins` double DEFAULT NULL,
  `per_km_en_plus` double DEFAULT NULL,
  `percent_en_moins` double DEFAULT NULL,
  `percent_en_plus` double DEFAULT NULL,
  `puiss_fiscale_km` enum('VH','AUTOCARS','BUS','PORTEURS','CAMIONS','VHLOCATION') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- fmsardb.fmsar_coef_abat_km_seq definition

CREATE TABLE `fmsar_coef_abat_km_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- fmsardb.fmsar_roles definition

CREATE TABLE `fmsar_roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- fmsardb.fmsar_user definition

CREATE TABLE `fmsar_user` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `flag` bit(1) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- fmsardb.fmsar_user_seq definition

CREATE TABLE `fmsar_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- fmsardb.fmsar_vvinale definition

CREATE TABLE `fmsar_vvinale` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `categ_veh` enum('CATEG_1','CATEG_2','CATEG_3','CATEG_4','CATEG_5') DEFAULT NULL,
  `percent_afetr_year10di` int DEFAULT NULL,
  `percent_afetr_year10es` int DEFAULT NULL,
  `percent_afetr_year10hy` int DEFAULT NULL,
  `percent_year1di` int DEFAULT NULL,
  `percent_year1es` int DEFAULT NULL,
  `percent_year1hy` int DEFAULT NULL,
  `percent_year2di` int DEFAULT NULL,
  `percent_year2es` int DEFAULT NULL,
  `percent_year2hy` int DEFAULT NULL,
  `percent_year3di` int DEFAULT NULL,
  `percent_year3es` int DEFAULT NULL,
  `percent_year3hy` int DEFAULT NULL,
  `percent_year4di` int DEFAULT NULL,
  `percent_year4es` int DEFAULT NULL,
  `percent_year4hy` int DEFAULT NULL,
  `percent_year5di` int DEFAULT NULL,
  `percent_year5es` int DEFAULT NULL,
  `percent_year5hy` int DEFAULT NULL,
  `puiss_fiscale` enum('LESS_THAN_8_CV','BW_8_AND_12_CV','MORE_THAN_12_CV') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- fmsardb.fmsar_vvinale_calcule definition

CREATE TABLE `fmsar_vvinale_calcule` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `ttc` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- fmsardb.fmsar_vvinale_calcule_seq definition

CREATE TABLE `fmsar_vvinale_calcule_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- fmsardb.fmsar_vvinale_seq definition

CREATE TABLE `fmsar_vvinale_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- fmsardb.fmsar_user_roles definition

CREATE TABLE `fmsar_user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKq8gwb7dowe1e0ry1r4flffrej` (`role_id`),
  CONSTRAINT `FKd19xe7fns30jvkwqhoegdgmlc` FOREIGN KEY (`user_id`) REFERENCES `fmsar_user` (`id`),
  CONSTRAINT `FKq8gwb7dowe1e0ry1r4flffrej` FOREIGN KEY (`role_id`) REFERENCES `fmsar_roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;