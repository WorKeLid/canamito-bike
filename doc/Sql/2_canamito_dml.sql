SET search_path = canamito;

SET session_replication_role = 'replica';
DELETE FROM c_process_view;
DELETE FROM c_view;
DELETE FROM c_report;
DELETE FROM c_window;
DELETE FROM c_column;
DELETE FROM c_table;
DELETE FROM c_rol_menu;
DELETE FROM c_menu;
DELETE FROM c_process;
DELETE FROM c_process_type;
DELETE FROM c_user_rol;
DELETE FROM c_rol;
DELETE FROM c_user_preferences;
DELETE FROM c_user_recovery;
DELETE FROM c_user;
DELETE FROM c_person_organization;
DELETE FROM c_organization;
DELETE FROM c_group_person;
DELETE FROM c_group;
DELETE FROM c_letter;
DELETE FROM c_grade;
DELETE FROM c_person_authorization;
DELETE FROM c_authorization;
DELETE FROM c_person;
DELETE FROM c_locality;
DELETE FROM c_province;
SET session_replication_role = 'origin';

INSERT INTO c_province (c_province_id, name) VALUES(1, 'Álava');
INSERT INTO c_province (c_province_id, name) VALUES(2, 'Albacete');
INSERT INTO c_province (c_province_id, name) VALUES(3, 'Alicante');
INSERT INTO c_province (c_province_id, name) VALUES(4, 'Almería');
INSERT INTO c_province (c_province_id, name) VALUES(5, 'Ávila');
INSERT INTO c_province (c_province_id, name) VALUES(6, 'Badajoz');
INSERT INTO c_province (c_province_id, name) VALUES(7, 'Illes Balears');
INSERT INTO c_province (c_province_id, name) VALUES(8, 'Barcelona');
INSERT INTO c_province (c_province_id, name) VALUES(9, 'Burgos');
INSERT INTO c_province (c_province_id, name) VALUES(10, 'Cáceres');
INSERT INTO c_province (c_province_id, name) VALUES(11, 'Cádiz');
INSERT INTO c_province (c_province_id, name) VALUES(12, 'Castellón');
INSERT INTO c_province (c_province_id, name) VALUES(13, 'Ciudad Real');
INSERT INTO c_province (c_province_id, name) VALUES(14, 'Córdoba');
INSERT INTO c_province (c_province_id, name) VALUES(15, 'A Coruña');
INSERT INTO c_province (c_province_id, name) VALUES(16, 'Cuenca');
INSERT INTO c_province (c_province_id, name) VALUES(17, 'Girona');
INSERT INTO c_province (c_province_id, name) VALUES(18, 'Granada');
INSERT INTO c_province (c_province_id, name) VALUES(19, 'Guadalajara');
INSERT INTO c_province (c_province_id, name) VALUES(20, 'Gipuzkoa');
INSERT INTO c_province (c_province_id, name) VALUES(21, 'Huelva');
INSERT INTO c_province (c_province_id, name) VALUES(22, 'Huesca');
INSERT INTO c_province (c_province_id, name) VALUES(23, 'Jaén');
INSERT INTO c_province (c_province_id, name) VALUES(24, 'León');
INSERT INTO c_province (c_province_id, name) VALUES(25, 'Lleida');
INSERT INTO c_province (c_province_id, name) VALUES(26, 'La Rioja');
INSERT INTO c_province (c_province_id, name) VALUES(27, 'Lugo');
INSERT INTO c_province (c_province_id, name) VALUES(28, 'Madrid');
INSERT INTO c_province (c_province_id, name) VALUES(29, 'Málaga');
INSERT INTO c_province (c_province_id, name) VALUES(30, 'Murcia');
INSERT INTO c_province (c_province_id, name) VALUES(31, 'Navarra');
INSERT INTO c_province (c_province_id, name) VALUES(32, 'Ourense');
INSERT INTO c_province (c_province_id, name) VALUES(33, 'Asturias');
INSERT INTO c_province (c_province_id, name) VALUES(34, 'Palencia');
INSERT INTO c_province (c_province_id, name) VALUES(35, 'Las Palmas');
INSERT INTO c_province (c_province_id, name) VALUES(36, 'Pontevedra');
INSERT INTO c_province (c_province_id, name) VALUES(37, 'Salamanca');
INSERT INTO c_province (c_province_id, name) VALUES(38, 'Santa Cruz de Tenerife');
INSERT INTO c_province (c_province_id, name) VALUES(39, 'Cantabria');
INSERT INTO c_province (c_province_id, name) VALUES(40, 'Segovia');
INSERT INTO c_province (c_province_id, name) VALUES(41, 'Sevilla');
INSERT INTO c_province (c_province_id, name) VALUES(42, 'Soria');
INSERT INTO c_province (c_province_id, name) VALUES(43, 'Tarragona');
INSERT INTO c_province (c_province_id, name) VALUES(44, 'Teruel');
INSERT INTO c_province (c_province_id, name) VALUES(45, 'Toledo');
INSERT INTO c_province (c_province_id, name) VALUES(46, 'Valencia');
INSERT INTO c_province (c_province_id, name) VALUES(47, 'Valladolid');
INSERT INTO c_province (c_province_id, name) VALUES(48, 'Bizkaia');
INSERT INTO c_province (c_province_id, name) VALUES(49, 'Zamora');
INSERT INTO c_province (c_province_id, name) VALUES(50, 'Zaragoza');
INSERT INTO c_province (c_province_id, name) VALUES(51, 'Ceuta');
INSERT INTO c_province (c_province_id, name) VALUES(52, 'Melilla');

INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34057, '41500', 'Acebuchal, El (Alcala De Guadaira)', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34058, '41440', 'Acebuchal, El (lora Del Rio)', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34059, '41728', 'Adriano', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34060, '41550', 'Aguadulce', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34061, '41560', 'Alamedilla', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34062, '41898', 'Alamo, El (el Madroño)', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34063, '41380', 'Alanis', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34064, '41809', 'Albaida Del Aljarafe', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34065, '41500', 'Alcala De Guadaira', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34066, '41200', 'Alcala Del Rio', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34067, '41449', 'Alcolea Del Rio', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34068, '41899', 'Alcornocosa, La', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34069, '41980', 'Algaba, La', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34070, '41661', 'Algamitas', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34071, '41889', 'Alisar, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34072, '41240', 'Almaden De La Plata', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34073, '41111', 'Almensilla', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34074, '41600', 'Arahal', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34075, '41989', 'Aral, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34076, '41899', 'Archidona', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34077, '41889', 'Arroyo De La Plata', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34078, '41898', 'Aulaga, La', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34079, '41849', 'Aznalcazar', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34080, '41870', 'Aznalcollar', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34081, '41570', 'Badolatosa', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34082, '41805', 'Benacazon', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34083, '41510', 'Bencarron', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34084, '41710', 'Bencarron (utrera)', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34085, '41110', 'Bollullos De La Mitacion', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34086, '41930', 'Bormujos', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34087, '41310', 'Brenes', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34088, '41220', 'Burguillos', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34089, '41730', 'Cabezas De San Juan, Las', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34090, '41610', 'Calvario, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34091, '41900', 'Camas', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34092, '41429', 'Campana, La', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34093, '41430', 'Campillo, El (la Luisiana)', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34094, '41320', 'Cantillana', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34095, '41439', 'Cañada Rosal', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34096, '41360', 'Cañadas Del Romero', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34097, '41889', 'Cañuelo, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34098, '41910', 'Carambolo, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34099, '41359', 'Carbonal', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34100, '41100', 'Carchena', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34101, '41410', 'Carmona', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34102, '41820', 'Carrion De Los Cespedes', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34103, '41580', 'Casariche', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34104, '41230', 'Castilblanco De Los Arroyos', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34105, '41908', 'Castilleja De Guzman', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34106, '41950', 'Castilleja De La Cuesta', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34107, '41810', 'Castilleja Del Campo', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34108, '41890', 'Castillo De Las Guardas, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34109, '41370', 'Cazalla De La Sierra', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34110, '41389', 'Cerro Del Hierro', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34111, '41409', 'Cerro Perea', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34112, '41728', 'Chapatales, Los', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34113, '41510', 'Clavinque', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34114, '41910', 'Coca De La Piñera', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34115, '41450', 'Constantina', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34116, '41599', 'Corcoya', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34117, '41100', 'Coria Del Rio', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34118, '41780', 'Coripe', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34119, '41760', 'Coronil, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34120, '41657', 'Corrales, Los', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34121, '41550', 'Cortijo Del Marques', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34122, '41749', 'Cuervo, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34123, '41710', 'Don Rodrigo', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34124, '41000', 'Dos Hermanas (ver Callejero)', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34125, '41400', 'Ecija', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34126, '41807', 'Espartinas', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34127, '41209', 'Esquivel', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34128, '41560', 'Estepa', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34129, '41703', 'Fuente Del Rey', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34130, '41450', 'Fuente El Negro', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34131, '41420', 'Fuentes De Andalucia', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34132, '41370', 'Galeon, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34133, '41560', 'Gallo, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34134, '41370', 'Ganchosa, La', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34135, '41500', 'Gandul-marchenilla', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34136, '41888', 'Garrobo, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34137, '41120', 'Gelves', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34138, '41860', 'Gerena', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34139, '41565', 'Gilena', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34140, '41960', 'Gines', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34141, '41600', 'Gironda, La', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34142, '41339', 'Guadajoz', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34143, '41390', 'Guadalcanal', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34144, '41719', 'Guadalema De Los Quintero', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34145, '41210', 'Guillena', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34146, '41567', 'Herrera', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34147, '41880', 'Hoyuelo, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34148, '41550', 'Huerta Del Colegio', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34149, '41570', 'Huertas De La Manga', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34150, '41830', 'Huevar De Aljarafe', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34151, '41409', 'Isla Del Vicario', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34152, '41140', 'Isla Mayor', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34153, '41563', 'Isla Redonda La Aceñuela', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34154, '41309', 'Jarilla, La', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34155, '41360', 'Jarillas, Las', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34156, '41898', 'Juan Anton', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34157, '41898', 'Juan Gallego', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34158, '41210', 'Lagos Del Serrano', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34159, '41630', 'Lantejuela, La', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34160, '41740', 'Lebrija', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34161, '41564', 'Lora De Estepa', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34162, '41440', 'Lora Del Rio', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34163, '41430', 'Luisiana, La', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34164, '41897', 'Madroño, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34165, '41510', 'Mairena Del Alcor', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34166, '41927', 'Mairena Del Aljarafe', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34167, '41309', 'Majaloba', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34168, '41620', 'Marchena', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34169, '41727', 'Maribañez', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34170, '41569', 'Marinaleda', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34171, '41731', 'Marismillas', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34172, '41658', 'Martin De La Jara', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34173, '41569', 'Matarredonda', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34174, '41659', 'Mezquitilla, La', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34175, '41898', 'Minas Del Castillo', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34176, '41750', 'Molares, Los', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34177, '41439', 'Monclova, La', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34178, '41600', 'Monjas, Las', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34179, '41770', 'Montellano', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34180, '41610', 'Monte-palacio', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34181, '41089', 'Montequinto (ver Callejero De Dos Hermanas)', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34182, '41530', 'Moron De La Frontera', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34183, '41360', 'Navahonda', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34184, '41409', 'Navalagrulla', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34185, '41659', 'Navarredonda', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34186, '41460', 'Navas De Las Concepcion, Las', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34187, '41804', 'Olivares', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34188, '41640', 'Osuna', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34189, '41219', 'Pajanosas, Las', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34190, '41320', 'Pajares, Los', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34191, '41720', 'Palacios Y Villafranca, Los', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34192, '41719', 'Palmar De Troya, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34193, '41610', 'Palomar, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34194, '41928', 'Palomares Del Rio', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34195, '41610', 'Paradas', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34196, '41566', 'Pedrera', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34197, '41360', 'Pedroso, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34198, '41470', 'Peñaflor', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34199, '41898', 'Peralejo, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34200, '41599', 'Perenos, Los', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34201, '41599', 'Perez, Los', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34202, '41890', 'Peroamigo', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34203, '41840', 'Pilas', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34204, '41370', 'Pintado, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34205, '41728', 'Pinzon', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34206, '41150', 'Poblado De Alfonso Xiii', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34207, '41130', 'Poblado De Colinas', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34208, '41300', 'Poligono Industrial El Gordillo', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34209, '41300', 'Poligono Industrial Majaravique', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34210, '41300', 'Poligono Industrial Nacoisa', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34211, '41560', 'Pozo Del Villar', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34212, '41440', 'Priorato, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34213, '41670', 'Pruna', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34214, '41540', 'Puebla De Cazalla, La', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34215, '41479', 'Puebla De Los Infantes, La', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34216, '41130', 'Puebla Del Rio, La', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34217, '41640', 'Puerto De La Encina', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34218, '41440', 'Rambla, La', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34219, '41530', 'Ramira, La', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34220, '41880', 'Ratilla, La', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34221, '41250', 'Real De La Jara, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34222, '41658', 'Rejano', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34223, '41580', 'Riguelo', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34224, '41440', 'Rincon, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34225, '41309', 'La Rinconada', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34226, '41590', 'Roda De Andalucia, La', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34227, '41880', 'Ronquillo, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34228, '41330', 'Rosales, Los', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34229, '41568', 'Rubio, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34230, '41730', 'Sacramento', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34231, '41560', 'Salada, La', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34232, '41909', 'Salteras', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34233, '41209', 'San Ignacio Del Viar', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34234, '41300', 'San Jose De La Rinconada', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34235, '41920', 'San Juan De Aznalfarache', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34236, '41388', 'San Nicolas Del Puerto', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34237, '41500', 'San Rafael, Urbanizacion', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34238, '41800', 'Sanlucar La Mayor', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34239, '41500', 'Santa Genoveva, Urbanizacion', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34240, '41970', 'Santiponce', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34241, '41650', 'Saucejo, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34242, '41440', 'Setefilla', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34243, '41000', 'Sevilla (ver Callejero)', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34244, '41370', 'Solana Del Valle', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34245, '41500', 'Soledad', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34246, '41340', 'Tocina', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34247, '41940', 'Tomares', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34248, '41218', 'Torre De La Reina', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34249, '41500', 'Torrequinto, Urbanizacion', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34250, '41727', 'Trajano', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34251, '41727', 'Trobal, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34252, '41500', 'Trujillo Cabeza Sordo', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34253, '41806', 'Umbrete', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34254, '41710', 'Utrera', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34255, '41899', 'Valdeflores', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34256, '41907', 'Valencina De La Concepcion', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34257, '41470', 'Vega De Almenara', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34258, '41100', 'Vega, La', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34259, '41470', 'Vereda', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34260, '41730', 'Vetaherrado', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34261, '41319', 'Viar, El', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34262, '41850', 'Villamanrique De La Condesa', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34263, '41660', 'Villanueva De San Juan', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34264, '41808', 'Villanueva Del Ariscal', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34265, '41409', 'Villanueva Del Rey', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34266, '41359', 'Villanueva Del Rio', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34267, '41350', 'Villanueva Del Rio Y Minas', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34268, '41409', 'Villar Del Marco, El, Poblado', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34269, '41898', 'Villargordo', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34270, '41318', 'Villaverde Del Rio', '41');
INSERT INTO c_locality (c_locality_id, postal_code, name, fk_c_province_id) VALUES(34271, '41520', 'Viso Del Alcor, El', '41');

