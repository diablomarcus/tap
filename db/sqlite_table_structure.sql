PRAGMA foreign_keys = ON;

DROP TABLE IF EXISTS spell;
CREATE TABLE spell (
  spell_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
  ,name TEXT
  ,school TEXT
  ,subschool TEXT
  ,casting_time INTEGER
  ,casting_unit TEXT
  ,components TEXT
  ,range TEXT
  ,area TEXT
  ,effect TEXT
  ,targets TEXT
  ,duration TEXT
  ,dismissible INTEGER
  ,shapeable INTEGER
  ,saving_throw TEXT
  ,spell_resistance TEXT
  ,description TEXT
  ,source_book_id INTEGER
  ,full_text TEXT
  ,verbal INTEGER
  ,somatic INTEGER
  ,material INTEGER
  ,arcane_focus INTEGER
  ,divine_focus INTEGER
  ,deity TEXT
  ,short_description TEXT
  ,material_cost INTEGER
  ,url TEXT
);

DROP TABLE IF EXISTS caster_type;
CREATE TABLE caster_type (
   caster_type_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
   , short_name TEXT
   , long_name TEXT
   , divine INTEGER
   , arcane INTEGER
);

DROP TABLE IF EXISTS caster_spell_level;
CREATE TABLE caster_spell_level (
   caster_spell_level_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
   ,spell_id REFERENCES spell
   ,caster_type_id REFERENCES caster_type
   ,spell_lvl INTEGER
);

DROP TABLE IF EXISTS source_book;
CREATE TABLE source_book (
   source_book_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
   , short_name TEXT
   , long_name TEXT
   , year INTEGER
   , paizo INTEGER
);

DROP TABLE IF EXISTS author;
CREATE TABLE author (
   author_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
   , first_name TEXT
   , last_name TEXT
);

DROP TABLE IF EXISTS author_connect;
CREATE TABLE author_connect (
   author_id REFERENCES author
   , source_book_id REFERENCES source_book
);

DROP TABLE IF EXISTS descriptor;
CREATE TABLE descriptor (
   descriptor_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
   , descriptor TEXT
);

DROP TABLE IF EXISTS descriptor_connect;
CREATE TABLE descriptor_connect (
   spell_id REFERENCES spell
   , descriptor_id REFERENCES descriptor
);

DROP TABLE IF EXISTS domain;
CREATE TABLE domain (
   domain_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
   , domain_name TEXT
);

DROP TABLE IF EXISTS domain_connect;
CREATE TABLE domain_connect (
   domain_id REFERENCES domain
   , spell_id REFERENCES spell
);
