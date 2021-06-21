DROP SCHEMA IF EXISTS canamito CASCADE;
CREATE SCHEMA canamito;

SET SCHEMA 'canamito';

CREATE TABLE c_province (
  c_province_id SERIAL PRIMARY KEY,

  name VARCHAR(64) NOT NULL
);

CREATE TABLE c_locality (
  c_locality_id SERIAL PRIMARY KEY,

  postal_code VARCHAR(5) NOT NULL,
  name VARCHAR(128) NOT NULL,

  fk_c_province_id INTEGER NOT NULL REFERENCES c_province (c_province_id)
);

CREATE TABLE c_person (
  c_person_id SERIAL PRIMARY KEY,

  dni VARCHAR(9) NOT NULL UNIQUE,
  name VARCHAR(128) NOT NULL,
  surname VARCHAR(128) NOT NULL,
  born_date DATE NOT NULL,
  address VARCHAR(128) NOT NULL,
  phone_number VARCHAR(9) NOT NULL,
  is_verified BOOLEAN NOT NULL DEFAULT FALSE,
  is_active BOOLEAN NOT NULL DEFAULT FALSE,

  fk_authorizer_id INTEGER REFERENCES c_person (c_person_id),
  fk_c_locality_id INTEGER NOT NULL REFERENCES c_locality (c_locality_id)
);

CREATE TABLE c_authorization (
  c_authorization_id SERIAL PRIMARY KEY,

  name VARCHAR(64) NOT NULL UNIQUE,
  terms_description VARCHAR(1024) NOT NULL
);

CREATE TABLE c_person_authorization (
  c_person_authorization_id SERIAL PRIMARY KEY,

  authorization_date DATE NOT NULL,
  is_accepted BOOLEAN NOT NULL DEFAULT FALSE,

  fk_c_person_id INTEGER NOT NULL REFERENCES c_person (c_person_id),
  fk_c_authorization_id INTEGER NOT NULL REFERENCES c_authorization (c_authorization_id),

  UNIQUE (fk_c_person_id, fk_c_authorization_id)
);

CREATE TABLE c_grade (
  c_grade_id SERIAL PRIMARY KEY,

  grade SMALLINT NOT NULL UNIQUE
);

CREATE TABLE c_letter (
  c_letter_id SERIAL PRIMARY KEY,

  letter char(1) NOT NULL UNIQUE
);

CREATE TABLE c_group (
  c_group_id SERIAL PRIMARY KEY,

  fk_c_grade_id INTEGER NOT NULL REFERENCES c_grade (c_grade_id),
  fk_c_letter_id INTEGER NOT NULL REFERENCES c_letter (c_letter_id),

  UNIQUE (fk_c_grade_id, fk_c_letter_id)
);

CREATE TABLE c_group_person (
  c_group_person_id SERIAL PRIMARY KEY,

  fk_c_group_id INTEGER NOT NULL REFERENCES c_group (c_group_id),
  fk_c_person_id INTEGER NOT NULL REFERENCES c_person (c_person_id),

  UNIQUE (fk_c_group_id, fk_c_person_id)
);