-- Personas
INSERT INTO c_person (c_person_id, dni, name, surname, born_date, address, phone_number, is_verified, is_active, fk_authorizer_id, fk_c_locality_id)
  VALUES (1, '29987891t', 'Miguel Ángel', 'Castañeda García', '1993-08-09', 'Germos tras, Nº 14', '645735089', true, true, null, 34234);
INSERT INTO c_person (c_person_id, dni, name, surname, born_date, address, phone_number, is_verified, is_active, fk_authorizer_id, fk_c_locality_id)
  VALUES (2, '12345678a', 'Padre', 'Padre', '1988-10-07', 'Germos tras, Nº 68', '943393123', true, true, null, 34225);
INSERT INTO c_person (c_person_id, dni, name, surname, born_date, address, phone_number, is_verified, is_active, fk_authorizer_id, fk_c_locality_id)
  VALUES (3, '87654321a', 'Hijo', 'Hijo', '2011-08-09', 'Germos tras, Nº 68', '943393123', true, true, 2, 34225);
INSERT INTO c_person (c_person_id, dni, name, surname, born_date, address, phone_number, is_verified, is_active, fk_authorizer_id, fk_c_locality_id)
  VALUES (4, '87654321b', 'Hija', 'Hija', '2011-12-02', 'Germos tras, Nº 68', '943393123', true, false, 2, 34225);

