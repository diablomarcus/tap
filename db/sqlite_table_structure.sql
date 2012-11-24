CREATE TABLE "SpellDB" (
  "ID" integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  "name" TEXT,
  "school" TEXT,
  "subschool" TEXT,
  "descriptor" TEXT,
  "spell_level" TEXT,
  "casting_time" TEXT,
  "components" TEXT,
  "costly_components" INTEGER,
  "range" TEXT,
  "area" TEXT,
  "effect" TEXT,
  "targets" TEXT,
  "duration" TEXT,
  "dismissible" INTEGER,
  "shapeable" INTEGER,
  "saving_throw" TEXT,
  "spell_resistence" TEXT,
  "description" TEXT,
  "description_formated" TEXT,
  "source" TEXT,
  "full_text" TEXT,
  "verbal" INTEGER,
  "somatic" INTEGER,
  "material" INTEGER,
  "focus" INTEGER,
  "divine_focus" INTEGER,
  "sor" INTEGER,
  "wiz" INTEGER,
  "cleric" INTEGER,
  "druid" INTEGER,
  "ranger" INTEGER,
  "bard" INTEGER,
  "paladin" INTEGER,
  "alchemist" INTEGER,
  "summoner" INTEGER,
  "witch" INTEGER,
  "inquisitor" INTEGER,
  "oracle" INTEGER,
  "antipaladin" INTEGER,
  "magus" INTEGER,
  "deity" TEXT,
  "SLA_Level" INTEGER,
  "domain" TEXT,
  "short_description" TEXT,
  "majorcaster_cost_mult" REAL,
  "powercaster_cost_mult" REAL,
  "caster_cost_mult" REAL,
  "minorcaster_cost_mult" REAL,
  "best_spell_cost" REAL,
  "material_cost" REAL,
  "scroll_cost" REAL,
  "potion_cost" REAL,
  "wand_cost" REAL,
  "URL" TEXT
);
CREATE TABLE sqlite_sequence(name,seq);
CREATE TABLE "Filter_SpellDB_Details"
(
  "ID" INTEGER PRIMARY KEY,
  "wiz" TEXT
, "sor" TEXT, "cleric" TEXT, "druid" TEXT, "ranger" TEXT, "bard" TEXT, "paladin" TEXT, "alchemist" TEXT, "summoner" TEXT, "witch" TEXT, "inquisitor" TEXT, "oracle" TEXT, "antipaladin" TEXT, "magus" TEXT, "school" TEXT, "subschool" TEXT, "descriptor" TEXT, "verbal" INTEGER, "somatic" INTEGER, "material" INTEGER, "focus" INTEGER, "divinefocus" INTEGER, "costly_components" INTEGER);
CREATE TABLE "ListBox_Spell_Descriptors"
(
  "ID" INTEGER PRIMARY KEY,
  "descriptor" TEXT,
  "filter" TEXT
);
CREATE TABLE "ListBox_Spell_Schools" ("ID" integer NOT NULL,"school" varchar(8),"filter" varchar(100), PRIMARY KEY  ("ID"));
CREATE TABLE "ListBox_Spell_SubSchools" ("ID" integer NOT NULL,"subschool" wvarchar(32,10),"filter" wvarchar(32,10), PRIMARY KEY  ("ID"));
CREATE TABLE "ListBox_Spell_Levels" ("ID" integer NOT NULL,"level" wvarchar(32,10),"filter" wvarchar(32,10), PRIMARY KEY  ("ID"));
CREATE VIEW "SpellNames" AS SELECT * FROM "SpellDB";
CREATE VIEW FormattedDetails AS SELECT
  "ID",
  "name",
  ( REPLACE( (
    (CASE WHEN "wiz" >= 0 THEN 'Wiz/Sor:' || "wiz" || ', ' ELSE '' END) ||
    (CASE WHEN "witch" >= 0 THEN 'Witch:' || "witch" || ', ' ELSE '' END) ||
    (CASE WHEN "bard" >= 0 THEN 'Bard:' || "bard" || ', ' ELSE '' END) ||
    (CASE WHEN "magus" >= 0 THEN 'Magus:' || "magus" || ', ' ELSE '' END) ||
    (CASE WHEN "alchemist" >= 0 THEN 'Alch:' || "alchemist" || ', ' ELSE '' END) ||
    (CASE WHEN "summoner" >= 0 THEN 'Summ:' || "summoner" || ', ' ELSE '' END) ||
    (CASE WHEN "cleric" >= 0 THEN 'Cler/Ora:' || "cleric" || ', ' ELSE '' END) ||
    (CASE WHEN "druid" >= 0 THEN 'Druid:' || "druid" || ', ' ELSE '' END) ||
    (CASE WHEN "paladin" >= 0 THEN 'Pal:' || "paladin" || ', ' ELSE '' END) ||
    (CASE WHEN "ranger" >= 0 THEN 'Ranger:' || "ranger" || ', ' ELSE '' END) ||
    (CASE WHEN "inquisitor" >= 0 THEN 'Inq:' || "inquisitor" || ', ' ELSE '' END) ||
    (CASE WHEN "antipaladin" >= 0 THEN 'A-Pal:' || "antipaladin" || ', ' ELSE '' END) ||
    '.' ), ', .', '' )
  ) AS "spell_level",
  (
    "school" ||
    (CASE WHEN "subschool" IS NOT NULL THEN ' / ' || "subschool" ELSE '' END) ||
    (CASE WHEN "descriptor" IS NOT NULL THEN ' (' || "descriptor" || ')' ELSE '' END)
  ) as "school",
  "casting_time",
  "components",
  "range",
  "area",
  "effect",
  "targets",
  "duration",
  "saving_throw" || ' / ' || "spell_resistence" as "saving_throw",
  "spell_resistence",
  "description",
  "source",
  "focus",
  "domain",
  "short_description",
  "majorcaster_cost_mult",
  "powercaster_cost_mult",
  "caster_cost_mult",
  "minorcaster_cost_mult",
  "best_spell_cost",
  "material_cost",
  (
    CAST(ROUND("scroll_cost",0) AS INTEGER) || 'gp'
  ) as "scroll_cost",
  (
    CAST(ROUND("potion_cost",0) AS INTEGER) || 'gp'
  ) as "potion_cost",
  (
    CAST(ROUND("wand_cost",0) AS INTEGER) || 'gp'
  ) as "wand_cost"
FROM "SpellDB";
