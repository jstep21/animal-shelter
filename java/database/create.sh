#!/bin/bash
export PGPASSWORD='root'
BASEDIR=$(dirname $0)
DATABASE=final-capstone
sudo docker exec -it dpage/pgadmin4 psql -U jstephens1215@gmail.com -W root
psql -h localhost -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -h localhost -U postgres $DATABASE &&
psql -h localhost -U postgres -d $DATABASE -f "$BASEDIR/schema.sql" &&
psql -h localhost -U postgres -d $DATABASE -f "$BASEDIR/image-data.sql" &&
psql -h localhost -U postgres -d $DATABASE -f "$BASEDIR/image-data2.sql" &&
psql -h localhost -U postgres -d $DATABASE -f "$BASEDIR/data.sql" &&
psql -h localhost -U postgres -d $DATABASE -f "$BASEDIR/user.sql"