-- Autorizaciones
INSERT INTO c_authorization (c_authorization_id, name, terms_description)
  VALUES (1, 'Inscripción', 'Autorizo a mi hijo/a a que pueda realizar las actividades del curso sobre ciclismo, pudiendo realizarlas tanto dentro como fuera del recinto escolar');
INSERT INTO c_authorization (c_authorization_id, name, terms_description)
  VALUES (2, 'Difusión material gráfico', 'Autorizo al club deportivo Cañamito Bike a publicar en su página web cualquier tipo de material gráfico (fotos, videos...) en el que aparezca mi hijo/a o tutorado/a practicando las actividades propias del club');

-- Autorizaciones de los hijos
INSERT INTO c_person_authorization (c_person_authorization_id, authorization_date, is_accepted, fk_c_person_id, fk_c_authorization_id)
  VALUES (1, '2021-04-02', true, 3, 1);
INSERT INTO c_person_authorization (c_person_authorization_id, authorization_date, is_accepted, fk_c_person_id, fk_c_authorization_id)
  VALUES (2, '2021-04-02', true, 3, 2);
INSERT INTO c_person_authorization (c_person_authorization_id, authorization_date, is_accepted, fk_c_person_id, fk_c_authorization_id)
  VALUES (3, '2021-04-02', true, 4, 1);