CREATE TABLE c_organization (
  c_organization_id SERIAL PRIMARY KEY,

  name VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE c_person_organization (
  c_person_organization_id SERIAL PRIMARY KEY,

  fk_c_person_id INTEGER NOT NULL REFERENCES c_person (c_person_id),
  fk_c_organization_id INTEGER NOT NULL REFERENCES c_organization (c_organization_id),

  UNIQUE (fk_c_person_id, fk_c_organization_id)
);

CREATE TABLE c_user (
  c_user_id SERIAL PRIMARY KEY,

  email VARCHAR(128) NOT NULL UNIQUE,
  password VARCHAR(32) NOT NULL,
  is_protected BOOLEAN NOT NULL DEFAULT FALSE,
  is_active BOOLEAN NOT NULL DEFAULT TRUE,

  fk_c_person_id INTEGER UNIQUE REFERENCES c_person (c_person_id)
);

CREATE TABLE c_user_recovery (
  c_user_recovery_id SERIAL PRIMARY KEY,

  recovery_code INTEGER NOT NULL,
  tries_left SMALLINT NOT NULL,
  valid_until TIMESTAMP WITHOUT TIME ZONE NOT NULL,

  fk_c_user_id INTEGER NOT NULL UNIQUE REFERENCES c_user (c_user_id)
);

CREATE TABLE c_user_preferences (
  c_user_preferences_id SERIAL PRIMARY KEY,

  fk_c_user_id INTEGER NOT NULL UNIQUE REFERENCES c_user (c_user_id)
);

CREATE TABLE c_rol (
  c_rol_id SERIAL PRIMARY KEY,

  name VARCHAR(64) NOT NULL UNIQUE,
  description VARCHAR(255)
);

CREATE TABLE c_user_rol (
  c_user_rol_id SERIAL PRIMARY KEY,

  fk_c_user_id INTEGER NOT NULL REFERENCES c_user (c_user_id),
  fk_c_rol_id INTEGER NOT NULL REFERENCES c_rol (c_rol_id),

  UNIQUE (fk_c_user_id, fk_c_rol_id)
);

CREATE TABLE c_process_type (
  c_process_type_id SERIAL PRIMARY KEY,

  type VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE c_process (
  c_process_id SERIAL PRIMARY KEY,

  description VARCHAR(256),
  process_path VARCHAR(256) NOT NULL UNIQUE,

  fk_c_process_type_id INTEGER NOT NULL REFERENCES c_process_type (c_process_type_id)
);

CREATE TABLE c_menu (
  c_menu_id SERIAL PRIMARY KEY,

  name VARCHAR(64),
  path VARCHAR(64),
  description VARCHAR(64),

  fk_c_menu_group_id INTEGER REFERENCES c_menu (c_menu_id) ON DELETE SET NULL,
  fk_c_process_id INTEGER UNIQUE REFERENCES c_process (c_process_id) ON DELETE CASCADE
);

CREATE TABLE c_rol_menu (
  c_rol_menu_id SERIAL PRIMARY KEY,

  fk_c_rol_id INTEGER NOT NULL REFERENCES c_rol (c_rol_id),
  fk_c_menu_id INTEGER NOT NULL REFERENCES c_menu (c_menu_id) ON DELETE CASCADE
);

CREATE TABLE c_table (
  c_table_id SERIAL PRIMARY KEY,

  db_name VARCHAR(64) NOT NULL UNIQUE,
  class_name VARCHAR(64) NOT NULL UNIQUE,
  name VARCHAR(64) NOT NULL UNIQUE,
  description VARCHAR(256)
);

CREATE TABLE c_column (
  c_column_id SERIAL PRIMARY KEY,

  db_name VARCHAR(64) NOT NULL,
  attribute_name VARCHAR(64) NOT NULL,
  name VARCHAR(64) NOT NULL,
  description VARCHAR(256),
  inputType VARCHAR(64),

  fk_c_table_id INTEGER NOT NULL REFERENCES c_table (c_table_id) ON DELETE CASCADE
);

CREATE TABLE c_window (
  c_window_id SERIAL PRIMARY KEY REFERENCES c_process (c_process_id) ON DELETE CASCADE,

  name VARCHAR(64) NOT NULL UNIQUE,
  description VARCHAR(256) NOT NULL,

  fk_c_table_id INTEGER NOT NULL REFERENCES c_table (c_table_id) ON DELETE CASCADE
);

CREATE TABLE c_report (
  c_report_id SERIAL PRIMARY KEY REFERENCES c_process (c_process_id) ON DELETE CASCADE,

  report_path VARCHAR(256) NOT NULL
);

CREATE TABLE c_view (
  c_view_id SERIAL PRIMARY KEY,

  name VARCHAR(64) NOT NULL UNIQUE,
  jsp_path VARCHAR(256) NOT NULL UNIQUE
);

CREATE TABLE c_process_view (
  c_process_view_id SERIAL PRIMARY KEY,

  is_default BOOLEAN NOT NULL DEFAULT FALSE,

  fk_c_process_id INTEGER NOT NULL REFERENCES c_process (c_process_id),
  fk_c_view_id INTEGER NOT NULL REFERENCES c_view (c_view_id) ON DELETE CASCADE,

  UNIQUE (fk_c_process_id, fk_c_view_id)
);
