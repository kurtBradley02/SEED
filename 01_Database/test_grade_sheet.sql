BEGIN;

SELECT plan(1);

SELECT has_table('tbl_students', 'Assertion on tbl_students');

SELECT * FROM finish();

ROLLBACK;