INSERT INTO c_person_authorization (c_person_authorization_id, authorization_date, is_accepted, fk_c_person_id, fk_c_authorization_id)
  VALUES (4, '2021-04-02', false, 4, 2);

INSERT INTO c_grade (c_grade_id, grade) VALUES (1, 1);
INSERT INTO c_grade (c_grade_id, grade) VALUES (2, 2);
INSERT INTO c_grade (c_grade_id, grade) VALUES (3, 3);
INSERT INTO c_grade (c_grade_id, grade) VALUES (4, 4);

INSERT INTO c_letter (c_letter_id, letter) VALUES (1, 'A');
INSERT INTO c_letter (c_letter_id, letter) VALUES (2, 'B');
INSERT INTO c_letter (c_letter_id, letter) VALUES (3, 'C');
INSERT INTO c_letter (c_letter_id, letter) VALUES (4, 'D');

INSERT INTO c_group (c_group_id, fk_c_grade_id, fk_c_letter_id) VALUES (1, 1, 1);
INSERT INTO c_group (c_group_id, fk_c_grade_id, fk_c_letter_id) VALUES (2, 2, 1);
INSERT INTO c_group (c_group_id, fk_c_grade_id, fk_c_letter_id) VALUES (3, 3, 1);
INSERT INTO c_group (c_group_id, fk_c_grade_id, fk_c_letter_id) VALUES (4, 4, 1);

INSERT INTO c_group_person (c_group_person_id, fk_c_group_id, fk_c_person_id) VALUES (1, 1, 1);
INSERT INTO c_group_person (c_group_person_id, fk_c_group_id, fk_c_person_id) VALUES (2, 2, 3);
INSERT INTO c_group_person (c_group_person_id, fk_c_group_id, fk_c_person_id) VALUES (3, 2, 4);

INSERT INTO c_organization (c_organization_id, name) VALUES (1, 'Club deportivo Cañamito Bike');
INSERT INTO c_organization (c_organization_id, name) VALUES (2, 'Escuela de ciclismo Cañamito Bike');

INSERT INTO c_person_organization (c_person_organization_id, fk_c_person_id, fk_c_organization_id) VALUES (1, 1, 1);
INSERT INTO c_person_organization (c_person_organization_id, fk_c_person_id, fk_c_organization_id) VALUES (2, 1, 2);
INSERT INTO c_person_organization (c_person_organization_id, fk_c_person_id, fk_c_organization_id) VALUES (3, 2, 2);
INSERT INTO c_person_organization (c_person_organization_id, fk_c_person_id, fk_c_organization_id) VALUES (4, 3, 2);
INSERT INTO c_person_organization (c_person_organization_id, fk_c_person_id, fk_c_organization_id) VALUES (5, 4, 2);

INSERT INTO c_user (c_user_id, email, password, is_protected, is_active, fk_c_person_id)
  VALUES (1, 'workelid@gmail.com', 'canamito', false, true, 1);
INSERT INTO c_user (c_user_id, email, password, is_protected, is_active, fk_c_person_id)
  VALUES (2, 'workelid+padre@gmail.com', 'canamito', false, true, 2);

INSERT INTO c_user_preferences (c_user_preferences_id, fk_c_user_id) VALUES (1, 1);
INSERT INTO c_user_preferences (c_user_preferences_id, fk_c_user_id) VALUES (2, 2);

INSERT INTO c_rol (c_rol_id, name, description) VALUES (1, 'Administrador', 'Responsable de la gestión de la aplicación web Cañamito Bike');
INSERT INTO c_rol (c_rol_id, name, description) VALUES (2, 'Usuario', 'Consumidor de la aplicación web Cañamito Bike');
INSERT INTO c_rol (c_rol_id, name, description) VALUES (3, 'Anónimo', 'Usuario sin registro');

