SELECT * FROM PERSON

CREATE OR REPLACE FUNCTION log_activity() RETURNS TRIGGER AS $$
	BEGIN
		INSERT INTO log(name_table,type_operation,old_value,new_value,modified_at)
		VALUES('person', 'UPDATE', row_to_json(OLD), row_to_json(NEW), now());
		RETURN NEW;
	END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER last_name_changes
   BEFORE UPDATE ON person
   FOR EACH ROW EXECUTE FUNCTION log_activity();


SELECT * FROM log
