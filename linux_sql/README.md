# Introduction
The Jarvis Linux Cluster Administration (LCA) team manages a Linux cluster of 10 nodes/servers running CentOS 7. 
The product monitor hardware specification for each node connected to the server and the data is stored in a RDBMS
The user will have bash agent installed in their machine to monitor automatically every min their data
Technologies : bash shell, docker, git, crontab, postgresql, linux command line, Intelliji

# Quick Start
Use markdown code block for your quick-start commands
- bash /home/centos/dev/jarvis_data_eng_Alex/linux_sql/scripts/psql_docker.sh start postgres password 
- psql -h localhost -U postgres -d host_agent -f /home/centos/dev/jarvis_data_eng_Alex/linux_sql/sql/ddl.sql
- bash /home/centos/dev/jarvis_data_eng_Alex/linux_sql/scripts/host_info.sh localhost 5432 host_agent postgres password
- bash /home/centos/dev/jarvis_data_eng_Alex/linux_sql/scripts/host_usage.sh localhost 5432 host_agent postgres password
- crontab -e -> * * * * * bash /home/centos/dev/jarvis_data_eng_Alex/linux_sql/scripts/host_usage.sh localhost 5432 host_agent postgres password > /tmp/host_usage.log 

# Implemenation
We made a mvp (Mininum viable product) version of this product to showcase it functionality. 

## Architecture
/home/centos/dev/jarvis_data_eng_Alex/linux_sql/Assets/Linux_Architecture_Diagram.drawio.png

## Scripts
Shell script description and usage (use markdown code block for script usage)
- psql_docker.sh: bash [PATH] start|stop|create "dbusername" "dbpassword"
- host_info.sh: bash [PATH] "hostname" [PORT] "databasename" "username "password"
- host_usage.sh: bash [PATH] "hostname" [PORT] "databasename" "username "password"
- crontab: crontab -e (edit) crontab -l (list)
- queries.sql (describe what business problem you are trying to resolve)

## Database Modeling
Describe the schema of each table using markdown table syntax (do not put any sql code)
- `host_info`
- `host_usage`

# Test
I tried to create/insert data into my database with the sql and did a SELECT * FROM table directly on the database to see if everything matched

# Deployment
crontab every min

# Improvements
- Better sql and shell scripting 
- Navigate around in linux
- tiem management