-- workelid@gmail.com
INSERT INTO c_user_rol (c_user_rol_id, fk_c_user_id, fk_c_rol_id) VALUES (1, 1, 1);
INSERT INTO c_user_rol (c_user_rol_id, fk_c_user_id, fk_c_rol_id) VALUES (2, 1, 2);

-- workelid+padre@gmail.com
INSERT INTO c_user_rol (c_user_rol_id, fk_c_user_id, fk_c_rol_id) VALUES (3, 2, 2);

INSERT INTO c_process_type (c_process_type_id, type) VALUES (1, 'Proceso');
INSERT INTO c_process_type (c_process_type_id, type) VALUES (2, 'Ventana');
INSERT INTO c_process_type (c_process_type_id, type) VALUES (3, 'Informe');

INSERT INTO c_process (c_process_id, description, process_path, fk_c_process_type_id) VALUES (1, 'Ofrece la página principal de Cañamito', 'es.canamito.app.controller.process.HomePage', 1);
INSERT INTO c_process (c_process_id, description, process_path, fk_c_process_type_id) VALUES (2, 'Formulario de inicio de sesión', 'es.canamito.app.controller.process.Login', 1);
INSERT INTO c_process (c_process_id, description, process_path, fk_c_process_type_id) VALUES (3, 'Forumlario de registro para usuarios', 'es.canamito.app.controller.process.Signin', 1);
INSERT INTO c_process (c_process_id, description, process_path, fk_c_process_type_id) VALUES (4, 'Proceso para la gestión de la base de datos', 'es.canamito.app.controller.process.SystemAdministration', 1);
INSERT INTO c_process (c_process_id, description, process_path, fk_c_process_type_id) VALUES (5, 'Genera un informe de las personas', 'es.canamito.app.controller.process.ReportGenerator', 3);
INSERT INTO c_process (c_process_id, description, process_path, fk_c_process_type_id) VALUES (6, 'Proceso que muestra las provincias', 'es.canamito.app.controller.process.window.Province', 2);
INSERT INTO c_process (c_process_id, description, process_path, fk_c_process_type_id) VALUES (7, 'Formulario de registo de autorizantes', 'es.canamito.app.controller.process.SigninAuthorizer', 1);
INSERT INTO c_process (c_process_id, description, process_path, fk_c_process_type_id) VALUES (8, 'Preferencias del usuario', 'es.canamito.app.controller.process.Preferences', 1);
INSERT INTO c_process (c_process_id, description, process_path, fk_c_process_type_id) VALUES (9, 'Cerrar sesión', 'es.canamito.app.controller.process.Logout', 1);
-- Grupos de menú
INSERT INTO c_menu (c_menu_id, name, description, fk_c_menu_group_id, fk_c_process_id) VALUES (1, 'Acciones', 'Grupo para los procesos', null, null);
INSERT INTO c_menu (c_menu_id, name, description, fk_c_menu_group_id, fk_c_process_id) VALUES (2, 'Ventanas', 'Grupo para las ventanas', null, null);
INSERT INTO c_menu (c_menu_id, name, description, fk_c_menu_group_id, fk_c_process_id) VALUES (3, 'Informes', 'Grupo para los informes', null, null);

-- Entradas de menú: Acciones
INSERT INTO c_menu (c_menu_id, name, path, description, fk_c_menu_group_id, fk_c_process_id) VALUES (4, 'Inicio', 'pagina-principal', 'Página principal de Cañamito Bike', 1, 1);
INSERT INTO c_menu (c_menu_id, name, path, description, fk_c_menu_group_id, fk_c_process_id) VALUES (5, 'Inicio de sesión', 'inicio-sesion', 'Formulario de inicio de sesión', 1, 2);
INSERT INTO c_menu (c_menu_id, name, path, description, fk_c_menu_group_id, fk_c_process_id) VALUES (6, 'Registro', 'registro', 'Registrate como miembro de la escuela de ciclismo Cañamito Bike', 1, 3);
INSERT INTO c_menu (c_menu_id, name, path, description, fk_c_menu_group_id, fk_c_process_id) VALUES (7, 'Gestión administrativa', 'administracion', 'Accede a la información almacenada en el sistema', 1, 4);
INSERT INTO c_menu (c_menu_id, name, path, description, fk_c_menu_group_id, fk_c_process_id) VALUES (8, 'Preferencias', 'preferencias', 'Accede a tus preferencias', 1, 8);
INSERT INTO c_menu (c_menu_id, name, path, description, fk_c_menu_group_id, fk_c_process_id) VALUES (9, 'Registro de autorizante', 'registro-autorizante', 'Registrate como autorizante', 1, 7);
INSERT INTO c_menu (c_menu_id, name, path, description, fk_c_menu_group_id, fk_c_process_id) VALUES (10, 'Cerrar sesión', 'salir', 'Cierra la sesión', 1, 9);

