-- Requires the pgtap extension to already be enabled on the target database:
-- CREATE EXTENSION IF NOT EXISTS pgtap;

BEGIN;

SELECT plan(5);

-- 1. Table exists
SELECT has_table('tbl_operations', 'tbl_operations should exist');

-- 2. Correct columns, in the correct order
SELECT columns_are(
    'tbl_operations',
    ARRAY['id', 'col01', 'col02', 'col03', 'col04'],
    'tbl_operations should have the expected columns'
);

-- 3. Exactly one record
SELECT is(
    (SELECT count(*)::int FROM tbl_operations),
    1,
    'tbl_operations should have exactly 1 record'
);

-- 4. Validate col01 value on that record
SELECT is(
    (SELECT col01 FROM tbl_operations WHERE id = 1),
    'test',
    'col01 should default back to test after truncate and re-insert'
);

-- 5. Validate col02 value on that record
SELECT is(
    (SELECT col02 FROM tbl_operations WHERE id = 1),
    0,
    'col02 should default back to 0 after truncate and re-insert'
);

SELECT * FROM finish();

ROLLBACK;