--Entradas de menú: Ventanas
INSERT INTO c_menu (c_menu_id, name, path, description, fk_c_menu_group_id, fk_c_process_id) VALUES (11, 'Provincias', 'provincias', 'Accede a las provincias definidas', 2, 6);
-- Entradas de menú: Informes
INSERT INTO c_menu (c_menu_id, name, path, description, fk_c_menu_group_id, fk_c_process_id) VALUES (12, 'Informe de provincias', 'informe-provincias', 'Genera un informe sobre las provincias', 3, 5);

-- Rol administrador
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (1, 1, 1);
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (2, 1, 2);
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (3, 1, 3);

INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (4, 1, 4);
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (5, 1, 5);
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (6, 1, 6);
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (7, 1, 7);
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (8, 1, 8);
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (9, 1, 9);
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (10, 1, 10);
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (11, 1, 11);
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (12, 1, 12);

-- Rol usuario
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (13, 2, 1);
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (14, 2, 2);
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (15, 2, 3);

INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (16, 2, 4);
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (17, 2, 8);
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (18, 2, 9);
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (19, 2, 10);

-- Rol Anónimo
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (20, 3, 1);
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (21, 3, 2);
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (22, 3, 3);

INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (23, 3, 4);
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (24, 3, 5);
INSERT INTO c_rol_menu (c_rol_menu_id, fk_c_rol_id, fk_c_menu_id) VALUES (25, 3, 6);


INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (1, 'c_province', 'CProvince', 'Provincias', 'Provincias de España');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (2, 'c_locality', 'CLocality', 'Localidades', 'Localidades de España');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (3, 'c_person', 'CPerson', 'Personas', 'Personas registradas en Cañamito Bike');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (4, 'c_autorization', 'CAuthorization', 'Autorizaciones', 'Autorizaciones de Cañamito Bike');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (5, 'c_person_authorization', 'CPersonAuthorization', 'Autorizaciones de personas', 'Autorizaciones concedidas por las personas');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (6, 'c_grade', 'CGrade', 'Grado', 'Nivel del grupo');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (7, 'c_letter', 'CLetter', 'Letra', 'Letra asociada al grupo');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (8, 'c_group_person', 'CGroupPerson', 'Personas en grupos', 'Las personas y sus grupos');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (9, 'c_organization', 'COrganization', 'Organización', 'Organizaciones de Cañamito Bike');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (10, 'c_person_organization', 'CPersonOrganization', 'Personas en organizaciones', 'Las personas y sus organizaciones');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (11, 'c_user', 'CUser', 'Usuarios', 'Usuarios de Cañamito Bike');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (12, 'c_user_recovery', 'CUserRecovery', 'Recuperación de usuario', 'Sistema de Recuperación de usuarios');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (13, 'c_user_preferences', 'CUserPreferences', 'Preferencias de usuarios', 'Preferencias de los usuarios sobre la aplicación Cañamito Bike');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (14, 'c_rol', 'CRol', 'Roles', 'Roles que un usuario puede tener');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (15, 'c_rol_user', 'CRolUser', 'Roles de los usuarios', 'Las personas y sus roles');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (16, 'c_process_type', 'CProcessType', 'Tipo de proceso', 'Tipos de procesos existentes en Cañamito Bike');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (17, 'c_process', 'CProcess', 'Procesos', 'Procesos disponibles en Cañamito Bike');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (18, 'c_menu', 'CMenu', 'Menús', 'Entradas de menú disponibles para navegar la aplicación Cañamito Bike');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (19, 'c_rol_menu', 'CRolMenu', 'Menús de los roles', 'Entradas de menú disponibles para los roles');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (20, 'c_table', 'CTable', 'Tablas', 'Tablas almacenadas en la base de datos');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (21, 'c_column', 'CColumn', 'Columnas de tablas', 'Columnas de las tablas almacenadas en la base de datos');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (22, 'c_window', 'CWindow', 'Ventana', 'Procesos que utilizan ventanas');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (23, 'c_window_table', 'CWindowTable', 'Tablas de ventanas', 'Las ventanas están compuestas por tablas');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (24, 'c_report', 'CReport', 'Informes', 'Impresión de informes');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (25, 'c_view', 'CView', 'Vistas', 'Representaciones gráficas usadas para visualizar procesos');
INSERT INTO c_table (c_table_id, db_name, class_name, name, description) VALUES (26, 'c_process_view', 'CProcessView', 'Vistas de los procesos', 'Los procesos y sus representaciones gráficas');

-- INSERT INTO c_column (c_column_id, db_name, name, description, fk_c_table_id) VALUES (...);

-- Columnas de la tabla c_province
INSERT INTO c_column (c_column_id, db_name, attribute_name, name, description, fk_c_table_id) VALUES (1, 'c_column_id', 'cProvinceId', 'Identificador', 'Identificador único de la provincia', 1);
INSERT INTO c_column (c_column_id, db_name, attribute_name, name, description, fk_c_table_id) VALUES (2, 'db_name', 'name', 'Provincia', 'Nombre de la provincia', 1);
-- Columnas de la tabla c_locality
INSERT INTO c_column (c_column_id, db_name, attribute_name, name, description, fk_c_table_id) VALUES (3, 'c_column_id', 'cLocalityId', 'Identificador', 'Identificador único de la localidad', 2);
INSERT INTO c_column (c_column_id, db_name, attribute_name, name, description, fk_c_table_id) VALUES (4, 'postal_code', 'postalCode', 'Código postal', 'Código postal de la localidad', 2);
INSERT INTO c_column (c_column_id, db_name, attribute_name, name, description, fk_c_table_id) VALUES (5, 'db_name', 'name', 'Localidad', 'Nombre de la localidad', 2);

INSERT INTO c_window (c_window_id, name, description, fk_c_table_id) VALUES (6, 'Provincias', 'Ventata con las provincias', 1);

INSERT INTO c_report (c_report_id, report_path) VALUES (5, '/core/report/getTable.jrxml');

INSERT INTO c_view (c_view_id, name, jsp_path) VALUES (1, 'Cabecera', '/WEB-INF/jsp/es/canamito/app/view/Header.jsp');
INSERT INTO c_view (c_view_id, name, jsp_path) VALUES (2, 'Pie', '/WEB-INF/jsp/es/canamito/app/view/Footer.jsp');
INSERT INTO c_view (c_view_id, name, jsp_path) VALUES (3, 'Página principal', '/WEB-INF/jsp/es/canamito/app/view/process/HomePage.jsp');
INSERT INTO c_view (c_view_id, name, jsp_path) VALUES (4, 'Ventana', '/WEB-INF/jsp/es/canamito/app/view/process/WindowGenerator.jsp');
INSERT INTO c_view (c_view_id, name, jsp_path) VALUES (5, 'Visualizacion del sistema', '/WEB-INF/jsp/es/canamito/app/view/process/SystemAdministration.jsp');
INSERT INTO c_view (c_view_id, name, jsp_path) VALUES (6, 'Inicio de sesión', '/WEB-INF/jsp/es/canamito/app/view/process/Login.jsp');
INSERT INTO c_view (c_view_id, name, jsp_path) VALUES (7, 'Formulario de registo para usuarios', '/WEB-INF/jsp/es/canamito/app/view/process/SigninAuthorizer.jsp');

INSERT INTO c_process_view (c_process_view_id, is_default, fk_c_process_id, fk_c_view_id) VALUES (1, TRUE, 1, 3);
INSERT INTO c_process_view (c_process_view_id, is_default, fk_c_process_id, fk_c_view_id) VALUES (2, TRUE, 2, 6);
INSERT INTO c_process_view (c_process_view_id, is_default, fk_c_process_id, fk_c_view_id) VALUES (3, TRUE, 3, 7);
INSERT INTO c_process_view (c_process_view_id, is_default, fk_c_process_id, fk_c_view_id) VALUES (4, TRUE, 4, 5);
INSERT INTO c_process_view (c_process_view_id, is_default, fk_c_process_id, fk_c_view_id) VALUES (5, TRUE, 6, 4);
